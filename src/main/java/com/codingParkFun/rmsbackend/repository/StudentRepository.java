package com.codingParkFun.rmsbackend.repository;

import com.codingParkFun.rmsbackend.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
