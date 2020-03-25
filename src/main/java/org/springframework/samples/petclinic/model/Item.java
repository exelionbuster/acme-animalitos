package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "items")
public class Item extends NamedEntity {

    @NotNull
    @Min(value = 0)
    @Column(name="price")
    private Double price;

    @NotNull
    @Min(value = 0)
    @Column(name="amount")
    private Integer amount;

    @URL
    @Column(name="photo")
    private String photo;

    @ManyToOne(optional = false)
//    @Column(name="shop")
    private Shop shop;
}
