package com.uxp.model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Long> annotations;
	private String exportURI;
	
	public Collection() {}

	public Collection(long userId, List<Long> annotations, String exportURI) {
		super();
		this.userId = userId;
		this.annotations = annotations;
		this.exportURI = exportURI;
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

	public List<Long> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<Long> annotations) {
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
		return "Collection [collectionId=" + collectionId + ", userId=" + userId + ", annotations=" + annotations
				+ ", exportURI=" + exportURI + "]";
	}
	
	
	
}
