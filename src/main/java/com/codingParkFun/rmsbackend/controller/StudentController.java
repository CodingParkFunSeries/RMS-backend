package com.codingParkFun.rmsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent( @RequestBody Student student ) {
        studentService.create( student );
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents() {
        return studentService.get();
    }


}
