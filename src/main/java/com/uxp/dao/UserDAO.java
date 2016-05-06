package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Long> {
	
}
