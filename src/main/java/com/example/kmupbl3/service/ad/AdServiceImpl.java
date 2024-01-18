package com.example.kmupbl3.service.ad;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.dto.AdUpdateDTO;
import com.example.kmupbl3.repository.AD.ADRepository;
import com.example.kmupbl3.repository.AD.SpringDataJpaADRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
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
        jpaADRepository.updateAdById(id, updateParam);
    }

    @Override
    public Optional<AD> findById(Integer id) {
        return jpaADRepository.findById(id);
    }

    @Override
    public List<AD> findAds(AdSearchCond cond) {
        log.debug("AdServiceImpl.findAds({})", cond);
        return adRepository.findAll(cond);
    }

    @Override
    public boolean delete(Integer id) {
        Optional<AD> byId = findById(id);

        if (byId.isPresent()) {
            jpaADRepository.delete(byId.get());
            return true;
        }
        else return false;
    }

}
