package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 */
public class VendorGroupParamTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3189209001754425850L;
	
	private String vendorNumber;

	private String origin;

	private String destination;

	private String createUserId;

	private Timestamp createdTimeStamp;

	private String lastUpdatedUserId;

	private Timestamp lastUpdatedTimestamp;

	private List<ParameterTO> paramCdLiat;

	private int vendorGroupId;

	private String laneLoadGroupId;

	private int originId;

	private int destinationId;

	private int rowNumber;

	private String defaultFlag;

	private String effectiveBeginDate;

	private String effectiveEndDate;


	/**
	 * Method setVendorNumber.
	 * @param vendorNumber String
	 */
	public void setVendorNumber(String vendorNumber) {
		
		this.vendorNumber = vendorNumber;
	}

	/**
	 * Method getVendorNumber.
	 * @return String
	 */
	public String getVendorNumber() {
		
		return vendorNumber;
	}

	/**
	 * Method setOrigin.
	 * @param origin String
	 */
	public void setOrigin(String origin) {
		
		this.origin = origin;
		
	}

	/**
	 * Method getOrigin.
	 * @return String
	 */
	public String getOrigin() {
		
		return origin;
	}

	/**
	 * Method setDestination.
	 * @param dest String
	 */
	public void setDestination(String dest) {
	
		this.destination = dest;
		
	}

	/**
	 * Method getDestination.
	 * @return String
	 */
	public String getDestination() {
		
		return destination;
	}

	/**
	 * Method setCreateUserId.
	 * @param userId String
	 */
	public void setCreateUserId(String userId) {
		
		this.createUserId = userId;
	}

	/**
	 * Method getCreateUserId.
	 * @return String
	 */
	public String getCreateUserId() {
		
		return createUserId;
	}
	
/**
 * Method setCreateTimeStamp.
 * @param createdTimeStamp Timestamp
 */
public void setCreateTimeStamp(Timestamp createdTimeStamp) {
		
		this.createdTimeStamp = createdTimeStamp;
		
	}

	/**
	 * Method getCreateTimestamp.
	 * @return Timestamp
	 */
	public Timestamp getCreateTimestamp() {
		
		return createdTimeStamp;
	}

	/**
	 * Method setLastUpdatedUserId.
	 * @param userId String
	 */
	public void setLastUpdatedUserId(String userId) {
		
		this.lastUpdatedUserId = userId;
		
	}

	/**
	 * Method getLastUpdatedUserId.
	 * @return String
	 */
	public String getLastUpdatedUserId() {
		
		return lastUpdatedUserId;
	}

	/**
	 * Method setLastUpdatedTimestamp.
	 * @param lastUpdatedTimeStamp Timestamp
	 */
	public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimeStamp) {
		
		this.lastUpdatedTimestamp = lastUpdatedTimeStamp;
		
	}
	
	/**
	 * Method getLastUpdatedTimestamp.
	 * @return Timestamp
	 */
	public Timestamp getLastUpdatedTimestamp() {

		return lastUpdatedTimestamp;
	}

	/**
	 * Method setLoadParamList.
	 * @param paramCdLiat List<ParameterTO>
	 */
	public void setLoadParamList(List<ParameterTO> paramCdLiat) {
		
		this.paramCdLiat = paramCdLiat;
	}

	/**
	 * Method getLoadParamList.
	 * @return List<ParameterTO>
	 */
	public List<ParameterTO> getLoadParamList() {
		
		return paramCdLiat;
	}

	/**
	 * Method setVendorGroupId.
	 * @param vendorGroupId int
	 */
	public void setVendorGroupId(int vendorGroupId) {
		
		this.vendorGroupId = vendorGroupId;
		
	}

	/**
	 * Method getVendorGroupId.
	 * @return int
	 */
	public int getVendorGroupId() {
		
		return vendorGroupId;
	}

	/**
	 * Method setLaneLoadGroupId.
	 * @param lanGroupid String
	 */
	public void setLaneLoadGroupId(String lanGroupid) {
		
		this.laneLoadGroupId = lanGroupid;
		
	}

	/**
	 * Method getLaneLoadGroupId.
	 * @return String
	 */
	public String getLaneLoadGroupId() {
		
		return laneLoadGroupId;
	}

	/**
	 * Method setOriginId.
	 * @param originId int
	 */
	public void setOriginId(int originId) {
		
		this.originId = originId;
	}

	/**
	 * Method getOriginId.
	 * @return int
	 */
	public int getOriginId() {
		
		return originId;
	}

	/**
	 * Method setDestinationId.
	 * @param destinationId int
	 */
	public void setDestinationId(int destinationId) {
		
		this.destinationId = destinationId;
	}

	/**
	 * Method getDestinationId.
	 * @return int
	 */
	public int getDestinationId() {
		
		return destinationId;
	}

	/**
	 * Method setRowNumber.
	 * @param rowNumber int
	 */
	public void setRowNumber(int rowNumber) {
		
		this.rowNumber = rowNumber;
	}

	/**
	 * Method getRowNumber.
	 * @return int
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/**
	 * Method setDefaultFlag.
	 * @param flag String
	 */
	public void setDefaultFlag(String flag) {
		
		this.defaultFlag = flag;
		
	}

	/**
	 * Method getDefaultFlag.
	 * @return String
	 */
	public String getDefaultFlag() {
		
		return defaultFlag;
	}

	/**
	 * Method setEffectiveBeginDate.
	 * @param beginDate String
	 */
	public void setEffectiveBeginDate(String beginDate) {

		this.effectiveBeginDate = beginDate;
		
	}

	/**
	 * Method getEffectiveBeginDate.
	 * @return String
	 */
	public String getEffectiveBeginDate() {
		
		return effectiveBeginDate;
	}

	/**
	 * Method setEffectiveEndDate.
	 * @param endDate String
	 */
	public void setEffectiveEndDate(String endDate) {
		
		this.effectiveEndDate = endDate;
	}
	
	/**
	 * Method getEffectiveEndDate.
	 * @return String
	 */
	public String getEffectiveEndDate() {

		return effectiveEndDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createUserId == null) ? 0 : createUserId.hashCode());
		result = prime
				* result
				+ ((createdTimeStamp == null) ? 0 : createdTimeStamp.hashCode());
		result = prime * result
				+ ((defaultFlag == null) ? 0 : defaultFlag.hashCode());
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + destinationId;
		result = prime
				* result
				+ ((effectiveBeginDate == null) ? 0 : effectiveBeginDate
						.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime * result
				+ ((laneLoadGroupId == null) ? 0 : laneLoadGroupId.hashCode());
		result = prime
				* result
				+ ((lastUpdatedTimestamp == null) ? 0 : lastUpdatedTimestamp
						.hashCode());
		result = prime
				* result
				+ ((lastUpdatedUserId == null) ? 0 : lastUpdatedUserId
						.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + originId;
		result = prime * result
				+ ((paramCdLiat == null) ? 0 : paramCdLiat.hashCode());
		result = prime * result + rowNumber;
		result = prime * result + vendorGroupId;
		result = prime * result
				+ ((vendorNumber == null) ? 0 : vendorNumber.hashCode());
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
		VendorGroupParamTO other = (VendorGroupParamTO) obj;
		if (createUserId == null) {
			if (other.createUserId != null)
				return false;
		} else if (!createUserId.equals(other.createUserId))
			return false;
		if (createdTimeStamp == null) {
			if (other.createdTimeStamp != null)
				return false;
		} else if (!createdTimeStamp.equals(other.createdTimeStamp))
			return false;
		if (defaultFlag == null) {
			if (other.defaultFlag != null)
				return false;
		} else if (!defaultFlag.equals(other.defaultFlag))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (destinationId != other.destinationId)
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
		if (laneLoadGroupId == null) {
			if (other.laneLoadGroupId != null)
				return false;
		} else if (!laneLoadGroupId.equals(other.laneLoadGroupId))
			return false;
		if (lastUpdatedTimestamp == null) {
			if (other.lastUpdatedTimestamp != null)
				return false;
		} else if (!lastUpdatedTimestamp.equals(other.lastUpdatedTimestamp))
			return false;
		if (lastUpdatedUserId == null) {
			if (other.lastUpdatedUserId != null)
				return false;
		} else if (!lastUpdatedUserId.equals(other.lastUpdatedUserId))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (originId != other.originId)
			return false;
		if (paramCdLiat == null) {
			if (other.paramCdLiat != null)
				return false;
		} else if (!paramCdLiat.equals(other.paramCdLiat))
			return false;
		if (rowNumber != other.rowNumber)
			return false;
		if (vendorGroupId != other.vendorGroupId)
			return false;
		if (vendorNumber == null) {
			if (other.vendorNumber != null)
				return false;
		} else if (!vendorNumber.equals(other.vendorNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendorGroupParamTO [vendorNumber=" + vendorNumber + ", origin="
				+ origin + ", destination=" + destination + ", createUserId="
				+ createUserId + ", createdTimeStamp=" + createdTimeStamp
				+ ", lastUpdatedUserId=" + lastUpdatedUserId
				+ ", lastUpdatedTimestamp=" + lastUpdatedTimestamp
				+ ", paramCdLiat=" + paramCdLiat + ", vendorGroupId="
				+ vendorGroupId + ", laneLoadGroupId=" + laneLoadGroupId
				+ ", originId=" + originId + ", destinationId=" + destinationId
				+ ", rowNumber=" + rowNumber + ", defaultFlag=" + defaultFlag
				+ ", effectiveBeginDate=" + effectiveBeginDate
				+ ", effectiveEndDate=" + effectiveEndDate + "]";
	}
	
	
}
