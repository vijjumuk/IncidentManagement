package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.Date;

public class RouteTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int routeID;
	private String createdSysUserId;
	private Date createdTs;
	private String lastUptdUserId;
	private Date lastUptdTs;
	private Date effectiveBeginDate;
	private Date effectiveEndDate;
	private int routeTypeCd;
	private int routeConfigCd;
	private String routeNm;
	private String errorString;
	
 

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
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

	public Date getEffectiveBeginDate() {
		return effectiveBeginDate;
	}

	public void setEffectiveBeginDate(Date effectiveBeginDate) {
		this.effectiveBeginDate = effectiveBeginDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public int getRouteTypeCd() {
		return routeTypeCd;
	}

	public void setRouteTypeCd(int routeTypeCd) {
		this.routeTypeCd = routeTypeCd;
	}

	public int getrouteConfigCd() {
		return routeConfigCd;
	}

	public void setrouteConfigCd(int routeConfigCd) {
		this.routeConfigCd = routeConfigCd;
	}

	public String getRouteNm() {
		return routeNm;
	}

	public void setRouteNm(String routeNm) {
		this.routeNm = routeNm.toUpperCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((createdSysUserId == null) ? 0 : createdSysUserId.hashCode());
		result = prime * result
				+ ((createdTs == null) ? 0 : createdTs.hashCode());
		result = prime
				* result
				+ ((effectiveBeginDate == null) ? 0 : effectiveBeginDate
						.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime * result
				+ ((lastUptdTs == null) ? 0 : lastUptdTs.hashCode());
		result = prime * result
				+ ((lastUptdUserId == null) ? 0 : lastUptdUserId.hashCode());
		result = prime * result + routeConfigCd;
		result = prime * result + routeID;
		result = prime * result + ((routeNm == null) ? 0 : routeNm.hashCode());
		result = prime * result + routeTypeCd;
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
		RouteTO other = (RouteTO) obj;
		if (createdSysUserId == null) {
			if (other.createdSysUserId != null)
				return false;
		} else if (!createdSysUserId.equals(other.createdSysUserId))
			return false;
		if (createdTs == null) {
			if (other.createdTs != null)
				return false;
		} else if (!createdTs.equals(other.createdTs))
			return false;
		if (effectiveBeginDate == null) {
			if (other.effectiveBeginDate != null)
				return false;
		} else if (!effectiveBeginDate.equals(other.effectiveBeginDate))
			return false;
		if (effectiveEndDate == null) {
			if (other.effectiveEndDate != null)
				return false;
		} else if (!effectiveEndDate.equals(other.effectiveEndDate))
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
		if (routeConfigCd != other.routeConfigCd)
			return false;
		if (routeID != other.routeID)
			return false;
		if (routeNm == null) {
			if (other.routeNm != null)
				return false;
		} else if (!routeNm.equals(other.routeNm))
			return false;
		if (routeTypeCd != other.routeTypeCd)
			return false;
		return true;
	}

	public String getCreatedSysUserId() {
		return createdSysUserId;
	}

	public void setCreatedSysUserId(String createdSysUserId) {
		this.createdSysUserId = createdSysUserId;
	}

	@Override
	public String toString() {
		return "RouteTO [routeID=" + routeID + ", createdSysUserId="
				+ createdSysUserId + ", createdTs=" + createdTs
				+ ", lastUptdUserId=" + lastUptdUserId + ", lastUptdTs="
				+ lastUptdTs + ", effectiveBeginDate=" + effectiveBeginDate
				+ ", effectiveEndDate=" + effectiveEndDate + ", routeTypeCd="
				+ routeTypeCd + ", rTransPTypeCd=" + routeConfigCd
				+ ", routeNm=" + routeNm + "]";
	}

	public void setRouteTypeCd(String rteTypCd) {
		
		this.routeTypeCd = Integer.parseInt(rteTypCd);
		
	}

	public void setRouteConfigCd(String routeConfigCd) {
	 
		this.routeConfigCd = Integer.parseInt(routeConfigCd);
		
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	
	
}
