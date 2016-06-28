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
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
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
	@RequestMapping(value="", method={RequestMethod.POST}, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE , produces="application/json")
	public @ResponseBody Object postAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String userName, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam StringBuffer annotationMedia,
			@RequestParam(required=false) String programId, @RequestParam long userId,@RequestParam String hashtag, @RequestParam(required=false, defaultValue="") StringBuffer attachment,
			@RequestParam(required=false,  defaultValue="") String fileName, @RequestParam(defaultValue="") String recommendation, @RequestParam(defaultValue="") String severity,
			@RequestParam(defaultValue="") String violation, @RequestParam(defaultValue="") StringBuffer userVideo, HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {
			try {
				System.out.println("USERNAME FROM TOKEN: " + Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().toString());
				if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
					return annotationService.postAnnotation(annotationTitle, annotationText, emoji, pinType, userName, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, annotationMedia, programId, userId, hashtag, attachment, fileName, recommendation, severity, violation, userVideo, request, response);
				} else {
					return Collections.singletonMap("error", "Not Authorized");
				}
			} catch(SignatureException e) {
				return Collections.singletonMap("error", "Not Authorized");
			} catch(MalformedJwtException m) {
				return Collections.singletonMap("error", "Bad token");
			}
	}
	
	@RequestMapping(value="/audio", method={RequestMethod.POST}, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public @ResponseBody Object postAudioAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String userName, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam(required=false) String programId, 
			@RequestParam long userId,@RequestParam String hashtag, @RequestParam StringBuffer annotationMediaImage,
			@RequestParam StringBuffer annotationMediaAudio, @RequestParam(defaultValue="") String recommendation, @RequestParam(defaultValue="") String severity,
			@RequestParam(defaultValue="") String violation, HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {
				try {	
					if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
						return annotationService.postAudioAnnotation(annotationTitle, annotationText, emoji, pinType, userName, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, programId, userId, hashtag, annotationMediaImage, annotationMediaAudio, recommendation, severity, violation, request, response);
					} else {
						return Collections.singletonMap("error", "Not Authorized");
					}
				} catch(SignatureException e) {
					return Collections.singletonMap("error", "Not Authorized");
				} catch(MalformedJwtException m) {
					return Collections.singletonMap("error", "Bad token");
				}
			
	}
	
	@RequestMapping(value="/delete/{annotationId}", method={RequestMethod.POST}, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Object markAnnotationDeleted(@RequestHeader(name="Authorization") String token, @PathVariable Long annotationId) {
		
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				String userName = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
				System.out.println("-------" + userName);
				return annotationService.markAnnotationDeleted(annotationId, userName);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	
	//*********************************GET Requests************************************************
	
	@RequestMapping(value="/all", method={RequestMethod.GET})
	public @ResponseBody Object getAllAnnotations(@RequestHeader(required=false) String programId, @RequestHeader(name="page", defaultValue="0") Integer page, HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {
			try {
				if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
					if(page < 0) {
						page = 0;
					}
					page = page * 10;
					return annotationService.getAllAnnotations(programId, page, request, response);
				} else {
					return Collections.singletonMap("error", "Not Authorized");
				}
			} catch(SignatureException e) {
				return Collections.singletonMap("error", "Not Authorized");
			} catch(MalformedJwtException m) {
				return Collections.singletonMap("error", "Bad token");
			}
			
			
	}
	
	@RequestMapping(value="/user/{userName}", method={RequestMethod.GET})
	public @ResponseBody Object getUserAnnotations(@PathVariable("userName") String userName, @RequestHeader(name="programId", required=false) String programId, @RequestHeader(name="page", defaultValue="0") Integer page, HttpServletRequest request, HttpServletResponse response, @RequestHeader(name="Authorization") String token) {	
		System.out.println("HEAD FROM TOKEN: " + Jwts.parser().setSigningKey(key).parseClaimsJws(token).getHeader().toString());
		System.out.println("BODY FROM TOKEN: " + Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().toString());
		
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				if(page < 0) {
					page = 0;
				}
				page = page * 10;
				return annotationService.getUserAnnotations(userName, page, programId, request, response);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
			
		
	}
	
}

	