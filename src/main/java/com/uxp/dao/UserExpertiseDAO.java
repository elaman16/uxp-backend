package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.UserExpertise;

@Transactional
public interface UserExpertiseDAO extends CrudRepository<UserExpertise, Long> {
	
}
