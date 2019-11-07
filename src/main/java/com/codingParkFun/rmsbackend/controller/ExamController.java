package com.codingParkFun.rmsbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import com.codingParkFun.rmsbackend.exception.IdMismatchException;
import com.codingParkFun.rmsbackend.model.Exam;
import com.codingParkFun.rmsbackend.service.ExamService;

@RestController
@RequestMapping("schools/{schoolId}/semesters/{semesterId}/batches/{batchId}/exams")
public class ExamController {

	@Autowired
	ExamService examService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createExam(@PathVariable Long schoolId, @PathVariable Long semesterId, @PathVariable Long batchId,
			@RequestBody Exam exam) {

		if (exam.getSchoolId() == null) {
			exam.setSchoolId(schoolId);
		}

		if (exam.getBatchId() == null) {
			exam.setBatchId(batchId);
		}

		if (exam.getSemesterId() == null) {
			exam.setSemesterId(semesterId);
		}

		if (exam.getSchoolId() != schoolId) {
			throw new IdMismatchException("Provided school id is invalid");
		}

		if (exam.getSemesterId() != semesterId) {
			throw new IdMismatchException("Provided semester id is invalid");
		}

		if (exam.getBatchId() != batchId) {
			throw new IdMismatchException("Provided batch id is invalid");
		}

		examService.create(exam);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Exam> getExams(@PathVariable Long schoolId, @PathVariable Long semesterId, @PathVariable Long batchId) {
		return examService.getExams(schoolId, semesterId, batchId);
	}

	@GetMapping("/{examId}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Exam> getExam(@PathVariable Long schoolId, @PathVariable Long semesterId,
			@PathVariable Long batchId, @PathVariable Long examId) {
		if (examId == null) {
			throw new IdDoesNotExistException("Exam does not exist with this id");
		}

		return examService.getExamById(examId);
	}

}
