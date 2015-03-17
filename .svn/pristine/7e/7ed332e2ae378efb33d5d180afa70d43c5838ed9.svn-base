/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: EFSUtil.java 
 * author: The Home Depot Inc
 */
package com.homedepot.di.xd.efs.util;

import java.math.BigDecimal;
import java.util.List;

import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.ta.aa.dao.exceptions.QueryException;
import com.homedepot.ta.aa.dao.stream.MapStream;

/**
 * The Class ApplicationUtil.
 * 
 * 
 */
public final class EFSUtil {
	private EFSUtil() {
	}


	/**
	 * Checks if is null or empty.
	 * 
	 * @param input
	 *            List<T> : list
	 * @return true, if input is null or Empty
	 */
	public static <T> boolean isEmpty(final List<T> list) {
		return list == null || list.isEmpty();
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
	 * Checks if is null or empty.
	 * 
	 * @param input
	 *            String : str
	 * @return true, if input is null or Zero
	 */
	public static boolean isEmpty(final BigDecimal value) {
		return value == null || value.doubleValue() == 0;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param input
	 *            Integer : value
	 * @return true, input if is null or Zero
	 */
	public static boolean isEmpty(final Integer value) {
		return value == null || value.intValue() == 0;
	}

	/**
	 * Checks if is null or Zero.
	 * 
	 * @param input
	 *            the value
	 * @return true, if input is null or Zero.
	 */
	public static boolean isEmpty(final Short value) {
		return value == null || value.intValue() == 0;
	}
	

	/**
	 * If input is not null then, Method will add the inputs into Mapstream .
	 * otherwise it will add null
	 * 
	 * @param inputs
	 * @param inputName
	 * @param input
	 * @throws QueryException
	 */
	public static void addInputIfExists(MapStream inputs, String inputName,
			Integer input) throws QueryException {

		if (input != null) {
			inputs.put(inputName, input);
		} else {
			inputs.putAllowNull(inputName, (BigDecimal) null);
		}
	}

	/**
	 * If input is not null then, Method will add the inputs into Mapstream .
	 * otherwise it will add null
	 * 
	 * @param inputs
	 * @param inputName
	 * @param input
	 * @throws QueryException
	 */
	public static void addInputIfExists(MapStream inputs, String inputName,
			String input) throws QueryException {
		if (input != null) {
			inputs.put(inputName, input);
		} else {
			inputs.putAllowNull(inputName, (String) null);
		}
	}

	/**
	 * If input is not null then, Method will add the inputs into Mapstream .
	 * otherwise it will add null
	 * 
	 * @param inputs
	 * @param inputName
	 * @param input
	 * @throws QueryException
	 */
	public static void addInputIfExists(MapStream inputs, String inputName,
			Short input) throws QueryException {
		if (input != null) {
			inputs.put(inputName, input);
		} else {
			inputs.putAllowNull(inputName, null);
		}
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
	 * This method returns true/False based on yes/no.
	 * 
	 * @param flg
	 * @return boolean
	 */
	public static Boolean getFlagValue(String flg) {
		if (flg != null && flg.equalsIgnoreCase(EFSConstants.YES)) {
			return true;
		} else if (flg != null && flg.equalsIgnoreCase(EFSConstants.NO)) {
			return false;
		} 
		return false;
	}

	/**
	 * This method returns Y or N based on true/False.
	 * 
	 * @param flg
	 * @return boolean
	 */
	public static String convertBooleanToString(boolean flag) {

		return flag ? "Y" : "N";
	}
	
	/**
	 * This method returns Y or N based on true/false.
	 * 
	 * @param flg
	 * @return boolean
	 */
	public static String getFlgValue(Boolean flg) {
		if (flg != null && flg.equals(Boolean.TRUE)) {
			return "Y";
		} else if (flg != null && flg.equals(Boolean.FALSE)) {
			return "N";
		} else {
			return null;
		}
	}
	
	/**
	 * Converts the time 
	 * @param time
	 * @return
	 */
	public static String convertToValidTimeFormat(String time){
		
		String[] timeArray = time.split(":");
		StringBuilder timeBuilder = new StringBuilder();
		for(int i=0; i<timeArray.length; i++){
			if(timeArray[i].length()<2){
				timeBuilder.append("0");
			}
			timeBuilder.append(timeArray[i]);
			timeBuilder.append(":");
		}
		
		//Appends the second field
		if(timeBuilder.length() == 6 ){
			timeBuilder.append("00");
		}
		//To be on safer side if Semi colne is end of the string remove that
		if(timeBuilder.charAt(timeBuilder.length()-1) == ':'){
			timeBuilder.deleteCharAt(timeBuilder.length()-1);
		}
		return timeBuilder.toString();
	}

}
