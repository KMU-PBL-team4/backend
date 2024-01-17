package com.example.kmupbl3.repository.mapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementTargetMappingRepository extends JpaRepository<AdvertisementTargetMapping, AdvertisementTargetMappingId> {

    List<AdvertisementTargetMapping> findByAdId(Integer adId);

}

