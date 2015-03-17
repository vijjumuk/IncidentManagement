package com.homedepot.di.xd.efs.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.businesshelper.ReportTypeManager;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.ApplicationException;
import com.homedepot.di.xd.efs.to.EmailInfoTO;
import com.homedepot.di.xd.efs.to.ReportTypeTO;


@Path("/reportTypes")
public class ReportTypeService {

	private static final Logger LOGGER = Logger.getLogger(ReportTypeService.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getReportTypes(@Context HttpServletRequest request) throws ApplicationException{
		
		try{
			List<ReportTypeTO> reportTypesList = ReportTypeManager.getReportTypeCodes();
			return Response.status(200).entity(new GenericEntity<List<ReportTypeTO>>(reportTypesList) {}).build();
		}
		catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(500, EFSConstants.GET_ALL_REPORT_TYPES_ERROR_CODE, e.getMessage(), e.getMessage());
		}	
	}
	
	
	@GET
	@Path("/{reportTypeCode}/getEmailInfo")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	public Response getEmailInfo(@PathParam("reportTypeCode") short reportTypeCode,
			@QueryParam("pvendorId") int pvendorId,
			@QueryParam("carrierCd") String carrierCd,
			@Context HttpServletRequest request) {
		
		try {
			EmailInfoTO emailInfo = ReportTypeManager.getEmailInfo(reportTypeCode, pvendorId, carrierCd);
			return Response.status(200).entity(emailInfo).build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return Response.status(500).build();
		}
	}
	
}
