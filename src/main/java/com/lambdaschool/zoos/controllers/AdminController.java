package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.repositories.TelephoneRepository;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(path={"/admin"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    ZooRepository zooRepo;

    @Autowired
    AnimalRepository animalRepo;

    @Autowired
    TelephoneRepository phoneRepo;

    @PutMapping("/zoos/{id}")
    public Zoo updateCourseById(@RequestBody Zoo newZoo, @PathVariable long zooid) throws URISyntaxException {
        Optional<Zoo> updateZoo = zooRepo.findById(zooid);

        if(updateZoo.isPresent()) {
            newZoo.setZooid(zooid);
            zooRepo.save(newZoo);

            return newZoo;
        }
        else {
            return null;
        }
    }

    @PutMapping("/phones/{id}")
    public Telephone updatePhoneById(@RequestBody Telephone newPhone, @PathVariable long phoneid) throws URISyntaxException {
        Optional<Telephone> updatePhone = phoneRepo.findById(phoneid);

        if(updatePhone.isPresent()) {
            newPhone.setPhoneid(phoneid);
            phoneRepo.save(newPhone);

            return newPhone;
        }
        else {
            return null;
        }
    }

    @PutMapping("/animals/{id}")
    public Animal updateAnimalById(@RequestBody Animal newAnimal, @PathVariable long animalid) throws URISyntaxException {
        Optional<Animal> updateAnimal = animalRepo.findById(animalid);

        if(updateAnimal.isPresent()) {
            newAnimal.setAnimalid(animalid);
            animalRepo.save(newAnimal);

            return newAnimal;
        }
        else {
            return null;
        }
    }

}


