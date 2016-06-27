package com.uxp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collection")
public class Collection {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long collectionId;
	private long userId;
	private String userName;
	@Column(columnDefinition = "TEXT")
	private String annotations;
	private String exportURI;
	
	public Collection() {}

	public Collection(String userName, String annotations, String exportURI) {
		super();
		this.userName = userName;
		this.annotations = annotations;
		this.exportURI = exportURI;
		this.userId = 0;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public String getExportURI() {
		return exportURI;
	}

	public void setExportURI(String exportURI) {
		this.exportURI = exportURI;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Collection [collectionId=" + collectionId + ", userName=" + userName + ", annotations=" + annotations
				+ ", exportURI=" + exportURI + "]";
	}

	
	
	
	
}
