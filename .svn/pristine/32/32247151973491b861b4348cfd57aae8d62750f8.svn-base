package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="emailInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailInfoTO implements Serializable {
	
	private static final long serialVersionUID = -2038726789796797812L;
	
	private String displayName;
	private List<ReportEmailTO> reportEmails;

	public EmailInfoTO() {
		this.displayName = null;
		this.reportEmails = null; 
	}

	public EmailInfoTO(String name, List<ReportEmailTO> emails) {
		this.displayName = name;
		this.reportEmails = emails;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<ReportEmailTO> getReportEmails() {
		return reportEmails;
	}

	public void setReportEmails(List<ReportEmailTO> reportEmails) {
		this.reportEmails = reportEmails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result
				+ ((reportEmails == null) ? 0 : reportEmails.hashCode());
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
		EmailInfoTO other = (EmailInfoTO) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (reportEmails == null) {
			if (other.reportEmails != null)
				return false;
		} else if (!reportEmails.equals(other.reportEmails))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailInfoTO [displayName=" + displayName + ", reportEmails="
				+ reportEmails + "]";
	}
	
}
