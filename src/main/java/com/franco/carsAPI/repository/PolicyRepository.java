package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PolicyRepository extends JpaRepository<Policy,Integer> {
}
