package com.lambdaschool.zoos.models;

import javax.persistence.*;

@Entity
@Table(name="animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalid;

    private String animaltype;

    //TODO create many-to-many relationship with zoo

    //TODO remember to add getters and setters once finished


    public Animal() {
    }
}
