package com.codingParkFun.rmsbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.codingParkFun.rmsbackend.model.Users;

public interface UserRepository extends CrudRepository<Users, Long> {

	Users findByUsername(String username);

}
