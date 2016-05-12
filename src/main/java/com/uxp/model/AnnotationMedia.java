package com.uxp.model;

import java.io.File;
import java.io.FileOutputStream;

import java.net.InetAddress;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;



@Entity
@Table(name="annotationMedia")
public class AnnotationMedia {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long annotationMediaId;
	@Column(columnDefinition = "TEXT", name="annotationMediaData")
	private String annotationMediaData;
	@Column(name="annotationMediaType")
	private String annotationMediaType;
	@Column(name="timeUpdated")
	private Date timeUpdated;
	
	public AnnotationMedia() {}
	
	
	
	public AnnotationMedia(String mediaType, String mediaData) {
		
		this.annotationMediaData = mediaData;	
		this.annotationMediaType = mediaType;
		this.timeUpdated = new Date();
	}
	
	

	public String getAnnotationMediaType() {
		return annotationMediaType;
	}

	public void setAnnotationMediaType(String annotationMediaType) {
		this.annotationMediaType = annotationMediaType;
	}

	public long getAnnotationMediaId() {
		return annotationMediaId;
	}

	public void setAnnotationMediaId(long annotationMediaId) {
		this.annotationMediaId = annotationMediaId;
	}


	public String getAnnotationMediaData() {
		return annotationMediaData;
	}

	public void setAnnotationMediaData(String annotationMediaData) {
		this.annotationMediaData = annotationMediaData;
	}

	
	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	
	
}