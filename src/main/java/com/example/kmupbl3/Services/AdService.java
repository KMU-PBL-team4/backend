package com.example.kmupbl3.Services;

import com.example.kmupbl3.DTO.AdUpdateDTO;
import com.example.kmupbl3.Domain.AD;

import java.util.List;
import java.util.Optional;

public interface AdService {
    AD save(AD ad);

    void update(Integer id, AdUpdateDTO updateParam);

    Optional<AD> findById(Integer id);

    List<AD> findAds();
}
