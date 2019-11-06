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
import com.codingParkFun.rmsbackend.exception.SchoolIdMismatchException;
import com.codingParkFun.rmsbackend.model.Semester;
import com.codingParkFun.rmsbackend.service.SemesterService;

@RestController
@RequestMapping("/schools/{schoolId}/semesters")
public class SemesterController {

	@Autowired
	SemesterService semesterService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createSemester(@PathVariable long schoolId, @RequestBody Semester semester) {
		if (semester.getSchoolId() == null) {
			semester.setSchoolId(schoolId);
		}

		if (semester.getSchoolId() != schoolId) {
			throw new SchoolIdMismatchException("School Id mismatch");
		}

		semesterService.create(semester);
	}

	@DeleteMapping("/{semesterId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteSemester(@PathVariable Long semesterId) {
		if (semesterId == null) {
			throw new IdDoesNotExistException("Given semester not present");
		}
		semesterService.delete(semesterId);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Semester> getStudents(@PathVariable long schoolId) {
		return semesterService.getSemesterBySchoolId(schoolId);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("{semesterId}")
	public Optional<Semester> getStudents(@PathVariable long schoolId, @PathVariable long semesterId) {
		return semesterService.getById(semesterId);
	}
}
