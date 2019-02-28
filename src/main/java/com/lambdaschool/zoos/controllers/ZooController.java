package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path={"/zoos"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {

    @Autowired
    ZooRepository zooRepo;

    @GetMapping("")
    public List<Zoo> getAllZoosWithAnimalsAndPhone() {
        return zooRepo.findAll();
    }
    @GetMapping("{name}")
    public Zoo getZooByName(@PathVariable String name) {
        return zooRepo.findByZooname(name);
    }
}
