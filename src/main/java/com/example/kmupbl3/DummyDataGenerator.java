package com.example.kmupbl3;

import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.service.ad.AdService;
import com.example.kmupbl3.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.kmupbl3.tool.TimeTool.timeStringToTimestamp;

@Component
@Profile("test")
@RequiredArgsConstructor
@Slf4j
public class DummyDataGenerator {

    private final AdService adService;
    private final UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        adService.save(new AD(
                "제품1", "제품1 소개", "영상",
                timeStringToTimestamp("2024-01-16 12:00:00"),
                timeStringToTimestamp("2024-01-17 12:00:00"),
                100, "제품1에 대한 설명입니다."));

        adService.save(new AD(
                "서비스2", "서비스2 소개", "영상",
                timeStringToTimestamp("2024-01-18 15:30:00"),
                timeStringToTimestamp("2024-01-20 18:45:00"),
                50, "서비스2에 대한 설명입니다."));

        adService.save(new AD(
                "이벤트3", "이벤트3 소개", "이미지",
                timeStringToTimestamp("2024-01-21 09:00:00"),
                timeStringToTimestamp("2024-01-22 09:00:00"),
                200, "이벤트3에 대한 설명입니다."));

        userService.join(new User(24, "male"));

    }



}
