package com.uxp.controller;


import java.security.Key;
import java.util.Collections;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.uxp.model.User;
import com.uxp.model.UserProfile;
import com.uxp.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;



@RestController
@CrossOrigin
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	private Key key = ControllerConfig.key;
	
	//*************************************POST REQUESTS***********************************
	
	/*
	 * POST to create a new user.
	 */
	@RequestMapping(value="", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public @ResponseBody Object createUser(@RequestParam String userName, @RequestParam String userPassword, @RequestParam String userFirstName, 
			@RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail, @RequestParam String userEmployer,
			@RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState, @RequestParam(required=false) String programId, 
			@RequestParam long updatedBy, @RequestParam String userExpertise, @RequestParam String userRoleDescription,
			@RequestParam String userPermissionCode, @RequestParam String userPermissionDescription, HttpServletRequest request, HttpServletResponse response) {
		return userService.createUser(userName, userPassword, userFirstName, userLastName, userPicURL, userEmail, userEmployer, userDesignation, userCity, userState, programId, updatedBy, userExpertise, userRoleDescription, userPermissionCode, userPermissionDescription, request, response);
	}
	/*
	 * POST to Login
	 */
	@RequestMapping(value="/googleLogin", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Object verifyGoogleToken(@RequestParam String googleToken) {
		try {
			String email = userService.verifyGoogleToken(googleToken);
			System.out.println("Response from google: email - " + email);
			if(email.length() > 0) {
				 long now = new Date().getTime();
				 long expires = now + 86400000;
				 try {
					 UserProfile up = userService.getUserByEmail(email);
					 System.out.println("USER FOUND: " + up.toString());
					 String s = Jwts.builder().setSubject(up.getUserName()).setIssuer("UxP-Gll").setExpiration(new Date(expires)).setHeaderParam("user", up).signWith(SignatureAlgorithm.HS512, key).compact();
					 return userService.getUserByUserName(up.getUserName(), s);
				 } catch (Exception e) {
					 return Collections.singletonMap("error", "no account found for email: " + email); 
				 }
				 
			} else {
				return Collections.singletonMap("error", "bad response from google");
			}
		} catch(Exception e) {
			System.out.println(e.toString());
			return Collections.singletonMap("error", "token could not be validated");
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public @ResponseBody Object loginUser(@RequestParam String userName, @RequestParam String userPassword, HttpServletRequest request, HttpServletResponse response) {	
		
		User user = userService.userLogin(userName, userPassword);
		if(user != null) {
			 long now = new Date().getTime();
			 long expires = now + 86400000;
			 if(user.getUseStatus() == 'B') {
				 return Collections.singletonMap("error", "This account has been disabled");
			 }
			 String s;
			 if(user.getUseStatus() == 'A') {
				 s = Jwts.builder().setSubject(userName).setIssuer("UxP-Gll").setExpiration(new Date(expires)).setHeaderParam("user", user).signWith(SignatureAlgorithm.HS512, key).compact();
			 } else {
				 s = Jwts.builder().setSubject(userName).setIssuer("UxP-Gll").setExpiration(new Date(expires)).setHeaderParam("user", user).signWith(SignatureAlgorithm.HS512, key).compact();
			 }
			 return userService.getUserByUserName(userName, s);
		 } else {
			 return Collections.singletonMap("response", "Invalid Username or Password");
		 }
	}
	/*
	 * POST to update existing user profile
	 */
	@RequestMapping(value="/{userId}/userProfile", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserProfile(@PathVariable("userId") long userId, @RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam(defaultValue="") StringBuffer userPicURL,
			@RequestParam String userEmployer, @RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState,
			@RequestParam(required=false) String programId, UriComponentsBuilder ucBuilder,  HttpServletResponse response,  HttpServletRequest request, @RequestHeader(name="Authorization") String token) {
			try {
				if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll") || Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Admin")) {
					return userService.updateUserProfile(userId, userFirstName, userLastName, userPicURL, userEmployer, userDesignation, userCity, userState, programId, response, request);
				} else {
					return Collections.singletonMap("error", "Not Authorized");
				}
			} catch(SignatureException e) {
				return Collections.singletonMap("error", "Not Authorized");
			} catch(MalformedJwtException m) {
				return Collections.singletonMap("error", "Bad token");
			}
		
			
		
		
	}
	/*
	 * POST to change user password, old pass req'd
	 */
	@RequestMapping(value="/{userId}/userAccountSetting", method=RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE )
	public @ResponseBody Object postUserAccountSetting(@PathVariable("userId") long userId, @RequestParam(required=false) String programId, 
		   @RequestParam String oldPass, @RequestParam String newPass, HttpServletResponse response,  HttpServletRequest request, HttpSession session, @RequestHeader(name="Authorization") String token) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.changeUserPass(userId, programId, oldPass, newPass, response, request);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	// POST a new collection of annotations
	@RequestMapping(value="/{userName}/collections", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Object postNewCollection(@PathVariable("userName") String userName, @RequestParam String annotations, @RequestParam String exportURI, @RequestParam String fileName, @RequestHeader(name="Authorization") String token) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.postNewCollection(userName, annotations, exportURI, fileName);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	
	//POST to change users 'userExpertise'
	@RequestMapping(value="/{userId}/expertise", method=RequestMethod.POST)
	public @ResponseBody Object changeUserExpertise(@PathVariable("userId") String userId, @RequestHeader(name="Authorization") String token, @RequestParam String userExpertise) {
		try {			
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("sub").toString() != null) {
				String tokenUser = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("sub").toString();
				return userService.changeUserExpertise(tokenUser, userExpertise);
			} else {
				return Collections.singletonMap("error", "Could not updated user expertise"); 
			}
		} catch(Exception e) {
			return Collections.singletonMap("error", "Could not updated user expertise");
		}
	}
	// POST to check if a username is available
	@RequestMapping(value="/available/user", method=RequestMethod.POST)
	public @ResponseBody Object checkUserNameAvailable(@RequestParam String userName) {
		try {
			return userService.checkUserNameAvailable(userName);
		} catch(Exception e) {
			System.out.println("Thats an error.  " + e.toString());
			return Collections.singletonMap("status", "error");
		}
	}
	//POST to check if an email is available
	@RequestMapping(value="/available/email", method=RequestMethod.POST)
	public @ResponseBody Object checkEmailAvailable(@RequestParam String email) {
		try {
			return userService.checkEmailAvailable(email);
		} catch (Exception e) {
			System.out.println("Thats an error.  " + e.toString());
			return Collections.singletonMap("status", "error");
		}
	}
	
	@RequestMapping(value="/invitations", method=RequestMethod.POST)
	public @ResponseBody Object logInvitationRequest(@RequestParam String email, @RequestParam String name, @RequestParam String company) {
		try {
			return userService.logInvitationRequest(email, name, company);
		} catch(Exception e) {
			System.out.println(e.toString());
			return Collections.singletonMap("error", "Could not save request, an error occured");
		}
	}
	
	@RequestMapping(value="/suggestions", method=RequestMethod.POST)
	public Object logSuggestion(@RequestParam String suggestionType, @RequestParam String suggestion) {
		try {
			return userService.logSuggestion(suggestionType, suggestion);
		} catch(Exception e) {
			System.out.println("ERROR: "+ e.toString());
			return Collections.singletonMap("error", "could not save suggestion");
		}
	}
	//******************************************GET Requests******************************888
	@RequestMapping(value="/invitations/list", method=RequestMethod.GET)
	public @ResponseBody Object getAllInvitationRequests() {
		return userService.getInvitationRequests();
	}
	
	@RequestMapping(value="/{userName}", method=RequestMethod.GET )
	public @ResponseBody Object getUserByUserName(@PathVariable("userName") String userName, @RequestParam(required=false, name="programId") String programId, @RequestHeader(name="Authorization") String token, HttpServletResponse response, HttpServletRequest request) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.getUserByUserName(userName);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	@RequestMapping(value="/{userName}/collections", method=RequestMethod.GET)
	public @ResponseBody Object userCollections(@PathVariable("userName") String userName, @RequestHeader(name="Authorization") String token) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("sub").toString().contentEquals(userName)) {
				return userService.findAllCollectionsByUserName(userName);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Bad Signature");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	@RequestMapping(value="/collections/{collectionId}", method=RequestMethod.GET)
	public @ResponseBody Object getCollection(@PathVariable("collectionId") long collectionId, @RequestHeader(name="Authorization") String token) {
		
		//making collections public for now, should revert back later
		//return userService.findCollectionById(collectionId);
		
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.findCollectionById(collectionId);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		} 
	}
	
	/*@RequestMapping(value="/{userId}/userActivityLog", method=RequestMethod.GET)
	public @ResponseBody Object postUserActivityLog(@PathVariable("userId") long userId, @RequestHeader("programId") String programId, HttpServletResponse response,  HttpServletRequest request) {
		try {
			List<UserActivityLog> userActions = userActivityDAO.findByActiveUserId(userId);
			UserActivityLog userActivityLog = new UserActivityLog(userId, "UserActivityFetched", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
			response.setStatus(HttpServletResponse.SC_OK);
			return userActions;
			
		} catch (Exception ex) {
		    System.out.println("User action lookup failed: " + ex.toString());
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    return new ResponseMsg("Error", "Could not find any user actions");
	 }
	}
	*/
}