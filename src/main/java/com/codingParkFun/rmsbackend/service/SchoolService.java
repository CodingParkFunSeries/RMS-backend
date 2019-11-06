package com.codingParkFun.rmsbackend.service;

import com.codingParkFun.rmsbackend.model.School;
import com.codingParkFun.rmsbackend.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public void create( School school ) {
        schoolRepository.save( school );
    }

    public Optional<School> getById( long id ) {
        return schoolRepository.findById( id );
    }

    public List<School> getSchools() {
        return (List<School>) schoolRepository.findAll();
    }

    public void  delete( Long id ) {
        schoolRepository.deleteById( id );
    }
}
