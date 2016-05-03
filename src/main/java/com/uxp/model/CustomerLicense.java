package com.uxp.model;

import java.util.Date;

public class CustomerLicense {
	private int customerLicenseId;
	private Date dateEffectiveFrom;
	private Date dateEffectiveThru;
	private int customerId;
	private int paymentId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeupdated;
	private int updatedBy;
	public CustomerLicense(int customerLicenseId, Date dateEffectiveFrom, Date dateEffectiveThru, int customerId,
			int paymentId, char useStatus, String programId, String locId, Date timeupdated, int updatedBy) {
		super();
		this.customerLicenseId = customerLicenseId;
		this.dateEffectiveFrom = dateEffectiveFrom;
		this.dateEffectiveThru = dateEffectiveThru;
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeupdated = timeupdated;
		this.updatedBy = updatedBy;
	}
	public int getCustomerLicenseId() {
		return customerLicenseId;
	}
	public void setCustomerLicenseId(int customerLicenseId) {
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
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
	public Date getTimeupdated() {
		return timeupdated;
	}
	public void setTimeupdated(Date timeupdated) {
		this.timeupdated = timeupdated;
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
		result = prime * result + customerId;
		result = prime * result + customerLicenseId;
		result = prime * result + ((dateEffectiveFrom == null) ? 0 : dateEffectiveFrom.hashCode());
		result = prime * result + ((dateEffectiveThru == null) ? 0 : dateEffectiveThru.hashCode());
		result = prime * result + paymentId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeupdated == null) ? 0 : timeupdated.hashCode());
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
		CustomerLicense other = (CustomerLicense) obj;
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
		if (timeupdated == null) {
			if (other.timeupdated != null)
				return false;
		} else if (!timeupdated.equals(other.timeupdated))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (useStatus != other.useStatus)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerLicense [customerLicenseId=" + customerLicenseId + ", dateEffectiveFrom=" + dateEffectiveFrom
				+ ", dateEffectiveThru=" + dateEffectiveThru + ", customerId=" + customerId + ", paymentId=" + paymentId
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeupdated="
				+ timeupdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
