package com.codingParkFun.rmsbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Marks;

public interface MarksRepository extends CrudRepository<Marks, Long> {

	List<Marks> findBySchoolIdAndSemesterIdAndStudentIdAndExamId(Long schoolId, Long semesterId, Long studentId,
			Long examId);

}
