package com.homedepot.di.xd.efs.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.to.VendorGroupParamTO;
import com.homedepot.homer.util.HomerUnitTestCase;

/**
 */
public class VendorGroupParamDAOTest extends HomerUnitTestCase {

	VendorGroupParamUploadDAO vendorGroupParamDAO = null;
	/**
	 * Method getLoadVendorGroupId.
	 * @throws DataOperationException
	 */
	@Test
	public void getLoadVendorGroupId() throws DataOperationException {
		VendorGroupParamTO  vendorGrpTo = new VendorGroupParamTO();
		vendorGrpTo.setVendorNumber("383625");
		vendorGrpTo.setLaneLoadGroupId("456");
		StringBuilder errString = new StringBuilder();
		List<Integer> vendorGroupIdList = VendorGroupParamUploadDAO.getLoadGroupVendorId(vendorGrpTo,errString,false);
		Assert.assertTrue(errString.toString().isEmpty());
	}

	/**
	 * Method getLaneLoadGroupId.
	 * @throws DataOperationException
	 */
	@Test 
	public void getLaneLoadGroupId() throws DataOperationException {
		VendorGroupParamTO  vendorGrpTo = new VendorGroupParamTO();
		StringBuilder errString = new StringBuilder();
		vendorGrpTo.setOriginId(101);
		vendorGrpTo.setDestinationId(201);
		VendorGroupParamUploadDAO.getLoadGroupIdList(vendorGrpTo,errString);
		Assert.assertTrue(errString.toString().isEmpty());
	}
	
	/**
	 * Method getLoadVendorGroupIdFailure.
	 * @throws DataOperationException
	 */
	@Test
	public void getLoadVendorGroupIdFailure() throws DataOperationException {
		VendorGroupParamTO  vendorGrpTo = new VendorGroupParamTO();
		vendorGrpTo.setVendorNumber("383625");
		vendorGrpTo.setLaneLoadGroupId("102");
		StringBuilder errString = new StringBuilder();
		VendorGroupParamUploadDAO.getLoadGroupVendorId(vendorGrpTo,errString,false);
		Assert.assertFalse(errString.toString().isEmpty());
	}

	/**
	 * Method getLaneLoadGroupIdFailure.
	 * @throws DataOperationException
	 */
	@Test 
	public void getLaneLoadGroupIdFailure() throws DataOperationException {
		VendorGroupParamTO  vendorGrpTo = new VendorGroupParamTO();
		StringBuilder errString = new StringBuilder();
		vendorGrpTo.setOriginId(101);
		vendorGrpTo.setDestinationId(334);
		VendorGroupParamUploadDAO.getLoadGroupIdList(vendorGrpTo,errString);
		Assert.assertFalse(errString.toString().isEmpty());
	}
	
	/**
	 * Method GetLocationId.
	 * @throws DataOperationException
	 */
	@Test
	public void GetLocationId() throws DataOperationException {
		VendorGroupParamTO  vendorGrpTo = new VendorGroupParamTO();
		vendorGrpTo.setOrigin("513769MD001");
		vendorGrpTo.setDestination("5030");
		StringBuilder error = new StringBuilder();
		VendorGroupParamUploadDAO.getActiveLocationIdList(vendorGrpTo,error);
		assertNotNull(vendorGrpTo.getOriginId());
	}
	
}
