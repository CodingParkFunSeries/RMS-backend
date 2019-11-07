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

import com.codingParkFun.rmsbackend.exception.IdMismatchException;
import com.codingParkFun.rmsbackend.model.Batch;
import com.codingParkFun.rmsbackend.service.BatchService;

@RestController
@RequestMapping("schools/{schoolId}/batches")
public class BatchController {

	@Autowired
	BatchService batchService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createBatch(@PathVariable Long schoolId, @RequestBody Batch batch) {
		
		if (batch.getSchoolId() == null) {
			batch.setSchoolId(schoolId);
		}
		
		if (batch.getSchoolId() != schoolId) {
			throw new IdMismatchException("School Id mismatch");
		}
		
		batchService.create(batch);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Batch> getBatches(@PathVariable Long schoolId) {
		return batchService.getBatchesBySchoolId(schoolId);
	}

	@GetMapping("{batchId}")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("{batchId}")
	public Optional<Batch> getBatch(@PathVariable Long schoolId, @PathVariable Long batchId) {
		return batchService.getBatchById(batchId);
	}

}
