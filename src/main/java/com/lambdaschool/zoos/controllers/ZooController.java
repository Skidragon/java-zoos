package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path={"/zoos"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {

    @Autowired
    ZooRepository zooRepo;
}
