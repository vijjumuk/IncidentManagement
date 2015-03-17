package com.homedepot.di.xd.efs.businesshelper;

import java.util.List;

import com.homedepot.di.xd.efs.dao.PaymentVendorDAO;
import com.homedepot.di.xd.efs.dao.ReportTypeDAO;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.ReportTypeException;
import com.homedepot.di.xd.efs.to.EmailInfoTO;
import com.homedepot.di.xd.efs.to.ReportEmailTO;
import com.homedepot.di.xd.efs.to.ReportTypeTO;
import com.homedepot.di.xd.efs.to.ReportTypeCodes;

public class ReportTypeManager{
	
	
	/** 
	 * Get a list of the report type codes from the database
	 * 
	 * @return List of Report Type Code table objects
	 * @throws ReportTypeException - invalid report type
	 */
	public static List<ReportTypeTO> getReportTypeCodes() throws ReportTypeException{
		try {
			return ReportTypeDAO.getReportTypeCodes();
		} catch (DataOperationException e) {
			throw new ReportTypeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Get the email info for given pvendorId/carrierCd. This includes a display name and a list of email subscribers
	 * 
	 * @param reportTypeCode
	 * @param pvendorId
	 * @param carrierCd
	 * @return EmailInfoTO - display name and list of email subscribers
	 * @throws DataOperationException
	 */
	public static EmailInfoTO getEmailInfo(short reportTypeCode, int pvendorId, String carrierCd) throws DataOperationException {
		
		if (ReportTypeCodes.PAYMENT_VENDOR_REPORT_TYPE_CODE.getReportTypeCode() == reportTypeCode) { // PVendor
			String pvendorName = PaymentVendorDAO.validatePVendorIdAndGetName(pvendorId);
			if (pvendorName == null) return new EmailInfoTO();
			
			List<ReportEmailTO> reportEmails = ReportTypeDAO.getReportEmailsForPVendor(pvendorId);
			return new EmailInfoTO(pvendorName, reportEmails);
		}
		
		return null;
	}
}
