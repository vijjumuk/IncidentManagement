package com.homedepot.di.xd.efs.businesshelper;

import java.util.List;

import com.homedepot.di.xd.efs.dao.ReportDAO;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.ReportException;
import com.homedepot.di.xd.efs.to.ReportTO;

public class ReportManager {

	public static List<ReportTO> getReportCodes() throws ReportException {
		try {
			return ReportDAO.getReportCodes();
		} catch (DataOperationException e) {
			throw new ReportException(e.getMessage(), e);
		}
	}
}
