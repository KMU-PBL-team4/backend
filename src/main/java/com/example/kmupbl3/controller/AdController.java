package com.example.kmupbl3.controller;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.dto.AdCreateForm;
import com.example.kmupbl3.dto.AdShowDTO;
import com.example.kmupbl3.service.ad.AdService;
import com.example.kmupbl3.service.mapping.AdTargetMapService;
import com.example.kmupbl3.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.kmupbl3.tool.JsonTool.*;

@RestController
@Slf4j
@RequestMapping("/neighbor-ad")
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;
    private final UserService userService;
    private final AdTargetMapService mapService;

    @PostMapping
    public String addAdvertisement(@Validated @RequestBody AdCreateForm form) {
        log.info("API Call [POST] - /neighbor-ad");

        AD ad = AdCreateForm.build(form);

        AD result = adService.save(ad);
        if (result != null) {
            log.info("Successfully added advertisement. Id: " + result.getId());
            return ApiResponseJsonMapper(0, null, result.getId());
        } else {
            log.warn("Failed to add advertisement (Title: " + form.getTitle() + ")");
            return ApiResponseJsonMapper(1, "Failed to save advertisement", null);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAdvertisement(@PathVariable("id") Integer id) {
        log.info("API Call [DELETE] - /neighbor-ad/" + id);

        boolean isSuccess = adService.delete(id);
        if (isSuccess) {
            log.info("Successfully deleted advertisement id: " + id);
            return ApiResponseJsonMapper(0, null, id);
        } else {
            log.warn("Failed to delete advertisement id: " + id + ".");
            return ApiResponseJsonMapper(1, "No advertisement found", null);
        }
    }

    /**
     * 광고 목록 UI에 검색한 광고 리스트업 (Management)
     *
     * @param category
     * @param timestamp
     * @return
     */
    @GetMapping("/ad-list")
    public String getAdList(@RequestParam(name = "category", required = false) String category,
                            @RequestParam(name = "searchDate", required = false) Long timestamp) {
        log.info("API Call [GET] - /neighbor-ad/ad-list");
        AdSearchCond adSearchCond = new AdSearchCond(category, timestamp);
        List<AD> adList = adService.findAds(adSearchCond);

        return getJson(adList);
    }

    /**
     * 유저가 볼 광고 리스트를 요청하는 API (AD Server)
     *
     * @param username
     * @param category
     * @param timestamp
     * @return
     */
    @GetMapping("/ad-list/{username}")
    public String getAdListForUser(@PathVariable(name = "username") String username,
                                   @RequestParam(name = "category") String category,
                                   @RequestParam(name = "searchDate") Long timestamp,
                                   @RequestParam(name = "adQuantity") Integer adQuantity) {
        log.info("API Call [GET] - /neighbor-ad/ad-list");
        AdSearchCond adSearchCond = new AdSearchCond(category, timestamp);
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
