package com.codingParkFun.rmsbackend.controller;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import com.codingParkFun.rmsbackend.model.School;
import com.codingParkFun.rmsbackend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchool( @RequestBody School school ) {
        schoolService.create( school );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool( @PathVariable Long id ) {
        if (id == null) {
            throw new IdDoesNotExistException( "Given school not present" );
        }
        schoolService.delete( id );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAllSchools() {
        return schoolService.getSchools();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<School> getSchool( @PathVariable Long id ) {
        if (id == null) {
            throw new IdDoesNotExistException( "Given school not present" );
        }
        return schoolService.getById( id );
    }
}
