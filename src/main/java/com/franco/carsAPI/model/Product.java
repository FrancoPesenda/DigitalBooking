package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column
    @NotNull
    String name ;
    @Column
    @NotNull
    String descriptionTitle ;
    @Column(nullable = false, length = 2500)
    @NotNull
    String description ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "category_id")
    @NotNull
    Category category;
    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "location_id")
    @NotNull
    Location location ;
    @OneToMany( mappedBy = "product" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "score_id" )
    @JsonIgnore
    Set<Score> scoreSet ;
    @OneToMany( mappedBy = "product" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "feature_products_id")
    @JsonIgnore
    Set<FeatureProduct> featureProductSet;
    @OneToMany( mappedBy = "product" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "image_id")
    @JsonIgnore
    Set<Image> imageSet;
    @OneToMany( mappedBy = "product" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "policies_product_id")
    @JsonIgnore
    Set<PolicyProduct> policyProductSet ;
    @OneToMany( mappedBy = "product" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "reservation_id")
    @JsonIgnore
    Set<Reservation> reservationSet ;
    @OneToMany( mappedBy = "user" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "favorite_id")
    @JsonIgnore
    Set<Favorite> favoriteSet ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
