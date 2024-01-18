package com.example.kmupbl3.service;

import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.service.ad.AdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.example.kmupbl3.tool.TimeTool.timeStringToTimestamp;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class AdServiceImplTest {

    @Autowired
    private AdService adService;

    @BeforeEach
    void setUp() {

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


    }

    @Test
    void save() {
        //given
        AD ad = new AD(
                "이벤트3", "이벤트3 소개", "이미지",
                timeStringToTimestamp("2024-01-21 09:00:00"),
                timeStringToTimestamp("2024-01-22 09:00:00"),
                200, "이벤트3에 대한 설명입니다.");
        //when
        AD save = adService.save(ad);

        //then
        assertThat(save.getId()).isEqualTo(3);
        assertThat(save.getTitle()).isEqualTo(ad.getTitle());
        assertThat(save.getShortHeading()).isEqualTo(ad.getShortHeading());
        assertThat(save.getStart_exposure()).isEqualTo(ad.getStart_exposure());
        assertThat(save.getEnd_exposure()).isEqualTo(ad.getEnd_exposure());
        assertThat(save.getCount()).isEqualTo(ad.getCount());
        assertThat(save.getReg_date()).isNotNull();
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAds() {
    }
}