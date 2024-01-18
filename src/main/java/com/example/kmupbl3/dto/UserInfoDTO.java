package com.example.kmupbl3.dto;

import com.example.kmupbl3.domain.AdTagConstants;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private String gender;

    /**
     * 유저의 나이와 성별을 Tag Id로 변환
     * @return
     */
    public List<Integer> getTagIdList() {
        return List.of(AdTagConstants.getIdByTagName(classifyAgeGroup(age)), AdTagConstants.getIdByTagName(gender));
    }

    private static String classifyAgeGroup(int age) {
        return (age <= 19) ? "10s-":
               (age <= 29) ? "20s" :
               (age <= 39) ? "30s" :
               (age <= 49) ? "40s" :
               (age <= 59) ? "50s" :
               (age <= 69) ? "60s" :
                             "70s+";
    }
}
