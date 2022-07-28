package com.franco.carsAPI.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "scores" )
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Score {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id ;
    @Column
    private Integer score ;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "product_id" )
    private Product product ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "user_id" )
    private User user ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Score score = (Score) o;
        return id != null && Objects.equals(id, score.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
