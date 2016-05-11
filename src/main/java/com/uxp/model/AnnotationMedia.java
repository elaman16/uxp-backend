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
	
	public AnnotationMedia(String mediaType, StringBuffer mediaData) {
		
		this.annotationMediaData = decodeBase64JPEG(mediaData);	
		this.annotationMediaType = mediaType;
		this.timeUpdated = new Date();
	}
	public String decodeBase64JPEG(StringBuffer mediaData) {
		String header = mediaData.substring(0, mediaData.indexOf(","));
		String encoded = mediaData.substring(mediaData.indexOf(",") + 1);
		try {
		System.out.println("____________________________________________________");
		System.out.println("Trying to decode..");
		System.out.println("Header for file is: " + header );
		System.out.println("____________________________________________________");
		UUID uid = UUID.randomUUID();
		byte[] decoded = Base64.getMimeDecoder().decode(encoded);
		File f = new File("public/annotationImage/" + uid + ".jpeg");
		FileOutputStream fos = new FileOutputStream("public/annotationImage/" + uid + ".jpeg");
		fos.write(decoded);
		fos.close();
		
		String hostname = InetAddress.getLocalHost().getHostName();
		return "http://192.168.1.62:8080" + "/annotationImage/" + uid + ".jpeg";
		} catch(Exception ex) {
		      return "Error creating the user: " + ex.toString();
		    }

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