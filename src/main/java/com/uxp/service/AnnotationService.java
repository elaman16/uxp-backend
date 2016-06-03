package com.uxp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

public interface AnnotationService {
	Object postAnnotation( String annotationTitle, StringBuffer annotationText, String emoji,
		String pinType, String userName, String pinTypeDescription,	String annotationContentType,
		String annotationType, String parentDomain, String specificUrl, String pinXCoordinate,
		String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth,
		StringBuffer annotationMedia, String programId, long userId, String hashtag, HttpServletRequest request,
		HttpServletResponse response, HttpSession session );
	
	String uploadToS3(String fileName, String fileLocation, String bucket);
	
	String decodeBase64JPEG(StringBuffer mediaData);
	
	Object getAllAnnotations(String programId,  HttpServletRequest request, HttpServletResponse response);
	
	Object getUserAnnotations(String userName, String programId, HttpServletRequest request, HttpServletResponse response);
	
	Object postAudioAnnotation( String annotationTitle, StringBuffer annotationText, String emoji, String pinType, String userName,
			String pinTypeDescription, String annotationContentType, String annotationType, String parentDomain, String specificUrl, 
			String pinXCoordinate, String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth, 
			String programId, long userId, String hashtag, StringBuffer annotationMediaImage, StringBuffer annotationMediaAudio,
			HttpServletRequest request, HttpServletResponse response);
}
