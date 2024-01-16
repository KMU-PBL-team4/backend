package com.example.kmupbl3.Repository;

import com.example.kmupbl3.DTO.AdUpdateDTO;
import com.example.kmupbl3.Domain.AD;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.kmupbl3.Domain.QAD.aD;

@Slf4j
@Repository
@Transactional
public class ADRepositoryImpl implements ADRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public ADRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public AD create(AD ad) {
        em.persist(ad);
        return ad;
    }

    @Override
    public Optional<AD> findById(Integer id) {
        AD ad = em.find(AD.class, id);
        return Optional.ofNullable(ad);
    }

    @Override
    public List<AD> findAll() {
        return query.selectFrom(aD).fetch();
    }

    @Override
    public void update(Integer id, AdUpdateDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
