package com.franco.carsAPI.repository;

import com.franco.carsAPI.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findAllReservationByProductId( Long id ) ;
    @Query(value = "SELECT * FROM reservations AS r WHERE r.user_id = ?1" , nativeQuery = true)
    List<Reservation> findAllReservationByUserId( Long id ) ;
}
