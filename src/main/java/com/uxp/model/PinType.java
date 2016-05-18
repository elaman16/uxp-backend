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
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	public PinType() {}
	
	public PinType(String pinType, String pinTypeDescription, String programId, String locId, long userId) {
		this.pinType = pinType;
		this.pinTypeDescription = pinTypeDescription;
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

	
}
