package com.uxp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uxp.service.AnnotationService;

@RestController
@CrossOrigin
@RequestMapping(value="/annotations", method={RequestMethod.POST, RequestMethod.GET})
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
			@RequestParam String programId, @RequestParam long userId,@RequestParam String hashtag, HttpServletRequest request, HttpServletResponse response ) {
			
			return annotationService.postAnnotation(annotationTitle, annotationText, emoji, pinType, pinTypeColor, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, annotationMedia, programId, userId, hashtag, request, response);
		
	}
	
	//*********************************GET Requests************************************************
	
	@RequestMapping(value="/all", method={RequestMethod.GET})
	public @ResponseBody Object getAllAnnotations(@RequestHeader String programId,  HttpServletRequest request, HttpServletResponse response) {
		return annotationService.getAllAnnotations(programId, request, response);
	}
	
	@RequestMapping(value="/user/{userId}", method={RequestMethod.GET})
	public @ResponseBody Object getUserAnnotations(@RequestHeader("userId") long userId, @RequestParam String programId,  HttpServletRequest request, HttpServletResponse response) {
		return annotationService.getUserAnnotations(userId, programId, request, response);
	}
	
}

	