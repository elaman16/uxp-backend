package com.uxp.dao;

import org.springframework.data.repository.CrudRepository;

import com.uxp.model.UserSuperUser;

public interface UserSuperUserDAO extends CrudRepository<UserSuperUser, Long> {

}
