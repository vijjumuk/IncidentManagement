package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.Date;

public class RouteTransportTypeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int routeTransportTypeCd;
	private String lastUptdUserId;
	private Date lastUptdTs;
	private String langCd; 
	private String descriptionTypeCd;
	private String shortTypeDescription;
	private String typeDescription;
	
	@Override
	public String toString() {
		return "RouteTransportTypeTO [routeTransportTypeCd="
				+ routeTransportTypeCd + ", lastUptdUserId=" + lastUptdUserId
				+ ", lastUptdTs=" + lastUptdTs + ", langCd=" + langCd
				+ ", descriptionTypeCd=" + descriptionTypeCd
				+ ", shortTypeDescription=" + shortTypeDescription
				+ ", typeDescription=" + typeDescription + "]";
	}

	public int getRouteTransportTypeCd() {
		return routeTransportTypeCd;
	}

	public void setRouteTransportTypeCd(int routeTransportTypeCd) {
		this.routeTransportTypeCd = routeTransportTypeCd;
	}

	public String getLastUptdUserId() {
		return lastUptdUserId;
	}

	public void setLastUptdUserId(String lastUptdUserId) {
		this.lastUptdUserId = lastUptdUserId;
	}

	public Date getLastUptdTs() {
		return lastUptdTs;
	}

	public void setLastUptdTs(Date lastUptdTs) {
		this.lastUptdTs = lastUptdTs;
	}

	public String getLangCd() {
		return langCd;
	}

	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}

	public String getDescriptionTypeCd() {
		return descriptionTypeCd;
	}

	public void setDescriptionTypeCd(String descriptionTypeCd) {
		this.descriptionTypeCd = descriptionTypeCd;
	}

	public String getShortTypeDescription() {
		return shortTypeDescription;
	}

	public void setShortTypeDescription(String shortTypeDescription) {
		this.shortTypeDescription = shortTypeDescription;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((descriptionTypeCd == null) ? 0 : descriptionTypeCd
						.hashCode());
		result = prime * result + ((langCd == null) ? 0 : langCd.hashCode());
		result = prime * result
				+ ((lastUptdTs == null) ? 0 : lastUptdTs.hashCode());
		result = prime * result
				+ ((lastUptdUserId == null) ? 0 : lastUptdUserId.hashCode());
		result = prime * result + routeTransportTypeCd;
		result = prime
				* result
				+ ((shortTypeDescription == null) ? 0 : shortTypeDescription
						.hashCode());
		result = prime * result
				+ ((typeDescription == null) ? 0 : typeDescription.hashCode());
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
		RouteTransportTypeTO other = (RouteTransportTypeTO) obj;
		if (descriptionTypeCd == null) {
			if (other.descriptionTypeCd != null)
				return false;
		} else if (!descriptionTypeCd.equals(other.descriptionTypeCd))
			return false;
		if (langCd == null) {
			if (other.langCd != null)
				return false;
		} else if (!langCd.equals(other.langCd))
			return false;
		if (lastUptdTs == null) {
			if (other.lastUptdTs != null)
				return false;
		} else if (!lastUptdTs.equals(other.lastUptdTs))
			return false;
		if (lastUptdUserId == null) {
			if (other.lastUptdUserId != null)
				return false;
		} else if (!lastUptdUserId.equals(other.lastUptdUserId))
			return false;
		if (routeTransportTypeCd != other.routeTransportTypeCd)
			return false;
		if (shortTypeDescription == null) {
			if (other.shortTypeDescription != null)
				return false;
		} else if (!shortTypeDescription.equals(other.shortTypeDescription))
			return false;
		if (typeDescription == null) {
			if (other.typeDescription != null)
				return false;
		} else if (!typeDescription.equals(other.typeDescription))
			return false;
		return true;
	} 
	
	

}
