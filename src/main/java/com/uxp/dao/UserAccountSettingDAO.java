package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.UserAccountSetting;

@Transactional
public interface UserAccountSettingDAO extends CrudRepository<UserAccountSetting, Long> {
	
}
