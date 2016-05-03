package com.uxp.model;

import java.util.Date;

public class Annotation {
	private int annotationId;
	private String annotationTitle;
	private String annotationText;
	private int emojiId;
	private int pinTypeId;
	private int annotationContentTypeId;
	private int annotationTypeId;
	private int parentDomainId;
	private long specificURL;
	private String pinXCoordinate;
	private String pinYCoordinate;
	private String annotationAudioURL;
	private String annotationAttachmentURL;
	private StringBuffer annotationScreenshot;
	private int annotationScreenshotHeight;
	private int annotationScreenshotWidth;
	private String annotationScreenshotPinXCoordinate;
	private String annotationScreenshotPinYCoordinate;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public int getAnnotationId() {
		return annotationId;
	}
	public void setAnnotationId(int annotationId) {
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
	public int getEmojiId() {
		return emojiId;
	}
	public void setEmojiId(int emojiId) {
		this.emojiId = emojiId;
	}
	public int getPinTypeId() {
		return pinTypeId;
	}
	public void setPinTypeId(int pinTypeId) {
		this.pinTypeId = pinTypeId;
	}
	public int getAnnotationContentTypeId() {
		return annotationContentTypeId;
	}
	public void setAnnotationContentTypeId(int annotationContentTypeId) {
		this.annotationContentTypeId = annotationContentTypeId;
	}
	public int getAnnotationTypeId() {
		return annotationTypeId;
	}
	public void setAnnotationTypeId(int annotationTypeId) {
		this.annotationTypeId = annotationTypeId;
	}
	public int getParentDomainId() {
		return parentDomainId;
	}
	public void setParentDomainId(int parentDomainId) {
		this.parentDomainId = parentDomainId;
	}
	public long getSpecificURL() {
		return specificURL;
	}
	public void setSpecificURL(long specificURL) {
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
	public String getAnnotationAudioURL() {
		return annotationAudioURL;
	}
	public void setAnnotationAudioURL(String annotationAudioURL) {
		this.annotationAudioURL = annotationAudioURL;
	}
	public String getAnnotationAttachmentURL() {
		return annotationAttachmentURL;
	}
	public void setAnnotationAttachmentURL(String annotationAttachmentURL) {
		this.annotationAttachmentURL = annotationAttachmentURL;
	}
	public StringBuffer getAnnotationScreenshot() {
		return annotationScreenshot;
	}
	public void setAnnotationScreenshot(StringBuffer annotationScreenshot) {
		this.annotationScreenshot = annotationScreenshot;
	}
	public int getAnnotationScreenshotHeight() {
		return annotationScreenshotHeight;
	}
	public void setAnnotationScreenshotHeight(int annotationScreenshotHeight) {
		this.annotationScreenshotHeight = annotationScreenshotHeight;
	}
	public int getAnnotationScreenshotWidth() {
		return annotationScreenshotWidth;
	}
	public void setAnnotationScreenshotWidth(int annotationScreenshotWidth) {
		this.annotationScreenshotWidth = annotationScreenshotWidth;
	}
	public String getAnnotationScreenshotPinXCoordinate() {
		return annotationScreenshotPinXCoordinate;
	}
	public void setAnnotationScreenshotPinXCoordinate(String annotationScreenshotPinXCoordinate) {
		this.annotationScreenshotPinXCoordinate = annotationScreenshotPinXCoordinate;
	}
	public String getAnnotationScreenshotPinYCoordinate() {
		return annotationScreenshotPinYCoordinate;
	}
	public void setAnnotationScreenshotPinYCoordinate(String annotationScreenshotPinYCoordinate) {
		this.annotationScreenshotPinYCoordinate = annotationScreenshotPinYCoordinate;
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
	public Annotation(int annotationId, String annotationTitle, String annotationText, int emojiId, int pinTypeId,
			int annotationContentTypeId, int annotationTypeId, int parentDomainId, long specificURL,
			String pinXCoordinate, String pinYCoordinate, String annotationAudioURL, String annotationAttachmentURL,
			StringBuffer annotationScreenshot, int annotationScreenshotHeight, int annotationScreenshotWidth,
			String annotationScreenshotPinXCoordinate, String annotationScreenshotPinYCoordinate, char useStatus,
			String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.annotationId = annotationId;
		this.annotationTitle = annotationTitle;
		this.annotationText = annotationText;
		this.emojiId = emojiId;
		this.pinTypeId = pinTypeId;
		this.annotationContentTypeId = annotationContentTypeId;
		this.annotationTypeId = annotationTypeId;
		this.parentDomainId = parentDomainId;
		this.specificURL = specificURL;
		this.pinXCoordinate = pinXCoordinate;
		this.pinYCoordinate = pinYCoordinate;
		this.annotationAudioURL = annotationAudioURL;
		this.annotationAttachmentURL = annotationAttachmentURL;
		this.annotationScreenshot = annotationScreenshot;
		this.annotationScreenshotHeight = annotationScreenshotHeight;
		this.annotationScreenshotWidth = annotationScreenshotWidth;
		this.annotationScreenshotPinXCoordinate = annotationScreenshotPinXCoordinate;
		this.annotationScreenshotPinYCoordinate = annotationScreenshotPinYCoordinate;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((annotationAttachmentURL == null) ? 0 : annotationAttachmentURL.hashCode());
		result = prime * result + ((annotationAudioURL == null) ? 0 : annotationAudioURL.hashCode());
		result = prime * result + annotationContentTypeId;
		result = prime * result + annotationId;
		result = prime * result + ((annotationScreenshot == null) ? 0 : annotationScreenshot.hashCode());
		result = prime * result + annotationScreenshotHeight;
		result = prime * result
				+ ((annotationScreenshotPinXCoordinate == null) ? 0 : annotationScreenshotPinXCoordinate.hashCode());
		result = prime * result
				+ ((annotationScreenshotPinYCoordinate == null) ? 0 : annotationScreenshotPinYCoordinate.hashCode());
		result = prime * result + annotationScreenshotWidth;
		result = prime * result + ((annotationText == null) ? 0 : annotationText.hashCode());
		result = prime * result + ((annotationTitle == null) ? 0 : annotationTitle.hashCode());
		result = prime * result + annotationTypeId;
		result = prime * result + emojiId;
		result = prime * result + parentDomainId;
		result = prime * result + pinTypeId;
		result = prime * result + ((pinXCoordinate == null) ? 0 : pinXCoordinate.hashCode());
		result = prime * result + ((pinYCoordinate == null) ? 0 : pinYCoordinate.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + (int) (specificURL ^ (specificURL >>> 32));
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
		Annotation other = (Annotation) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationAttachmentURL == null) {
			if (other.annotationAttachmentURL != null)
				return false;
		} else if (!annotationAttachmentURL.equals(other.annotationAttachmentURL))
			return false;
		if (annotationAudioURL == null) {
			if (other.annotationAudioURL != null)
				return false;
		} else if (!annotationAudioURL.equals(other.annotationAudioURL))
			return false;
		if (annotationContentTypeId != other.annotationContentTypeId)
			return false;
		if (annotationId != other.annotationId)
			return false;
		if (annotationScreenshot == null) {
			if (other.annotationScreenshot != null)
				return false;
		} else if (!annotationScreenshot.equals(other.annotationScreenshot))
			return false;
		if (annotationScreenshotHeight != other.annotationScreenshotHeight)
			return false;
		if (annotationScreenshotPinXCoordinate == null) {
			if (other.annotationScreenshotPinXCoordinate != null)
				return false;
		} else if (!annotationScreenshotPinXCoordinate.equals(other.annotationScreenshotPinXCoordinate))
			return false;
		if (annotationScreenshotPinYCoordinate == null) {
			if (other.annotationScreenshotPinYCoordinate != null)
				return false;
		} else if (!annotationScreenshotPinYCoordinate.equals(other.annotationScreenshotPinYCoordinate))
			return false;
		if (annotationScreenshotWidth != other.annotationScreenshotWidth)
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
	
	
}
