package com.homedepot.di.xd.efs.exception;

import javax.ws.rs.WebApplicationException;

public class ApplicationException extends WebApplicationException {

	private static final long serialVersionUID = 561789325431646271L;

	/** 
	 * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
	 * the developer does not have to look into the response headers. If null a default 
	 */
	Integer status;
	
	/** application specific error code */
	int code; 
		
	/** detailed error description for developers*/
	String developerMessage;	
	
	/**
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param developerMessage
	 * @param link
	 */
	public ApplicationException(int status, int code, String message,
			String developerMessage) {
		super(status);
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public ApplicationException() { }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
}
