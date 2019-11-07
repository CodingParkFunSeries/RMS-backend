package com.codingParkFun.rmsbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingParkFun.rmsbackend.model.Semester;

@Repository
public interface SemesterRepository extends CrudRepository<Semester, Long> {

	List<Semester> findBySchoolId(Long schoolId);
	
}
