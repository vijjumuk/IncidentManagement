/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: UploadValidationUtil.java 
 * author: The Home Depot Inc
 */

package com.homedepot.di.xd.efs.util;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;

public class UploadValidationUtil{

	private UploadValidationUtil() {
	}
	
	public static boolean isRouteDescriptionValid(String rteDesc){
		if (rteDesc != null
				//&& rteDesc.matches(UploadConstants.ROUTE_NAME_VALIDATION)
				&& (rteDesc.length() > UploadConstants.ROUTE_NM_MIN_LENGTH && rteDesc.length() < UploadConstants.ROUTE_NM_MAX_LENGTH)) {
			return true;
		}
		return false;
	}
	/**
	 * If routeTypeCd is valid return isValid else return false.
	 * 
	 * @param rteTypCd The route Type code being presented
	 * @return boolean is valid
	 */
	public static boolean isRouteTypeCodeValid(String rteTypCd){
		if (rteTypCd != null
				&& (!rteTypCd.isEmpty())
				&& rteTypCd.matches(UploadConstants.NUMBER_ONLY)){
			return true;
		}
		
		return false;
	}

	/**
	 * If vendor number is valid return isValid else return false.
	 * 
	 * @param vndrNbr
	 * @return boolean
	 */
	public static boolean isVendorValid(String vndrNbr) {

		if (vndrNbr != null
				&& (!vndrNbr.isEmpty())
				&& vndrNbr.matches(UploadConstants.NUMBER_ONLY)
				&& (vndrNbr.length() > UploadConstants.VENDR_MIN_LENGTH && vndrNbr.length() < UploadConstants.VENDR_MAX_LENGTH)) {
			return true;
		}

		return false;
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
	 * Validate SKU number
	 * 
	 * @param sku
	 * @return boolean
	 */
	public static boolean isSKUValid(String sku) { // --Todo Use SKU validation
		try { // jar to validate the SKU.

			if (sku != null
					&& sku.matches(UploadConstants.NUMBER_ONLY)
					&& (sku.length() == UploadConstants.SKU_LENGTH1 || sku.length() == UploadConstants.SKU_LENGTH2)
					&& Integer.valueOf(sku) <= UploadConstants.MAX_SKU_VALUE) {
				return true;

			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

	
	/**
	 * validate the headers. If all headers are similar check if there is any
	 * extra or less columns in csv file.
	 * 
	 * @param uploadedHeader
	 * @param reqHeader
	 * @param headerLen
	 * @return 1 if columns are greater, 0 if equals, -1 if not matches
	 */
	public static int validateHeaderFields(String[] uploadedHeader,
			String[] reqHeader) {
		if (uploadedHeader.length != reqHeader.length) {
			return 1;
		}
		for (int i = 0; i <= reqHeader.length - 1; i++) {
			if (!reqHeader[i].equalsIgnoreCase(uploadedHeader[i])) {
				return -1;
			}
		}
		return 0;
	}

	/**
	 * Method will return total records count details
	 * 
	 * @param reader
	 * @return count of number of records
	 * @throws EFSException
	 */
	public static int getRecordCount(final CsvReader reader)
			throws EFSException {

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
					EFSConstants.EXCEPTION_OCCURED, e);
		}
		return recCount;
	}

	/**
	 * Method converts the string date into Util.Date format
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date convertStringToDate(String dateString) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(UploadConstants.FALSE);
		Date dateValue = null;
		
		try {
			dateValue = new Date(sdf.parse(dateString).getTime());
		} catch (ParseException e) {
			return null;
		}
		return dateValue;
	}

	public static Date convertSUtilDateToSqlDate(Object dateObj) {

		Date dateValue = null;
		if(dateObj !=null)
		{
			java.util.Date utilDate = (java.util.Date) dateObj;
			dateValue = new Date(utilDate.getTime());
		}
		return dateValue;
	}

	/**
	 * Method will check for group name existence. 
	 * 
	 * @param groupName
	 * @return
	 */
	public static boolean isEmptyString(String str) {
		if (str !=null){
			if(str.trim().length() == 0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public static boolean isNumeric(String dest) {

		if (dest != null && (!dest.isEmpty()) && dest.matches(UploadConstants.NUMBER_ONLY)) {
			return true;
		}
		return false;
	}

	public static boolean isValidStringLength(String str, int noOfChar){

		if(str!=null && str.length()<= noOfChar){
			return true;
		}
		
		
		return false;
		
	}
	
	

	/**
	 * Method calculates the VTT 
	 * 
	 * @param shipDay
	 * @param orderDay
	 * @param locationLastWorkDayCode
	 * @return
	 */
	public static short  calculateVendorTranspTime(Short shipDay, Short orderDay, Map<String, String> locationLastWorkDayCode) {
		short vndrTT=0;
		vndrTT= (short) ((shipDay-orderDay)+ 1);
		
		// Get this value from table SCHN_EFS_LOC_OPS_HRS
		short maxWorkDayCd = 0;
		if(locationLastWorkDayCode.containsKey(UploadConstants.CONSTANT_9100)){
			String[] value = locationLastWorkDayCode.get(UploadConstants.CONSTANT_9100).split("_");
			maxWorkDayCd = Short.valueOf(value[0]);
		}else{
			// Considering 5 days as business days for a week
			maxWorkDayCd = 5;
		}
		
		// Handle the scenario when Ship Day is Monday hence the order day should be 
		// a week prior to ship day
		if(shipDay < orderDay){
			
			short prevWk = (short) ((maxWorkDayCd - orderDay) +1);
			vndrTT = (short) (shipDay + prevWk); 
		}
		return vndrTT;
	}
	
	
	/**
	 * Method to validate if the input is valid (negative or positive) number
	 * @param numb
	 * @return
	 */
	
	
	public static boolean isNumber(String numb) {

		if (numb != null && (!numb.isEmpty()) && UploadConstants.NEGATIVE_AND_POSITIVE_NUMBER.matcher(numb.substring(1, numb.length())).find()) {
			return true;
		}
		else
		{
		return false;
		}
	}

	/**
	 * Method to check if the input day lies between 1 and 7.
	 * @param day
	 * @return
	 */
	public static boolean isValidWeekDayNumber(String  day) {

		if(day !=null && (!day.isEmpty()&&day.matches(UploadConstants.WEEKDAYS)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Method to validate the time format in HH:MM
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isValidTimeFormat(String time) {


		if(time !=null && (!time.isEmpty()&&time.matches(UploadConstants.TIMEFORMAT_IN24HRS)))

		{
			return true;
		}

		else
		{
			return false;
		}



	}

	/**
	 * Method to validate the time format in HH.
	 * @param time
	 * @return
	 */
	public static boolean isValidTimeFormatInHrs(String inputTime) {


		if(inputTime !=null && (!inputTime.isEmpty()&&inputTime.matches(UploadConstants.TIMEFORMAT)))

		{
			return true;
		}

		else
		{
			return false;
		}

	}
	
	/**
	 * 
	 * @param effBgnDt1
	 * @param effEndDt1
	 * @param effBgnDt2
	 * @param effEndDt2
	 * @return
	 */
	public static boolean isDateRangeOverlapping(Date effBgnDt1, Date effEndDt1, 
			Date effBgnDt2, Date effEndDt2) {

		boolean isOverlaps = false;

		if(effBgnDt2.equals(effBgnDt1) || effBgnDt2.equals(effEndDt1) 
				|| effEndDt2.equals(effBgnDt1) || effEndDt2.equals(effEndDt1))
		{
			isOverlaps = true;
		}
		else if((effBgnDt2.after(effBgnDt1) && effBgnDt2.before(effEndDt1)) || 
				(effEndDt2.after(effBgnDt1) && effEndDt2.before(effEndDt1)))
		{
			isOverlaps = true;
		}
		else if((effBgnDt1.after(effBgnDt2) && effBgnDt1.before(effEndDt2)) || 
				(effEndDt1.after(effBgnDt2) && effEndDt1.before(effEndDt2)))
		{
			isOverlaps = true;
		}
		return isOverlaps;
	} 
	
	/**
	 * Method calculates the working hours for given dc 
	 * 
	 * @param locationLastWorkDayCode
	 * @param destinationNbr
	 * @param shiftCount
	 * @return
	 */
	public static double calculateWorkHours(Map<String, String> locationLastWorkDayCode, String destinationNbr, short shiftCount){
		
		double totalWorkHour = 0;
		if(locationLastWorkDayCode.containsKey(destinationNbr)){
			String[] value = locationLastWorkDayCode.get(destinationNbr).split("_");
			totalWorkHour = Short.valueOf(value[1]);
		}else{
			totalWorkHour = UploadConstants.DC_WORK_HOURS;
		}
		return shiftCount * totalWorkHour;
	}
	
}
