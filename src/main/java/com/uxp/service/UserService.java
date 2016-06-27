package com.uxp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.uxp.model.UserProfile;
import com.uxp.model.UserResponse;


public interface UserService {
	public Object createUser(String userName, String userPassword, String userFirstName, 
		   String userLastName, String userPicURL, String userEmail, String userEmployer,
		   String userDesignation, String userCity, String userState, String programId, 
		   long updatedBy, String userExpertise, String userRoleDescription, String userPermissionCode,
		   String userPermissionDescription, HttpServletRequest request, HttpServletResponse response);

	public Object changeUserPass(long userId, String programId, String oldPass, String newPass,
			HttpServletResponse response,  HttpServletRequest request);
	
	public Object checkUserNameAvailable(String userName);
	
	public Object checkEmailAvailable(String email);
	
	public Object updateUserProfile(long userId, String userFirstName, String userLastName, String userPicURL, String userEmployer, String userDesignation,
			String userCity, String userState, String programId, HttpServletResponse response, 
			HttpServletRequest request);
	public boolean userLogin(String userName, String userPass);
	public UserProfile getUserProfile(String userName);
	public UserResponse getUserByUserName(String userName);
	public UserResponse getUserByUserName(String userName, String token);
	public Object postNewCollection(long userId, String annotations, String exportURI);
	public Object findAllCollectionsByUserId(long userId);
}
