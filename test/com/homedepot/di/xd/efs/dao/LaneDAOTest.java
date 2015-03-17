package com.homedepot.di.xd.efs.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.to.LaneLoadGroupTO;
import com.homedepot.di.xd.efs.to.LaneLoadGroupVendorTO;
import com.homedepot.di.xd.efs.to.LaneTO;
import com.homedepot.homer.util.HomerUnitTestCase;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

/**
 */
public class LaneDAOTest extends HomerUnitTestCase {
	
	static int laneId =100;
	static int laneGroupId=1;
	static int laneGrpVndrId=500;
	static int seqNmbr = 100;
	
	/**
	 * Method setUp.
	 * @throws Exception
	 */
	@Before
	public void setUp()

	throws Exception {

	// add additional set up code here

	}




	/**
	 * Method tearDown.
	 * @throws Exception
	 */
	@After

	public void tearDown()

	throws Exception {

	// Add additional tear down code here

	}



	/**
	 * Method getLaneId.
	 * @throws DataOperationException
	 * @throws  
	 */
	@Test
	public void getLaneId() throws DataOperationException {
		int origin = 101;
		int destination = 201;
		Assert.assertEquals(LaneDAO.getLaneId(origin, destination), 1);

	}

	/**
	 * Method getLaneGroupId.
	 * @throws DataOperationException
	 */
	@Test
	public void getLaneGroupId() throws DataOperationException {
		int laneId = 1;
		String groupName = "DEFAULT";
		Assert.assertEquals(LaneDAO.getLaneGroupId(laneId, groupName),
				123);
	}

	/**
	 * Method getLaneLoadGroupVendorId.
	 * @throws DataOperationException
	 */
	@Test
	public void getLaneLoadGroupVendorId() throws DataOperationException {
		int laneGroupId = 123;
		String vendorNumber = "383625";
		Assert.assertEquals(
				LaneDAO.getLaneLoadGroupVendorId(laneGroupId, vendorNumber, "N"), 800);
	}

	/**
	 * Method validateMvendorNumbersforLane.
	 * @throws QueryException
	 * @throws DataOperationException 
	 */
	@Test
	public void validateMvendorNumbersforLane() throws QueryException, DataOperationException {
		List<String> vndrList = new ArrayList<String>();
		vndrList.add("383625");
		vndrList.add("10017");
		Assert.assertNotNull(LaneDAO.validateMvendorNumbers(vndrList));

	}

	@Test
	public void getLaneValidEFSLocationIds() throws DataOperationException {
		List<String> sourceLocationId = new ArrayList<String>();
		sourceLocationId.add("5520");
		sourceLocationId.add("688509TX002");
		sourceLocationId.add("454512OK001");
		sourceLocationId.add("471003IL001");
		Map<String, Integer> locationMap = new HashMap<String, Integer>();

		LaneDAO.getValidEFSLocationIds(sourceLocationId, locationMap);
		Assert.assertTrue(locationMap.size() > 1);

	}

	/**
	 * Method insertRecordsShpLane_1.
	 * @throws DataOperationException
	 */
	@Test
	public void insertRecordsShpLane_1() throws DataOperationException {
		LaneTO lt = new LaneTO();
		laneId++;
		lt.setLaneId(laneId);
		lt.setOriginLocId(105);
		lt.setDestinationLocId(205);
		lt.setCreatedUserId("SXP8562");
		lt.setLastUptdUserId("SXP8562");
		lt.setActiveFlag(true);
		lt.setShppingLaneName("BREAUX BRIDGE - 5520");
		
		da.table("SCHN_SHPG_LANE").where("SCHN_SHPG_LANE_ID = "+laneId);
		da.assert_count(0);
		Assert.assertTrue(LaneDAO.createLane(lt));

		da.table("SCHN_SHPG_LANE").where("SCHN_SHPG_LANE_ID = "+laneId);
		da.assert_count(1);

	}

	/**
	 * Method insertRecordsShpgLaneLoadGrp.
	 * @throws DataOperationException
	 */
	@Test
	public void insertRecordsShpgLaneLoadGrp() throws DataOperationException {

		LaneLoadGroupTO laneLoadGroupTo = new LaneLoadGroupTO();
		laneGroupId++;
		laneLoadGroupTo.setLandLoadGroupId(laneGroupId);
		laneLoadGroupTo.setCreatedUserId("SXP8562");
		laneLoadGroupTo.setLastUptdUserId("SXP8562");
		laneLoadGroupTo.setLaneId(1);
		laneLoadGroupTo.setEffectiveBeginDate(new Date(System
				.currentTimeMillis()));
		laneLoadGroupTo
				.setEffectiveEndDate(new Date(System.currentTimeMillis()));
		laneLoadGroupTo.setLaneLoadGroupName("DEFAULT");

		da.table("SCHN_SHPG_LANE_LOAD_GRP").where("SCHN_SHPG_LANE_LOAD_GRP_ID = "+laneGroupId);
		da.assert_count(0);
		Assert.assertTrue(LaneDAO.createLaneLoadGroup(laneLoadGroupTo));

		da.table("SCHN_SHPG_LANE_LOAD_GRP").where("SCHN_SHPG_LANE_LOAD_GRP_ID = "+laneGroupId);
		da.assert_count(1);

	}

	/**
	 * Method testinsertRecordsShpgLaneLoadGrpVndr.
	 * @throws DataOperationException
	 */
	@Test
	public void testinsertRecordsShpgLaneLoadGrpVndr() throws DataOperationException {

		LaneLoadGroupVendorTO laneLoadGroupVendorTO = new LaneLoadGroupVendorTO();
		laneGrpVndrId++;
		laneLoadGroupVendorTO.setLaneLoadGrpVndrId(laneGrpVndrId);
		laneLoadGroupVendorTO.setCreatedUserId("SXP8562");
		laneLoadGroupVendorTO.setLastUptdUserId("SXP8562");
		laneLoadGroupVendorTO.setMvndrNbr("383625");
		laneLoadGroupVendorTO.setDepartmentNbr((short) 26);
		laneLoadGroupVendorTO.setLaneLoadGrpId(123);
		laneLoadGroupVendorTO.setEffectiveBeginDate(new Date(System
				.currentTimeMillis()));
		laneLoadGroupVendorTO.setEffectiveEndDate(new Date(System
				.currentTimeMillis()));
		laneLoadGroupVendorTO.setMerchendiseBaseCode((short) 1);
		laneLoadGroupVendorTO.setPrimaryLocation("Y");
		da.table("SCHN_SHLANE_LGRP_VNDR").where(
				"SCHN_SHLANE_LGRP_VNDR_ID = "+laneGrpVndrId);
		da.assert_count(0);
		Assert.assertTrue(LaneDAO
				.createLaneLoadGroupVendor(laneLoadGroupVendorTO));

		da.table("SCHN_SHLANE_LGRP_VNDR").where(
				"SCHN_SHLANE_LGRP_VNDR_ID = "+laneGrpVndrId);
		da.assert_count(1);

	}
	
	/**
	 * Method testGetSequenceId.
	 * @throws Exception
	 */
	@Test
	public void testGetSequenceId()
		throws Exception {

		String LANE_SEQ_NBR = "SELECT SCHN_SHPG_LANE_SEQ.NEXTVAL AS SCHN_SHPG_LANE_SEQ FROM DUAL";
		
		Assert.assertEquals(LaneDAO.getNextSeqId(LANE_SEQ_NBR), seqNmbr);
		seqNmbr++;
	}
	
	/**
	 * Method testInListBuilder.
	 * @throws Exception
	 */
	@Test
	public void testInListBuilder()
		throws Exception {
		
		String column = "SCHN_EFS_SCH_TYP_CD";
		List<Short> inList = new ArrayList<>();
		inList.add((short) 1);
		String listName = "Type Code List";
		
		String query = LaneDAO.inListBuilder(column, inList, listName, 100);
		Assert.assertNotNull(query);
		
	}

	
}
