package com.sharethought.service;

import java.util.List;

import com.sharethought.dto.UserDTO;

public interface UserService {
	
	public List<UserDTO> getAllUsers();
	public UserDTO getUser(Integer val) throws Exception;
	public Integer createUser(UserDTO user) throws Exception;
	
}
