package com.uxp.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.Blob;
import com.uxp.dao.AnnotationContentTypeDAO;
import com.uxp.dao.AnnotationDAO;
import com.uxp.dao.AnnotationHashTagDAO;
import com.uxp.dao.AnnotationMediaDAO;
import com.uxp.dao.AnnotationTypeDAO;
import com.uxp.dao.EmojiDAO;
import com.uxp.dao.ParentDomainDAO;
import com.uxp.dao.PinTypeDAO;
import com.uxp.dao.UserActivityDAO;
import com.uxp.dao.UserDAO;
import com.uxp.model.Annotation;
import com.uxp.model.AnnotationContentType;
import com.uxp.model.AnnotationHashTag;
import com.uxp.model.AnnotationMedia;
import com.uxp.model.AnnotationResponse;
import com.uxp.model.AnnotationType;
import com.uxp.model.Emoji;
import com.uxp.model.ParentDomain;
import com.uxp.model.PinType;
import com.uxp.model.ResponseMsg;
import com.uxp.model.UserActivityLog;
import com.uxp.service.AnnotationService;


@RestController
@CrossOrigin
@RequestMapping(value="/annotations", method={RequestMethod.POST, RequestMethod.GET})
public class AnnotationController {
	@Autowired
	private AnnotationDAO annotationDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AnnotationContentTypeDAO annotationContentTypeDAO;
	@Autowired
	private AnnotationHashTagDAO annotationHashTagDAO;
	@Autowired
	private AnnotationTypeDAO annotationTypeDAO;
	@Autowired
	private ParentDomainDAO parentDomainDAO;
	@Autowired 
	private PinTypeDAO pinTypeDAO;
	@Autowired 
	private AnnotationMediaDAO annotationMediaDAO;
	@Autowired
	private UserActivityDAO userActivityDAO; 
	@Autowired
	private EmojiDAO emojiDAO;
	@Autowired
	private AnnotationService annotationService;
	
	//********************************POST Requests ***************************************
	@CrossOrigin
	@RequestMapping(value="", method={RequestMethod.POST})
	public @ResponseBody Object postAnnotation(@RequestParam String annotationTitle, @RequestParam String annotationText,
			@RequestParam String emoji, @RequestParam String pinType, @RequestParam String pinTypeColor, @RequestParam String pinTypeDescription,
			@RequestParam String annotationContentType,	@RequestParam String annotationType, @RequestParam String parentDomain, @RequestParam String specificUrl, 
			@RequestParam String pinXCoordinate, @RequestParam String pinYCoordinate, @RequestParam String annotationMediaType,
			@RequestParam int annotationPageHeight, @RequestParam int annotationPageWidth, @RequestParam StringBuffer annotationMedia,
			@RequestParam String programId, @RequestParam long userId,@RequestParam String hashtag, HttpServletRequest request, HttpServletResponse response ) {
			
			return annotationService.postAnnotation(annotationTitle, annotationText, emoji, pinType, pinTypeColor, pinTypeDescription, annotationContentType, annotationType, parentDomain, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, annotationMedia, programId, userId, hashtag, request, response);
		/*try {
			Annotation annotation = new Annotation(annotationTitle, annotationText, specificUrl, pinXCoordinate, pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, programId, request.getRemoteAddr(), userId);
			ParentDomain _parentDomain = new ParentDomain(annotation.getAnnotationId(), parentDomain, programId, request.getRemoteAddr(), userId);
			PinType _pinType = new PinType(pinType, pinTypeDescription, pinTypeColor, programId, request.getRemoteAddr(), userId);
			AnnotationType _annotationType = new AnnotationType(annotationType, programId, request.getRemoteAddr(), userId);
			AnnotationHashTag _annotationHashTag = new AnnotationHashTag(annotation.getAnnotationId(), hashtag, programId, request.getRemoteAddr(), userId);
			AnnotationContentType _annotationContentType = new AnnotationContentType(annotationContentType, programId, request.getRemoteAddr(), userId);
			Emoji _emoji = new Emoji(emoji, annotation.getAnnotationId(), programId, request.getRemoteAddr(), userId);
			AnnotationMedia _annotationMedia = new AnnotationMedia(annotationMediaType, annotationMedia);
			
			emojiDAO.save(_emoji);
			annotationContentTypeDAO.save(_annotationContentType);
			annotationHashTagDAO.save(_annotationHashTag);
			annotationTypeDAO.save(_annotationType);
			pinTypeDAO.save(_pinType);
			parentDomainDAO.save(_parentDomain);
			annotationMediaDAO.save(_annotationMedia);
			
			annotation.setParentDomainId(_parentDomain.getParentDomainId());
			annotation.setPinTypeId(_pinType.getPinTypeId());
			annotation.setAnnotationTypeId(_annotationType.getAnnotationTypeId());
			annotation.setAnnotationContentTypeId(_annotationContentType.getAnnotationContentTypeId());
			annotation.setEmojiId(_emoji.getEmojiId());
			annotation.setAnnotationMediaId(_annotationMedia.getAnnotationMediaId());
			
			annotationDAO.save(annotation);
			
			UserActivityLog userActivityLog = new UserActivityLog(userId, "annotationPosted", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
			
			return new ResponseMsg("link", "/annotation/" + annotation.getAnnotationId());
		} catch (Exception ex) {
			  UserActivityLog userActivityLog = new UserActivityLog(userId, "annotationPostFail", programId, request.getRemoteAddr());
			  userActivityLog.setUpdatedBy(userId);
			  userActivityDAO.save(userActivityLog);
		      System.out.println("Error updating the user profile: " + ex.toString());
		      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			  return new ResponseMsg("Error", "Could not update user profile");
		 }*/
	}
	
	//*********************************GET Requests************************************************
	
	@RequestMapping(value="/all", method={RequestMethod.GET})
	public @ResponseBody Object getAllAnnotations(@RequestHeader String programId,  HttpServletRequest request, HttpServletResponse response) {
		try {
		List<AnnotationResponse> annotationResponses = new ArrayList<AnnotationResponse>();
		List<Annotation> allAnnotations = (List<Annotation>) annotationDAO.findAll();
		for(Annotation a : allAnnotations) {
			Emoji emo = emojiDAO.findOne(a.getEmojiId());
			AnnotationContentType annotationContent = annotationContentTypeDAO.findOne(a.getAnnotationContentTypeId());
			AnnotationHashTag annotationHashTag = annotationHashTagDAO.findOneByAnnotationId(a.getAnnotationId());
			AnnotationType annotationType = annotationTypeDAO.findOne(a.getAnnotationTypeId());
			PinType pinType = pinTypeDAO.findOne(a.getPinTypeId());
			ParentDomain parentDomain = parentDomainDAO.findOne(a.getParentDomainId());
			AnnotationMedia annotationMedia = annotationMediaDAO.findOne(a.getAnnotationMediaId());
			
			AnnotationResponse resp = new AnnotationResponse(a, annotationMedia, parentDomain, pinType, annotationType, annotationHashTag, annotationContent, emo);
			annotationResponses.add(resp);
		}
		response.setStatus(HttpServletResponse.SC_OK);
		return annotationResponses;
		} catch (Exception ex) {
			  UserActivityLog userActivityLog = new UserActivityLog(0, "annotationGetFail", programId, request.getRemoteAddr());
			  userActivityLog.setUpdatedBy(0);
			  userActivityDAO.save(userActivityLog);
		      System.out.println("Error updating the user profile: " + ex.toString());
		      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			  return new ResponseMsg("Error", "Could not fetch annotations");
		 }
	}
	
	@RequestMapping(value="/user/{userId}", method={RequestMethod.GET})
	public @ResponseBody Object getUserAnnotations(@RequestHeader("userId") long userId, @RequestParam String programId,  HttpServletRequest request, HttpServletResponse response) {
		try {
		List<AnnotationResponse> annotationResponses = new ArrayList<AnnotationResponse>();
		List<Annotation> allAnnotations = (List<Annotation>) annotationDAO.findAllByUpdatedBy(userId);
		for(Annotation a : allAnnotations) {
			Emoji emo = emojiDAO.findOne(a.getEmojiId());
			AnnotationContentType annotationContent = annotationContentTypeDAO.findOne(a.getAnnotationContentTypeId());
			AnnotationHashTag annotationHashTag = annotationHashTagDAO.findOneByAnnotationId(a.getAnnotationId());
			AnnotationType annotationType = annotationTypeDAO.findOne(a.getAnnotationTypeId());
			PinType pinType = pinTypeDAO.findOne(a.getPinTypeId());
			ParentDomain parentDomain = parentDomainDAO.findOne(a.getParentDomainId());
			AnnotationMedia annotationMedia = annotationMediaDAO.findOne(a.getAnnotationMediaId());
			
			AnnotationResponse resp = new AnnotationResponse(a, annotationMedia, parentDomain, pinType, annotationType, annotationHashTag, annotationContent, emo);
			annotationResponses.add(resp);
		}
		response.setStatus(HttpServletResponse.SC_OK);
		return annotationResponses;
		} catch (Exception ex) {
			  UserActivityLog userActivityLog = new UserActivityLog(userId, "annotationGetFail", programId, request.getRemoteAddr());
			  userActivityLog.setUpdatedBy(userId);
			  userActivityDAO.save(userActivityLog);
		      System.out.println("Error updating the user profile: " + ex.toString());
		      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			  return new ResponseMsg("Error", "Could not fetch annotations for user " + userId);
		 }
	}
	
}

	