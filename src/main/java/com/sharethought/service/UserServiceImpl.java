package com.sharethought.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharethought.dao.UserDao;
import com.sharethought.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> reqList = null;
		reqList = userDao.getUsers();
		return reqList;	
	}

}
