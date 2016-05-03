package com.uxp.model;

import java.util.Date;

public class AnnotationContentType {
	private int annotationContentTypeId;
	private String annotationContentTypeDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	
	
	public AnnotationContentType(int annotationContentTypeId, String annotationContentTypeDescription, char useStatus,
			String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.annotationContentTypeId = annotationContentTypeId;
		this.annotationContentTypeDescription = annotationContentTypeDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getAnnotationContentTypeId() {
		return annotationContentTypeId;
	}
	public void setAnnotationContentTypeId(int annotationContentTypeId) {
		this.annotationContentTypeId = annotationContentTypeId;
	}
	public String getAnnotationContentTypeDescription() {
		return annotationContentTypeDescription;
	}
	public void setAnnotationContentTypeDescription(String annotationContentTypeDescription) {
		this.annotationContentTypeDescription = annotationContentTypeDescription;
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
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result
				+ ((annotationContentTypeDescription == null) ? 0 : annotationContentTypeDescription.hashCode());
		result = prime * result + annotationContentTypeId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + updatedBy;
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
		AnnotationContentType other = (AnnotationContentType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationContentTypeDescription == null) {
			if (other.annotationContentTypeDescription != null)
				return false;
		} else if (!annotationContentTypeDescription.equals(other.annotationContentTypeDescription))
			return false;
		if (annotationContentTypeId != other.annotationContentTypeId)
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
		return "AnnotationContentType [annotationContentTypeId=" + annotationContentTypeId
				+ ", annotationContentTypeDescription=" + annotationContentTypeDescription + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy="
				+ updatedBy + "]";
	}
	
	
}
