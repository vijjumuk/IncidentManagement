package com.homedepot.di.xd.efs.to;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class VendorGroupParamTOTest {
	
	VendorGroupParamTO vendorGroupTo = null;
	@Test
	public void testSetAndGetVendorNumber() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setVendorNumber("87334");
		Assert.assertEquals("87334", vendorGroupTo.getVendorNumber());
	}
	
	@Test
	public void testSetAndGetOrigin(){
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setOrigin("459898PA001");
		Assert.assertEquals("459898PA001", vendorGroupTo.getOrigin());
	}
	
	@Test
	public void testSetAndGetDestination(){
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setDestination("5520");
		Assert.assertEquals("5520", vendorGroupTo.getDestination());
	}
	
	@Test
	public void setAndGetLaneLoadGroupCreateUserIdTest() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setCreateUserId("PXA8573");
		Assert.assertEquals("PXA8573", vendorGroupTo.getCreateUserId());
	}
	
	@Test
	public void setAndGetCreateTimeStamp(){
		vendorGroupTo = new VendorGroupParamTO();
		Timestamp timestamp = Timestamp.valueOf("2015-02-18 10:10:10.0");
		vendorGroupTo.setCreateTimeStamp(timestamp);
		Assert.assertEquals(timestamp,vendorGroupTo.getCreateTimestamp());
		
	}
	
	@Test
	public void setAndGetUpdatedUserId(){
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setLastUpdatedUserId("PXA8573");
		Assert.assertEquals("PXA8573", vendorGroupTo.getLastUpdatedUserId());
	}
	
	@Test
	public void setAndGetUpdatedTimestamp(){
		vendorGroupTo = new VendorGroupParamTO();
		Timestamp timestamp = Timestamp.valueOf("2015-02-18 10:10:10.0");
		vendorGroupTo.setLastUpdatedTimestamp(timestamp);
		Assert.assertEquals(timestamp,vendorGroupTo.getLastUpdatedTimestamp());
	}
	
	@Test
	public void testSetAndGetVendorGroupId() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setVendorGroupId(1);
		Assert.assertEquals(1, vendorGroupTo.getVendorGroupId());
	}
	
	@Test
	public void testSetAndGetLaneLoadGroupId() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setLaneLoadGroupId("1");
		Assert.assertEquals("1", vendorGroupTo.getLaneLoadGroupId());
	}
	
	@Test
	public void testSetAndGetOriginId() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setOriginId(1);
		Assert.assertEquals(1, vendorGroupTo.getOriginId());
	}
	
	@Test
	public void testSetAndGetDestinationId() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setDestinationId(1);
		Assert.assertEquals(1, vendorGroupTo.getDestinationId());
	}
	
	
	@Test
	public void testSetAndGetDefaultFlag() {
		vendorGroupTo = new VendorGroupParamTO();
		vendorGroupTo.setDefaultFlag("Y");
		Assert.assertEquals("Y", vendorGroupTo.getDefaultFlag());
	}
	
	
	@Test
	public void testSetAndGetLoadParamList() {
		vendorGroupTo = new VendorGroupParamTO();
		List<ParameterTO> paramCdLiat =  new ArrayList<ParameterTO>();
		ParameterTO paramTo = new ParameterTO();
		paramCdLiat.add(paramTo);
		vendorGroupTo.setLoadParamList(paramCdLiat);
		Assert.assertEquals(paramCdLiat.size(), vendorGroupTo.getLoadParamList().size());
	}
	
	@Test
	public void setAndGetEffBeginDate() throws ParseException {
		vendorGroupTo = new VendorGroupParamTO();
		String effBeginDate  = "03-02-2015";
		vendorGroupTo.setEffectiveBeginDate(effBeginDate);
		Assert.assertEquals(effBeginDate, vendorGroupTo.getEffectiveBeginDate());
	}
	
	@Test
	public void setAndGetEffEndDate() throws ParseException {
		vendorGroupTo = new VendorGroupParamTO();
		String effEndDate  = "03-02-2015";
		vendorGroupTo.setEffectiveEndDate(effEndDate);
		Assert.assertEquals(effEndDate, vendorGroupTo.getEffectiveEndDate());
	}
}
