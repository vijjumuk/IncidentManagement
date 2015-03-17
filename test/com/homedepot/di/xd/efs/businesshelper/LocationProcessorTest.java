package com.homedepot.di.xd.efs.businesshelper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.LocationTO;
import com.homedepot.homer.util.HomerUnitTestCase;

public class LocationProcessorTest extends HomerUnitTestCase {

	//Test that you can get all locations by location name
	@Test
	public void testGetAllLocationsByLocationName_Success() throws EFSException{
		
		List<LocationTO> locationList = LocationProcessor.getLocationsByWildcard("ma", null);
		Assert.assertNotNull(locationList);
		Assert.assertTrue(!locationList.isEmpty());
		Assert.assertEquals(5, locationList.size());
	}
}
