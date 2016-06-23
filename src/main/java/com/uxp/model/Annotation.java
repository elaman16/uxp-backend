package com.uxp.model;

import java.util.Date;
import javax.persistence.*;
 
@Entity
@Table(name="annotation")
public class Annotation {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long annotationId;
	private String annotationTitle;
	@Column(columnDefinition = "TEXT")
	private String annotationText;
	private String userName;
	private long emojiId;
	private long pinTypeId;
	private long annotationContentTypeId;
	private long annotationTypeId;
	private long parentDomainId;
	private String specificURL;
	private String pinXCoordinate;
	private String pinYCoordinate;
	private String annotationMediaType;
	private String attachmentURI;
	private long annotationMediaId;
	private int annotationPageHeight;
	private int annotationPageWidth;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	private String recommendation;
	private String severity;
	private String violation;
	private String userVideo;
	
	public Annotation() {}
	
	

	public Annotation(String annotationTitle, String annotationText, String specificURL, String pinXCoordinate,
			String pinYCoordinate, String annotationMediaType, int annotationPageHeight, int annotationPageWidth,
			String programId, String locId, long updatedBy, String userName, String recommendation, String severity, String violation, String userVideo) {
		super();
		this.annotationTitle = annotationTitle;
		this.annotationText = annotationText;
		this.specificURL = specificURL;
		this.pinXCoordinate = pinXCoordinate;
		this.pinYCoordinate = pinYCoordinate;
		this.annotationMediaType = annotationMediaType;
		this.annotationPageHeight = annotationPageHeight;
		this.annotationPageWidth = annotationPageWidth;
		this.useStatus = 'V';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = updatedBy;
		this.userName = userName;
		this.recommendation = recommendation;
		this.severity = severity;
		this.violation = violation;
		this.userVideo = userVideo;
	}
	public String getUserVideo() {
		return userVideo;
	}



	public void setUserVideo(String userVideo) {
		this.userVideo = userVideo;
	}


	public String getRecommendation() {
		return recommendation;
	}



	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}



	public String getSeverity() {
		return severity;
	}



	public void setSeverity(String severity) {
		this.severity = severity;
	}



	public String getViolation() {
		return violation;
	}



	public void setViolation(String violation) {
		this.violation = violation;
	}



	public String getAttachmentURI() {
		return attachmentURI;
	}



	public void setAttachmentURI(String attachmentURI) {
		this.attachmentURI = attachmentURI;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public long getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(long annotationId) {
		this.annotationId = annotationId;
	}

	public String getAnnotationTitle() {
		return annotationTitle;
	}

	public void setAnnotationTitle(String annotationTitle) {
		this.annotationTitle = annotationTitle;
	}

	public String getAnnotationText() {
		return annotationText;
	}

	public void setAnnotationText(String annotationText) {
		this.annotationText = annotationText;
	}

	public long getEmojiId() {
		return emojiId;
	}

	public void setEmojiId(long emojiId) {
		this.emojiId = emojiId;
	}

	public long getPinTypeId() {
		return pinTypeId;
	}

	public void setPinTypeId(long pinTypeId) {
		this.pinTypeId = pinTypeId;
	}

	public long getAnnotationContentTypeId() {
		return annotationContentTypeId;
	}

	public void setAnnotationContentTypeId(long annotationContentTypeId) {
		this.annotationContentTypeId = annotationContentTypeId;
	}

	public long getAnnotationTypeId() {
		return annotationTypeId;
	}

	public void setAnnotationTypeId(long annotationTypeId) {
		this.annotationTypeId = annotationTypeId;
	}

	public long getParentDomainId() {
		return parentDomainId;
	}

	public void setParentDomainId(long parentDomainId) {
		this.parentDomainId = parentDomainId;
	}

	public String getSpecificURL() {
		return specificURL;
	}

	public void setSpecificURL(String specificURL) {
		this.specificURL = specificURL;
	}

	public String getPinXCoordinate() {
		return pinXCoordinate;
	}

	public void setPinXCoordinate(String pinXCoordinate) {
		this.pinXCoordinate = pinXCoordinate;
	}

	public String getPinYCoordinate() {
		return pinYCoordinate;
	}

	public void setPinYCoordinate(String pinYCoordinate) {
		this.pinYCoordinate = pinYCoordinate;
	}

	public String getAnnotationMediaType() {
		return annotationMediaType;
	}

	public void setAnnotationMediaType(String annotationMediaType) {
		this.annotationMediaType = annotationMediaType;
	}

	public long getAnnotationMediaId() {
		return annotationMediaId;
	}

	public void setAnnotationMediaId(long annotationMediaId) {
		this.annotationMediaId = annotationMediaId;
	}

	public int getAnnotationPageHeight() {
		return annotationPageHeight;
	}

	public void setAnnotationPageHeight(int annotationPageHeight) {
		this.annotationPageHeight = annotationPageHeight;
	}

	public int getAnnotationPageWidth() {
		return annotationPageWidth;
	}

	public void setAnnotationPageWidth(int annotationPageWidth) {
		this.annotationPageWidth = annotationPageWidth;
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
		result = prime * result + (int) (annotationContentTypeId ^ (annotationContentTypeId >>> 32));
		result = prime * result + (int) (annotationId ^ (annotationId >>> 32));
		result = prime * result + (int) (annotationMediaId ^ (annotationMediaId >>> 32));
		result = prime * result + ((annotationMediaType == null) ? 0 : annotationMediaType.hashCode());
		result = prime * result + annotationPageHeight;
		result = prime * result + annotationPageWidth;
		result = prime * result + ((annotationText == null) ? 0 : annotationText.hashCode());
		result = prime * result + ((annotationTitle == null) ? 0 : annotationTitle.hashCode());
		result = prime * result + (int) (annotationTypeId ^ (annotationTypeId >>> 32));
		result = prime * result + (int) (emojiId ^ (emojiId >>> 32));
		result = prime * result + (int) (parentDomainId ^ (parentDomainId >>> 32));
		result = prime * result + (int) (pinTypeId ^ (pinTypeId >>> 32));
		result = prime * result + ((pinXCoordinate == null) ? 0 : pinXCoordinate.hashCode());
		result = prime * result + ((pinYCoordinate == null) ? 0 : pinYCoordinate.hashCode());
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
		Annotation other = (Annotation) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationContentTypeId != other.annotationContentTypeId)
			return false;
		if (annotationId != other.annotationId)
			return false;
		if (annotationMediaId != other.annotationMediaId)
			return false;
		if (annotationMediaType == null) {
			if (other.annotationMediaType != null)
				return false;
		} else if (!annotationMediaType.equals(other.annotationMediaType))
			return false;
		if (annotationPageHeight != other.annotationPageHeight)
			return false;
		if (annotationPageWidth != other.annotationPageWidth)
			return false;
		if (annotationText == null) {
			if (other.annotationText != null)
				return false;
		} else if (!annotationText.equals(other.annotationText))
			return false;
		if (annotationTitle == null) {
			if (other.annotationTitle != null)
				return false;
		} else if (!annotationTitle.equals(other.annotationTitle))
			return false;
		if (annotationTypeId != other.annotationTypeId)
			return false;
		if (emojiId != other.emojiId)
			return false;
		if (parentDomainId != other.parentDomainId)
			return false;
		if (pinTypeId != other.pinTypeId)
			return false;
		if (pinXCoordinate == null) {
			if (other.pinXCoordinate != null)
				return false;
		} else if (!pinXCoordinate.equals(other.pinXCoordinate))
			return false;
		if (pinYCoordinate == null) {
			if (other.pinYCoordinate != null)
				return false;
		} else if (!pinYCoordinate.equals(other.pinYCoordinate))
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (specificURL != other.specificURL)
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
		return "Annotation [annotationId=" + annotationId + ", annotationTitle=" + annotationTitle + ", annotationText="
				+ annotationText + ", emojiId=" + emojiId + ", pinTypeId=" + pinTypeId + ", annotationContentTypeId="
				+ annotationContentTypeId + ", annotationTypeId=" + annotationTypeId + ", parentDomainId="
				+ parentDomainId + ", specificURL=" + specificURL + ", pinXCoordinate=" + pinXCoordinate
				+ ", pinYCoordinate=" + pinYCoordinate + ", annotationMediaType=" + annotationMediaType
				+ ", annotationMediaId=" + annotationMediaId + ", annotationPageHeight=" + annotationPageHeight
				+ ", annotationPageWidth=" + annotationPageWidth + ", useStatus=" + useStatus + ", programId="
				+ programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}

	
	
	
}
