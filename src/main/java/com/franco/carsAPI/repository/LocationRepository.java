package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface LocationRepository extends JpaRepository<Location,Long> {
    Optional<List<Location>> findAllLocationByCityId(Long id);
    @Query(value = "SELECT * FROM locations AS l WHERE l.address = ?1 AND  l.address_number = ?2 " , nativeQuery = true)
    Optional<Location> findLocationByAddressAndAddressNumber( String address , String addresNumber ) ;
}
