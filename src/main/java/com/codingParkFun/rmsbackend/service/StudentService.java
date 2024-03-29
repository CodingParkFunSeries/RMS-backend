package com.codingParkFun.rmsbackend.service;

import com.codingParkFun.rmsbackend.model.Student;
import com.codingParkFun.rmsbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public void create(Student student) {
		studentRepository.save(student);
	}

	public List<Student> getStudentsInBatch(Long schoolId, Long batchId) {
		return (List<Student>) studentRepository.findBySchoolIdAndBatchId(schoolId, batchId);
	}

	public Optional<Student> getById(Long id) {
		return studentRepository.findById(id);
	}

	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	public void deleteStudentsInBatch(Long schoolId, Long batchId) {
		studentRepository.deleteBySchoolIdAndBatchId(schoolId, batchId);
	}
}
