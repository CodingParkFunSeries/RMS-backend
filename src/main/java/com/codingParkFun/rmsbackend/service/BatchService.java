package com.codingParkFun.rmsbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.Batch;
import com.codingParkFun.rmsbackend.repository.BatchRepository;

@Service
public class BatchService {

	@Autowired
	BatchRepository groupRepository;

	public void create(Batch group) {
		groupRepository.save(group);
	}

	public List<Batch> getGroupBySchoolId(Long schoolId) {
		return (List<Batch>) groupRepository.findBySchoolId(schoolId);
	}

	public Optional<Batch> getGroupById(Long groupId) {
		return (Optional<Batch>) groupRepository.findById(groupId);
	}
}
