package com.example.kmupbl3.repository.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AdvertisementTargetMappingId.class)
public class AdvertisementTargetMapping implements Serializable {
    @Id
    private Integer adId;

    @Id
    private Integer featureId;
}

