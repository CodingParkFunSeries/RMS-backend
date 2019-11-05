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

import com.codingParkFun.rmsbackend.exception.BatchMismatchException;
import com.codingParkFun.rmsbackend.model.Batch;
import com.codingParkFun.rmsbackend.service.BatchService;

@RestController
@RequestMapping("schools/{schoolId}/batches")
public class BatchController {

	@Autowired
	BatchService batchService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createGroup(@PathVariable long schoolId, @RequestBody Batch group) {
		
		if (group.getSchoolId() == null) {
			group.setSchoolId(schoolId);
		}
		
		if (group.getSchoolId() != schoolId) {
			throw new BatchMismatchException("School Id mismatch");
		}
		
		batchService.create(group);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Batch> getStudents(@PathVariable long schoolId) {
		return batchService.getGroupBySchoolId(schoolId);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("{batchId}")
	public Optional<Batch> getStudents(@PathVariable long schoolId, @PathVariable long batchId) {
		return batchService.getGroupById(batchId);
	}

}
