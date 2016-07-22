package com.uxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collectionannotation")
public class CollectionAnnotation {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long collectionId;
	private String annotationId;
	
	public CollectionAnnotation() {}

	public CollectionAnnotation(long collectionId, String annotationId) {
		super();
		this.collectionId = collectionId;
		this.annotationId = annotationId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	public String getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(String annotationId) {
		this.annotationId = annotationId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotationId == null) ? 0 : annotationId.hashCode());
		result = prime * result + (int) (collectionId ^ (collectionId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
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
		CollectionAnnotation other = (CollectionAnnotation) obj;
		if (annotationId == null) {
			if (other.annotationId != null)
				return false;
		} else if (!annotationId.equals(other.annotationId))
			return false;
		if (collectionId != other.collectionId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CollectionAnnotation [id=" + id + ", collectionId=" + collectionId + ", annotationId=" + annotationId
				+ "]";
	}
	
	
}
