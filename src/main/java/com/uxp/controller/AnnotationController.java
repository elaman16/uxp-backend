package com.uxp.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uxp.model.ResponseMsg;
import com.uxp.model.UserProfile;
import com.uxp.service.AnnotationService;

@RestController
@CrossOrigin
@RequestMapping(value="/annotations", method={RequestMethod.POST, RequestMethod.GET})
@SessionAttributes("user")
public class AnnotationController {
	@Autowired
	private AnnotationService annotationService;
	
	//********************************POST Requests ***************************************
	@RequestMapping(value="", method={RequestMethod.POST})
	public @ResponseBody Object postAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String pinTypeColor, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam StringBuffer annotationMedia,
			@RequestParam String programId, @RequestParam long userId,@RequestParam String hashtag, HttpServletRequest request, HttpServletResponse response, HttpSession session ) {
			
			return annotationService.postAnnotation(annotationTitle, annotationText, emoji, pinType, pinTypeColor, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, annotationMedia, programId, userId, hashtag, request, response, session);
		
	}
	
	@RequestMapping(value="/audio", method={RequestMethod.POST})
	public @ResponseBody Object postAudioAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String pinTypeColor, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam String programId, 
			@RequestParam long userId,@RequestParam String hashtag, @RequestParam StringBuffer annotationMediaImage,
			@RequestParam StringBuffer annotationMediaAudio, HttpServletRequest request, HttpServletResponse response ) {
			
			return annotationService.postAudioAnnotation(annotationTitle, annotationText, emoji, pinType, pinTypeColor, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, programId, userId, hashtag, annotationMediaImage, annotationMediaAudio, request, response);
		
	}
	
	//*********************************GET Requests************************************************
	
	@RequestMapping(value="/all", method={RequestMethod.GET})
	public @ResponseBody Object getAllAnnotations(@RequestHeader String programId,  HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("user") != null) {
			UserProfile up = (UserProfile) session.getAttribute("user");
			System.out.print(up);
			return annotationService.getAllAnnotations(programId, request, response);
		} else {
			return Collections.singletonMap("response", "Please Log In");
		}
		
	}
	
	@RequestMapping(value="/user/{userId}", method={RequestMethod.GET})
	public @ResponseBody Object getUserAnnotations(@RequestHeader("userId") long userId, @RequestParam String programId,  HttpServletRequest request, HttpServletResponse response) {
		return annotationService.getUserAnnotations(userId, programId, request, response);
	}
	
}

	