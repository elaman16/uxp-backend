package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.UserPermissions;

@Transactional
public interface UserPermissionDAO extends CrudRepository<UserPermissions, Long> {
	
}
