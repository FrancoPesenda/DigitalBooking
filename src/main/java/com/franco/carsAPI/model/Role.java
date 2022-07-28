package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id ;
    @Column( name = "name")
    String name;
    @OneToMany( mappedBy = "role" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "user_id")
    @JsonIgnore
    Set<User> userSet ;
}
