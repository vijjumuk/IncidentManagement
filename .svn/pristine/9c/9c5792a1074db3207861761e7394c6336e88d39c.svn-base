package com.homedepot.di.xd.efs.businesshelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.ParameterTO;
import com.homedepot.di.xd.efs.to.VendorGroupParamTO;

/**
 */
public class VendorGroupParamUploadProcessorTest {

	/**
	 * Method testVendorGroupParamProcessorInvalidVendor.
	 * @throws IOException
	 * @throws EFSException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidVendor() throws IOException, EFSException {
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_Vendor.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		vendorParamProcessor.validateVendorDetails(row,errString,vendorParamTO,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	/**
	 * Method testVendorGroupParamProcessorInvalidOrigin.
	 * @throws IOException
	 * @throws EFSException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidOrigin() throws IOException, EFSException {
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_Origin.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		vendorParamProcessor.validateVendorDetails(row,errString,vendorParamTO,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	/**
	 * Method testVendorGroupParamProcessorInvalidDestionation.
	 * @throws IOException
	 * @throws EFSException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidDestionation() throws IOException, EFSException {
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_Destination.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		vendorParamProcessor.validateVendorDetails(row,errString,vendorParamTO,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	
	/**
	 * Method testVendorGroupParamProcessorInvalidDefaultFlag.
	 * @throws IOException
	 * @throws EFSException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidDefaultFlag() throws IOException, EFSException {
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_DefaultFlag.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		vendorParamProcessor.validateVendorDetails(row,errString,vendorParamTO,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	
	/**
	 * Method testVendorGroupParamProcessorInvalidMaxPullFwdDays.
	 * @throws IOException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidMaxPullFwdDays() throws IOException {
		
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_MaxPullFwdDays.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		vendorParamProcessor.validateVendorParameterDetails(row,errString,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	/**
	 * Method testVendorGroupParamProcessorInvalidTLRoundUp.
	 * @throws IOException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidTLRoundUp() throws IOException {
		
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_TLRoundUp.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		vendorParamProcessor.validateVendorParameterDetails(row,errString,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	/**
	 * Method testVendorGroupParamProcessorInvalidTLRoundDown.
	 * @throws IOException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidTLRoundDown() throws IOException{
		
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_TLRoundDown.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		vendorParamProcessor.validateVendorParameterDetails(row,errString,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	
	/**
	 * Method testVendorGroupParamProcessorInvalidOUTLThreshold.
	 * @throws IOException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidOUTLThreshold() throws IOException {
		
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_OUTLThreshold.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		vendorParamProcessor.validateVendorParameterDetails(row,errString,vendorParmToList);
		Assert.assertTrue(errString.toString().length() > 0);
	}
	
	/**
	 * Method testVendorGroupParamProcessorInvalidEffectiveBeginDate.
	 * @throws IOException
	 * @throws EFSException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidEffectiveBeginDate() throws IOException, EFSException {
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_EffectiveBeginDate.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		vendorParamProcessor.validateVendorDetails(row,errString,vendorParamTO,vendorParmToList);
		Assert.assertNotNull(errString);
	}
	
	/**
	 * Method testVendorGroupParamProcessorInvalidEffectiveEndDate.
	 * @throws IOException
	 * @throws EFSException
	 */
	@Test
	public void testVendorGroupParamProcessorInvalidEffectiveEndDate() throws IOException, EFSException{
		List<ParameterTO> vendorParmToList = new ArrayList<ParameterTO>();
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_EffectiveEndDate.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		vendorParamProcessor.validateVendorDetails(row,errString,vendorParamTO,vendorParmToList);
		Assert.assertNotNull(errString);
	}
	
	/*@Test 
	public void testDataBaseValidation() throws IOException, EFSException{
		VendorGroupUploadParamProcessor vendorParamProcessor = new VendorGroupUploadParamProcessor();
		List<VendorGroupParamTO> validVendorParmToList = new ArrayList<VendorGroupParamTO>();
		List<VendorGroupParamTO> invalidVendorParmToList = new ArrayList<VendorGroupParamTO>();
		VendorGroupParamTO vendorParamTO = new VendorGroupParamTO();
		StringBuilder errString = new StringBuilder();
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Vndr_Parm_InValid_EffectiveEndDate.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		vendorParamProcessor.performDataBaseValidation(vendorParamTO, validVendorParmToList,invalidVendorParmToList,errString);
	}*/
	
}
