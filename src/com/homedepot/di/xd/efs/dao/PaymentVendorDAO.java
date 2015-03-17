package com.homedepot.di.xd.efs.dao;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class PaymentVendorDAO {

	private static final Logger LOGGER = Logger.getLogger(PaymentVendorDAO.class);
	
	private static final String RETRIEVE_PVENDOR_NM_SQL = 
		"SELECT DISTINCT PVNDR_NM FROM ICR_PVNDR " +
		"WHERE MBAS_PVNDR_NBR = ? ";
	
	private PaymentVendorDAO() {}
	
	/**
	 * Validate that the pvendorId exists and return pvendor name
	 * 
	 * @param pvendorId
	 * @return pvendor_nm corresponding to pvendorId from the icr_pvndr table
	 * @throws DataOperationException
	 */
	public static String validatePVendorIdAndGetName(int pvendorId) throws DataOperationException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Inside method validatePVendorIdAndGetName()");
		}
		
		try {
			String pvendorName = DAO.useJNDI(EFSConstants.EMAILER_ORACLE_JNDI_NAME_2)
				.setSQL(RETRIEVE_PVENDOR_NM_SQL, pvendorId)
				.debug(true)
				.get(String.class);
			
			if (pvendorName != null) return pvendorName.trim();
			
			return null;
				
		} catch (QueryException qe) {
			throw new DataOperationException(qe.getMessage(), qe);
		}
	}
}
