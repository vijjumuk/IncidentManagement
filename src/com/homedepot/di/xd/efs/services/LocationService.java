package com.homedepot.di.xd.efs.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.businesshelper.LocationProcessor;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.ApplicationException;
import com.homedepot.di.xd.efs.to.LocationTO;


@Path("/location")
public class LocationService {

	private static final Logger LOGGER = Logger.getLogger(LocationService.class);
	
	/**
	 * This method gets all locations with an option filter on location type.
	 * @param locationType - the location type.
	 * @param request - a handle to the Servlet Request if needed.
	 * @return - a list of Location TOs.
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getLocations(@QueryParam("query") String query,
								 @QueryParam("locationType") Short locationTypeCode,
								 @Context HttpServletRequest request){
		
		try{
			List<LocationTO> locationList = 
					LocationProcessor.getLocationsByWildcard(query, locationTypeCode);
			return Response.status(200).entity(new GenericEntity<List<LocationTO>>(locationList) {}).build();
		}
		catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(500, EFSConstants.GET_ALL_LOCATIONS_BY_WILDCARD_ERROR_CODE, e.getMessage(), e.getMessage());
		}
	}
}
