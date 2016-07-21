package com.uxp.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.uxp.dao.CollectionDAO;
import com.uxp.dao.InvitationDAO;
import com.uxp.dao.SuggestionDAO;
import com.uxp.dao.UserAccountSettingDAO;
import com.uxp.dao.UserActivityDAO;
import com.uxp.dao.UserDAO;
import com.uxp.dao.UserExpertiseDAO;
import com.uxp.dao.UserPermissionDAO;
import com.uxp.dao.UserProfileDAO;
import com.uxp.dao.UserRoleDAO;
import com.uxp.dao.VerificationDAO;
import com.uxp.model.Collection;
import com.uxp.model.InvitationRequest;
import com.uxp.model.ResponseMsg;
import com.uxp.model.Suggestion;
import com.uxp.model.User;
import com.uxp.model.UserAccountSetting;
import com.uxp.model.UserActivityLog;
import com.uxp.model.UserExpertise;
import com.uxp.model.UserPermissions;
import com.uxp.model.UserProfile;
import com.uxp.model.UserResponse;
import com.uxp.model.UserRole;
import com.uxp.model.Verification;


@Service
@Transactional
public class UserService_Impl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserProfileDAO userProfileDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;
	@Autowired
	private UserActivityDAO userActivityDAO;
	@Autowired
	private UserAccountSettingDAO userAccountSettingDAO;
	@Autowired
	private UserExpertiseDAO userExpertiseDAO;
	@Autowired
	private UserPermissionDAO userPermissionDAO;
	@Autowired
	private CollectionDAO collectionDAO;
	@Autowired 
	private InvitationDAO invitationDAO;
	@Autowired 
	private AnnotationService annoServ;
	@Autowired
	private SuggestionDAO suggestionDAO;
	@Autowired 
	VerificationDAO verificationDAO;
	
	public List<Collection> searchUserCollections(String term, String userName) {
		return collectionDAO.searchUserCollections(term, userName);
	}
	
	public Object logSuggestion(String suggestionType, String suggestion) {
		Suggestion sug = new Suggestion(suggestionType, suggestion);
		suggestionDAO.save(sug);
		return Collections.singletonMap("status", "Suggestion saved!");
	}
	
	public Object changeUserExpertise(String userName, String userExpertise) {
		UserProfile u = userProfileDAO.findOneByUserName(userName);
		User r = userDAO.findOneByUserProfileId(u.getUserProfileId());
		UserExpertise x = userExpertiseDAO.findOne(r.getUserExpertiseId());
		x.setUserExpertise(userExpertise);
		userExpertiseDAO.save(x);
		return Collections.singletonMap("status", "User Expertise updated!");
	}
	
	private String readInputStreamToString(HttpURLConnection connection) {
	    String result = null;
	    StringBuffer sb = new StringBuffer();
	    InputStream is = null;

	    try {
	        is = new BufferedInputStream(connection.getInputStream());
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String inputLine = "";
	        while ((inputLine = br.readLine()) != null) {
	            sb.append(inputLine);
	        }
	        result = sb.toString();
	    }
	    catch (Exception e) {
	       
	        result = null;
	    }
	    finally {
	        if (is != null) {
	            try { 
	                is.close(); 
	            } 
	            catch (IOException e) {
	                 Collections.singletonMap("error", "could not close the stream");
	            }
	        }   
	    }

	    return result;
	}
	
	public UserProfile getUserByEmail(String email) {
		try {
			return userProfileDAO.findOneByUserEmail(email);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	public void sendVerificationEmail(String email, String uuid) {
		try {
		URL url = new URL("https://htmlntopdf.herokuapp.com/email/verification?email=" + email + "&uuid="+ uuid);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("POST");
		OutputStreamWriter out = new OutputStreamWriter(
				 httpCon.getOutputStream());
		String resp = readInputStreamToString(httpCon);
		System.out.println(resp);
		out.close();
		} catch(Exception e) {
			System.out.println("error: " + e.toString());
		}
	}
	public String verifyGoogleToken(String googleToken) {
		try {
			URL url = new URL("https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=" + googleToken);
			 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			 httpCon.setDoOutput(true);
			 httpCon.setRequestMethod("POST");
			 OutputStreamWriter out = new OutputStreamWriter(
			 httpCon.getOutputStream());
			 String resp = readInputStreamToString(httpCon);
			 System.out.println("GOOGLE RESP: " + resp);
			 resp = resp.substring(1, resp.length()-1);
			 String[] keyValuePairs = resp.split(",");              //split the string to creat key-value pairs
			 Map<String,String> map = new HashMap<>();               

			 for(String pair : keyValuePairs)                        //iterate over the pairs
			 {
			     String[] entry = pair.split(":");                   //split the pairs to get key and value 
			     System.out.println(entry[0] + " " + entry[1]);
			     map.put(entry[0].trim().replaceAll("^\"|\"$", ""), entry[1].trim().replaceAll("^\"|\"$", ""));          //add them to the hashmap and trim whitespaces
			 }
			 String email = map.get("email");
			 System.out.println("MAP CREATED: " + map.toString());
			 out.close();
			 return email;
		} catch (Exception e) {
			System.out.println("Thats an error: " + e.toString());
			return "could not verify google token";
		}
	}
	
	public Object logInvitationRequest(String email, String name, String company) {
		if(invitationDAO.findAllByEmail(email).isEmpty()) {
			try {
				InvitationRequest ir = new InvitationRequest(email, name, company);
				invitationDAO.save(ir);
				return Collections.singletonMap("status", "posted");
			} catch(Exception e) {
				return Collections.singletonMap("error", "Could not save request");
			}
		} else {
			return Collections.singletonMap("error", "email has already requested an invitation.");
		}
	}
	
	public Object getInvitationRequests() {
		try {
			return invitationDAO.findAll();
		} catch (Exception e) {
			return Collections.singletonMap("error", "Could not list invitation requests");
		}
	}
	
	public Object checkUserNameAvailable(String userName) {
		if(userProfileDAO.findOneByUserName(userName) == null) {
			return Collections.singletonMap("status", "available");
		} else {
			return Collections.singletonMap("status", "in use");
		}
	}
	
	public Object checkEmailAvailable(String email) {
		System.out.println("EMAIL:  " + email);
		List<UserProfile> found = userProfileDAO.findAllByUserEmail(email);
		if(found.isEmpty()) {
			return Collections.singletonMap("status", "available");
		} else {
			return Collections.singletonMap("status", "in use");
		}
	}
	
	public Object postNewCollection(String userName, String annotations, String exportURI, String fileName) {
		
		Collection collection = new Collection(userName, annotations, exportURI, fileName);
		collectionDAO.save(collection);
		return Collections.singletonMap("response", "Collection Posted");
	}
	
	public List<Collection> findAllCollectionsByUserName(String userName) {
		return collectionDAO.findAllByUserName(userName);
	}
	
	public Object findCollectionById(long collectionId) {
		return collectionDAO.findOne(collectionId);
	}
	
	public UserProfile getUserProfile(String userName) {
		return userProfileDAO.findOneByUserName(userName);
	}
	public UserResponse getUserByUserName(String userName) {
		UserProfile userProfile = userProfileDAO.findOneByUserName(userName);
		User user = userDAO.findOneByUserProfileId(userProfile.getUserProfileId());
		UserExpertise ux = userExpertiseDAO.findOne(user.getUserExpertiseId());
		UserResponse up = new UserResponse(user, userProfile, ux);
		return up;
	}
	public UserResponse getUserByUserName(String userName, String token) {
		UserProfile userProfile = userProfileDAO.findOneByUserName(userName);
		User user = userDAO.findOneByUserProfileId(userProfile.getUserProfileId());
		UserExpertise ux = userExpertiseDAO.findOne(user.getUserExpertiseId());
		UserResponse up = new UserResponse(user, userProfile, ux, token);
		return up;
	}
	
	public User userLogin(String userName, String userPass) {
		UserProfile userProfile = userProfileDAO.findOneByUserName(userName);
			if(userProfile == null) {
				return null;
			}
		User user = userDAO.findOneByUserProfileId(userProfile.getUserProfileId());
		UserAccountSetting userAccountSetting = userAccountSettingDAO.findOne(user.getAccountSettingId());
		if(userAccountSetting.checkForMatch(userPass)) {
				return user;
		}
		return null;
	}
	public Object verifyUserEmail(String uuid) {
		try {
		Verification verification = verificationDAO.findOneByUuid(uuid);
		verification.setVerified(true);
		verificationDAO.save(verification);
		return Collections.singletonMap("success", "Email verified");
		} catch (Exception e) {
			System.out.println("Could not updated verification " + e.toString());
			return Collections.singletonMap("error", "Email verification failed");
		}
	}
	public boolean checkUserVerifiedEmail(User user) {
		try{
		Verification verification = verificationDAO.findOneByUserId(user.getUserId());
		if(verification.isVerified()) {
			return true;
		}
		return false;
		} catch(Exception e) {
			System.out.println("error verifying user email " + e.toString());
			return false;
		}
	}
	public Object createUser(String userName, String userPassword, String userFirstName, 
		   String userLastName, String userPicURL, String userEmail, String userEmployer,
		   String userDesignation, String userCity, String userState, String programId, 
		   long updatedBy, String userExpertise, String userRoleDescription, String userPermissionCode,
		   String userPermissionDescription, HttpServletRequest request, HttpServletResponse response) {
				if(userProfileDAO.findOneByUserName(userName) == null) {
					long profileId;
				    try {	 
				      
				      UserAccountSetting userAccountSetting = new UserAccountSetting(userPassword, programId, request.getRemoteAddr());
				      userAccountSettingDAO.save(userAccountSetting);
				      
				      UserRole userRole = new UserRole(userRoleDescription, programId, request.getRemoteAddr());
				      userRoleDAO.save(userRole);
				      
				      UserProfile userProfile = new UserProfile(userName, userFirstName, userLastName, userPicURL,
						userEmail, userEmployer, userDesignation, userCity, userState,
						programId, request.getRemoteAddr());
				      userProfileDAO.save(userProfile);
				      
				      UserExpertise _userExpertise = new UserExpertise(userExpertise, programId, request.getRemoteAddr());
				      userExpertiseDAO.save(_userExpertise);
				      
				      UserPermissions userPermission = new UserPermissions(userPermissionCode, userPermissionDescription, userRole.getUserRoleId(), programId, request.getRemoteAddr());
				      userPermissionDAO.save(userPermission);
				      
				      User user = new User(userAccountSetting.getUserId(), userRole.getUserRoleId(), userProfile.getUserProfileId(), _userExpertise.getUserId(), userPermission.getUserPermissionId(), programId, request.getRemoteAddr());
				      UserActivityLog userActivityLog = new UserActivityLog(user.getUserId(), "newUserCreated", programId, request.getRemoteAddr());
				      user.setUserActivityId(userActivityLog.getActivityId());
				      
				      
				      userActivityDAO.save(userActivityLog);
				      userDAO.save(user);
				      Verification verification = new Verification(user.getUserId());
				      verificationDAO.save(verification);
				      this.sendVerificationEmail(userProfile.getUserEmail(), verification.getUuid());
				      profileId = user.getUserId();
				    }
				    catch (Exception ex) {
				      System.out.println("Error creating the user: " + ex.toString());
				      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					  return new ResponseMsg("Error", "Could not create user");
				    }
				    response.setStatus(HttpServletResponse.SC_CREATED);
				    return new ResponseMsg("Success", "User " + profileId + " Created!");
	            } else {
	            	return Collections.singletonMap("response", "Username already in use");
	            }
		
			}
	
	public Object updateUserProfile(long userId, String userFirstName, String userLastName, StringBuffer userPicURL, String userEmployer, String userDesignation,
			String userCity, String userState, String programId, HttpServletResponse response, 
			HttpServletRequest request) {
		try {
			User foundUser = userDAO.findOne(userId);
			UserActivityLog userActivityLog = new UserActivityLog(userId, "profileChanged", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
			UserProfile storedProfile = userProfileDAO.findOne(foundUser.getUserProfileId());
			storedProfile.setUserFirstName(userFirstName);
			storedProfile.setUserLastName(userLastName);
			if(userPicURL.length() > 1 && !userPicURL.equals(storedProfile.getUserPicURL())) {
				storedProfile.setUserPicURL(annoServ.decodeBase64JPEG(userPicURL));
			}
			storedProfile.setUserEmployer(userEmployer);
			storedProfile.setUserDesignation(userDesignation);
			storedProfile.setUserCity(userCity);
			storedProfile.setUserState(userState);
			storedProfile.setLocId(request.getRemoteAddr());
			storedProfile.setTimeUpdated(new Date());
			userProfileDAO.save(storedProfile);
		} catch (Exception ex) {
		      System.out.println("Error updating the user profile: " + ex.toString());
		      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			  return new ResponseMsg("Error", "Could not update user profile");
		    }
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return new ResponseMsg("Message", "User " + userId + " profile updated.");
	}
	
	public Object changeUserPass(long userId, String programId, String oldPass, String newPass, HttpServletResponse response,  HttpServletRequest request) {
		try {
			User foundUser = userDAO.findOne(userId);
			UserAccountSetting storedAccount = userAccountSettingDAO.findOne(foundUser.getAccountSettingId());
			if(storedAccount.checkForMatch(oldPass)) {
				storedAccount.setUserPassword(newPass);
				UserActivityLog userActivityLog = new UserActivityLog(userId, "passChangeOK", programId, request.getRemoteAddr());
				userActivityLog.setUpdatedBy(userId);
				userActivityDAO.save(userActivityLog);
				userAccountSettingDAO.save(storedAccount);
			} else {
				UserActivityLog userActivityLog = new UserActivityLog(userId, "passChangeFail", programId, request.getRemoteAddr());
				userActivityLog.setUpdatedBy(userId);
				userActivityDAO.save(userActivityLog);
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return new ResponseMsg("Error", "Password mismatch");
			}
		} catch (Exception ex) {
		    System.out.println("Error updating the user password: " + ex.toString());
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    return new ResponseMsg("Error", "Could not update user profile");
		  }
		response.setStatus(HttpServletResponse.SC_OK);
		return new ResponseMsg("Message", "User " + userId + " Account Settings updated.");
	}
}
