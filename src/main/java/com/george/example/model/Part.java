package com.george.example.model;

import javax.persistence.*;

/**
 * Created by george on 9/10/17.
 */
@Entity
public class Part {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @Column(length = 50)
    String name;

    @ManyToOne(fetch=FetchType.LAZY)
    Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
