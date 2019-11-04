package com.codingParkFun.rmsbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
