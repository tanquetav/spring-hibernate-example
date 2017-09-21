package com.george.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@org.hibernate.annotations.Entity(
        dynamicUpdate = true
)
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @Column(length = 50)
    String name;
    @Column(length = 250)
    String description;

    @OneToMany(mappedBy = "product")
    List<Part> parts = new ArrayList<Part>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
