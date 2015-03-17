package com.homedepot.di.xd.efs.to;

import java.io.Serializable;

public class FrequencyTO implements Serializable {

	private static final long serialVersionUID = -4075099289301887330L;
	private int freqCode;
	private String description;
	
	public int getFreqCode() {
		return freqCode;
	}
	public void setFreqCode(int freqCode) {
		this.freqCode = freqCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + freqCode;
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
		FrequencyTO other = (FrequencyTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (freqCode != other.freqCode)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FrequencyTO [freqCode=" + freqCode + ", description="
				+ description + "]";
	}

}
