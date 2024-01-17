package com.example.kmupbl3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class AdUpdateDTO {
    private String title;

    private String shortHeading;

    private Timestamp startExposure;

    private Timestamp endExposure;

    private int count;

    private String description;


}
