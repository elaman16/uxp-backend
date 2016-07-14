package com.uxp.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uxp.dao.UserDAO;
import com.uxp.model.User;

@Service("annotationService")
@Transactional()
public class AdminService_Impl implements AdminService {
	@Autowired
	UserDAO userDAO;
	
	public Object disableUser(long userId) {
		User user = userDAO.findOne(userId);
		user.setUseStatus('B');
		userDAO.save(user);
		return Collections.singletonMap("status", "User " + userId + " has been blocked from login");
	}
	
}

