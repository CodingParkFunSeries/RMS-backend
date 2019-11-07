package com.codingParkFun.rmsbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.Semester;
import com.codingParkFun.rmsbackend.repository.SemesterRepository;

@Service
public class SemesterService {
	@Autowired
	SemesterRepository semesterRepository;

	public void create(Semester semester) {
		semesterRepository.save(semester);
	}

	public Optional<Semester> getById(long id) {
		return semesterRepository.findById(id);
	}

	public List<Semester> getSemesterBySchoolId(Long schoolId) {
		return (List<Semester>) semesterRepository.findBySchoolId(schoolId);
	}

	public void delete(Long id) {
		semesterRepository.deleteById(id);
	}
}
