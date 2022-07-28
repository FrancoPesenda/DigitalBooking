package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "policies")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Policy {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id ;
    @Column
    String policy ;
    @OneToMany( mappedBy = "policy" ,fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "policies_product_id")
    @JsonIgnore
    Set<PolicyProduct> policyProductSet ;
}
