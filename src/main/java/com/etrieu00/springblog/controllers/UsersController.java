package com.etrieu00.springblog.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etrieu00.springblog.dto.UsersResponse;
import com.etrieu00.springblog.services.UsersService;

@RestController
public class UsersController implements BaseController {
	private final UsersService usersService;
	
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping(value = "/users", produces = "application/json")
	public ResponseEntity<?> addNewUser(@RequestBody UsersResponse request) {
		UsersResponse response = usersService.addNewUser(request);
		return response != null
			? new ResponseEntity<UsersResponse>(response, HttpStatus.CREATED)
			: new ResponseEntity<String>("Failed to add new user", HttpStatus.BAD_REQUEST);
	}
}
