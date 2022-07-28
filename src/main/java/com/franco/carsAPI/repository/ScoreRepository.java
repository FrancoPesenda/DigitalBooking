package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ScoreRepository extends JpaRepository<Score,Long> {

    Optional<List<Score>> getAllScoreByProductId(Long id ) ;
}
