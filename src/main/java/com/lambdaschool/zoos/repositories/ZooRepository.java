package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ZooRepository extends JpaRepository<Zoo, Long> {

    Zoo findByZooname(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE animalid == :animalid", nativeQuery = true)
    void deleteAnimalFromZoo(long animalid);
}
