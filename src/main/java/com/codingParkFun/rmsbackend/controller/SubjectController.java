package com.codingParkFun.rmsbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import com.codingParkFun.rmsbackend.exception.IdMismatchException;
import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.model.Subject;
import com.codingParkFun.rmsbackend.service.SubjectService;

@RestController
@RequestMapping("/schools/{schoolId}/semesters/{semesterId}/batches/{batchId}/subjects")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createSubject(@PathVariable Long schoolId, @PathVariable Long semesterId, @PathVariable Long batchId,
			@RequestBody Subject subject) {

		if (subject.getSchoolId() == null) {
			subject.setSchoolId(schoolId);
		}

		if (subject.getBatchId() == null) {
			subject.setBatchId(batchId);
		}

		if (subject.getSemesterId() == null) {
			subject.setSemesterId(semesterId);
		}

		if (subject.getSchoolId() != schoolId) {
			throw new IdMismatchException("Provided school id is invalid");
		}

		if (subject.getSemesterId() != semesterId) {
			throw new IdMismatchException("Provided semester id is invalid");
		}

		if (subject.getBatchId() != batchId) {
			throw new IdMismatchException("Provided batch id is invalid");
		}

		subjectService.create(subject);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Subject> getSubjects(@PathVariable Long schoolId, @PathVariable Long semesterId,
			@PathVariable Long batchId) {
		return subjectService.getSubjects(schoolId, semesterId, batchId);
	}

	@GetMapping("/{subjectId}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Subject> getSubject(@PathVariable Long schoolId, @PathVariable Long semesterId,
			@PathVariable Long batchId, @PathVariable Long subjectId) {
		if (subjectId == null) {
			throw new IdDoesNotExistException("subject does not exist with this id");
		}

		return subjectService.getSubjectById(subjectId);
	}

}
