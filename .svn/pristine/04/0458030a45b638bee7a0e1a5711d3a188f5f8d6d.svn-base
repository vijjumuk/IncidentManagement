package com.homedepot.di.xd.efs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.ParameterTO;
import com.homedepot.di.xd.efs.to.VendorGroupParamTO;
import com.homedepot.di.xd.efs.util.EFSUtil;
import com.homedepot.di.xd.efs.util.ValidationUtil;
import com.homedepot.ta.aa.dao.Inputs;
import com.homedepot.ta.aa.dao.Query;
import com.homedepot.ta.aa.dao.Results;
import com.homedepot.ta.aa.dao.ResultsReader;
import com.homedepot.ta.aa.dao.builder.BatchData;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.builder.UnitOfWork;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

/**
 */
public class VendorGroupParamUploadDAO {
	
	/**
	 * Field LOGGER.
	 */
	private static final Logger LOGGER = Logger.getLogger(VendorGroupParamUploadDAO.class);
	
	
	// Data source constant
	private static final String SupplyChainDistributionNetwork = "java:comp/env/jdbc/SupplyChainDistributionNetwork.1";
	
	//in list Max size
	private static final int IN_LIST_MAX_SIZE = 500;
	
	// Location Column count
	private static final int EFS_VNDR_LGRP_PARAM = 11;
	
	
	// Insert Query for Lane Load Group Param table
		private static final String INSERT_LGRP_VENDOR_PARM = " INSERT INTO SCHN_SHLANE_VNDR_PARM " +
				" (SCHN_SHLANE_VNDR_PARM_ID  , " +
				" CRT_SYSUSR_ID  , " +
				" CRT_TS  , " +
				" LAST_UPD_SYSUSR_ID  , " +
				" LAST_UPD_TS  , " +
				" SCHN_SHLANE_LGRP_VNDR_ID , " +
				" LOAD_PLNG_PARM_CD  , " +
				" EFF_BGN_DT  , " +
				" EFF_END_DT  , " +
				" PARM_CHAR_VAL  , " +
				" PARM_INTG_VAL , " +
				" PARM_DEC_VAL , " +
				" PARM_FLG_VAL ) " +
				" VALUES (? , ? , CURRENT_TIMESTAMP , ? , CURRENT_TIMESTAMP, ? , ? , ? , ? , ? , ? , ? , ? ) " ;
	
	//Query to fetch the Load Vendor group Id
	private static final String READ_LGRP_VNDR_ID = " SELECT   SCHN_SHLANE_LGRP_VNDR_ID , " +
			" MBAS_MVNDR_NBR, " +
			" MBAS_DEPT_NBR, " +
			" SCHN_SHPG_LANE_LOAD_GRP_ID, " +
			" EFF_BGN_DT, " +
			" EFF_END_DT, " +
			" MER_BASE_CD " +
			" FROM SCHN_SHLANE_LGRP_VNDR " +
			" WHERE MBAS_MVNDR_NBR = ? ";
	
	
	// Query to fetch the Active Location Id
		private static final String READ_ACTIVE_LOCATION_ID = " SELECT XREF.SCHN_LOC_ID, " +
				" XREF.SRC_LOC_ID  " +
				" FROM   SCHN_EFS_LOC_XREF XREF, " +
				" SCHN_EFS_LOC LOC  " +
				" WHERE  XREF.SCHN_LOC_ID = LOC.SCHN_LOC_ID   " +
				 " AND LOC.ACTV_FLG = 'Y'  " ;
	
		// Query to fetch Lane group Id
		private static final String READ_LOAD_GROUP_ID = "select LGRP.SCHN_SHPG_LANE_LOAD_GRP_ID "
				+ "from SCHN_SHPG_LANE_LOAD_GRP LGRP ,"
				+ "(select schn_shpg_lane_id "
				+ "from schn_shpg_lane "
				+ "where ORIG_SCHN_LOC_ID = ? "
				+ "and SHP_TO_SCHN_LOC_ID = ? "
				+ "and actv_flg='Y') lane "
				+ "where lane.schn_shpg_lane_id = LGRP.schn_shpg_lane_id ";
		
		
		/**
		 * Select query for sequence object for Lane load param id  (SCHN_SHLANE_LGRP_PARM_SEQ).
		 */
		private static final String SHLANE_VNDR_PARM_SEQ_NBR = "SELECT SCHN_SHLANE_VNDR_PARM_SEQ.NEXTVAL FROM DUAL";
		
		
		/**
		 * Method createVendorLoadGroupParams.
		 * @param vendorGroupParamList List<VendorGroupParamTO>
		 * @param userId String
		 * @return boolean
		 * @throws EFSException
		 */
		public static boolean createVendorLoadGroupParams(final List<VendorGroupParamTO> vendorGroupParamList, final String userId) throws DataOperationException {
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(UploadConstants.ENTERING_METHOD + "createVendorLoadGroupParams");
			}
			try {
				new UnitOfWork<Boolean>() {

					@Override
					public Boolean runQueries() throws Exception {
						// get next sequence number (SCHN_SHLANE_LGRP_PARM_SEQ)  for each valid record 
						//And insert into Lane Load group param table 
						insertVendorGroupParams(getInsertLoadParamList(vendorGroupParamList,userId));
						
						return true;
					}
				};
			} catch (QueryException qe) {
				throw new DataOperationException(qe.getMessage(), qe);
			}
			return true;
		}
		
		/**
		 * Insert parameter details into SCHN_SHLANE_LGRP_PARM
		 * @param laneLoadGrpParamList
		
		
		
		
		 * @return Success or Failure * @throws QueryException * @throws EFSException  * @throws   
		 * @throws QueryException */
		public static  boolean insertVendorGroupParams(List<ParameterTO> laneLoadGrpParamList) throws  DataOperationException, QueryException {
			if (LOGGER.isDebugEnabled()) {
				
				LOGGER.debug(UploadConstants.ENTERING_METHOD + "insertVendorGroupParams");
			}
			
			if (laneLoadGrpParamList != null && laneLoadGrpParamList.size() > 0) {
				
				BatchData laneLoadGrpParamData  = new BatchData(EFS_VNDR_LGRP_PARAM);
				int row = 0;
				int rowsInserted;
				for (ParameterTO vendorLoadGroupParamTO : laneLoadGrpParamList) {
					laneLoadGrpParamData.add(row , 0, getNextLocationSeqId());
					laneLoadGrpParamData.add(row , 1, vendorLoadGroupParamTO.getCreateUserId());
					laneLoadGrpParamData.add(row , 2, vendorLoadGroupParamTO.getLastUpdatedUserId());
					laneLoadGrpParamData.add(row , 3, vendorLoadGroupParamTO.getLoadGroupId());
					laneLoadGrpParamData.add(row , 4, vendorLoadGroupParamTO.getLoadGroupParamCode());
					laneLoadGrpParamData.add(row , 5, vendorLoadGroupParamTO.getEffBeginDate());
					laneLoadGrpParamData.add(row , 6, vendorLoadGroupParamTO.getEffEndDate());
					laneLoadGrpParamData.add(row , 7, vendorLoadGroupParamTO.getCharValue()!= null ? vendorLoadGroupParamTO.getCharValue() : null);
					laneLoadGrpParamData.add(row , 8, vendorLoadGroupParamTO.getIntValue() != null ? vendorLoadGroupParamTO.getIntValue() : null );
					laneLoadGrpParamData.add(row , 9, vendorLoadGroupParamTO.getDecimalValue()!= null ? vendorLoadGroupParamTO.getDecimalValue() : null);
					laneLoadGrpParamData.add(row , 10, vendorLoadGroupParamTO.getFlagValue()!= null ? vendorLoadGroupParamTO.getFlagValue().toUpperCase() : null);
					row++;
				}
				
				rowsInserted = DAO.useJNDI(SupplyChainDistributionNetwork)
						.setSQL(INSERT_LGRP_VENDOR_PARM)
						.batch(laneLoadGrpParamData).length;
				if (laneLoadGrpParamList.size() == rowsInserted) {
					
					return true;
				}
			}
			
			return false;
		}
		
		
		/**
		 * To get the sequence number for Location ID.
		 * 
		
		
		 * @return integer- sequence next value * @throws EFSException */
		public static int getNextLocationSeqId() throws DataOperationException {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(UploadConstants.ENTERING_METHOD
						+ "getNextLocationSeqId");
			}
			List<BigDecimal> seqNbrList = new LinkedList<BigDecimal>();
			List<Integer> seqNbr = new ArrayList<Integer>();
			try {
				seqNbrList = DAO.useJNDI(SupplyChainDistributionNetwork)
						.setSQL(SHLANE_VNDR_PARM_SEQ_NBR).list(BigDecimal.class);
				for (BigDecimal id : seqNbrList) {
					seqNbr.add(id.intValue());
				}
			} catch (QueryException qe) {
				throw new DataOperationException(qe.getMessage(), qe);
			}
			return seqNbr.get(0);
		}
		
	/**
	 * Method getLoadGroupVendorId.
	 * @param vendorGrpTo VendorGroupParamTO
	 * @param error StringBuilder
	 * @param isDefaultParam 
	 * @throws EFSException
	 */
	public static List<Integer> getLoadGroupVendorId(final VendorGroupParamTO vendorGrpTo,final StringBuilder error, boolean isDefaultParam) throws DataOperationException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "getLoadGroupVendorId");
		}
		final List<Integer> vendorGroupIdList =  new ArrayList<Integer>();
		try {
			String loadGroupIdQuery = READ_LGRP_VNDR_ID;
			if (!isDefaultParam) {
				loadGroupIdQuery += inListLoadGrpBuilder(
						"SCHN_SHPG_LANE_LOAD_GRP_ID", vendorGrpTo,
						IN_LIST_MAX_SIZE);
			}
			DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(loadGroupIdQuery)
					.input(1, vendorGrpTo.getVendorNumber()).debug(true)
		.results(new ResultsReader() {
			@Override
			public void readResults(Results results, Query query,
							Inputs inputs) throws QueryException {
						if (results.next()) {

							vendorGroupIdList.add(results
									.getInt("SCHN_SHLANE_LGRP_VNDR_ID"));
						} else {

							error.append(UploadConstants.LGRP_VENDOR_ID_DOES_NOT_EXISTS);
						}

					}
		});
		} catch (QueryException qe) {
			throw new DataOperationException(qe.getMessage(), qe);
		}
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.EXIT_METHOD + "getLoadGroupVendorId");
		}
		return vendorGroupIdList;
	}
	
	
	/**
	 * Method will fetch all the active Locations from Location table 
	
	
	
	 * @param vendorGroupParamTO VendorGroupParamTO
	 * @param error StringBuilder
	 * @throws EFSException */
	public static void getActiveLocationIdList(
			final VendorGroupParamTO vendorGroupParamTO, final StringBuilder error) throws DataOperationException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "getActiveLoactionIdList");
		}
		try {
				String loactionIdQuery = READ_ACTIVE_LOCATION_ID;
				loactionIdQuery += inListBuilder("SRC_LOC_ID",
						vendorGroupParamTO, "location",
						IN_LIST_MAX_SIZE);
				DAO.useJNDI(SupplyChainDistributionNetwork)
				.setSQL( loactionIdQuery)
						.debug(true).results(new ResultsReader()
							{
								@Override
								public void readResults(Results results, Query query, Inputs inputs)
										throws QueryException {
									while(results.next()){
										if(results.getString("SRC_LOC_ID").equals(vendorGroupParamTO.getOrigin())){
											
											vendorGroupParamTO.setOriginId(results.getInt("SCHN_LOC_ID"));
										}
										
										else if(results.getString("SRC_LOC_ID").equals(vendorGroupParamTO.getDestination())){
											
											vendorGroupParamTO.setDestinationId(results.getInt("SCHN_LOC_ID"));
										}else{
											
											error.append(UploadConstants.LOCATION_ID_DOES_NOT_EXISTS);
										}
									}
								}
		
							});
		
		} catch (QueryException qe){
			throw new DataOperationException(qe.getMessage(), qe);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.EXIT_METHOD + "getActiveLoactionIdList");
		}
	
	}
	
	
	/**
	 * Method getLoadGroupIdList.
	 * @param vendorGrpTo VendorGroupParamTO
	 * @param error StringBuilder
	 * @throws EFSException
	 * @throws DataOperationException 
	 */
	public static void getLoadGroupIdList(final VendorGroupParamTO vendorGrpTo,final StringBuilder error) throws DataOperationException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "getLoadGroupIdList");
		}
	
		try {
			
			DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(READ_LOAD_GROUP_ID,
							vendorGrpTo.getOriginId(),
							vendorGrpTo.getDestinationId()).debug(true)
			.results(new ResultsReader() {
				@Override
				public void readResults(Results results, Query query,
								Inputs inputs) throws QueryException {
							StringBuilder groupId = new StringBuilder();
							while(results.next()) {
								
								groupId.append(results
										.getInt("SCHN_SHPG_LANE_LOAD_GRP_ID"));
								groupId.append("-");
							} 
							if (!EFSUtil.isEmpty(groupId.toString())) {
								vendorGrpTo
										.setLaneLoadGroupId(groupId.toString()
												.substring(
														0,
														groupId.toString()
																.length() - 1));
							} else {
								error.append(UploadConstants.LOAD_GROUP_ID_DOES_NOT_EXISTS);
							}
						}
			});
		} catch (QueryException qe ) {
			throw new DataOperationException(qe.getMessage(), qe);
		}
		
	}
	
	/**
	 * Utility method to generate IN clause query string
	 * 
	 * @param columnName
	
	 * @param listName
	 * @param maxSize
	
	
	 * @param vendorGrpTo VendorGroupParamTO
	 * @return String
	 * @throws QueryException */
	private static String inListBuilder(String columnName, VendorGroupParamTO vendorGrpTo ,String listName, int maxSize) throws QueryException{
		StringBuilder buff = new StringBuilder();
		
		buff.append(" AND ");
		buff.append(columnName);
		buff.append(" IN ( '");
		buff.append(vendorGrpTo.getOrigin());
		buff.append("', '" + vendorGrpTo.getDestination());
		buff.append("' ) ");
		return buff.toString();
	}

	
	/**
	 * Utility method to generate IN clause query string
	 * 
	 * @param columnName
	
	
	 * @param maxSize
	
	
	 * @param vendorGrpTo VendorGroupParamTO
	 * @return String
	 * @throws QueryException */
	private static String inListLoadGrpBuilder(String columnName, VendorGroupParamTO vendorGrpTo , int maxSize) throws QueryException{
		StringBuilder buff = new StringBuilder();
		String[] groupId = vendorGrpTo.getLaneLoadGroupId().split("-");
		buff.append(" AND ");
		buff.append(columnName);
		buff.append(" IN ( ");
		buff.append(groupId[0]);
		if (groupId.length > 1) {
			buff.append(", " + groupId[1]);
		}
		buff.append(" ) ");
		return buff.toString();
	}
	
	/**
	 * Method getInsertLoadParamList.
	 * @param vendorGroupParamList List<VendorGroupParamTO>
	 * @param userId String
	 * @return List<ParameterTO>
	 * @throws EFSException
	 */
	private static List<ParameterTO> getInsertLoadParamList(List<VendorGroupParamTO> vendorGroupParamList,String userId) throws EFSException {
		List<ParameterTO> insertLoadParamList = new ArrayList<ParameterTO>();
		for (VendorGroupParamTO vendorGroupParamTO :vendorGroupParamList) {
			for (ParameterTO loadParamTo : vendorGroupParamTO.getLoadParamList()) {
				loadParamTo.setCreateUserId(userId);
				loadParamTo.setLastUpdatedUserId(userId);
				loadParamTo.setLoadGroupId(vendorGroupParamTO.getVendorGroupId());
				loadParamTo.setEffBeginDate(ValidationUtil.convertStringToDate(vendorGroupParamTO.getEffectiveBeginDate()));
				loadParamTo.setEffEndDate(ValidationUtil.convertStringToDate(vendorGroupParamTO.getEffectiveEndDate()));
			}
			insertLoadParamList.addAll(vendorGroupParamTO.getLoadParamList());
		}
		
		return insertLoadParamList;
	}


}
