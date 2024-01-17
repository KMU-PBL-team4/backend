package com.example.kmupbl3.service.ad;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.dto.AdUpdateDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface AdService {
    AD save(AD ad);

    void update(Integer id, AdUpdateDTO updateParam);

    Optional<AD> findById(Integer id);

    List<AD> findAds(AdSearchCond cond);

    boolean delete(Integer id);

    HashMap<Integer, Integer> findAdTags(List<Integer> adIdList);
}
