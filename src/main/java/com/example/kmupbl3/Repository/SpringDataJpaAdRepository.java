package com.example.kmupbl3.Repository;

import com.example.kmupbl3.Domain.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaAdRepository extends JpaRepository<Ad, Integer> {
}
