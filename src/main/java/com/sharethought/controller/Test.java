package com.sharethought.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sharethought.dto.UserDTO;
import com.sharethought.service.UserService;
import com.sharethought.utilites.MailFunction;

@RestController
public class Test {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailFunction mailFunction;
	
	@Autowired
	private Environment env;

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
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId){
		try {
			UserDTO userDto = userService.getUser(userId);
			return new ResponseEntity<UserDTO>(userDto,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,env.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO){
		try {
			Integer userId = userService.createUser(userDTO);
			return new ResponseEntity<Integer>(userId, HttpStatus.CREATED);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,env.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping("/sendEmail")
	public ResponseEntity<String> testSendMail(){
		try {
			mailFunction.sendEmail();
			mailFunction.sendEmail("reddysiva9920@gmail.com", 1);
			return new ResponseEntity<String>("Sent",HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.CHECKPOINT,env.getProperty(e.getMessage()));
		}
	}
}
