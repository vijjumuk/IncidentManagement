package com.homedepot.di.xd.efs.businesshelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.to.ScheduleOrderDayTO;
import com.homedepot.di.xd.efs.to.ScheduleTO;
import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;


/**
 * The class <code>ScheduleUploadProcessorTest</code> contains tests for the
 * class {@link <code>ScheduleUploadProcessor</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 3/6/15 4:56 PM
 *
 * @author 565581
 *
 * @version $Revision$
 */
public class ScheduleUploadProcessorTest {

	
	/**
	 * Test case when there is no header fields in the uploaded csv.
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateHeaderFieldsForSchedule() throws IOException, Exception
	{

		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_NoHeader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);

		int val=schedulePro.validateHeader(uploadedHeader);
		Assert.assertEquals(1,val);

	}
	
	/**
	 * Test case when  valid header fields are present in the uploaded csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateHeaderFieldsForScheduleForvalidheaders() throws IOException, Exception
	{

		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_ValidHeader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);

		int val=schedulePro.validateHeader(uploadedHeader);
		Assert.assertEquals(0,val);

	}
	
	
	/**
	 * Test case when  invalid header fields are present in the uploaded csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateHeaderFieldsForScheduleForInvalidheaders() throws IOException, Exception
	{

		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_InvalidHeader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);

		int val=schedulePro.validateHeader(uploadedHeader);
		Assert.assertEquals(-1,val);

	}
	
	/**
	 * Test case when  invalid origin is present in the csv
	 * @throws IOException
	 * @throws Exception
	 */

	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void validateOrigin() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_InvalidOrigin.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);
		
		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
	//	Assert.assertEquals(UploadConstants.INVALID_ORIGIN,responseTo.getErrorMsg());

	}
	
	/**
	 * Test case when origin field is empty in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void validateEmptyOrigin() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_EmptyOrigin.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);

		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
	//	Assert.assertEquals(UploadConstants.INVALID_ORIGIN,responseTo.getErrorMsg());
	}
	
	/**
	 * Test case to validate Destination field in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void validateDestination() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_InvalidDC.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);

		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
		//Assert.assertEquals(UploadConstants.INVALID_DESTINATION,responseTo.getErrorMsg());
	}
	
	/**
	 * Test case to validate Schedule Type Code field in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(expected = com.homedepot.di.xd.efs.upload.FileParserException.class)
	public void validateScheduleTypeCd() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_SchTypCd.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);

		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
		//Assert.assertEquals(UploadConstants.INVALID_SCHEDULE_TYP_CD,responseTo.getErrorMsg());
	}
	
	/**
	 * Test case to validate Schedule Group Code field in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(expected = com.homedepot.di.xd.efs.upload.FileParserException.class)
	public void validateScheduleGrpCd() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_SchGrpCd.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);

		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
		//Assert.assertEquals(UploadConstants.INVALID_SCHEDULE_GRP_CD,responseTo.getErrorMsg());
	}
	
	/**
	 * Test case to validate Eff begin date field in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void validateEffectiveBeginDate() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_EffBgnDt.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);

		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
		//Assert.assertEquals(UploadConstants.INVALID_EFF_BGN_DT,responseTo.getErrorMsg());
	}

	
	/**
	 * Test case to validate Eff End date field in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void validateEffectiveEndDate() throws IOException, Exception
	{

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_EffEndDt.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		ScheduleUploadProcessor.processValidHeaderDataForSchedule(fileObj, responseTo);

		//TODO: Need to uncomment once ResponseTO is set with proper error message
		Assert.assertNotNull(responseTo);
		//Assert.assertEquals(UploadConstants.INVALID_EFF_END_DT,responseTo.getErrorMsg());
	}
	
	/**
	 * Run the void populateScheduleTO(ScheduleTO,Object[],StringBuilder,InputFileTO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/9/15 5:52 PM
	 */
	@Test
	public void testPopulateScheduleTO()
		throws Exception {
	
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_SchduleTO.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);
		
		StringBuilder errString = new StringBuilder();
		
		Map<Integer, Object[]> fileContents = fileObj.getFileContents();

		Map<String, String> locationLastWorkDayCode = new HashMap<>();
		
		Object[] row = fileContents.get(1);
		ScheduleTO scheduleTo = new ScheduleTO();
		scheduleTo.setOriginNumber(row[0].toString());

		ScheduleUploadProcessor.populateScheduleTO(scheduleTo, row, errString, fileObj, locationLastWorkDayCode);
		Assert.assertNotNull(scheduleTo);

	}
	
	/**
	 * Run the void populateScheduleOrderDayTO(ScheduleOrderDayTO,Object[] Short,StringBuilder,InputFileTO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/9/15 5:52 PM
	 */
	@Test
	public void testPopulateScheduleOrderDayTO()
		throws Exception {
	
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_SchduleTO.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);
		
		StringBuilder errString = new StringBuilder();
		
		Map<Integer, Object[]> fileContents = fileObj.getFileContents();
		
		Map<String, String> locationLastWorkDayCode = new HashMap<>();
		Object[] row = fileContents.get(1);
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short orderDay = 1;
		

		ScheduleUploadProcessor.populateScheduleOrderDayTO(orderDayTO, row, orderDay,errString, fileObj, locationLastWorkDayCode);
		Assert.assertNotNull(orderDayTO);

	}
	
	
	
	
}
