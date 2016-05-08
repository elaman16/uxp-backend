package com.uxp.model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="pinType")
public class PinType {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pinTypeId;
	private String pinType;
	private String pinTypeDescription;
	private String pinTypeColor;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	public PinType() {}
	
	public PinType(String pinType, String pinTypeDescription, String pinTypeColor, String programId, String locId, long userId) {
		this.pinType = pinType;
		this.pinTypeDescription = pinTypeDescription;
		this.pinTypeColor = pinTypeColor;
		this.useStatus = 'I';
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = userId;
	}



	public String getPinType() {
		return pinType;
	}

	public void setPinType(String pinType) {
		this.pinType = pinType;
	}

	public long getPinTypeId() {
		return pinTypeId;
	}

	public void setPinTypeId(long pinTypeId) {
		this.pinTypeId = pinTypeId;
	}

	public String getPinTypeDescription() {
		return pinTypeDescription;
	}

	public void setPinTypeDescription(String pinTypeDescription) {
		this.pinTypeDescription = pinTypeDescription;
	}

	public String getPinTypeColor() {
		return pinTypeColor;
	}

	public void setPinTypeColor(String pinTypeColor) {
		this.pinTypeColor = pinTypeColor;
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
		result = prime * result + ((pinTypeColor == null) ? 0 : pinTypeColor.hashCode());
		result = prime * result + ((pinTypeDescription == null) ? 0 : pinTypeDescription.hashCode());
		result = prime * result + (int) (pinTypeId ^ (pinTypeId >>> 32));
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
		PinType other = (PinType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (pinTypeColor == null) {
			if (other.pinTypeColor != null)
				return false;
		} else if (!pinTypeColor.equals(other.pinTypeColor))
			return false;
		if (pinTypeDescription == null) {
			if (other.pinTypeDescription != null)
				return false;
		} else if (!pinTypeDescription.equals(other.pinTypeDescription))
			return false;
		if (pinTypeId != other.pinTypeId)
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
		return "PinType [pinTypeId=" + pinTypeId + ", pinTypeDescription=" + pinTypeDescription + ", pinTypeColor="
				+ pinTypeColor + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
