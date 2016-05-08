package com.uxp.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="annotationType")
public class AnnotationType {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long annotationTypeId;
	private String annotationTypeDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	public AnnotationType() {}
	

	public AnnotationType(String annotationTypeDescription, String programId, String locId, long updatedBy) {
		this.annotationTypeDescription = annotationTypeDescription;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = updatedBy;
	}


	public long getAnnotationTypeId() {
		return annotationTypeId;
	}

	public void setAnnotationTypeId(long annotationTypeId) {
		this.annotationTypeId = annotationTypeId;
	}

	public String getAnnotationTypeDescription() {
		return annotationTypeDescription;
	}

	public void setAnnotationTypeDescription(String annotationTypeDescription) {
		this.annotationTypeDescription = annotationTypeDescription;
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
		result = prime * result + ((annotationTypeDescription == null) ? 0 : annotationTypeDescription.hashCode());
		result = prime * result + (int) (annotationTypeId ^ (annotationTypeId >>> 32));
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
		AnnotationType other = (AnnotationType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationTypeDescription == null) {
			if (other.annotationTypeDescription != null)
				return false;
		} else if (!annotationTypeDescription.equals(other.annotationTypeDescription))
			return false;
		if (annotationTypeId != other.annotationTypeId)
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
		return "AnnotationType [annotationTypeId=" + annotationTypeId + ", annotationTypeDescription="
				+ annotationTypeDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
