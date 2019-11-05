package com.codingParkFun.rmsbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Batch;

public interface BatchRepository extends CrudRepository<Batch, Long> {

	List<Batch> findBySchoolId(Long schoolId);

}
