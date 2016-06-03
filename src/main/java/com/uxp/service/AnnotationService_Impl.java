package com.uxp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.uxp.dao.AnnotationContentTypeDAO;
import com.uxp.dao.AnnotationDAO;
import com.uxp.dao.AnnotationHashTagDAO;
import com.uxp.dao.AnnotationMediaDAO;
import com.uxp.dao.AnnotationTypeDAO;
import com.uxp.dao.AudioAnnotationDAO;
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
import com.uxp.model.AudioAnnotation;
import com.uxp.model.Emoji;
import com.uxp.model.ParentDomain;
import com.uxp.model.PinType;
import com.uxp.model.ResponseMsg;
import com.uxp.model.UserActivityLog;
//propagation = Propagation.SUPPORTS, readOnly = false
@Service("annotationService")
@Transactional()
@SessionAttributes("datas")
public class AnnotationService_Impl implements AnnotationService {
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
	private AudioAnnotationDAO audioAnnotationDAO;
	@Autowired
	private UserActivityDAO userActivityDAO; 
	@Autowired
	private EmojiDAO emojiDAO;
	
	public Object getAllAnnotations(String programId,  HttpServletRequest request, HttpServletResponse response) {
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
	
	public Object getUserAnnotations(String userName, String programId, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<AnnotationResponse> annotationResponses = new ArrayList<AnnotationResponse>();
			List<Annotation> allAnnotations = (List<Annotation>) annotationDAO.findAllByUserName(userName);
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
			      System.out.println("Error fetching user annotations" + ex.toString());
			      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				  return new ResponseMsg("Error", "Could not fetch annotations for user " + userName);
			 }
		}
	
	public String uploadToS3(String fileName, String fileLocation, String bucket) {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAJAEOKYIRMVE3VK5Q", "P7XutdkzEyO56IanKX9gGJzDSZ2T9bqBS7NMly0B");
		AmazonS3Client s3client = new AmazonS3Client(credentials);
		s3client.putObject(new PutObjectRequest(bucket, fileName, new File(fileLocation))
		.withCannedAcl(CannedAccessControlList.PublicRead));
		String url = s3client.getResourceUrl(bucket, fileName);
		return url;
	}
	public String decodeBase64(StringBuffer mediaData) {
		
			String header = mediaData.substring(0, mediaData.indexOf(","));
			System.out.println("____________________________________");
			System.out.println(header);
			System.out.println("____________________________________");
			if(header.contentEquals("data:image/jpeg;base64")) {
				return decodeBase64JPEG(mediaData);
			} else if(header.contentEquals("data:video/webm;base64")) {
				return decodeBase64WEBM(mediaData);
			} else if(header.contentEquals("data:audio/ogg;base64")) {
				return decodeBase64OGG(mediaData);
			} else {
				return "No match!";
			}
		
	}
	public String decodeBase64OGG(StringBuffer mediaData) {
		try {
			String encoded = mediaData.substring(mediaData.indexOf(",") + 1);
			UUID uid = UUID.randomUUID();
			byte[] decoded = Base64.getMimeDecoder().decode(encoded);
			FileOutputStream fos = new FileOutputStream("tmp/" + uid + ".ogg");
			fos.write(decoded);
			fos.close();
			String url = uploadToS3(uid + ".ogg", "tmp/" + uid + ".ogg", "uxpogg");
			return url;
		} catch(Exception ex) {
		      return "Error Decoding Base64 string " + ex.toString();
		    }
	}
	
	public String decodeBase64WEBM(StringBuffer mediaData) {
		try {
			String encoded = mediaData.substring(mediaData.indexOf(",") + 1);
			UUID uid = UUID.randomUUID();
			byte[] decoded = Base64.getMimeDecoder().decode(encoded);
			FileOutputStream fos = new FileOutputStream("tmp/" + uid + ".webm");
			fos.write(decoded);
			fos.close();
			String url = uploadToS3(uid + ".webm", "tmp/" + uid + ".webm", "uxpwebm");
			return url;
		} catch(Exception ex) {
		      return "Error Decoding Base64 string " + ex.toString();
		    }
	}
	
	public String decodeBase64JPEG(StringBuffer mediaData) {
		try {
			String encoded = mediaData.substring(mediaData.indexOf(",") + 1);
			UUID uid = UUID.randomUUID();
			byte[] decoded = Base64.getMimeDecoder().decode(encoded);
			FileOutputStream fos = new FileOutputStream("tmp/" + uid + ".jpeg");
			fos.write(decoded);
			fos.close();
			String url = uploadToS3(uid + ".jpeg", "tmp/" + uid + ".jpeg", "uxpjpeg");
			return url;
		} catch(Exception ex) {
		      return "Error Decoding Base64 string " + ex.toString();
		    }

	}
	
	public Object postAnnotation( String annotationTitle, String annotationText, String emoji,
		String pinType, String userName, String pinTypeDescription,	String annotationContentType,
		String annotationType, String parentDomain, String specificUrl, String pinXCoordinate,
		String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth,
		StringBuffer annotationMedia, String programId, long userId, String hashtag, HttpServletRequest request,
		HttpServletResponse response, HttpSession session ) {
		try {
			Annotation annotation = new Annotation(annotationTitle, annotationText, specificUrl, pinXCoordinate, 
					pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, programId, 
					request.getRemoteAddr(), userId, userName);
			
			ParentDomain _parentDomain = new ParentDomain(annotation.getAnnotationId(), parentDomain, programId, request.getRemoteAddr(), userId);
			
			PinType _pinType = new PinType(pinType, pinTypeDescription, programId, request.getRemoteAddr(), userId);
			
			AnnotationType _annotationType = new AnnotationType(annotationType, programId, request.getRemoteAddr(), userId);
			
			AnnotationHashTag _annotationHashTag = new AnnotationHashTag(annotation.getAnnotationId(), hashtag, programId, request.getRemoteAddr(), userId);
			
			AnnotationContentType _annotationContentType = new AnnotationContentType(annotationContentType, programId, request.getRemoteAddr(), userId);
			
			Emoji _emoji = new Emoji(emoji, annotation.getAnnotationId(), programId, request.getRemoteAddr(), userId);
			
			AnnotationMedia _annotationMedia = new AnnotationMedia(annotationMediaType, decodeBase64(annotationMedia));
			
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
		      System.out.println("Could not post new Annotation: " + ex.toString());
			  return new ResponseMsg("Error", "Could not post new Annotation");
		 }
	}
	public Object postAudioAnnotation( String annotationTitle, String annotationText, String emoji, String pinType, String userName,
			String pinTypeDescription, String annotationContentType, String annotationType, String parentDomain, String specificUrl, 
			String pinXCoordinate, String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth, 
			String programId, long userId, String hashtag, StringBuffer annotationMediaImage, StringBuffer annotationMediaAudio,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Annotation annotation = new Annotation(annotationTitle, annotationText, specificUrl, pinXCoordinate, 
					pinYCoordinate, annotationMediaType, annotationPageHeight, annotationPageWidth, programId, 
					request.getRemoteAddr(), userId, userName);
			ParentDomain _parentDomain = new ParentDomain(annotation.getAnnotationId(), parentDomain, programId, request.getRemoteAddr(), userId);
			PinType _pinType = new PinType(pinType, pinTypeDescription, programId, request.getRemoteAddr(), userId);
			AnnotationType _annotationType = new AnnotationType(annotationType, programId, request.getRemoteAddr(), userId);
			AnnotationHashTag _annotationHashTag = new AnnotationHashTag(annotation.getAnnotationId(), hashtag, programId, request.getRemoteAddr(), userId);
			AnnotationContentType _annotationContentType = new AnnotationContentType(annotationContentType, programId, request.getRemoteAddr(), userId);
			Emoji _emoji = new Emoji(emoji, annotation.getAnnotationId(), programId, request.getRemoteAddr(), userId);
			AnnotationMedia _audioAnnotation  = new AnnotationMedia(annotationMediaType, decodeBase64(annotationMediaImage), decodeBase64(annotationMediaAudio));
			
			emojiDAO.save(_emoji);
			annotationContentTypeDAO.save(_annotationContentType);
			annotationHashTagDAO.save(_annotationHashTag);
			annotationTypeDAO.save(_annotationType);
			pinTypeDAO.save(_pinType);
			parentDomainDAO.save(_parentDomain);
			annotationMediaDAO.save(_audioAnnotation);
			
			annotation.setParentDomainId(_parentDomain.getParentDomainId());
			annotation.setPinTypeId(_pinType.getPinTypeId());
			annotation.setAnnotationTypeId(_annotationType.getAnnotationTypeId());
			annotation.setAnnotationContentTypeId(_annotationContentType.getAnnotationContentTypeId());
			annotation.setEmojiId(_emoji.getEmojiId());
			annotation.setAnnotationMediaId(_audioAnnotation.getAnnotationMediaId());
			
			annotationDAO.save(annotation);
			
			UserActivityLog userActivityLog = new UserActivityLog(userId, "annotationPosted", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
			
			return Collections.singletonMap("link", "/annotation/" + annotation.getAnnotationId());
		} catch (Exception ex) {
			  UserActivityLog userActivityLog = new UserActivityLog(userId, "annotationPostFail", programId, request.getRemoteAddr());
			  userActivityLog.setUpdatedBy(userId);
			  userActivityDAO.save(userActivityLog);
		      System.out.println("Could not post new Annotation: " + ex.toString());
		      return Collections.singletonMap("Error", "Could not post new Annotation");
		 }
	}
}
