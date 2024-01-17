package com.example.kmupbl3.repository.user;

import com.example.kmupbl3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
