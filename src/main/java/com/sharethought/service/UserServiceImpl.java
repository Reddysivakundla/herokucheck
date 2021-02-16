package com.sharethought.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharethought.dao.UserDao;
import com.sharethought.dto.UserDTO;
import com.sharethought.utilites.MailFunction;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailFunction mailFunction;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> reqList = null;
		reqList = userDao.getUsers();
		return reqList;	
	}
	
	@Override
	public UserDTO getUser(Integer val) throws Exception {
		try {
			return userDao.getUser(val);
		}
		catch(Exception e) {
			throw new Exception("Application.NO_USER_FOUND");
		}
	}
	
	@Override
	public Integer createUser(UserDTO user) throws Exception {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(user.getPassword().getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
			String hashedPassword = sb.toString();
			user.setPassword(hashedPassword);
			
			List<String> userEmails = this.getAllUsers().stream().map(x -> x.getUseremail()).collect(Collectors.toList());
			if(userEmails.contains(user.getUseremail())) {
				throw new Exception("Application.EMAIL_ALREADY_EXIST");
			}
			
			Integer reqUserId = userDao.createUser(user);
			mailFunction.sendEmail(user.getUseremail(),reqUserId);
			return reqUserId;
			
		} catch (NoSuchAlgorithmException e) {
			 throw new Exception(e);
		}
	}
	
	@Override
	public String verifyEmail(Integer val) throws Exception {
		String verifyStatus = userDao.verifyEmail(val);
		if(verifyStatus == null) {
			throw new Exception("Application.NO_USER_FOUND");
		}
		return verifyStatus;
	}
}
