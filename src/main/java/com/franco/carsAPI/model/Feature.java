package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name = "features")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String feature ;
    @OneToMany( mappedBy = "feature", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "feature_product_id")
    @JsonIgnore
    private Set<FeatureProduct> featureProductSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Feature feature = (Feature) o;
        return id != null && Objects.equals(id, feature.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<FeatureProduct> getFeatureProductSet() {
        return featureProductSet;
    }

    public void setFeatureProductSet(Set<FeatureProduct> featureProductSet) {
        this.featureProductSet = featureProductSet;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
