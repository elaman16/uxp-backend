package com.uxp.model;

import java.util.Date;

public class Customer {
	private int customerId;
	private String customerPhoneNumber;
	private String customerEmail;
	private String customerCompanyName;
	private String customerCountry;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public Customer(int customerId, String customerPhoneNumber, String customerEmail, String customerCompanyName,
			String customerCountry, char useStatus, String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.customerId = customerId;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerCompanyName = customerCompanyName;
		this.customerCountry = customerCountry;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerCompanyName() {
		return customerCompanyName;
	}
	public void setCustomerCompanyName(String customerCompanyName) {
		this.customerCompanyName = customerCompanyName;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
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
		result = prime * result + ((customerCompanyName == null) ? 0 : customerCompanyName.hashCode());
		result = prime * result + ((customerCountry == null) ? 0 : customerCountry.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerPhoneNumber == null) ? 0 : customerPhoneNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (customerCompanyName == null) {
			if (other.customerCompanyName != null)
				return false;
		} else if (!customerCompanyName.equals(other.customerCompanyName))
			return false;
		if (customerCountry == null) {
			if (other.customerCountry != null)
				return false;
		} else if (!customerCountry.equals(other.customerCountry))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerPhoneNumber == null) {
			if (other.customerPhoneNumber != null)
				return false;
		} else if (!customerPhoneNumber.equals(other.customerPhoneNumber))
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
		return "Customer [customerId=" + customerId + ", customerPhoneNumber=" + customerPhoneNumber
				+ ", customerEmail=" + customerEmail + ", customerCompanyName=" + customerCompanyName
				+ ", customerCountry=" + customerCountry + ", useStatus=" + useStatus + ", programId=" + programId
				+ ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
