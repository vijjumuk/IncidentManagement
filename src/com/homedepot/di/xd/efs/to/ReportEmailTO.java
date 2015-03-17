package com.homedepot.di.xd.efs.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reportEmail")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportEmailTO implements Serializable {

	private static final long serialVersionUID = -8226485138155675562L;
	
	private String emailAddress;
	private String frequency;
	private String report;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((report == null) ? 0 : report.hashCode());
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
		ReportEmailTO other = (ReportEmailTO) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (report == null) {
			if (other.report != null)
				return false;
		} else if (!report.equals(other.report))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReportEmailTO [emailAddress=" + emailAddress + ", frequency="
				+ frequency + ", report=" + report + "]";
	}
}
