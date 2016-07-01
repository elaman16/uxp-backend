package com.uxp.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import com.uxp.model.UserProfile;

@Transactional
public interface UserProfileDAO extends CrudRepository<UserProfile, Long> {
	public UserProfile findOneByUserName(String userName);
	public List<UserProfile> findAllByUserEmail(String email);
	public UserProfile findOneByUserEmail(String email);
}
