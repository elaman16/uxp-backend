package com.uxp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

import com.uxp.model.Annotation;
import com.uxp.model.AnnotationResponse;

public interface AnnotationService {
	Object postAnnotation( String annotationTitle, String annotationText, String emoji,
		String pinType, String userName, String pinTypeDescription,	String annotationContentType,
		String annotationType, String parentDomain, String specificUrl, String pinXCoordinate,
		String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth,
		StringBuffer annotationMedia, String programId, long userId, String hashtag, StringBuffer attachment, String fileName, String recommendation, String severity, String violation, StringBuffer userVideo, String eventAnalytics, String timelineAnalytics, String clickAnalytics, String expertiseStudy, HttpServletRequest request,
		HttpServletResponse response);
	
	String uploadToS3(String fileName, String fileLocation, String bucket);
	
	Object markAnnotationDeleted(long annotationId, String userName);
	
	String decodeBase64JPEG(StringBuffer mediaData);
	
	public Object searchUserAnnotations(String term, String userName);
	
	Object getAllAnnotations(String programId, Integer page, HttpServletRequest request, HttpServletResponse response);
	
	Object getUserAnnotations(String userName, Integer page, String programId, HttpServletRequest request, HttpServletResponse response);
	
	Object postAudioAnnotation( String annotationTitle, String annotationText, String emoji, String pinType, String userName,
			String pinTypeDescription, String annotationContentType, String annotationType, String parentDomain, String specificUrl, 
			String pinXCoordinate, String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth, 
			String programId, long userId, String hashtag, StringBuffer annotationMediaImage, StringBuffer annotationMediaAudio, String recommendation, String severity, String violation,
			HttpServletRequest request, HttpServletResponse response);

	AnnotationResponse responseFromAnnotation(Annotation annotation);
}
