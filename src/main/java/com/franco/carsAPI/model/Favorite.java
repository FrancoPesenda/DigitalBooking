package com.franco.carsAPI.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table( name = "favorites" )
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Favorite {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long id ;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "product_id" )
    Product product ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id" )
    User user ;
}
