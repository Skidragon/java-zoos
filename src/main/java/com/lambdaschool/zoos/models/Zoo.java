package com.lambdaschool.zoos.models;

import javax.persistence.*;

@Entity
@Table(name="zoos")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    //TODO create a many-to-many relationship with animal

    //TODO create a one-to-many relationship to telephone
    public Zoo() {
    }
}
