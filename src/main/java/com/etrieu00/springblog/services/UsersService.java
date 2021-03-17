package com.etrieu00.springblog.services;

import org.springframework.stereotype.Service;

import com.etrieu00.springblog.dto.UsersResponse;
import com.etrieu00.springblog.entities.Users;
import com.etrieu00.springblog.repositories.UsersJPA;

@Service
public class UsersService {
	private final UsersJPA usersJpa;
	
	public UsersService(UsersJPA usersJpa) {
		this.usersJpa = usersJpa;
	}
	
	public UsersResponse addNewUser(UsersResponse response) {
		if(response.getFirstName() == null 
		|| response.getLastName() == null) {
			return null;
		} else {
			Users user = new Users(response.getFirstName(),
					   			   response.getLastName());
								   Users newUser = usersJpa.save(user);
								   return new UsersResponse(newUser.getUserId(),
														    newUser.getFirstName(),
														    newUser.getLastName());
		}
	}
}
