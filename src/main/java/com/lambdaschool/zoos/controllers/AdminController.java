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
    public Zoo updateZooById(@RequestBody Zoo newZoo, @PathVariable long zooid) throws URISyntaxException {
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
    @PostMapping("/zoos")
    public Zoo createNewZoo(@RequestBody Zoo newZoo) throws URISyntaxException {
        return zooRepo.save(newZoo);
    }

    @PostMapping("/phones")
    public Telephone createNewPhone(@RequestBody Telephone newPhone) throws URISyntaxException {
        return phoneRepo.save(newPhone);
    }

    @PostMapping("/animals")
    public Animal createNewAnimal(@RequestBody Animal newAnimal) throws URISyntaxException {
        return animalRepo.save(newAnimal);
    }

//    //TODO: POST /admin/zoos/animals - add the zooid, animalid combination to the zoo animals relations table
//    @PostMapping("/zoos/animals")
//    public Animal createRelationBetweenZooAndAnimal(@RequestBody Object[] ids) {
//
//    }


    @DeleteMapping("/zoos/{id}")
    public Zoo deleteZooById(@PathVariable long zooid) {
        Optional<Zoo> foundZoo = zooRepo.findById(zooid);
        if(foundZoo.isPresent()) {
            zooRepo.deleteById(zooid);

            return foundZoo.get();
        }
        else {
            return null;
        }
    }
    @DeleteMapping("/phones/{id}")
    public Telephone deletePhoneById(@PathVariable long phoneid) {
        var foundPhone = phoneRepo.findById(phoneid);
        if(foundPhone.isPresent()) {
            phoneRepo.deleteById(phoneid);

            return foundPhone.get();
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/animals/{id}")
    public Animal deleteAnimalById(@PathVariable long animalid) {
        var foundAnimal = animalRepo.findById(animalid);
        if(foundAnimal.isPresent()) {
            animalRepo.deleteById(animalid);
            return foundAnimal.get();
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/zoos/{zooid}/animals/{animalid}")
    public String deleteAnimalFromZoo(@PathVariable long zooid, @PathVariable long animalid) {
        var foundZoo = zooRepo.findById(zooid);
        if(foundZoo.isPresent()) {
            zooRepo.deleteAnimalFromZoo(animalid);
            return "Animal from zoo has been deleted";
        }
        else {
            return null;
        }
    }

}


