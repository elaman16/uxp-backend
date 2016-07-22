package com.uxp.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
public class CollectionResponse {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long collectionId;
	private long userId;
	private String userName;
	@Column(columnDefinition = "TEXT")
	private String exportURI;
	private String annotations;
	@Column(name="file_name")
	private String fileName;
	
	public CollectionResponse() {}
	
	public CollectionResponse(Collection collection, ArrayList<AnnotationResponse> annotations) {
		this.collectionId = collection.getCollectionId();
		this.userId = collection.getUserId();
		this.userName = collection.getUserName();
		this.exportURI = collection.getExportURI();
		this.fileName = collection.getFileName();
		this.annotations = new Gson().toJson(annotations);
	}

	public long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExportURI() {
		return exportURI;
	}

	public void setExportURI(String exportURI) {
		this.exportURI = exportURI;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotations == null) ? 0 : annotations.hashCode());
		result = prime * result + (int) (collectionId ^ (collectionId >>> 32));
		result = prime * result + ((exportURI == null) ? 0 : exportURI.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectionResponse other = (CollectionResponse) obj;
		if (annotations == null) {
			if (other.annotations != null)
				return false;
		} else if (!annotations.equals(other.annotations))
			return false;
		if (collectionId != other.collectionId)
			return false;
		if (exportURI == null) {
			if (other.exportURI != null)
				return false;
		} else if (!exportURI.equals(other.exportURI))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CollectionResponse [collectionId=" + collectionId + ", userId=" + userId + ", userName=" + userName
				+ ", exportURI=" + exportURI + ", annotations=" + annotations + ", fileName=" + fileName + "]";
	}
	
	
}
