package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.UserRole;

@Transactional
public interface UserRoleDAO extends CrudRepository<UserRole, Long> {
	
}
