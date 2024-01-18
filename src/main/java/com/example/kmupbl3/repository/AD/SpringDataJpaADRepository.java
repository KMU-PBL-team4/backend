package com.example.kmupbl3.repository.AD;

import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.dto.AdUpdateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SpringDataJpaADRepository extends JpaRepository<AD, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE ad " +
            "SET title = :#{#updateDTO.title}, " +
            "shortheading = :#{#updateDTO.shortHeading}, " +
            "start_exposure = :#{#updateDTO.start_exposure}, " +
            "end_exposure = :#{#updateDTO.end_exposure}, " +
            "count = :#{#updateDTO.count}, " +
            "description = :#{#updateDTO.description} " +
            "WHERE id = :id", nativeQuery = true)
    int updateAdById(@Param("id") Integer id, @Param("updateDTO") AdUpdateDTO updateDTO);

}
