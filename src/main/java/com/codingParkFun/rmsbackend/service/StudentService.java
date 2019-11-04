package com.codingParkFun.rmsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.repository.StudentRepository;

@Service
public
class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void create( Student student ) {
        System.out.println( studentRepository.save( student ) );
    }

    public List<Student> get() {
        return (List<Student>) studentRepository.findAll();
    }
}
