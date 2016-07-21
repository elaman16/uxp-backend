package com.uxp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uxp.model.Collection;
import com.uxp.model.User;
import com.uxp.model.UserProfile;
import com.uxp.model.UserResponse;


public interface UserService {
	public List<Collection> searchUserCollections(String term, String userName);
	
	public Object createUser(String userName, String userPassword, String userFirstName, 
		   String userLastName, String userPicURL, String userEmail, String userEmployer,
		   String userDesignation, String userCity, String userState, String programId, 
		   long updatedBy, String userExpertise, String userRoleDescription, String userPermissionCode,
		   String userPermissionDescription, HttpServletRequest request, HttpServletResponse response);

	public Object changeUserPass(long userId, String programId, String oldPass, String newPass,
			HttpServletResponse response,  HttpServletRequest request);
	
	public Object logSuggestion(String suggestionType, String suggestion);
	
	public Object changeUserExpertise(String userName, String userExpertise);
	
	public Object checkUserNameAvailable(String userName);
	
	public Object checkEmailAvailable(String email);
	
	public Object updateUserProfile(long userId, String userFirstName, String userLastName, StringBuffer userPicURL, String userEmployer, String userDesignation,
			String userCity, String userState, String programId, HttpServletResponse response, 
			HttpServletRequest request);
	public User userLogin(String userName, String userPass);
	public UserProfile getUserProfile(String userName);
	public UserResponse getUserByUserName(String userName);
	public UserResponse getUserByUserName(String userName, String token);
	public Object postNewCollection(String userName, String annotations, String exportURI, String fileName);
	public List<Collection> findAllCollectionsByUserName(String userName);
	public Object findCollectionById(long collectionId);
	public Object logInvitationRequest(String email, String name, String company);
	public Object getInvitationRequests();
	public String verifyGoogleToken(String googleToken);
	public UserProfile getUserByEmail(String email);

	public boolean checkUserVerifiedEmail(User user);

	public Object verifyUserEmail(String uuid);
	void sendVerificationEmail(String name, String email, String uuid);
}
