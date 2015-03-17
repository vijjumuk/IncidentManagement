package com.homedepot.di.xd.efs.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.businesshelper.FrequencyManager;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.ApplicationException;
import com.homedepot.di.xd.efs.to.FrequencyTO;

@Path("/frequencies")
public class FrequencyService {

	private static final Logger LOGGER = Logger.getLogger(FrequencyService.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getFrequencies(@Context HttpServletRequest request) throws ApplicationException{
		
		try{
			List<FrequencyTO> frequenciesList = FrequencyManager.getFrequencyCodes();
			return Response.status(200).entity(new GenericEntity<List<FrequencyTO>>(frequenciesList) {}).build();
		}
		catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(500, EFSConstants.GET_ALL_FREQUENCIES_ERROR_CODE, e.getMessage(), e.getMessage());
		}
		
	}
}
