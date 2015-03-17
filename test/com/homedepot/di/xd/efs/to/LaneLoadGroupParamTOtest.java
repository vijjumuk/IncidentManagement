package com.homedepot.di.xd.efs.to;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.util.ValidationUtil;

public class LaneLoadGroupParamTOtest {

	ParameterTO laneLoadGrpParam = null;
	@Test
	public void setAndGetLaneLoadGroupParamIdTest() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setParamId(12);
		Assert.assertEquals(12, laneLoadGrpParam.getParamId());
	}
	
	@Test
	public void setAndGetLaneLoadGroupCreateUserIdTest() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setCreateUserId("PXA8573");
		Assert.assertEquals("PXA8573", laneLoadGrpParam.getCreateUserId());
	}
	
	@Test
	public void setAndGetCreateTimeStamp(){
		laneLoadGrpParam = new ParameterTO();
		Timestamp timestamp = Timestamp.valueOf("2015-02-18 10:10:10.0");
		laneLoadGrpParam.setCreateTimeStamp(timestamp);
		Assert.assertEquals(timestamp,laneLoadGrpParam.getCreateTimestamp());
		
	}
	
	@Test
	public void setAndGetUpdatedUserId(){
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setLastUpdatedUserId("PXA8573");
		Assert.assertEquals("PXA8573", laneLoadGrpParam.getLastUpdatedUserId());
	}
	
	@Test
	public void setAndGetUpdatedTimestamp(){
		laneLoadGrpParam = new ParameterTO();
		Timestamp timestamp = Timestamp.valueOf("2015-02-18 10:10:10.0");
		laneLoadGrpParam.setLastUpdatedTimestamp(timestamp);
		Assert.assertEquals(timestamp,laneLoadGrpParam.getLastUpdatedTimestamp());
	}
	
	@Test
	public void setAndGetLoadGroupId() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setLoadGroupId(123);
		Assert.assertEquals(123, laneLoadGrpParam.getLoadGroupId());
	}
	
	@Test
	public void setAndGetParamCode() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setLoadGroupParamCode((short)1);
		Assert.assertEquals(1, laneLoadGrpParam.getLoadGroupParamCode());
	}
	
	@Test
	public void setAndGetEffBeginDate() throws ParseException, EFSException {
		laneLoadGrpParam = new ParameterTO();
		String effBeginDate  = "03/02/2015";
		laneLoadGrpParam.setEffBeginDate(ValidationUtil.convertStringToDate(effBeginDate));
		Assert.assertEquals(ValidationUtil.convertStringToDate(effBeginDate), laneLoadGrpParam.getEffBeginDate());
	}
	
	@Test
	public void setAndGetEffEndDate() throws ParseException, EFSException {
		laneLoadGrpParam = new ParameterTO();
		String effEndDate  = "03/02/2015";
		laneLoadGrpParam.setEffEndDate(ValidationUtil.convertStringToDate(effEndDate));
		Assert.assertEquals(ValidationUtil.convertStringToDate(effEndDate), laneLoadGrpParam.getEffEndDate());
	}
	
	@Test
	public void setAndGetCharValue() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setCharValue("Origin");
		Assert.assertEquals("Origin", laneLoadGrpParam.getCharValue());
	}
	
	@Test
	public void setAndGetIntValue() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setIntValue(1254);
		Assert.assertEquals(1254, laneLoadGrpParam.getIntValue().intValue());
	}
	
	@Test
	public void setAndGetDecimalValue() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setDecimalValue(new BigDecimal(123));
		Assert.assertEquals(new BigDecimal(123), laneLoadGrpParam.getDecimalValue());
	}
	
	@Test
	public void setAndGetFlagValue() {
		laneLoadGrpParam = new ParameterTO();
		laneLoadGrpParam.setFlagValue("Y");
		Assert.assertEquals("Y", laneLoadGrpParam.getFlagValue());
	}
	
}
