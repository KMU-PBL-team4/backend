package com.example.kmupbl3;
import com.example.kmupbl3.Domain.AD;
import com.example.kmupbl3.Services.AdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Profile("test")
@RequiredArgsConstructor
@Slf4j
public class DummyDataGenerator {

    private final JdbcTemplate jdbcTemplate;
    private final AdService adService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // 원하는 INSERT 쿼리 실행
//        jdbcTemplate.execute("" +
//                "INSERT INTO ad (title, shortheading, start_exposure, end_exposure, count, description)\n" +
//                "VALUES\n" +
//                "    ('제품1', '제품1 소개', '2024-01-16 12:00:00', '2024-01-17 12:00:00', 100, '제품1에 대한 설명입니다.'),\n" +
//                "    ('서비스2', '서비스2 소개', '2024-01-18 15:30:00', '2024-01-20 18:45:00', 50, '서비스2에 대한 설명입니다.'),\n" +
//                "    ('이벤트3', '이벤트3 소개', '2024-01-21 09:00:00', '2024-01-22 09:00:00', 200, '이벤트3에 대한 설명입니다.');");

        adService.save(new AD(
                "제품1", "제품1 소개",
                timeStringToTimestamp("2024-01-16 12:00:00"),
                timeStringToTimestamp("2024-01-17 12:00:00"),
                100, "제품1에 대한 설명입니다."));

        adService.save(new AD(
                "서비스2", "서비스2 소개",
                timeStringToTimestamp("2024-01-18 15:30:00"),
                timeStringToTimestamp("2024-01-20 18:45:00"),
                50, "서비스2에 대한 설명입니다."));

        adService.save(new AD(
                "이벤트3", "이벤트3 소개",
                timeStringToTimestamp("2024-01-21 09:00:00"),
                timeStringToTimestamp("2024-01-22 09:00:00"),
                200, "이벤트3에 대한 설명입니다."));

    }

    private Timestamp timeStringToTimestamp(String before) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(before);
            return new Timestamp(parsedDate.getTime());
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption
            log.error("Error occured whlist parsing Timestamp from time string " + before, e);
        }
        log.warn("Something went wrong! Unreachable statement reached in: " + "DummyDataGenerator.timeStringToTimestamp(" + before + ")");
        return null;  // Unreachable
    }

}
