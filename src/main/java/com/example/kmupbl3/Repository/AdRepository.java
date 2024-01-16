package com.example.kmupbl3.Repository;

import com.example.kmupbl3.DTO.AdUpdateDTO;
import com.example.kmupbl3.Domain.Ad;

import java.util.List;
import java.util.Optional;

public interface AdRepository {

    Ad create(Ad ad);

    Optional<Ad> findById(Integer id);

    List<Ad> findAll();

    void update(Integer id, AdUpdateDTO dto);

    void delete(Integer id);


}
