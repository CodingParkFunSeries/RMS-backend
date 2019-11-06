package com.codingParkFun.rmsbackend.controller;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("schools/{schoolId}/batches/{batchId}/students")
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student> getStudent( @PathVariable String id ) {
        if (id == null) {
            throw new IdDoesNotExistException( "Student does not exist with this id" );
        }
        long studentId = Long.parseLong(id.substring( 1,id.length()-1 ));
        return studentService.getById( studentId );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent( @PathVariable String id ) {
        if (id == null) {
            throw new IdDoesNotExistException( "Student does not exist with this id" );
        }
        long studentId = Long.parseLong(id.substring( 1,id.length()-1 ));
        studentService.delete( studentId );
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllStudents(){
        studentService.deleteAll();
    }

}


