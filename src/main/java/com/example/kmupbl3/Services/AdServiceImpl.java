package com.example.kmupbl3.Services;

import com.example.kmupbl3.DTO.AdUpdateDTO;
import com.example.kmupbl3.Domain.AD;
import com.example.kmupbl3.Repository.ADRepository;
import com.example.kmupbl3.Repository.SpringDataJpaADRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    private final ADRepository adRepository;
    private final SpringDataJpaADRepository jpaADRepository;

    @Override
    public AD save(AD ad) {
        jpaADRepository.save(ad);
        return ad;
    }

    @Override
    public void update(Integer id, AdUpdateDTO updateParam) {

    }

    @Override
    public Optional<AD> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<AD> findAds() {
        return adRepository.findAll();
    }
}
