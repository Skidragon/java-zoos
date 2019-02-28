package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path={"/animals"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {

    @Autowired
    AnimalRepository animalRepo;

    @GetMapping("")
    public List<Animal> getAllAnimalsWithZoos() {
        return animalRepo.findAll();
    }

    @GetMapping("{type}")
    public Animal getAnimalByType(@PathVariable String type) {
        return animalRepo.findByAnimaltype(type);
    }

}
