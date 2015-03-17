package com.homedepot.di.xd.efs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.LocationTO;
import com.homedepot.homer.util.HomerUnitTestCase;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

/**
 */
public class LocationUploadDAOTest extends HomerUnitTestCase {

	public static final Short RDC_LOC_TYPE_CODE = 13;
	static int locId = 20;
	
	/**
	 * Method insertLocationDetailsWithNull input.
	 * @throws QueryException
	 * @throws EFSException
	 */
	@Test
	public void insertLocationDetailsWithNull() throws QueryException,
			DataOperationException {
		Assert.assertFalse(LocationDAO.insertLocationDetails(null));
	}

	/**
	 * Method insertLocationDetailsWithEmptyList.
	 * @throws QueryException
	 * @throws EFSException
	 */
	@Test
	public void insertLocationDetailsWithEmptyList() throws QueryException,
			DataOperationException {
		List<LocationTO> locationList = new ArrayList<LocationTO>();
		Assert.assertFalse(LocationDAO
				.insertLocationDetails(locationList));
	}

	
	
	/**
	 * Method insertEmptyListForReferenceTable.
	 * @throws QueryException
	 */
	@Test
	public void insertEmptyListForReferenceTable() throws QueryException {
		List<LocationTO> locationList = new ArrayList<LocationTO>();
		Assert.assertFalse(LocationDAO
				.insertLocationReferenceDetails(locationList));
	}

	/**
	 * Method insertDetailsIntoReferenceTableWithNull.
	 * @throws QueryException
	 */
	@Test
	public void insertDetailsIntoReferenceTableWithNull() throws QueryException {
		Assert.assertFalse(LocationDAO
				.insertLocationReferenceDetails(null));
	}

	/**
	 * Method insertDetailsIntoReferenceTable.
	 * @throws QueryException
	 */
	@Test
	public void insertDetailsIntoReferenceTable() throws QueryException {
		
		List<LocationTO> locationList = new ArrayList<LocationTO>();
		LocationTO locTO = new LocationTO();
		locId++;
		locTO.setLocationId(locId);
		locTO.setCreateUserId("QAT005");
		locTO.setLastUpdatedUserId("QAT005");
		locTO.setSourceLocationNbr("459898PA001");
		locationList.add(locTO);
		da.table("SCHN_EFS_LOC_XREF").where("SCHN_LOC_ID =" +locId);
		da.assert_count(0);
		Assert.assertTrue(LocationDAO
				.insertLocationReferenceDetails(locationList));
		
		da.table("SCHN_EFS_LOC_XREF").where("SCHN_LOC_ID = " +locId);
		da.assert_count(1);
	}
	
	/**
	 * Method getLocationDetailsForUpdateTest.
	 * @throws EFSException
	 */
	@Test
	public void getLocationDetailsForUpdateTest() throws DataOperationException{
		Map<String, Integer> locationAndXrefDetailsMap = LocationDAO.readLocationDetailsForUpdate();
		Assert.assertNotNull(locationAndXrefDetailsMap);
	}
	
	/**
	 * Method updateLocationDetailsTest.
	 * @throws EFSException
	 */
	@Test
	public void updateLocationDetailsTest() throws DataOperationException {
		
		List<LocationTO> locationList = new ArrayList<LocationTO>();
		LocationTO locTO = new LocationTO();
		locId++;
		locTO.setLocationId(80);
		locTO.setCreateUserId("QAT005");
		locTO.setLastUpdatedUserId("QAT005");
//		locTO.setAddressLine1(null);
//		locTO.setAddressLine2(null);
//		locTO.setAddressLine3(null);
//		locTO.setAddressLine4(null);
//		locTO.setAddressLine5(null);
		locTO.setAddressLine1("Add1");
		locTO.setAddressLine2("Add2");
		locTO.setAddressLine3("Add3");
		locTO.setAddressLine4("Add4");
		locTO.setAddressLine5("Add5");
		locTO.setStateCode("OK");
		locTO.setPostalCode("70517");
		locTO.setCityName("FREEDOM");
		locTO.setCountryCode("US");
		locTO.setLatitude("15.2346");
		locTO.setLongitude("75.1234");
		locTO.setLocationTypeCd((short)2);
		locTO.setLocationName("HOUSTON");
		locTO.setActiveFlg("Y");
		locationList.add(locTO);
		da.table("SCHN_EFS_LOC").where("SCHN_LOC_ID =" +80);
		da.assert_count(1);
		Assert.assertTrue(LocationDAO
				.updateLocationDetails(locationList));
		
		da.table("SCHN_EFS_LOC").where("SCHN_LOC_ID = " +80);
		da.assert_count(1);
	}
	
	//Test that you can get all locations by location name
	/*@Test
	public void testGetAllLocationsByLocationName_Success() throws DataOperationException{
		
		List<LocationTO> locationList = LocationUploadDAO.getLocationsByWildcard("ma", null);
		Assert.assertNotNull(locationList);
		Assert.assertTrue(!locationList.isEmpty());
		Assert.assertEquals(5, locationList.size());
	}*/
	
	//Test that you can get all locations by location number
	/*@Test
	public void testGetAllLocationsByLocationNumber_Success() throws DataOperationException{
		List<LocationTO> locationList = LocationUploadDAO.getLocationsByWildcard("50", null);
		Assert.assertNotNull(locationList);
		Assert.assertTrue(!locationList.isEmpty());
		Assert.assertEquals(2, locationList.size());
	}*/
	
	//Test that you can get all locations by location Id
	/*@Test
	public void testGetAllLocationsByLocationId_Success() throws DataOperationException{
		List<LocationTO> locationList = LocationUploadDAO.getLocationsByWildcard("8", null);
		Assert.assertNotNull(locationList);
		Assert.assertTrue(!locationList.isEmpty());
		Assert.assertEquals(9, locationList.size());
	}*/
	
	//Test that you can get all locations filtered by locationTypeCode
	/*@Test
	public void testGetFilteredLocations_Success() throws DataOperationException{
		List<LocationTO> locationList = LocationUploadDAO.getLocationsByWildcard("8", RDC_LOC_TYPE_CODE);
		Assert.assertNotNull(locationList);
		Assert.assertTrue(!locationList.isEmpty());
		Assert.assertEquals(1, locationList.size());
	}*/
}
