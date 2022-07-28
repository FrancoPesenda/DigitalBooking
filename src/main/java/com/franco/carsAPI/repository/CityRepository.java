package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CityRepository extends JpaRepository<City,Long> {
    @Query( value = "SELECT * FROM cities AS c WHERE c.city_name like %?1% " , nativeQuery = true)
    Optional<List<City>> findCityByCityName( String name ) ;

}
