package com.codingParkFun.rmsbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.Exam;
import com.codingParkFun.rmsbackend.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;

	public void create(Exam exam) {
		examRepository.save(exam);
	}

	public List<Exam> getExams(Long schoolId, Long semesterId, Long batchId) {
		return (List<Exam>) examRepository.findBySchoolIdAndSemesterIdAndBatchId(schoolId, semesterId, batchId);
	}

	public Optional<Exam> getExamById(Long examId) {
		return (Optional<Exam>) examRepository.findById(examId);
	}
}
