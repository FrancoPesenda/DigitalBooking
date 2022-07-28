package com.franco.carsAPI.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "policies_products")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyProduct {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id ;
    @Column( length = 2500)
    String description ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "product_id")
    Product product ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "policy_id")
    Policy policy ;

    public PolicyProduct(String description, Product product, Policy policy) {
        this.description = description;
        this.product = product;
        this.policy = policy;
    }
}
