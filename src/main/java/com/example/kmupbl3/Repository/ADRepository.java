package com.example.kmupbl3.Repository;

import com.example.kmupbl3.DTO.AdUpdateDTO;
import com.example.kmupbl3.Domain.AD;

import java.util.List;
import java.util.Optional;

public interface ADRepository {

    AD create(AD ad);

    Optional<AD> findById(Integer id);

    List<AD> findAll();

    void update(Integer id, AdUpdateDTO dto);

    void delete(Integer id);


}
