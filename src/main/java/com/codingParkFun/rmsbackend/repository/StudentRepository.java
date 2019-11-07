package com.codingParkFun.rmsbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findBySchoolIdAndBatchId(Long schoolId, Long batchId);
	
	void deleteBySchoolIdAndBatchId(Long schoolId, Long batchId);
}
