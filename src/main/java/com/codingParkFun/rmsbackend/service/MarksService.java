package com.codingParkFun.rmsbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.Marks;
import com.codingParkFun.rmsbackend.repository.MarksRepository;

@Service
public class MarksService {

	@Autowired
	MarksRepository marksRepository;

	public void create(Marks group) {
		marksRepository.save(group);
	}

	public List<Marks> getMarks(Long schoolId, Long semesterId, Long studentId, Long examId) {
		return (List<Marks>) marksRepository.findBySchoolIdAndSemesterIdAndStudentIdAndExamId(schoolId, semesterId, studentId, examId);
	}
	
	public Optional<Marks> getMarksById(Long marksId) {
		return (Optional<Marks>) marksRepository.findById(marksId);
	}
}
