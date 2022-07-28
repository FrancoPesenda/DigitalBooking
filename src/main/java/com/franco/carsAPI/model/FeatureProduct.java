package com.franco.carsAPI.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "featuresproducts")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeatureProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "product_id" )
    private Product product ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "feature_id" )
    private Feature feature;

    public FeatureProduct(Product product, Feature feature) {
        this.product = product;
        this.feature = feature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FeatureProduct that = (FeatureProduct) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
