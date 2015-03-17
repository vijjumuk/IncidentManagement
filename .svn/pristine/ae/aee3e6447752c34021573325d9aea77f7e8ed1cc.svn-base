package com.homedepot.di.xd.efs.businesshelper;

import java.util.List;

import com.homedepot.di.xd.efs.dao.FrequencyDAO;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.FrequencyException;
import com.homedepot.di.xd.efs.to.FrequencyTO;

public class FrequencyManager {

	public static List<FrequencyTO> getFrequencyCodes() throws FrequencyException {
		try {
			return FrequencyDAO.getFrequencyCodes();
		} catch (DataOperationException e) {
			throw new FrequencyException(e.getMessage(), e);
		}
	}

}
