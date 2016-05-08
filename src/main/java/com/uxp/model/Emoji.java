package com.uxp.model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="emojis")
public class Emoji {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long emojiId;
	private String emojiType;
	private long annotationId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	
	public Emoji() {}

	public Emoji(String emojiType, long annotationId, String programId, String locId, long updatedBy) {
		this.emojiType = emojiType;
		this.annotationId = annotationId;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = updatedBy;
	}

	public long getEmojiId() {
		return emojiId;
	}


	public void setEmojiId(long emojiId) {
		this.emojiId = emojiId;
	}


	public String getEmojiType() {
		return emojiType;
	}


	public void setEmojiType(String emojiType) {
		this.emojiType = emojiType;
	}


	public long getAnnotationId() {
		return annotationId;
	}


	public void setAnnotationId(long annotationId) {
		this.annotationId = annotationId;
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
		result = prime * result + (int) (annotationId ^ (annotationId >>> 32));
		result = prime * result + (int) (emojiId ^ (emojiId >>> 32));
		result = prime * result + ((emojiType == null) ? 0 : emojiType.hashCode());
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
		Emoji other = (Emoji) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationId != other.annotationId)
			return false;
		if (emojiId != other.emojiId)
			return false;
		if (emojiType == null) {
			if (other.emojiType != null)
				return false;
		} else if (!emojiType.equals(other.emojiType))
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
		return "Emoji [emojiId=" + emojiId + ", emojiType=" + emojiType + ", annotationId=" + annotationId
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}

	
	
}
