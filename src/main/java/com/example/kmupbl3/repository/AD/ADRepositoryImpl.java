package com.example.kmupbl3.repository.AD;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.dto.AdUpdateDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static com.example.kmupbl3.domain.QAD.aD;

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
    public List<AD> findAll(AdSearchCond cond) {
        return query
                .selectFrom(aD)
                .where(
                        equalCategory(cond.getCategory()),
                        betweenAdvertiseTime(cond.getTimestamp())
                )
                .fetch();
    }

    private BooleanExpression equalCategory(String category) {
        if (StringUtils.hasText(category)) {
            return aD.category.eq(category);
        }
        return null;
    }

    private BooleanExpression betweenAdvertiseTime(Timestamp timestamp) {
        if (timestamp != null) {
            return aD.start_exposure.after(timestamp).and(aD.end_exposure.before(timestamp));
        }
        return null;
    }

    @Override
    public void update(Integer id, AdUpdateDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
