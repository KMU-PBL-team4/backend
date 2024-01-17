package com.example.kmupbl3;

import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.service.ad.AdService;
import com.example.kmupbl3.service.mapping.AdTargetMapService;
import com.example.kmupbl3.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.kmupbl3.domain.AdTagConstants.*;
import static com.example.kmupbl3.tool.TimeTool.timeStringToTimestamp;

@Component
@Profile("test")
@RequiredArgsConstructor
@Slf4j
public class DummyDataGenerator {

    private final AdService adService;
    private final UserService userService;
    private final AdTargetMapService mapService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // 더미 광고 3개 추가.
        AD ad1 = adService.save(new AD(
                "제품1", "제품1 소개", "영상",
                timeStringToTimestamp("2024-01-12 12:00:00"),
                timeStringToTimestamp("2024-01-20 12:00:00"),
                100, "제품1에 대한 설명입니다."));
        
        // 광고 태그 연결
        mapService.assignAdTags(ad1.getId(), getIdByTagName(TWENTIES));
        mapService.assignAdTags(ad1.getId(), getIdByTagName(MALE));

        AD ad2 = adService.save(new AD(
                "서비스2", "서비스2 소개", "영상",
                timeStringToTimestamp("2024-01-14 12:00:00"),
                timeStringToTimestamp("2024-01-20 12:00:00"),
                50, "서비스2에 대한 설명입니다."));

        mapService.assignAdTags(ad2.getId(), getIdByTagName(THIRTIES));
        mapService.assignAdTags(ad2.getId(), getIdByTagName(MALE));

        AD ad3 = adService.save(new AD(
                "이벤트3", "이벤트3 소개", "이미지",
                timeStringToTimestamp("2024-01-16 12:00:00"),
                timeStringToTimestamp("2024-01-20 12:00:00"),
                200, "이벤트3에 대한 설명입니다."));

        mapService.assignAdTags(ad3.getId(), getIdByTagName(THIRTIES));
        mapService.assignAdTags(ad3.getId(), getIdByTagName(FEMALE));

        // 더미 유저 4명 추가.
        userService.join(new User("male2" ,24, "male"));
        userService.join(new User("male3" ,34, "male"));
        userService.join(new User("female2" ,24, "female"));
        userService.join(new User("female3" ,34, "female"));

    }



}
