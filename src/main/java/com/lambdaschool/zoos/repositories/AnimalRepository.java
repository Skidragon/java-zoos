package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal findByAnimaltype(String type);
}
