package com.homedepot.di.xd.efs.businesshelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.to.LoadGroupParamTO;
import com.homedepot.di.xd.efs.to.ParameterTO;

/**
 */
public class LaneLoadGroupParmUploadProcessorTest {

	/**
	 * Method inValidLoadGroupName.
	 * @throws Exception
	 */
	@Test
	public void inValidLoadGroupName()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_InvalidLoadGroupName.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid Load Group Name, Should be either default/hazmat.,", errString.toString());
	}
	
	
	/**
	 * Method inValidLocationNumber.
	 * @throws Exception
	 */
	@Test
	public void inValidLocationNumber()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_InvalidLocNbr.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid Location Number,", errString.toString());
	}
	
	/**
	 * Method inValidDestination.
	 * @throws Exception
	 */
	@Test
	public void inValidDestination()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_InvalidDestination.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid Destination. ,", errString.toString());
	}
	

	/**
	 * Method inValidMaxTruckHeight.
	 * @throws Exception
	 */
	@Test
	public void inValidMaxTruckHeight()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_InvalidMaxTruckHgt.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid Max Truck Height Value,", errString.toString());
	}
	
	/**
	 * Method inValidTLCubeThreshold.
	 * @throws Exception
	 */
	@Test
	public void inValidTLCubeThreshold()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidTLCubeThreshold.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid TruckLoad Cube Threshold Value,", errString.toString());
	}

	/**
	 * Method inValidTLWeightThreshold.
	 * @throws Exception
	 */
	@Test
	public void inValidTLWeightThreshold()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidTLWeightThreshold.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid TruckLoad Weight Threshold Value,", errString.toString());
	}
	
	/**
	 * Method inValidDirRounding.
	 * @throws Exception
	 */
	@Test
	public void inValidDirRounding()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidDirRounding.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid Directional Rounding Threshold Value,", errString.toString());
	}
	
	/**
	 * Method inValidThresholdIncrement.
	 * @throws Exception
	 */
	@Test
	public void inValidThresholdIncrement()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidThresholdIncrement.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid Threshold Increment Value,", errString.toString());
	}

	/**
	 * Method inValidFullTlThreshold.
	 * @throws Exception
	 */
	@Test
	public void inValidFullTlThreshold()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidFullTlThreshold.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid Full TruckLoad Threshold Value,", errString.toString());
	}
	
	/**
	 * Method inValidLoadConfig.
	 * @throws Exception
	 */
	@Test
	public void inValidLoadConfig()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidLoadConfig.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid Load Configuarator Value,", errString.toString());
	}

	/**
	 * Method inValidSmoothingInterval.
	 * @throws Exception
	 */
	@Test
	public void inValidSmoothingInterval()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidSmoothingInterval.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadMandatoryGroupParms(row, lgParmToList, errString);
		Assert.assertEquals("Invalid Smoothing Interval Value,", errString.toString());
	}
	
	/**
	 * Method inValidTLDailyMin.
	 * @throws Exception
	 */
	@Test
	public void inValidTLDailyMin()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidTLDailyMin.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid TruckLoad Daily Min Value,", errString.toString());
	}
	
	/**
	 * Method inValidTLDailyMax.
	 * @throws Exception
	 */
	@Test
	public void inValidTLDailyMax()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidTLDailyMax.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid TruckLoad Daily Max Value,", errString.toString());
	}
	
	/**
	 * Method inValidEffBeginDt.
	 * @throws Exception
	 */
	@Test
	public void inValidEffBeginDt()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidEffBeginDt.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid Effective Begin Date,", errString.toString());
	}
	
	
	/**
	 * Method inValidEffEndDt.
	 * @throws Exception
	 */
	@Test
	public void inValidEffEndDt()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidEffEndDt.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Invalid Effective End Date,", errString.toString());
	}
	
	/**
	 * Method inValidEffBeginGreaterThanEffEndDate.
	 * @throws Exception
	 */
	@Test
	public void inValidEffBeginGreaterThanEffEndDate()throws Exception {
		LaneLoadGroupParmUploadProcessor loadGroupProcessor = new LaneLoadGroupParmUploadProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		LoadGroupParamTO loadGroupTo = new LoadGroupParamTO();
		List<ParameterTO> lgParmToList = new ArrayList<ParameterTO>();
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/LG_Parm_inValidEffDates.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		loadGroupProcessor.validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
		Assert.assertEquals("Effective begin Date greater than Effective End date,", errString.toString());
	}
	
}
