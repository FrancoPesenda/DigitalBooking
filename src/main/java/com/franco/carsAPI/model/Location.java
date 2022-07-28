package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table( name = "locations")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column
    @NotNull
    String address ;
    @Column( name = "address_number")
    @NotNull
    String addressNumber ;
    @Column
    @NotNull
    String latitude ;
    @Column
    @NotNull
    String longitude ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "city_id")
    City city ;
    @OneToOne( mappedBy = "location")
    @JsonIgnore
    Product product ;

}
