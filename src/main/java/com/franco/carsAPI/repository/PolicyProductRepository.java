package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.PolicyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@EnableJpaRepositories
public interface PolicyProductRepository extends JpaRepository<PolicyProduct,Long> {
    Optional<Set<PolicyProduct>> findAllPolicyProductByProductId(Long id ) ;
}
