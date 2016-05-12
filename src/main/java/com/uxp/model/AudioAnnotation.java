package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="annotationAudio")
public class AudioAnnotation {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long annotationMediaId;
	private String annotationImageData;
	private String annotationAudioData;
	private String annotationMediaType;
	private Date timeUpdated;
	public AudioAnnotation() {}
	
	
	
	public AudioAnnotation(String mediaType, String imageData, String audioData) {
		
		this.annotationImageData = imageData;	
		this.annotationAudioData = audioData;
		this.annotationMediaType = mediaType;
		this.timeUpdated = new Date();
	}



	public long getAnnotationMediaId() {
		return annotationMediaId;
	}



	public void setAnnotationMediaId(long annotationMediaId) {
		this.annotationMediaId = annotationMediaId;
	}



	public String getAnnotationImageData() {
		return annotationImageData;
	}



	public void setAnnotationImageData(String annotationImageData) {
		this.annotationImageData = annotationImageData;
	}



	public String getAnnotationAudioData() {
		return annotationAudioData;
	}



	public void setAnnotationAudioData(String annotationAudioData) {
		this.annotationAudioData = annotationAudioData;
	}



	public String getAnnotationMediaType() {
		return annotationMediaType;
	}



	public void setAnnotationMediaType(String annotationMediaType) {
		this.annotationMediaType = annotationMediaType;
	}



	public Date getTimeUpdated() {
		return timeUpdated;
	}



	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	
}
	