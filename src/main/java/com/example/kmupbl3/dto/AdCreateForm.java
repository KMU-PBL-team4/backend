package com.example.kmupbl3.dto;

import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.tool.TimeTool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AdCreateForm {

    @NotBlank
    private String title;

    @NotBlank
    private String shortHeading;

    @NotBlank
    private String category;

    @NotBlank
    private Long startExposure;

    @NotBlank
    private Long endExposure;

    @Positive
    private int count;

    private String description;

    private String content;

    public static AD build(AdCreateForm form) {
        Timestamp startExposure = TimeTool.convertLongToTimestamp(form.startExposure);
        Timestamp endExposure = TimeTool.convertLongToTimestamp(form.endExposure);
        return new AD(form.title, form.shortHeading, form.category, startExposure, endExposure, form.count,
                form.description, form.content);
    }

}
