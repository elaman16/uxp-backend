package com.uxp.model;


import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.mapping.Array;



@Entity
@Table(name="annotationHashtag")
public class AnnotationHashTag {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long annotationHashtagId;
	private long annotationId;
	private String hashTagValue;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	public AnnotationHashTag() {}

	public AnnotationHashTag(long annotationId, String hashTagValue, String programId, String locId, long updatedBy) {
		this.annotationId = annotationId;
		this.hashTagValue = hashTagValue;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = updatedBy;
	}

	public String getHashTagValue() {
		return hashTagValue;
	}

	public void setHashTagValue(String hashTagValue) {
		this.hashTagValue = hashTagValue;
	}

	public long getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(long annotationId) {
		this.annotationId = annotationId;
	}

	public long getAnnotationHashtagId() {
		return annotationHashtagId;
	}

	public void setAnnotationHashtagId(long annotationHashtagId) {
		this.annotationHashtagId = annotationHashtagId;
	}

	public char getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(char useStatus) {
		this.useStatus = useStatus;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getLocId() {
		return LocId;
	}

	public void setLocId(String locId) {
		LocId = locId;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + (int) (annotationHashtagId ^ (annotationHashtagId >>> 32));
		result = prime * result + (int) (annotationId ^ (annotationId >>> 32));
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = (int) (prime * result + updatedBy);
		result = prime * result + useStatus;
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
		AnnotationHashTag other = (AnnotationHashTag) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationHashtagId != other.annotationHashtagId)
			return false;
		if (annotationId != other.annotationId)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (useStatus != other.useStatus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnnotationHashTag [annotationId=" + annotationId + ", annotationHashtagId=" + annotationHashtagId
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
	
}
