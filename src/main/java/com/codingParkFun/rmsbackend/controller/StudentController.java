package com.codingParkFun.rmsbackend.controller;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import com.codingParkFun.rmsbackend.exception.IdMismatchException;
import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("schools/{schoolId}/batches/{batchId}/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createStudent(@PathVariable Long schoolId, @PathVariable Long batchId, @RequestBody Student student) {

		if (student.getSchoolId() == null) {
			student.setSchoolId(schoolId);
		}
		
		if (student.getBatchId() == null) {
			student.setBatchId(batchId);
		}
		
		if (student.getSchoolId() != schoolId) {
			throw new IdMismatchException("Provided school id is invalid");
		}
		
		if (student.getBatchId() != batchId) {
			 throw new IdMismatchException("Provided batch id is invalid");
		}

		studentService.create(student);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getStudents(@PathVariable Long schoolId, @PathVariable Long batchId) {
		return studentService.getStudentsInBatch(schoolId, batchId);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Student> getStudent(@PathVariable Long studentId) {
		if (studentId == null) {
			throw new IdDoesNotExistException("Student does not exist with this id");
		}

		return studentService.getById(studentId);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudent(@PathVariable Long studentId) {
		if (studentId == null) {
			throw new IdDoesNotExistException("Student does not exist with this id");
		}

		studentService.delete(studentId);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAllStudents(@PathVariable Long schoolId, @PathVariable Long batchId) {
		studentService.deleteStudentsInBatch(schoolId, batchId);
	}

}
