package com.lambdaschool.zoos.models;

import javax.persistence.*;

@Entity
@Table(name="telephones")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phoneid;

    private String phonetype;

    private String phonenumber;

    //TODO create a many-to-one relationship with zoo using zooid


    //TODO remember the getters and setters once finished
    public Telephone() {
    }
}
