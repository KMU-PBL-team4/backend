package com.example.kmupbl3.service.mapping;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.domain.AdTagConstants;
import com.example.kmupbl3.dto.AdShowDTO;
import com.example.kmupbl3.dto.UserInfoDTO;
import com.example.kmupbl3.repository.mapping.AdvertisementTargetMapping;
import com.example.kmupbl3.repository.mapping.AdvertisementTargetMappingRepository;
import com.example.kmupbl3.service.ad.AdService;
import com.example.kmupbl3.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class AdTargetMapServiceImpl implements AdTargetMapService {

    private final AdService adService;
    private final UserService userService;
    private final AdvertisementTargetMappingRepository mappingRepository;

    @Override
    public AdvertisementTargetMapping assignAdTags(Integer adId, Integer tagId) {
        // validation
        if (adService.findById(adId).isEmpty()) return null;
        if (AdTagConstants.getTagNameById(tagId) == null) return null;

        return mappingRepository.save(new AdvertisementTargetMapping(adId, tagId));
    }

    @Override
    public List<AdShowDTO> selectAdForUser(Integer userId, AdSearchCond cond, Integer adQuantity) {
        UserInfoDTO userInfo = userService.findUserInfo(userId);
        List<AD> adList = adService.findAds(cond);

        // 광고 연관성 점수 평가
        Map<Integer, Integer> adScores = evaluateAdRelevance(adList, userInfo);

        // 상위 N개 광고 선택
        List<AD> resultAdList = sortAdsByScore(adQuantity, adScores);

        // 전송할 형태로 매핑, 결과 반환
        return convertAdsToShowDTO(resultAdList);

    }

    private Map<Integer, Integer> evaluateAdRelevance(List<AD> adList, UserInfoDTO userInfo) {
        // 광고 연관성 평가
        Map<Integer, Integer> adScores = new HashMap<>();

        for (AD ad : adList) {
            List<AdvertisementTargetMapping> targetMappings = mappingRepository.findByAdId(ad.getId());

            // Calculate score based on UserInfoDTO and targetMappings
            int score = calculateScore(userInfo, targetMappings);

            // Update the score in the map
            adScores.put(ad.getId(), score);
        }
        return adScores;
    }

    private int calculateScore(UserInfoDTO userInfo, List<AdvertisementTargetMapping> targetMappings) {
        int score = 0;

        for (AdvertisementTargetMapping mapping : targetMappings) {
            List<Integer> tagIdList = userInfo.getTagIdList();
            for (Integer tag : tagIdList) {
                if (tag.equals(mapping.getFeatureId())) {
                    score++;
                }
            }
        }

        return score;
    }

    private List<AD> sortAdsByScore(Integer adQuantity, Map<Integer, Integer> adScores) {
        // Sort the ads based on scores in descending order
        List<AD> list = new ArrayList<>(adScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(adQuantity)
                .map(entry -> adService.findById(entry.getKey())) // Validation
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList());

        // 광고 수가 충분하지 않은 경우, 가장 관련성이 높은 광고를 복사한다.
        for (int duplicates = adQuantity - list.size(); duplicates > 0; duplicates--) {
            list.add(list.get(0));
        }

        return list;
    }

    private List<AdShowDTO> convertAdsToShowDTO(List<AD> resultAdList) {
        return resultAdList.stream()
                .map(ad -> new AdShowDTO(ad.getTitle(), ad.getShortHeading(), ad.getContent(), ad.getDescription()))
                .toList();
    }
}
