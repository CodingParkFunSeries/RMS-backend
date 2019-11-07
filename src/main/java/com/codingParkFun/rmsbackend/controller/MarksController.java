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
import com.codingParkFun.rmsbackend.model.Marks;
import com.codingParkFun.rmsbackend.service.MarksService;

@RestController
@RequestMapping("schools/{schoolId}/semesters/{semesterId}/exams/{examId}/students/{studentId}/marks")
public class MarksController {

	@Autowired
	MarksService marksService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createMarks(@PathVariable Long schoolId, @PathVariable Long examId, @PathVariable Long studentId,
			@RequestBody Marks marks) {

		if (marks.getSchoolId() == null) {
			marks.setSchoolId(schoolId);
		}

		if (marks.getSchoolId() != schoolId) {
			throw new IdMismatchException("Provided school id is invalid");
		}

		if (marks.getExamId() != examId) {
			throw new IdMismatchException("Provided exam id is invalid");
		}

		if (marks.getStudentId() != studentId) {
			throw new IdMismatchException("Provided student id is invalid");
		}

		marksService.create(marks);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Marks> getStudents(@PathVariable Long schoolId, @PathVariable Long semesterId, @PathVariable Long examId, @PathVariable Long studentId) {
		return marksService.getMarks(schoolId, semesterId, examId, studentId);
	}

	@GetMapping("/{marksId}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Marks> getMarks(@PathVariable Long marksId) {
		if (marksId == null) {
			throw new IdDoesNotExistException("Marks does not exist with this id");
		}

		return marksService.getMarksById(marksId);
	}
}
