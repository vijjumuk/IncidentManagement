package com.homedepot.di.xd.efs.util;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumMap;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.EFSConstants.StateCodeEnum;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;

public class ValidationUtil {

	public static int getRecordCount(CsvReader reader) throws EFSException{

		int recCount = 0;
		int indx;
		boolean empty = true;
		try {
			while (reader.readRecord()) {
				empty = true;
				for (indx = 0; indx < reader.getColumnCount() && empty; indx++) {
					empty = (reader.get(indx).trim().length() == 0);
				}
				if (!empty) {
					recCount++;
				}
			}
		} catch (IOException e) {
			throw new EFSException(
					UploadConstants.EXCEPTION +"getRecordCount", e);
		}
		return recCount;
	
	}
	
	/**
	 * Checks if is null or empty.
	 * 
	 * @param input
	 *            String : str
	 * @return true, if input is null or Zero
	 */
	public static boolean isEmpty(final String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * To check the record is empty or not.
	 * 
	 * @param row
	 * @return boolean
	 */
	public static boolean isRowEmpty(String[] row)
	{
		for(String columnValue: row)
		{
			if(!isEmpty(columnValue))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Validate Origin ID and return true if it is valid
	 * 
	 * @param origin
	 * @return
	 */
	public static boolean isOriginValid(String origin) {
		if (origin != null && (!origin.isEmpty())
				&& origin.matches(UploadConstants.ALPHA_NUMERIC_ONLY)
				&& origin.length() <= UploadConstants.ORIGIN_LENGTH) {

			return true;
		}
		return false;
	}
	
	/**
	 * Validate shipping location number and return true if it is valid
	 * 
	 * @param dest
	 * @return boolean
	 */
	public static boolean isDestinationValid(String dest) {

		if (dest != null && (!dest.isEmpty()) && dest.matches(UploadConstants.NUMBER_ONLY)
				&& dest.length() == UploadConstants.DEST_NBR_LENGTH) {

			return true;
		}
		return false;
	}

	public static boolean isLocationNameValid(String locName) {
		 
		if (locName != null && (!locName.isEmpty() && (locName.matches(UploadConstants.LOC_NAME_VALIDATION) || locName.matches(UploadConstants.ALPHABET_ONLY)) )){
			return true;
		} else {
			return false;
		}
			
	}

	/**
	 * Validation for Address columns, can be null.
	 * Length cannot exceed 60 characters.
	 * Allow digits, spaces, alphabets and some special characters.
	 * 
	 * @param addressLine
	 * @return boolean
	 */
	public static boolean isAddressLineValid(String addressLine) {
		if (addressLine == null) {
			return true;
		} else if(!(addressLine != null && (!addressLine.isEmpty()
				&& addressLine.length() <= UploadConstants.ADDRESS_OR_NAME_MAX_LENGTH && addressLine
					.matches(UploadConstants.ADDRESS_VALIDATION)))) {
			return false;
		}
		return true;
	}

	public static boolean isValidCity(String city) {
		if (city == null) {
			return true;
		} else if (!(city != null && (!city.isEmpty() && (city
				.matches(UploadConstants.CITY_VALIDATION) || city
				.matches(UploadConstants.ALPHABET_ONLY))))) {
			return false;
		}
		return true;
	}

	public static boolean isStateCodeValid(String stateCd) {
		
		 if (!(stateCd != null && (!stateCd.isEmpty()
				&& stateCd.length() == UploadConstants.STAT_CD_LENGTH && stateCd
					.matches(UploadConstants.NUMBER_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isPostalCodeValid(String postalCd) {
		if (postalCd == null) {
			return true;
		} else if (!(postalCd != null && (!postalCd.isEmpty()
				&& postalCd.length() <= UploadConstants.POSTAL_CD_LENGTH && postalCd
					.matches(UploadConstants.ALPHA_NUMERIC_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isLatitudeValid(String latitude) {
		try {
			if (latitude == null) {
				return true;
			} else if (Double.parseDouble(latitude) <= UploadConstants.LATITUDE_MAX_VAL && Double.parseDouble(latitude) >= UploadConstants.LATITUDE_MIN_VAL
					&& UploadConstants.LATITUDE_PATTERN.matcher(latitude.substring(1, latitude.length())).find() ) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}
	
	public static boolean isLongitudeValid(String longitude) {
		try {
			if (longitude == null ) {
				return true;
			} else if (Double.parseDouble(longitude) <= UploadConstants.LONGITUDE_MAX_VAL
			&& Double.parseDouble(longitude) >= UploadConstants.LONGITUDE_MIN_VAL
			&& UploadConstants.LONGITUDE_PATTERN.matcher(longitude.substring(1, longitude.length())).find()) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}

	public static boolean isCountryCodeValid(String countryCd) {
		if (countryCd == null ) {
			return true;
		} else if (!(countryCd != null && (!countryCd.isEmpty()
				&& countryCd.length() == UploadConstants.COUNTRY_CD_LENGTH && countryCd
					.matches(UploadConstants.NUMBER_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validates location type code. It is a number. It cannot be empty or null.
	 * 
	 * @param locTypCd
	 * @return boolean
	 */
	public static boolean isLocationTypeCd(String locTypCd) {
		if (!(locTypCd != null && (!locTypCd.isEmpty() && locTypCd
				.matches(UploadConstants.NUMBER_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Validate the flag value and return true if it is valid
	 * 
	 * @param flg
	 * @return boolean
	 */
	public static boolean isFlagValid(String flg) {
		if (flg != null && (!flg.isEmpty())
				&& (flg.equalsIgnoreCase(UploadConstants.YES) || flg.equalsIgnoreCase(UploadConstants.NO))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Convert empty string into null 
	 * @param emptyValue
	 * @return
	 */
	public static String changeEmptyToNull(String emptyValue) {
		if(emptyValue.isEmpty()) {
			return null;
		}  
		return emptyValue;
		
		
	}
	
	/**
	 * Method to validate load group name
	 * @param loadGrpName
	 * @return
	 */
	public static boolean isLoadGroupNameValid(String loadGrpName) {

		if ((loadGrpName != null)
				&& !(loadGrpName.isEmpty())
				&& Arrays.asList(UploadConstants.getLoadGroupNames()).contains(
						loadGrpName.toUpperCase())) {

			return true;
		}

		return false;
	} 
	
	public static String stateCodeMap(int code){
		EnumMap<StateCodeEnum, String> enumMap = new EnumMap<StateCodeEnum, String>(
				StateCodeEnum.class);
		enumMap.put(StateCodeEnum.PA, "PA");
		enumMap.put(StateCodeEnum.GU, "GU");
		enumMap.put(StateCodeEnum.AK, "AK");
		enumMap.put(StateCodeEnum.AR, "AR");
		enumMap.put(StateCodeEnum.IA, "IA");
		enumMap.put(StateCodeEnum.NH, "NH");
		enumMap.put(StateCodeEnum.MN, "MN");
		enumMap.put(StateCodeEnum.ID, "ID");
		enumMap.put(StateCodeEnum.NC, "NC");
		enumMap.put(StateCodeEnum.KS, "KS");
		enumMap.put(StateCodeEnum.WV, "WV");
		enumMap.put(StateCodeEnum.AL, "AL");
		enumMap.put(StateCodeEnum.MD, "MD");
		enumMap.put(StateCodeEnum.TX, "TX");
		enumMap.put(StateCodeEnum.CO, "CO");
		enumMap.put(StateCodeEnum.FL, "FL");
		enumMap.put(StateCodeEnum.RI, "WA");
		enumMap.put(StateCodeEnum.DE, "DE");
		enumMap.put(StateCodeEnum.CT, "CT");
		enumMap.put(StateCodeEnum.HI, "HI");
		enumMap.put(StateCodeEnum.NM, "NM");
		enumMap.put(StateCodeEnum.OK, "OK");
		enumMap.put(StateCodeEnum.UT, "UT");
		enumMap.put(StateCodeEnum.WI, "PA");
		enumMap.put(StateCodeEnum.MI, "MI");
		enumMap.put(StateCodeEnum.NJ, "NJ");
		enumMap.put(StateCodeEnum.WY, "WY");
		enumMap.put(StateCodeEnum.IL, "IL");
		enumMap.put(StateCodeEnum.SD, "SD");
		enumMap.put(StateCodeEnum.GA, "GA");
		enumMap.put(StateCodeEnum.MO, "MO");
		enumMap.put(StateCodeEnum.MT, "MT");
		enumMap.put(StateCodeEnum.SC, "SC");
		enumMap.put(StateCodeEnum.AZ, "AZ");
		enumMap.put(StateCodeEnum.VA, "VA");
		enumMap.put(StateCodeEnum.KY, "KY");
		enumMap.put(StateCodeEnum.OR, "OR");
		enumMap.put(StateCodeEnum.TN, "IN");
		enumMap.put(StateCodeEnum.VT, "VT");
		enumMap.put(StateCodeEnum.MA, "MA");
		enumMap.put(StateCodeEnum.PR, "PR");
		enumMap.put(StateCodeEnum.IN, "IN");
		enumMap.put(StateCodeEnum.OH, "OH");
		enumMap.put(StateCodeEnum.LA, "LA");
		enumMap.put(StateCodeEnum.ND, "ND");
		enumMap.put(StateCodeEnum.VI, "VI");
		enumMap.put(StateCodeEnum.MA, "MA");
		enumMap.put(StateCodeEnum.NY, "NY");
		enumMap.put(StateCodeEnum.NE, "NE");
		enumMap.put(StateCodeEnum.DC, "DC");
		enumMap.put(StateCodeEnum.NV, "NV");
		for (EnumMap.Entry<StateCodeEnum, String> entry : enumMap.entrySet()) {
			if (code == entry.getKey().getCode()){
				return entry.getValue();
			}
		}

		return null;

	}

	public static boolean isMaxTruckHeightValid(String truckHeight) {
		try {
			if ((UploadConstants.RATE_PATTERN_DEC2.matcher(truckHeight).find() || truckHeight
							.matches(UploadConstants.NUMBER_ONLY))
					&& (Double.parseDouble(truckHeight) > UploadConstants.MIN_VAL && Double
							.parseDouble(truckHeight) <= UploadConstants.MAX_TRUCK_HEIGHT_MAX_VAL)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
	
	
	/**
	 * Validate decimal values and return true if it is valid
	 * 
	 * @param days
	 * @return
	 */
	public static boolean isCubeThresholdValid(String days) {
		try {
			if (days != null
					&& (!days.isEmpty())
					&& (Integer.parseInt(days) > UploadConstants.MIN_LENGTH && Integer
							.parseInt(days) < UploadConstants.CUBE_MAX_LIMIT)) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}

	
	/**
	 * Validate decimal values and return true if it is valid
	 * 
	 * @param days
	 * @return
	 */
	public static boolean isWeightThresholdValid(String days) {
		try {
			if (days != null
					&& (!days.isEmpty())
					&& (Integer.parseInt(days) > UploadConstants.MIN_LENGTH && Integer
							.parseInt(days) < UploadConstants.WEIGHT_MAX_LIMIT)) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}

	/**
	 * Validate the Direct round threshold percent field and return true if
	 * valid
	 * 
	 * @param rate
	 * @return boolean
	 */
	public static boolean isDirectRoundValid(String roundoff) {
		try {
			if (roundoff != null
					&& (!roundoff.isEmpty())
					&& (UploadConstants.RATE_PATTERN.matcher(roundoff).find() || roundoff
							.matches(UploadConstants.NUMBER_ONLY))
					&& (Double.parseDouble(roundoff) >= UploadConstants.MIN_VAL && Double
							.parseDouble(roundoff) <= UploadConstants.INCR_PCT_MAX_VAL)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
	
	
	/**
	 * Validate the Direct round threshold percent field and return true if
	 * valid
	 * 
	 * @param rate
	 * @return boolean
	 */
	public static boolean isRoundIncrementValid(String roundoff) {
		try {
			if (roundoff != null
					&& (!roundoff.isEmpty())
					&& (UploadConstants.RATE_PATTERN.matcher(roundoff).find() || roundoff
							.matches(UploadConstants.NUMBER_ONLY))
					&& (Double.parseDouble(roundoff) > UploadConstants.MIN_VAL && Double
							.parseDouble(roundoff) <= UploadConstants.INCR_PCT_MAX_VAL)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

	/**
	 * Validate the Direct round threshold percent field and return true if
	 * valid
	 * 
	 * @param rate
	 * @return boolean
	 */
	public static boolean isFullTruckLoadPercentValid(String roundoff) {
		try {
			if (roundoff != null
					&& (!roundoff.isEmpty())
					&& (UploadConstants.RATE_PATTERN.matcher(roundoff).find() || roundoff
							.matches(UploadConstants.NUMBER_ONLY))
					&& (Double.parseDouble(roundoff) > UploadConstants.MIN_VAL && Double
							.parseDouble(roundoff) <= UploadConstants.FULL_TRUCK_THRESHOLD_VAL)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
	
	/**
	 * Validate the Direct round threshold percent field and return true if
	 * valid
	 * 
	 * @param rate
	 * @return boolean
	 */
	public static boolean isDailyTruckQtyValid(String roundoff) {
		try {
			if (EFSUtil.isEmpty(roundoff)){
				
				return true;
			}
			else if(roundoff
							.matches(UploadConstants.NUMBER_ONLY)
					&& (Integer.parseInt(roundoff) >= UploadConstants.MIN_VAL && Integer
							.parseInt(roundoff) < UploadConstants.DAILY_TRUCK_QTY)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

	
	/**
	 * Validate the Direct round threshold percent field and return true if
	 * valid
	 * 
	 * @param rate
	 * @return boolean
	 */
	public static boolean isSmoothingIntervalValid(String roundoff) {
		try {
			if (roundoff != null
					&& (!roundoff.isEmpty())
					&& (roundoff
							.matches(UploadConstants.NUMBER_ONLY) &&
							Integer.parseInt(roundoff) >= UploadConstants.MIN_LENGTH && Integer
							.parseInt(roundoff) < UploadConstants.SMOOTHING_MAX_LENGTH)) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}

	
	/**
	 * Method converts the string date into Util.Date format
	 * 
	 * @param dateString
	 * @return
	 */
	public static boolean isDateValid(String dateString) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(UploadConstants.FALSE);
		Date dateValue = null;
		
		try {
			dateValue = new Date(sdf.parse(dateString).getTime());
		} catch (ParseException e) {
			return false;
		} catch(NullPointerException e){
			return false;
		}
		return true;
	}
	
	/**
	 * Method converts the string date into Util.Date format
	 * 
	 * @param dateString
	 * @return
	 * @throws EFSException 
	 */
	public static Date convertStringToDate(String dateString) throws EFSException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(UploadConstants.FALSE);
		Date dateValue = null;
		
		try {
			dateValue = new Date(sdf.parse(dateString).getTime());
		} catch (ParseException e) {
			throw new EFSException(UploadConstants.EXCEPTION + e.getMessage());
		} catch(NullPointerException e){
			throw new EFSException(UploadConstants.EXCEPTION + e.getMessage());
		}
		return dateValue;
	}
	
	public static boolean isMaxPullFwdDaysValid(String maxFwdDays) {
		try {
			if (maxFwdDays.matches(UploadConstants.NUMBER_ONLY)
					&& (Integer.parseInt(maxFwdDays) >= UploadConstants.MIN_VAL && Integer
							.parseInt(maxFwdDays) < UploadConstants.MAX_PULL_FWD_DAYS_MAX_VALUE)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
	
	
	public static boolean isOUTLThresholdValid(String truckHeight) {
		try {
			if ((UploadConstants.RATE_PATTERN_DEC2.matcher(truckHeight).find() || truckHeight
							.matches(UploadConstants.NUMBER_ONLY))
					&& (Double.parseDouble(truckHeight) > UploadConstants.MIN_VAL && Double
							.parseDouble(truckHeight) <= UploadConstants.OUTL_THRESHOLD_MAX_VAL)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}


	public static Date getPreviousDay(java.util.Date date) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, -1);
		java.sql.Date sqlDate = new java.sql.Date((c.getTime()).getTime());

		return sqlDate;
	}

	public static java.util.Date getNextDay(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		
		return c.getTime();
	}
	
}
