package com.example.kmupbl3.Repository;

import com.example.kmupbl3.DTO.AdUpdateDTO;
import com.example.kmupbl3.Domain.Ad;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class AdRepositoryImpl implements AdRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public AdRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public Ad create(Ad ad) {
        em.persist(ad);
        return ad;
    }

    @Override
    public Optional<Ad> findById(Integer id) {
        Ad ad = em.find(Ad.class, id);
        return Optional.ofNullable(ad);
    }

    @Override
    public List<Ad> findAll() {
        return query
                .select(ad)
                .from(ad)
                .fetch();
        return null;
    }

    @Override
    public void update(Integer id, AdUpdateDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
