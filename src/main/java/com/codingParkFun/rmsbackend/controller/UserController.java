package com.codingParkFun.rmsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import com.codingParkFun.rmsbackend.model.UserDetail;
import com.codingParkFun.rmsbackend.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UsersService usersService;

	@GetMapping("/{username}")
	@ResponseStatus(HttpStatus.OK)
	public UserDetail getUser(@PathVariable String username) {
		if (username == null) {
			throw new IdDoesNotExistException("User does not exist with provided username");
		}

		return usersService.getUserByName(username);
	}

}
