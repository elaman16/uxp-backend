package com.uxp.model;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.*;


 
@Entity
@Table(name="annotationMedia")
public class AnnotationMedia {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long annotationMediaId;
	@Column(name="mediaData")
	private Blob annotationMediaData;
	@Column(name="mediaType")
	private String mediaType;
	
	public AnnotationMedia() {}
	
	
}