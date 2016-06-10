package com.uxp.controller;



import java.security.Key;
import java.util.Collections;

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


import com.uxp.service.AnnotationService;
import com.uxp.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolver;

@RestController
@CrossOrigin
@RequestMapping(value="/annotations", method={RequestMethod.POST, RequestMethod.GET})
@SessionAttributes("user")
public class AnnotationController {
	@Autowired
	private AnnotationService annotationService;
	@Autowired 
	private UserService userService;
	
	private Key key = ControllerConfig.key;
	
	//********************************POST Requests ***************************************
	@RequestMapping(value="", method={RequestMethod.POST}, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces="application/json")
	public @ResponseBody Object postAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String userName, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam StringBuffer annotationMedia,
			@RequestParam(required=false) String programId, @RequestParam long userId,@RequestParam String hashtag, @RequestParam(required=false, defaultValue="") StringBuffer attachment,
			@RequestParam(required=false,  defaultValue="") String fileName, HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {
				if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
					return annotationService.postAnnotation(annotationTitle, annotationText, emoji, pinType, userName, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, annotationMedia, programId, userId, hashtag, attachment, fileName, request, response);
				} else {
					return Collections.singletonMap("error", "Not Authorized");
				}			
	}
	
	@RequestMapping(value="/audio", method={RequestMethod.POST}, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public @ResponseBody Object postAudioAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String userName, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam(required=false) String programId, 
			@RequestParam long userId,@RequestParam String hashtag, @RequestParam StringBuffer annotationMediaImage,
			@RequestParam StringBuffer annotationMediaAudio, HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {
				if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
					return annotationService.postAudioAnnotation(annotationTitle, annotationText, emoji, pinType, userName, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, programId, userId, hashtag, annotationMediaImage, annotationMediaAudio, request, response);
				} else {
					return Collections.singletonMap("error", "Not Authorized");
				}
				
			
	}
	
	//*********************************GET Requests************************************************
	
	@RequestMapping(value="/all", method={RequestMethod.GET})
	public @ResponseBody Object getAllAnnotations(@RequestHeader(required=false) String programId,  HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return annotationService.getAllAnnotations(programId, request, response);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}		
	}
	
	@RequestMapping(value="/user/{userName}", method={RequestMethod.GET})
	public @ResponseBody Object getUserAnnotations(@PathVariable("userName") String userName, @RequestHeader(name="programId", required=false) String programId,  HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {	
		
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return annotationService.getUserAnnotations(userName, programId, request, response);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
			
		
	}
	
}

	