package com.uxp.model;

import java.util.Date;

public class AnnotationResponse {
	
	private long annotationId;
	private String annotationTitle;
	private String annotationText;
	private String emojiId;
	private String pinType;
	private String annotationContentType;
	private String annotationType;
	private String parentDomain;
	private String pinTypeColor;
	private String pinTypeDescription;
	private String specificURL;
	private String pinXCoordinate;
	private String pinYCoordinate;
	private String annotationMediaType;
	private String annotationMedia;
	private int annotationPageHeight;
	private int annotationPageWidth;
	private Date timeUpdated;
	
	public AnnotationResponse() {}
	
	public AnnotationResponse(Annotation annotation, AnnotationMedia media, ParentDomain parentDomain, PinType pintype, AnnotationType annotationType, AnnotationHashTag hashtag, AnnotationContentType contentType, Emoji emoji) {
		
		this.annotationId = annotation.getAnnotationId();
		this.annotationTitle = annotation.getAnnotationTitle();
		this.annotationText = annotation.getAnnotationText();
		this.emojiId = emoji.getEmojiType();
		this.pinType = pintype.getPinType();
		this.pinTypeColor = pintype.getPinTypeColor();
		this.pinTypeDescription = pintype.getPinTypeDescription();
		this.annotationContentType = contentType.getAnnotationContentTypeDescription();
		this.annotationType = annotationType.getAnnotationTypeDescription();
		this.parentDomain = parentDomain.getParentDomainName();
		this.specificURL = annotation.getSpecificURL();
		this.pinXCoordinate = annotation.getPinXCoordinate();
		this.pinYCoordinate = annotation.getPinYCoordinate();
		this.annotationMediaType = media.getAnnotationMediaType();
		this.annotationMedia = media.getAnnotationMediaData();
		this.annotationPageHeight = annotation.getAnnotationPageHeight();
		this.annotationPageWidth = annotation.getAnnotationPageWidth();
		this.timeUpdated = annotation.getTimeUpdated();
	}
	
	public String getPinTypeColor() {
		return pinTypeColor;
	}

	public void setPinTypeColor(String pinTypeColor) {
		this.pinTypeColor = pinTypeColor;
	}

	public String getPinTypeDescription() {
		return pinTypeDescription;
	}

	public void setPinTypeDescription(String pinTypeDescription) {
		this.pinTypeDescription = pinTypeDescription;
	}

	public long getAnnotationId() {
		return annotationId;
	}
	public void setAnnotationId(long annotationId) {
		this.annotationId = annotationId;
	}
	public String getAnnotationTitle() {
		return annotationTitle;
	}
	public void setAnnotationTitle(String annotationTitle) {
		this.annotationTitle = annotationTitle;
	}
	public String getAnnotationText() {
		return annotationText;
	}
	public void setAnnotationText(String annotationText) {
		this.annotationText = annotationText;
	}
	public String getEmojiId() {
		return emojiId;
	}
	public void setEmojiId(String emojiId) {
		this.emojiId = emojiId;
	}
	public String getPinType() {
		return pinType;
	}
	public void setPinType(String pinType) {
		this.pinType = pinType;
	}
	public String getAnnotationContentType() {
		return annotationContentType;
	}
	public void setAnnotationContentType(String annotationContentType) {
		this.annotationContentType = annotationContentType;
	}
	public String getAnnotationType() {
		return annotationType;
	}
	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}
	public String getParentDomain() {
		return parentDomain;
	}
	public void setParentDomain(String parentDomain) {
		this.parentDomain = parentDomain;
	}
	public String getSpecificURL() {
		return specificURL;
	}
	public void setSpecificURL(String specificURL) {
		this.specificURL = specificURL;
	}
	public String getPinXCoordinate() {
		return pinXCoordinate;
	}
	public void setPinXCoordinate(String pinXCoordinate) {
		this.pinXCoordinate = pinXCoordinate;
	}
	public String getPinYCoordinate() {
		return pinYCoordinate;
	}
	public void setPinYCoordinate(String pinYCoordinate) {
		this.pinYCoordinate = pinYCoordinate;
	}
	public String getAnnotationMediaType() {
		return annotationMediaType;
	}
	public void setAnnotationMediaType(String annotationMediaType) {
		this.annotationMediaType = annotationMediaType;
	}
	public String getAnnotationMedia() {
		return annotationMedia;
	}
	public void setAnnotationMedia(String annotationMedia) {
		this.annotationMedia = annotationMedia;
	}
	public int getAnnotationPageHeight() {
		return annotationPageHeight;
	}
	public void setAnnotationPageHeight(int annotationPageHeight) {
		this.annotationPageHeight = annotationPageHeight;
	}
	public int getAnnotationPageWidth() {
		return annotationPageWidth;
	}
	public void setAnnotationPageWidth(int annotationPageWidth) {
		this.annotationPageWidth = annotationPageWidth;
	}
	public Date getTimeUpdated() {
		return timeUpdated;
	}
	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	
}
