package com.sharethought.dto;

import com.sharethought.entity.UserEntity;

public class UserDTO {
	
	private Integer userId;
	private String userName;
	private String useremail;
	private String password;
	private String verifyStatus;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyStatus() {
		return verifyStatus;
	}
	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	
	public static UserEntity convertDTO(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userDTO.getUserId());
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setUseremail(userDTO.getUseremail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setVerifyStatus(userDTO.getVerifyStatus());
		return userEntity;
	}
}
