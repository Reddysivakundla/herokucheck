package com.sharethought.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sharethought.dto.UserDTO;
import com.sharethought.entity.UserEntity;


@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UserDTO> getUsers() {
		Query query = entityManager.createQuery("SELECT z FROM UserEntity z");
		List<UserEntity> userEntityList = query.getResultList();
		List<UserDTO> userDTOList = userEntityList.stream().map(x -> UserEntity.convertUsersEntity(x)).collect(Collectors.toList());
		return userDTOList;
	}
	
	@Override
	public UserDTO getUser(Integer val) {
		UserEntity usr = entityManager.find(UserEntity.class, val);
		UserDTO dtoUser = UserEntity.convertUsersEntity(usr);
		return dtoUser;
	}
	
	@Override
	public Integer createUser(UserDTO userDTO) {
		UserEntity user = UserDTO.convertDTO(userDTO);
		entityManager.persist(user);
		return user.getUserId();
	}
	
	@Override
	public String verifyEmail(Integer userId) {
		
		UserEntity userEntity = null;
		userEntity = entityManager.find(UserEntity.class, userId);
		
		if(userEntity == null) {
			return null;
		}
		
		if(userEntity.getVerifyStatus().equals("verified")) {
			return "Already Verified";
		}
		else {
			userEntity.setVerifyStatus("verified");
			entityManager.persist(userEntity);
		}
		return userEntity.getVerifyStatus();
	}
}
