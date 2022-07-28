package com.franco.carsAPI.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id ;
    @Column( name = "start_time")
    LocalTime startTime ;
    @Column( name = "start_day")
    LocalDate startDay ;
    @Column( name = "finish_day")
    LocalDate finishDay ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "product_id")
    Product product;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "user_id")
    User user;
}
