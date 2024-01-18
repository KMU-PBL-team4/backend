package com.example.kmupbl3.controller;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.dto.AdShowDTO;
import com.example.kmupbl3.service.ad.AdService;
import com.example.kmupbl3.service.mapping.AdTargetMapService;
import com.example.kmupbl3.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.example.kmupbl3.tool.JsonTool.AdShowListJsonMapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OfferController {

    private final UserService userService;
    private final AdService adService;
    private final AdTargetMapService mapService;

    /**
     * 유저가 볼 광고 리스트를 요청하는 API (AD Server)
     *
     * @param username
     * @param category
     * @param timestamp
     * @return
     */
    @GetMapping("/neighbor-ad/ad-list/{username}")
    public String getAdListForUser(@PathVariable(name = "username") String username,
                                   @RequestParam(name = "category") String category,
                                   @RequestParam(name = "searchDate") Long timestamp,
                                   @RequestParam(name = "adQuantity") Integer adQuantity) {
        log.info("API Call [GET] - /neighbor-ad/ad-list");
        AdSearchCond adSearchCond = new AdSearchCond(category, null, timestamp);
        List<AD> adList = adService.findAds(adSearchCond);
        Optional<User> findUser = userService.findByUsername(username);

        if (findUser.isEmpty()) {
            log.warn("Failed to find username {}", username);
            return AdShowListJsonMapper(1, "No user found", null);
        }

        if (adList.isEmpty()) {
            log.warn("Failed to get adList");
            return AdShowListJsonMapper(2, "AD DB is empty", null);
        }

        List<AdShowDTO> showDTOList = mapService.selectAdForUser(findUser.get().getId(), adSearchCond, adQuantity);

        return AdShowListJsonMapper(0, null, showDTOList);
    }
}
