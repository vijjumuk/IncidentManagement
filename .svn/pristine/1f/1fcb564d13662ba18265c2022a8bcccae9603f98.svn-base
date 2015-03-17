/**
 * 
 */
package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author
 * 
 * @version $Revision: 1.0 $
 */
public class ResponseTO implements Serializable {

	private static final long serialVersionUID = 2284337887950257037L;

	/**
	 * Field returnCode.
	 */
	private int returnCode;
	/**
	 * Field returnMessage.
	 */
	private String returnMessage;
	/**
	 * Field errorMsg.
	 */
	private String errorMsg;
	/**
	 * Field results.
	 */
	private ArrayList<?> results;

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {

		return "ResponseTO [" + "returnCode :" + returnCode
				+ " returnMessage :" + returnMessage + " errorMsg :" + errorMsg
				+ " results :" + results + "]";
	}

	/**
	 * Method setReturnCode.
	 * 
	 * @param returnCode
	 *            int
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Method getReturnCode.
	 * 
	 * @return int
	 */
	public int getReturnCode() {
		return returnCode;
	}

	/**
	 * Method setReturnMessage.
	 * 
	 * @param returnMessage
	 *            String
	 */
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;

	}

	/**
	 * Method getReturnMessage.
	 * 
	 * @return String
	 */
	public String getReturnMessage() {
		return returnMessage;
	}

	/**
	 * Method setErrorMsg.
	 * 
	 * @param errorMsg
	 *            String
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;

	}

	/**
	 * Method getErrorMsg.
	 * 
	 * @return String
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Method setResults.
	 * 
	 * @param results
	 *            ArrayList<?>
	 */
	public void setResults(ArrayList<?> results) {
		this.results = results;

	}

	/**
	 * Method getResults.
	 * 
	 * @return ArrayList<?>
	 */
	public ArrayList<?> getResults() {
		return results;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMsg == null) ? 0 : errorMsg.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + returnCode;
		result = prime * result
				+ ((returnMessage == null) ? 0 : returnMessage.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseTO other = (ResponseTO) obj;
		if (errorMsg == null) {
			if (other.errorMsg != null)
				return false;
		} else if (!errorMsg.equals(other.errorMsg))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (returnCode != other.returnCode)
			return false;
		if (returnMessage == null) {
			if (other.returnMessage != null)
				return false;
		} else if (!returnMessage.equals(other.returnMessage))
			return false;
		return true;
	}

}
