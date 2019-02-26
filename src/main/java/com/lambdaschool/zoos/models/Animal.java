package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalid;

    private String animaltype;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    private Set<Zoo> zoos = new HashSet<>();


    public Animal() {
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<Zoo> getZoos() {
        return zoos;
    }

    public void setZoos(Set<Zoo> zoos) {
        this.zoos = zoos;
    }
}
