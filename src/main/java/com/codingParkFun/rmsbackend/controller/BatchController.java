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

import com.codingParkFun.rmsbackend.exception.SchoolIdMismatchException;
import com.codingParkFun.rmsbackend.model.Batch;
import com.codingParkFun.rmsbackend.service.BatchService;

@RestController
@RequestMapping("schools/{schoolId}/batches")
public class BatchController {

	@Autowired
	BatchService batchService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createGroup(@PathVariable String schoolId, @RequestBody Batch group) {
		long id = Long.parseLong( schoolId.substring( 1,schoolId.length()-1 ) );
		if (group.getSchoolId() == null) {
			group.setSchoolId(id);
		}
		if (group.getSchoolId() != id) {
			throw new SchoolIdMismatchException("School Id mismatch");}
		batchService.create(group);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Batch> getStudents(@PathVariable String schoolId) {
		long id = Long.parseLong( schoolId.substring( 1,schoolId.length()-1 ) );
		return batchService.getGroupBySchoolId(id);
	}

	@GetMapping("{batchId}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Batch> getStudents(@PathVariable  String schoolId, @PathVariable long batchId) {
		return batchService.getGroupById(batchId);
	}

}
