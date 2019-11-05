package com.codingParkFun.rmsbackend.service;

import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void create( Student student ) {
        studentRepository.save( student );
    }

    public List<Student> get() {
        return (List<Student>) studentRepository.findAll();
    }
}
