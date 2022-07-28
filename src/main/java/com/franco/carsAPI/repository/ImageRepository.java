package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@EnableJpaRepositories
public interface ImageRepository extends JpaRepository<Image,Long> {
    @Query(value = "SELECT * FROM images AS i WHERE i.product_id = ?1" , nativeQuery = true)
    Optional<Set<Image>> findAllImageFromProductID(Long id ) ;
}
