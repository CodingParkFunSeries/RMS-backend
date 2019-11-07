package com.codingParkFun.rmsbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long> {

	List<Exam> findBySchoolIdAndSemesterIdAndBatchId(Long schoolId, Long semesterId, Long batchId);

}
