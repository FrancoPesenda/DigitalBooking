package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Integer> countByCategoryId(Long id ) ;

    Optional<List<Product>> findAllProductByCategoryId( Long id ) ;

    Optional<List<Product>> findAllProductByLocationId(Long id);
    @Query(value = "SELECT p.id FROM products AS p" , nativeQuery = true)
    Optional<List<Integer>> findAllId() ;

}
