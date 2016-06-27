package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import com.uxp.model.UserProfile;

@Transactional
public interface UserProfileDAO extends CrudRepository<UserProfile, Long> {
	public UserProfile findOneByUserName(String userName);
	public UserProfile findAllByUserEmail(String email);
}
