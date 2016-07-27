package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPlanLicense {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long customerLicenseId;
	private Date dateEffectiveFrom;
	private Date dateEffectiveThru;
	private long customerId;
	private long paymentId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;

	UserPlanLicense() {}

	public long getCustomerLicenseId() {
		return customerLicenseId;
	}

	public void setCustomerLicenseId(long customerLicenseId) {
		this.customerLicenseId = customerLicenseId;
	}

	public Date getDateEffectiveFrom() {
		return dateEffectiveFrom;
	}

	public void setDateEffectiveFrom(Date dateEffectiveFrom) {
		this.dateEffectiveFrom = dateEffectiveFrom;
	}

	public Date getDateEffectiveThru() {
		return dateEffectiveThru;
	}

	public void setDateEffectiveThru(Date dateEffectiveThru) {
		this.dateEffectiveThru = dateEffectiveThru;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + (int) (customerLicenseId ^ (customerLicenseId >>> 32));
		result = prime * result + ((dateEffectiveFrom == null) ? 0 : dateEffectiveFrom.hashCode());
		result = prime * result + ((dateEffectiveThru == null) ? 0 : dateEffectiveThru.hashCode());
		result = prime * result + (int) (paymentId ^ (paymentId >>> 32));
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
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
		UserPlanLicense other = (UserPlanLicense) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerLicenseId != other.customerLicenseId)
			return false;
		if (dateEffectiveFrom == null) {
			if (other.dateEffectiveFrom != null)
				return false;
		} else if (!dateEffectiveFrom.equals(other.dateEffectiveFrom))
			return false;
		if (dateEffectiveThru == null) {
			if (other.dateEffectiveThru != null)
				return false;
		} else if (!dateEffectiveThru.equals(other.dateEffectiveThru))
			return false;
		if (paymentId != other.paymentId)
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
		return "UserPlanLicense [customerLicenseId=" + customerLicenseId + ", dateEffectiveFrom=" + dateEffectiveFrom
				+ ", dateEffectiveThru=" + dateEffectiveThru + ", customerId=" + customerId + ", paymentId=" + paymentId
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
