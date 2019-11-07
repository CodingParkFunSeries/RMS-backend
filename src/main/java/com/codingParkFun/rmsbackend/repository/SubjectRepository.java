package com.codingParkFun.rmsbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

	List<Subject> findBySchoolIdAndSemesterIdAndBatchId(Long schoolId, Long semesterId, Long batchId);

}
