package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

// LISTO
@Entity
@Table( name = "cities")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String cityName ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "country_id")
    private Country country ;
    @OneToMany( mappedBy = "city" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "location_id")
    @JsonIgnore
    private Set<Location> locationSet ;
    //CAMBIAR
    @OneToMany( mappedBy = "user" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "score_id" )
    @JsonIgnore
    private Set<Score> scoreSet ;

    public City( Long id){
        super();
        this.id = id ;
    }

    public City( String cityName, Country country) {
        super();
        this.cityName = cityName;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;
        return id != null && Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
