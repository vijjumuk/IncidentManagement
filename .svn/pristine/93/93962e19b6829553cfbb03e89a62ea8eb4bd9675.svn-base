package com.homedepot.di.xd.efs.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.LoadGroupParamTO;
import com.homedepot.di.xd.efs.to.ParameterTO;
import com.homedepot.homer.util.HomerUnitTestCase;

public class LaneLoadGroupParamDAOTest extends HomerUnitTestCase {
	static int paramId = 100;
	@Test
	public void LaneLoadGroupNullTest() throws Exception {
		List<ParameterTO> laneLoadGrpParamList = null;
		Assert.assertFalse(LoadGroupParamUploadDAO.insertLaneGroupParams(laneLoadGrpParamList));
	}

	@Test
	public void LaneLoadGroupEmptyListTest() throws Exception {
		List<ParameterTO> laneLoadGrpParamList = new ArrayList<ParameterTO>();
		Assert.assertFalse(LoadGroupParamUploadDAO.insertLaneGroupParams(laneLoadGrpParamList));
	}

/*	@Test
	public void LaneLoadGroupInsertTest() throws ParseException, QueryException, EFSException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String effBeginDate  = "02-03-2015";
		String effEndDate  = "12-03-2015";
		paramId++;
		List<LaneLoadGroupParamTO> laneLoadGrpParamList = new ArrayList<LaneLoadGroupParamTO>();
		LaneLoadGroupParamTO laneLoadGrpParam = new LaneLoadGroupParamTO();
		laneLoadGrpParam.setParamId(paramId);
		laneLoadGrpParam.setCreateUserId("QAT005");
		laneLoadGrpParam.setCreateTimeStamp(Timestamp.valueOf("2015-02-18 10:10:10.0"));
		laneLoadGrpParam.setLastUpdatedUserId("QAT005");
		laneLoadGrpParam.setLastUpdatedTimestamp(Timestamp.valueOf("2015-02-18 10:10:10.0"));
		laneLoadGrpParam.setLoadGroupId(1);
		laneLoadGrpParam.setLoadGroupParamCode((short)1);
		laneLoadGrpParam.setEffBeginDate(formatter.parse(effBeginDate));
		laneLoadGrpParam.setEffEndDate(formatter.parse(effEndDate));
		laneLoadGrpParam.setCharValue("Origin");
		laneLoadGrpParam.setIntValue(12);
		laneLoadGrpParam.setDecimalValue(new BigDecimal(124));
		laneLoadGrpParam.setFlagValue("Y");
		laneLoadGrpParamList.add(laneLoadGrpParam);
		da.table("SCHN_SHLANE_LGRP_PARM").where("SCHN_SHLANE_LGRP_PARM_ID =" +paramId);
		da.assert_count(0);
		Assert.assertTrue(LaneLoadGroupDAO.insertLaneGroupParams(laneLoadGrpParamList));
		da.table("SCHN_SHLANE_LGRP_PARM").where("SCHN_SHLANE_LGRP_PARM_ID =" +paramId);
		da.assert_count(1);
	}*/
	
	@Test
	public void GetLocationId() throws EFSException {
		LoadGroupParamTO loadgrpTo = new LoadGroupParamTO();
		loadgrpTo.setLocationNbr("513769MD001");
		loadgrpTo.setDestinationNbr("5030");
		StringBuilder error = new StringBuilder();
		LoadGroupParamUploadDAO.getActiveLocationIdList(loadgrpTo,error);
		assertNotNull(loadgrpTo.getLocationId());
	}
	
	@Test
	public void getLoadGroupId() throws EFSException {
		LoadGroupParamTO loadgrpTo = new LoadGroupParamTO();
		StringBuilder error = new StringBuilder();
		loadgrpTo.setLocationId(80);
		loadgrpTo.setDestinationId(81);
		loadgrpTo.setLoadGrpName("hazmat");
		LoadGroupParamUploadDAO.getLoadGroupIdList(loadgrpTo,error);
		assertNotNull(error);
	}
	
/*	@Test
	public void getParamCodeDetails() throws EFSException {
		Map<String,Short> paramCodeMap = LaneLoadGroupDAO.getParamCodeMap();
		//assertNotNull(paramCodeMap);
	}*/
}
