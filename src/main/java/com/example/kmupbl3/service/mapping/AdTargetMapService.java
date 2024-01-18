package com.example.kmupbl3.service.mapping;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.dto.AdShowDTO;
import com.example.kmupbl3.repository.mapping.AdvertisementTargetMapping;

import java.util.List;

public interface AdTargetMapService {

    AdvertisementTargetMapping assignAdTags(Integer adId, Integer tagId);

    List<AdShowDTO> selectAdForUser(Integer userId, AdSearchCond cond, Integer adQuantity);
}
