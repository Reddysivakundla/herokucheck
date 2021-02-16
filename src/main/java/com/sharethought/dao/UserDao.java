package com.sharethought.dao;

import java.util.List;

import com.sharethought.dto.UserDTO;

public interface UserDao {
	public List<UserDTO> getUsers();
	public UserDTO getUser(Integer val);
	public Integer createUser(UserDTO userDTO);
	public String verifyEmail(Integer userId);
}
