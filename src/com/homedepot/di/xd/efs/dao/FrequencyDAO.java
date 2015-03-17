package com.homedepot.di.xd.efs.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.to.FrequencyTO;
import com.homedepot.ta.aa.dao.Inputs;
import com.homedepot.ta.aa.dao.Query;
import com.homedepot.ta.aa.dao.Results;
import com.homedepot.ta.aa.dao.ResultsReader;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.exceptions.PropertyNotFoundException;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class FrequencyDAO {
	
	private static final Logger LOGGER = Logger.getLogger(FrequencyDAO.class);
	public static final String US_LANG_CODE = "en_US";
	
	private static final String RETRIEVE_ALL_FREQUENCIES_SQL = 
			"SELECT A.SCHN_COLLAB_RPT_FREQ_CD, B.FREQ_DESC " +
			"FROM SCHN_COLLAB_RPT_FREQ_CD A, N_SCHN_COLLAB_RPT_FREQ B " +
			"WHERE A.SCHN_COLLAB_RPT_FREQ_CD = B.SCHN_COLLAB_RPT_FREQ_CD " +
			"AND B.LANG_CD = ?";
	
	private FrequencyDAO() {}
	
	/**
	 * This method will return all of the frequencies
	 * 
	 * @return a list of FrequencyTO objects
	 * @throws DataOperationException
	 */
	public static List<FrequencyTO> getFrequencyCodes() throws DataOperationException {
		
		final List<FrequencyTO> frequenciesList = new ArrayList<FrequencyTO>();
	
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("In the method getFrequencies()");
		}
		
		try {
			DAO.useJNDI(EFSConstants.EMAILER_ORACLE_JNDI_NAME).
					setSQL(RETRIEVE_ALL_FREQUENCIES_SQL, US_LANG_CODE).
					results( new ResultsReader() {
						
						@Override
						public void readResults(Results results, Query query, Inputs inputs)
														throws QueryException {
							while(results.next()){
								frequenciesList.add(createFrequencyFromResult(results));
							}
						}
					});
			
		} catch (QueryException qe) {
			throw new DataOperationException(qe.getMessage(), qe);
		}
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Finished getFrequencies and retrieved " + frequenciesList.size() + " frequencies.");
		}
		return frequenciesList;
	}
	
	private static FrequencyTO createFrequencyFromResult(Results results) throws PropertyNotFoundException {
		FrequencyTO frequencyTO = new FrequencyTO();
		
		frequencyTO.setFreqCode(results.getInt("SCHN_COLLAB_RPT_FREQ_CD"));
		frequencyTO.setDescription(results.getString("FREQ_DESC"));
		
		return frequencyTO;
	}

}
