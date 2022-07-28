package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.FeatureProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface FeatureProductRepository extends JpaRepository<FeatureProduct,Long> {

    Optional<List<FeatureProduct>> findAllFeatureByProductId(Long id ) ;

}

