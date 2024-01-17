package com.example.kmupbl3.repository.AD;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.dto.AdUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface ADRepository {

    AD create(AD ad);

    Optional<AD> findById(Integer id);

    List<AD> findAll(AdSearchCond cond);

    void update(Integer id, AdUpdateDTO dto);

    void delete(Integer id);


}
