package com.sharethought.dao;

import java.util.List;

import com.sharethought.dto.UserDTO;

public interface UserDao {
	public List<UserDTO> getUsers();
}
