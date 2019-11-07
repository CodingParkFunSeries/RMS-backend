package com.codingParkFun.rmsbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.Subject;
import com.codingParkFun.rmsbackend.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	public void create(Subject subject) {
		subjectRepository.save(subject);
	}

	public List<Subject> getSubjects(Long schoolId, Long semesterId, Long batchId) {
		return (List<Subject>) subjectRepository.findBySchoolIdAndSemesterIdAndBatchId(schoolId, semesterId, batchId);
	}

	public Optional<Subject> getSubjectById(Long subjectId) {
		return (Optional<Subject>) subjectRepository.findById(subjectId);
	}
}
