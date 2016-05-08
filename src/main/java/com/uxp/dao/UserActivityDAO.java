package com.uxp.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.UserActivityLog;

@Transactional
public interface UserActivityDAO extends CrudRepository<UserActivityLog, Long> {
	
	public List<UserActivityLog> findByActiveUserId(long userId);
	
}
