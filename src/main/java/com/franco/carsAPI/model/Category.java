package com.franco.carsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


//LISTO
@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column( name = "singular_title")
    String singularTitle;
    @Column( name = "plural_title")
    String pluralTitle;
    @Column
    String image ;
    @OneToMany( mappedBy = "category", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column( name = "product_id")
    @JsonIgnore
    Set<Product> product ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSingularTitle() {
        return singularTitle;
    }

    public void setSingularTitle(String singularTitle) {
        this.singularTitle = singularTitle;
    }

    public String getPluralTitle() {
        return pluralTitle;
    }

    public void setPluralTitle(String pluralTitle) {
        this.pluralTitle = pluralTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
