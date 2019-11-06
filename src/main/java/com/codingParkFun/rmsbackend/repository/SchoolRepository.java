package com.codingParkFun.rmsbackend.repository;

import com.codingParkFun.rmsbackend.model.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

}
