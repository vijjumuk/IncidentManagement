package com.homedepot.di.xd.efs.businesshelper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.dao.LoadGroupParamUploadDAO;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.LoadGroupParamTO;
import com.homedepot.di.xd.efs.to.ParameterTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.util.EFSUtil;
import com.homedepot.di.xd.efs.util.ValidationUtil;

/**
 */
public class LaneLoadGroupParmUploadProcessor implements IUploadProcessor {

	private static final Logger LOGGER = Logger
			.getLogger(LaneLoadGroupParmUploadProcessor.class);

	/**
	 * Method processFile.
	 * @param fileObj InputFileTO
	 * @param responseTO ResponseTO
	 * @throws IOException
	 * @throws EFSException
	 * @see com.homedepot.di.xd.efs.businesshelper.IUploadProcessor#processFile(InputFileTO, ResponseTO)
	 */
	@Override
	public void processFile(InputFileTO fileObj, ResponseTO responseTO)
			throws IOException, EFSException {

		processDataForLaneLoadGroupParm(fileObj, responseTO);

	}

	/**
	 * Method processDataForLaneLoadGroupParm.
	 * @param fileObj InputFileTO
	 * @param responseTO ResponseTO
	 * @throws EFSException
	 */
	public void processDataForLaneLoadGroupParm(InputFileTO fileObj,
			ResponseTO responseTO) throws EFSException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "processDataForLaneLoadGroupParm");
		}

		// List to store valid load group data
		List<LoadGroupParamTO> validLoadGroupList = new ArrayList<LoadGroupParamTO>();
		
		// List to store invalid load group parm data.
		List<LoadGroupParamTO> inValidLoadGroupList = new ArrayList<LoadGroupParamTO>();

		LoadGroupParamTO loadGroupTo = null;
		
		List<ParameterTO> lgParmToList = null;

		StringBuilder key = new StringBuilder();
		
		// to store error String.
		StringBuilder errString = null;

		// Map to find duplicate records.
		Map<String, LoadGroupParamTO> uniqueLoadGroupDetailsMap = new HashMap<String, LoadGroupParamTO>();
		
		// List to store update load group data
		List<LoadGroupParamTO> updateLoadGroupList = new ArrayList<LoadGroupParamTO>();
		
		int rowNumber = 1;
		
		// to store error messages.
		errString = new StringBuilder();

		// List to set the param code details
		lgParmToList = new ArrayList<ParameterTO>();

		Map<Integer, Object[]> fileContents = null;

		try {
			//Read the file content
			fileContents = fileObj.getFileContents();
			
			// Read each record in the file and validate
			for (Map.Entry<Integer, Object[]> entry : fileContents.entrySet()) {
				
				if(entry.getKey() == 0){
					continue;
				}
				
				loadGroupTo = new LoadGroupParamTO();
				
				//String[] row = java.util.Arrays.copyOf(entry.getValue(), entry.getValue().length, String[].class);
				Object[] row = entry.getValue();
				
				rowNumber++;

				// Set row number
				loadGroupTo.setRowNumber(rowNumber);

				// If more columns are present with data than required.
				if (row.length != UploadConstants.getLoadGroupParameters().length) {
					errString.append(UploadConstants.MORE_COLUMNS);
					continue;
				}

				// Validate input file inputs
				validateLoadGroupParmDetails(row, loadGroupTo, lgParmToList, errString);
				
				// check for duplicate rows - if multiple rows with same
				// location Number - Destination - load Group Name 
				if (EFSUtil.isEmpty(errString.toString())) {
					
					String beginDate;
					String endDate;
					key = key.append(row[UploadConstants.FIRST].toString()).append('-')
							.append(row[UploadConstants.SECOND].toString()).append('-')
							.append(row[UploadConstants.THIRD].toString());

						if (uniqueLoadGroupDetailsMap.containsKey(key.toString())
								&& key.toString() != null) {
							
							beginDate = uniqueLoadGroupDetailsMap
							.get(key.toString())
							.getEffectiveBeginDate();
							endDate = uniqueLoadGroupDetailsMap
									.get(key.toString())
									.getEffectiveEndDate();

							// same effective begin dates
							if (compareDates(
									loadGroupTo.getEffectiveBeginDate(),
									beginDate) == 0
									|| compareDates(
											loadGroupTo.getEffectiveEndDate(),
											endDate) == 0) {
								errString
										.append(UploadConstants.INVALID_EFFECTIVE_BEGIN_END_DATE_VALUE);

							}

							key = key.append('-').append(row[UploadConstants.FOURTEEN])
									.append('-')
									.append(row[UploadConstants.FIFTEEN]);

							if (uniqueLoadGroupDetailsMap.containsKey(key
									.toString())) {

								errString.append(UploadConstants.DUPLICATE_RECORD);
								errString.append(",");
							}
						}
						
						if(EFSUtil.isEmpty(errString.toString())){
							
							uniqueLoadGroupDetailsMap.put(key.toString(), loadGroupTo);
						}else{
							
							inValidLoadGroupList.add(loadGroupTo);
						}
						key.setLength(0);
						
						if (uniqueLoadGroupDetailsMap != null && uniqueLoadGroupDetailsMap.size() > 0) {
							// perform Datebase validation for the each record
							performDataBaseValidation(loadGroupTo,
									validLoadGroupList, updateLoadGroupList,
									inValidLoadGroupList, errString);
						}
						
					} else {
						inValidLoadGroupList.add(loadGroupTo);
					}

				} 
			if (!EFSUtil.isEmpty(validLoadGroupList)){
				
				LoadGroupParamUploadDAO.createLaneLoadGroupParams(validLoadGroupList,fileObj.getUserId());
			}
			
			
			if (!EFSUtil.isEmpty(updateLoadGroupList)) {
				LoadGroupParamUploadDAO.updateLoadGroupParamList(updateLoadGroupList, fileObj.getUserId());
			}
			
			responseTO.setReturnMessage(validLoadGroupList.size()+ "/" + (rowNumber-1) + " successful records uploaded.");
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Invalid Location Details List : "
						+ inValidLoadGroupList.size());
				LOGGER.debug("Failed Records " + errString + "\n " + inValidLoadGroupList.toString());
				LOGGER.debug(UploadConstants.EXIT_METHOD
						+ "processDataForLaneLoadGroupParm");
			}

		} catch (EFSException efs) {
			throw new EFSException(UploadConstants.EXCEPTION, efs);
		}
	}
	
	private int compareDates(String  beginDate, String endDate) throws EFSException{
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "compareDates");
		}
		return ValidationUtil.convertStringToDate(beginDate).compareTo(
				ValidationUtil.convertStringToDate(endDate));
			
	}

	/**
	 * Method will validate key fields with DB and add record into valid list
	 * key fields = Location number - Destination - Load group name 
	 * @param loadGroupTo
	 * @param validLoadGroupList
	 * @param inValidLoadGroupList
	 * @param errString
	
	 * @param updateLoadGroupList List<LoadGroupParamTO>
	 * @throws EFSException */
	private void performDataBaseValidation(LoadGroupParamTO loadGroupTo,
			List<LoadGroupParamTO> validLoadGroupList,
			List<LoadGroupParamTO> updateLoadGroupList,
			List<LoadGroupParamTO> inValidLoadGroupList, StringBuilder errString)
			throws EFSException {
		List<ParameterTO> insertLoadGroupParamList = new ArrayList<ParameterTO>();
		List<ParameterTO> updateLoadGroupParamList = new ArrayList<ParameterTO>();
		
		setEffBeginAndEndDates(loadGroupTo);
		
		LoadGroupParamTO updateLoadGroupTo = null;
		// Validate Origin/Destination in Location table & fetch the location Id
		LoadGroupParamUploadDAO.getActiveLocationIdList(loadGroupTo, errString);
		if (EFSUtil.isEmpty(errString.toString())) {
			
			// Check load group Id is exists or not for the load group name & lane Id
			LoadGroupParamUploadDAO.getLoadGroupIdList(loadGroupTo, errString);
			
			if (EFSUtil.isEmpty(errString.toString())) {
				
				LoadGroupParamUploadDAO.getUpdateLoadParamList(loadGroupTo,
						updateLoadGroupParamList, insertLoadGroupParamList);
				// Insert new parameters 
				if (!loadGroupTo.isUpdate()) {
					validLoadGroupList.add(loadGroupTo);
				} 
				// Existing records with different Effective Begin Date / Effective End Date
				if (insertLoadGroupParamList.size() > 0) {
					loadGroupTo.setLoadParamList(insertLoadGroupParamList);
					validLoadGroupList.add(loadGroupTo);
				}
				
				// Existing Records with different Value 
				if (updateLoadGroupParamList.size() > 0) {
					updateLoadGroupTo = new LoadGroupParamTO();
					updateLoadGroupTo.setLoadGrpId(loadGroupTo.getLoadGrpId());  ;
					updateLoadGroupTo
							.setLoadParamList(updateLoadGroupParamList);
					updateLoadGroupList.add(updateLoadGroupTo);
				}
				
			} else {
				
				inValidLoadGroupList.add(loadGroupTo);
			}
		} else {

			inValidLoadGroupList.add(loadGroupTo);

		}

	}
	
	/**
	 * Method setEffBeginAndEndDates.
	 * @param loadGrpTo LoadGroupParamTO
	 * @return List<ParameterTO>
	 * @throws EFSException
	 */
	private static List<ParameterTO> setEffBeginAndEndDates(LoadGroupParamTO loadGrpTo) throws EFSException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "setEffBeginAndEndDates");
		}
		
		List<ParameterTO> paramCodeList = new ArrayList<ParameterTO>();
		for (ParameterTO loadGroupParamTo : loadGrpTo.getLoadParamList()) {
			
			loadGroupParamTo.setEffBeginDate(ValidationUtil.convertStringToDate(loadGrpTo.getEffectiveBeginDate()));
			loadGroupParamTo.setEffEndDate(ValidationUtil.convertStringToDate(loadGrpTo.getEffectiveEndDate()));
			paramCodeList.add(loadGroupParamTo);
		}
		
		return paramCodeList;
		
	}
	
	/**
	 * Method will validate each record input values 
	 * @param row
	 * @param loadGroupTo
	 * @param lgParmToList
	
	 * @param errString
	
	 * @throws EFSException */
	public void validateLoadGroupParmDetails(Object[] row,
			LoadGroupParamTO loadGroupTo, List<ParameterTO> lgParmToList, StringBuilder errString) throws EFSException {

		
		boolean isValidDate = true;
		// Origin Validation
		loadGroupTo.setLocationNbr(row[UploadConstants.FIRST].toString().trim());
		if (!(ValidationUtil.isOriginValid(loadGroupTo.getLocationNbr()))) {

			errString.append(UploadConstants.INVALID_LOCATION);
			errString.append(',');
		}

		// Destination Validation
		loadGroupTo.setDestinationNbr((row[UploadConstants.SECOND].toString().trim()));
		if (!(ValidationUtil
				.isDestinationValid(loadGroupTo.getDestinationNbr()))) {

			errString.append(UploadConstants.INVALID_DESTINATION);
			errString.append(',');
		}
		
		// Load group name validation.
		if(EFSUtil.isEmpty(row[UploadConstants.THIRD].toString().trim())){
			
			loadGroupTo.setLoadGrpName(UploadConstants.DEFAULT);
		}
		else if (!(ValidationUtil.isLoadGroupNameValid(row[UploadConstants.THIRD].toString().trim()))) {

			errString.append(UploadConstants.INVALID_LOAD_GROUP_NAME);
			errString.append(',');
		}else{
			
			loadGroupTo.setLoadGrpName(row[UploadConstants.THIRD].toString().trim());
		}
		
		// validate Mandatory Load Parameters   
		validateLoadMandatoryGroupParms(row,lgParmToList, errString);
		
		// Validate optional Load Parameters , set default values for empty field
		validateOptionalLoadGroupParms(row, lgParmToList, errString);
		
		loadGroupTo.setLoadParamList(lgParmToList);
		
		// Validate Effective begin & Effective End date 
		loadGroupTo.setEffectiveBeginDate(row[UploadConstants.FOURTEEN].toString());
		
		if(!(ValidationUtil.isDateValid((loadGroupTo.getEffectiveBeginDate())))){
			
			errString.append(UploadConstants.INVALID_EFFECTIVE_BEGIN_DATE);
			errString.append(',');
			isValidDate = false;
		}
		
		loadGroupTo.setEffectiveEndDate(row[UploadConstants.FIFTEEN].toString());
		if(!(ValidationUtil.isDateValid((loadGroupTo.getEffectiveEndDate())))){
			
			errString.append(UploadConstants.INVALID_EFFECTIVE_END_DATE);
			errString.append(',');
			isValidDate = false;
		}
		if (isValidDate
				&& (ValidationUtil.convertStringToDate(loadGroupTo
						.getEffectiveEndDate()).compareTo(ValidationUtil
						.convertStringToDate(loadGroupTo
								.getEffectiveBeginDate()))) < 0) {
			errString.append(UploadConstants.EFFETIVE_BEGIN_DATE_GREATER_THAN_END_DATE);
			errString.append(',');
		}
		
	}
	
	/**
	 * Method will validate all the Mandatory Load parameter
	 * @param row
	 * @param lgParmToList
	 * @param errString
	 */
	public void validateLoadMandatoryGroupParms(Object[] row,
			List<ParameterTO> lgParmToList, StringBuilder errString) {
		
		// Validate cube threshold limits 1 to 9999
		if (!ValidationUtil.isCubeThresholdValid(row[UploadConstants.FIVE].toString().trim())) {
			
			errString.append(UploadConstants.INVALID_CUBE_THRESHOLD);
			errString.append(',');
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.TL_CUBE_THRESHOLD, row[UploadConstants.FIVE].toString().trim()));
		}
		
		// Validate cube weight threshold limits 1 to 99999 
		if (!ValidationUtil.isWeightThresholdValid(row[UploadConstants.SIX].toString().trim())) {
			
			errString.append(UploadConstants.INVALID_WEIGHT_THRESHOLD);
			errString.append(',');
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.TL_WEIGHT_THRESHOLD, row[UploadConstants.SIX].toString().trim()));
		}
		
		// Validate Direct round threshold limits 0.000 to 1.000 
		if (!ValidationUtil.isDirectRoundValid(row[UploadConstants.SEVEN].toString().trim())) {
			
			errString.append(UploadConstants.INVALID_DIR_ROUNDING);
			errString.append(',');
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.DIR_ROUNDING_THRESHOLD, row[UploadConstants.SEVEN].toString().trim()));
		}
		
		// Validate Threshold increment value limits 0.001 to 1.000
		if (!ValidationUtil.isRoundIncrementValid((row[UploadConstants.EIGHT].toString().trim()))) {
			
			errString.append(UploadConstants.INVALID_THRESHOLD_INCREMENT);
			errString.append(',');
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.THRESHOLD_INCREMENT, row[UploadConstants.EIGHT].toString().trim()));
		}
		
		
		// validate Full TL threshold value limits 0.001 to .999
		if (!ValidationUtil.isFullTruckLoadPercentValid((row[UploadConstants.NINE].toString().trim()))) {
			
			errString.append(UploadConstants.INVALID_TL_THRESHOLD);
			errString.append(',');
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.FULL_TL_THRESHOLD, row[UploadConstants.NINE].toString().trim()));
		}
		
		// Load configuratoer can be 'Y' or 'N'
		if (!ValidationUtil.isFlagValid((row[UploadConstants.TEN].toString().trim()))) {
			
			errString.append(UploadConstants.INVALID_LOAD_CONFIG);
			errString.append(',');
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.LOAD_CONFIG, row[UploadConstants.TEN].toString().trim()));
		}
		
		// 	Smoothing interval value limit 0 to 99
		if (!ValidationUtil
				.isSmoothingIntervalValid((row[UploadConstants.ELEVEN].toString().trim()))) {

			errString.append(UploadConstants.INVALID_SMOOTHING_INTERVAL);
			errString.append(',');
		} else {
			lgParmToList.add(setLoadGroupParmValues(
					UploadConstants.SMOOTHING_INTERVAL,
					row[UploadConstants.ELEVEN].toString().trim()));
		}
		
		
		
	}
	
	/**
	 * Method validateOptionalLoadGroupParms.
	 * @param row Object[]
	 * @param lgParmToList List<ParameterTO>
	 * @param errString StringBuilder
	 */
	public void validateOptionalLoadGroupParms(Object[] row,
			List<ParameterTO> lgParmToList, StringBuilder errString) {
		boolean isMaxQtyValid = true;

		if (EFSUtil.isEmpty(row[UploadConstants.FOURTH].toString().trim())) {

			lgParmToList.add(setLoadGroupParmValues(
					UploadConstants.MAX_TRUCK_HEIGHT,
					UploadConstants.DEFAULT_TRUCK_HEIGHT_VALUE));
		} else if (!ValidationUtil
				.isMaxTruckHeightValid(row[UploadConstants.FOURTH].toString().trim())) {

			errString.append(UploadConstants.INVALID_MAX_TRUCK_HEIGHT);
			errString.append(',');
		} else {
			lgParmToList.add(setLoadGroupParmValues(
					UploadConstants.MAX_TRUCK_HEIGHT,
					row[UploadConstants.FOURTH].toString().trim()));
		}
		
		if (row[UploadConstants.TWELVE].toString().trim().isEmpty()) {
			isMaxQtyValid = false;
			lgParmToList
			.add(setLoadGroupParmValues(UploadConstants.TL_DAILY_MIN_QTY, null));
		} else if (!ValidationUtil.isDailyTruckQtyValid((row[UploadConstants.TWELVE].toString().trim()))) {
			
			errString.append(UploadConstants.INVALID_TL_DAILY_MIN_QTY);
			errString.append(',');
			isMaxQtyValid = false;
			
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.TL_DAILY_MIN_QTY, row[UploadConstants.TWELVE].toString().trim()));
		}
		
		if (row[UploadConstants.THIRTEEN].toString().trim().isEmpty()) {
			isMaxQtyValid = false;
			lgParmToList
			.add(setLoadGroupParmValues(UploadConstants.TL_DAILY_MAX_QTY, null));
		} else if (!ValidationUtil.isDailyTruckQtyValid((row[UploadConstants.THIRTEEN].toString().trim()))) {
			
			errString.append(UploadConstants.INVALID_TL_DAILY_MAX_QTY);
			errString.append(',');
			isMaxQtyValid = false;
		} else {
			lgParmToList
					.add(setLoadGroupParmValues(UploadConstants.TL_DAILY_MAX_QTY, row[UploadConstants.THIRTEEN].toString().trim()));
		}
		
		if (isMaxQtyValid
				&& (Integer.parseInt(row[UploadConstants.TWELVE].toString().trim()) > Integer
						.parseInt(row[UploadConstants.THIRTEEN].toString().trim()))) {
			errString.append(UploadConstants.MIN_VALUE_GREATER_THAN_MAX_VAL);
			errString.append(",");
		}
	}
	
	/**
	 * Set the Parameter code and values for the load group
	 * 
	 * @param parmName
	 * @param parmValue
	
	 * @return ParameterTO
	 */
	private ParameterTO setLoadGroupParmValues(String parmName,
			String parmValue) {
		
		Map<String, Short> parmNameAndCode = new HashMap<String, Short>();
		parmNameAndCode.put(UploadConstants.MAX_TRUCK_HEIGHT, (short) 8);
		parmNameAndCode.put(UploadConstants.TL_CUBE_THRESHOLD, (short)9);
		parmNameAndCode.put(UploadConstants.TL_WEIGHT_THRESHOLD, (short)10);
		parmNameAndCode.put(UploadConstants.DIR_ROUNDING_THRESHOLD, (short)11);
		parmNameAndCode.put(UploadConstants.THRESHOLD_INCREMENT, (short)12);
		parmNameAndCode.put(UploadConstants.FULL_TL_THRESHOLD, (short)13);
		parmNameAndCode.put(UploadConstants.LOAD_CONFIG, (short)14);
		parmNameAndCode.put(UploadConstants.TL_DAILY_MIN_QTY, (short)15);
		parmNameAndCode.put(UploadConstants.TL_DAILY_MAX_QTY, (short)16);
		parmNameAndCode.put(UploadConstants.SMOOTHING_INTERVAL, (short)17);
		
		ParameterTO vndrGrpParm = new ParameterTO();
		if (parmName.equalsIgnoreCase(UploadConstants.MAX_TRUCK_HEIGHT)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.MAX_TRUCK_HEIGHT));
			vndrGrpParm.setDecimalValue(new BigDecimal(parmValue));
		} else if (parmName.equalsIgnoreCase(UploadConstants.TL_CUBE_THRESHOLD)) {
		
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.TL_CUBE_THRESHOLD));
			vndrGrpParm.setIntValue(Integer.valueOf(parmValue));
		} else if (parmName.equalsIgnoreCase(UploadConstants.TL_WEIGHT_THRESHOLD)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.TL_WEIGHT_THRESHOLD));
			vndrGrpParm.setIntValue(new Integer(parmValue));
		} else if (parmName.equalsIgnoreCase(UploadConstants.DIR_ROUNDING_THRESHOLD)) {
		
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.DIR_ROUNDING_THRESHOLD));
			vndrGrpParm.setDecimalValue(new BigDecimal(parmValue));
		} else if (parmName.equalsIgnoreCase(UploadConstants.THRESHOLD_INCREMENT)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.THRESHOLD_INCREMENT));
			vndrGrpParm.setDecimalValue(new BigDecimal(parmValue));
		} else if (parmName.equalsIgnoreCase(UploadConstants.FULL_TL_THRESHOLD)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.FULL_TL_THRESHOLD));
			vndrGrpParm.setDecimalValue(new BigDecimal(parmValue));
		}else if (parmName.equalsIgnoreCase(UploadConstants.LOAD_CONFIG)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.LOAD_CONFIG));
			vndrGrpParm.setFlagValue(parmValue);
		}else if (parmName.equalsIgnoreCase(UploadConstants.TL_DAILY_MIN_QTY)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.TL_DAILY_MIN_QTY));
			vndrGrpParm.setIntValue(parmValue != null ? Integer.valueOf(parmValue) : null);
		}else if (parmName.equalsIgnoreCase(UploadConstants.TL_DAILY_MAX_QTY)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.TL_DAILY_MAX_QTY));
			vndrGrpParm.setIntValue(parmValue != null ? Integer.valueOf(parmValue) : null);
		}else if (parmName.equalsIgnoreCase(UploadConstants.SMOOTHING_INTERVAL)) {
			
			vndrGrpParm.setLoadGroupParamCode(parmNameAndCode.get(UploadConstants.SMOOTHING_INTERVAL));
			vndrGrpParm.setIntValue(Integer.valueOf(parmValue));
		}else {
			vndrGrpParm = null;
		}
		return vndrGrpParm;
	}

}
