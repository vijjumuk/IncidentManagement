package com.homedepot.di.xd.efs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.RouteTO;
import com.homedepot.homer.util.HomerUnitTestCase;

public class RouteDAOTest extends HomerUnitTestCase {
	
	@Before
	public void setUp() throws Exception {
	// add additional set up code here
	}
	
	@After
	public void tearDown() throws Exception {
	// Add additional tear down code here
	}
	
	
	//TESTs OF getNextRouteIDSequence()
	@Test
	public void testGetNextSequenceRouteID() throws EFSException{
		//*****************************************************************************************************
		//This test validates that the next sequence number is valid for next ID to insert in the EFS_RTE table.
		//There are 5 rows already in the EFS_RTE table therefore the next sequence number should be 6 
		
		Assert.assertEquals(RouteDAO.getNextRouteIDSequence(),6);
		//*****************************************************************************************************
		
		//*****************************************************************************************************
		//This test validates that the nextRouteIDSequence() is succesfully in iterating.
		//Even though the another route has not been inserted, the last Assert's call to
		//getNextRouteIDSequence should have iterated to the next sequence to 7
		Assert.assertEquals(RouteDAO.getNextRouteIDSequence(),7);
		
		//*****************************************************************************************************
	}
	
	//TESTs OF checkIfRouteExists()
	@Test
	public void testCheckIfRouteExists() throws EFSException{
		//*****************************************************************************************************
		//This test validates that the following routeTO object is not similar to an existing route
		//checkIfRouteExists should return the routeID of a route given that it already exists in EFS_RTE. 
		//If the Route does not exist, the method should return 0 as there is no record of this route.
		//This test should return 0
		
		RouteTO rt = new RouteTO();
		rt.setCreatedSysUserId("lpb0001");
		rt.setLastUptdUserId("lpb0001");
		rt.setrouteConfigCd(1);
		rt.setRouteTypeCd(1);
		rt.setRouteNm("TEST ROUTE NAME");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt), 0);//testing that the return is 0
		//*****************************************************************************************************
		
		
		//*****************************************************************************************************
		//This test validates that the following routeTO object is similar to an existing route 
		//checkIfRouteExists should return the routeID of a route given that it already exists in EFS_RTE. 
		//If the Route does not exist, the method should return 0 as there is no record of this route.
		//This test should return 1
		//this test should not return 0
		
		RouteTO rt2 = new RouteTO();
		rt2.setCreatedSysUserId("lpb5559");
		rt2.setLastUptdUserId("lpb5559");
		rt2.setrouteConfigCd(1);
		rt2.setRouteTypeCd(1);
		rt2.setRouteNm("CARGILL SALT - BREAUX BRIDGE TO HOUSTON RDC");
		
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt2), 0);//Testing that the return is not 0
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt2), 1);//Testing that the return is 1
		//*****************************************************************************************************
		
	}
	
	@Test
	public void testInsertRecords() throws EFSException{
		//*****************************************************************************************************
		//This test validates the InsertRecords method. Given a list of RouteTOs, insertRecords() should populate
		//the EFS_RTE table with routes that have not already been added to the table previously. Any routes that
		//already exist should be ignored and not added.
		//This test validates that following routes are new by returning 0 for checkIfRouteExists()
		//then this test will add the recodrds using insertRecodes()
		//Finally each route will be tested using checkIfRouteExists() returning not 0 showing its existances in EFS_RTE
		//This test is dependent on passing of testCheckIfRouteExists() and testGetNextSequenceRouteID()
		List<RouteTO> badList = new ArrayList<RouteTO>();
		RouteTO rt = new RouteTO();
		rt.setCreatedSysUserId("lpb5559");
		rt.setLastUptdUserId("lpb5559");
		rt.setrouteConfigCd(2);
		rt.setRouteTypeCd(1);
		rt.setEffectiveBeginDate(new Date(1990,0,1));
		rt.setEffectiveEndDate(new Date(9999,12,30));
		rt.setRouteNm("CARGILL SALT - BREAUX BRIDGE TO HOUSTON RDC");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt), 0);
		
		RouteTO rt2 = new RouteTO();
		rt2.setCreatedSysUserId("lpb5559");
		rt2.setLastUptdUserId("lpb5559");
		rt2.setrouteConfigCd(1);
		rt2.setRouteTypeCd(2);
		rt2.setEffectiveBeginDate(new Date(1990,0,1));
		rt2.setEffectiveEndDate(new Date(9999,12,30));
		rt2.setRouteNm("CARGILL SALT - BREAUX BRIDGE TO HOUSTON RDC");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt2), 0);
		
		RouteTO rt3 = new RouteTO();
		rt3.setCreatedSysUserId("lpb5559");
		rt3.setLastUptdUserId("lpb5559");
		rt3.setrouteConfigCd(2);
		rt3.setRouteTypeCd(2);
		rt3.setEffectiveBeginDate(new Date(1990,0,1));
		rt3.setEffectiveEndDate(new Date(9999,12,30));
		rt3.setRouteNm("CARGILL SALT - BREAUX BRIDGE TO HOUSTON RDC");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt3), 0);
		
		RouteTO rt4 = new RouteTO();
		rt4.setCreatedSysUserId("lpb5559");
		rt4.setLastUptdUserId("lpb5559");
		rt4.setrouteConfigCd(1);
		rt4.setRouteTypeCd(1);
		rt4.setEffectiveBeginDate(new Date(1990,0,1));
		rt4.setEffectiveEndDate(new Date(9999,12,30));
		rt4.setRouteNm("CARGILL SALT - BREAUX BRIDGE TO HOUSTON RDC2");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt4), 0);
		
		RouteTO rt5 = new RouteTO();
		rt5.setCreatedSysUserId("abc1234");
		rt5.setLastUptdUserId("abc1234");
		rt5.setrouteConfigCd(1);
		rt5.setRouteTypeCd(2);
		rt5.setEffectiveBeginDate(new Date(1990,0,1));
		rt5.setEffectiveEndDate(new Date(9999,12,30));
		rt5.setRouteNm("FAKE ROUTE - NORTH POLE TO ATLANTIS");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt5), 0);
		
		List<RouteTO> list = new ArrayList<RouteTO>();
		list.add(rt);
		list.add(rt2);
		list.add(rt3);
		list.add(rt4);
		list.add(rt5);
		
		RouteDAO.insertRecords(list, badList);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt2), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt3), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt4), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt5), 0);
		Assert.assertEquals(RouteDAO.getNextRouteIDSequence(), 11);//Proves that there are 10 in the table as nextID is 11
		//*****************************************************************************************************

		//*****************************************************************************************************
		//This test validates the InsertRecords method. Given a list of RouteTOs, insertRecords() should populate
		//the EFS_RTE table with routes that have not already been added to the table previously. Any routes that
		//already exist should be ignored and not added.
		//This test validates that following routes are not new by returning not 0 for checkIfRouteExists()
		//then this test will add the recodrds using insertRecodes()
		//Finally each route will be tested using checkIfRouteExists() returning not 0 showing its existances in EFS_RTE
		//getNextRouteID will then expect 12 (as it was incrimented in the last step to 11)
		//This test is dependent on passing of testCheckIfRouteExists() and testGetNextSequenceRouteID()
		
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt2), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt3), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt4), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt5), 0);
		RouteDAO.insertRecords(list, badList);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt2), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt3), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt4), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt5), 0);
		Assert.assertEquals(RouteDAO.getNextRouteIDSequence(), 12);
		//*****************************************************************************************************
		
		//*****************************************************************************************************
		//This test validates the InsertRecords method. Given a list of RouteTOs, insertRecords() should populate
		//the EFS_RTE table with routes that have not already been added to the table previously. Any routes that
		//already exist should be ignored and not added.
		//This test validates that following routes are both new and by returning 0 and n for checkIfRouteExists()
		//then this test will add the recodrds using insertRecodes()
		//Finally each route will be tested using checkIfRouteExists() returning not 0 showing its existances in EFS_RTE
		//getNextRouteID will then expect 13 (as it was incrimented in the last step to 12)
		//This test is dependent on passing of testCheckIfRouteExists() and testGetNextSequenceRouteID()
		
		RouteTO rt6 = new RouteTO();
		rt6.setCreatedSysUserId("abc1234");
		rt6.setLastUptdUserId("abc1234");
		rt6.setrouteConfigCd(1);
		rt6.setRouteTypeCd(2);
		rt6.setEffectiveBeginDate(new Date(1990,0,1));
		rt6.setEffectiveEndDate(new Date(9999,12,30));
		rt6.setRouteNm("FAKE ROUTE - EARTH TO MARS");
		
		Assert.assertEquals(RouteDAO.checkIfRouteExists(rt6), 0);
		list.add(rt6);
		
		RouteDAO.insertRecords(list, badList);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt2), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt3), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt4), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt5), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt6), 0);
		Assert.assertEquals(RouteDAO.getNextRouteIDSequence(), 14);
		//*****************************************************************************************************
		
		//*****************************************************************************************************
		//This test validates the InsertRecords method. Given a list of RouteTOs, insertRecords() should populate
		//the EFS_RTE table with routes that have not already been added to the table previously. Any routes that
		//already exist should be ignored and not added.
		//This test validates that no routes get added when an empty list is sent
		//Finally each route will be tested using checkIfRouteExists() returning not 0 showing its existances in EFS_RTE
		//getNextRouteID will then expect 15 (as it was incrimented in the last step to 14)
		//This test is dependent on passing of testCheckIfRouteExists() and testGetNextSequenceRouteID()
		
		
		
		list = new ArrayList<RouteTO>();
		RouteDAO.insertRecords(list, badList);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt2), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt3), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt4), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt5), 0);
		Assert.assertNotSame(RouteDAO.checkIfRouteExists(rt6), 0);
		Assert.assertEquals(RouteDAO.getNextRouteIDSequence(), 15);
		
		
		//*****************************************************************************************************
		
	}
	
	

}
