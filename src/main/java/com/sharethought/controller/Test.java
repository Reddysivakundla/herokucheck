package com.sharethought.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sharethought.dto.UserDTO;
import com.sharethought.service.UserService;

@RestController
public class Test {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String checkUrl() {
		return "Reddy Siva Kundla";
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		try {
			List<UserDTO> getUsers = userService.getAllUsers();
			
			return new ResponseEntity<List<UserDTO>>(getUsers, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
	}
}
