package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path={"/phones"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class TelephoneController {

    @Autowired
    TelephoneRepository phoneRepo;
}
