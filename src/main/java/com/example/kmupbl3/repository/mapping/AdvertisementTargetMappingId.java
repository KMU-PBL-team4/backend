package com.example.kmupbl3.repository.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor  // JPA는 기본 생성자 필요.
@AllArgsConstructor
@Data
public class AdvertisementTargetMappingId implements Serializable {
    private Integer adId;
    private Integer featureId;
}

