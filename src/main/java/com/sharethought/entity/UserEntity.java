package com.sharethought.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sharethought.dto.UserDTO;

@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "name")
	private String userName;
	@Column(name = "email")
	private String useremail;
	private String password;
	@Column(name = "verifcation_status")
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
	
	public static UserDTO convertUsersEntity(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userEntity.getUserId());
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setUseremail(userEntity.getUseremail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setVerifyStatus(userEntity.getVerifyStatus());
		return userDTO;
	}
}
