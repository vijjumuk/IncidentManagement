package com.homedepot.di.xd.efs.exception;

import org.junit.Test;

/**
 */
public class EFSExceptionTest {

	/**
	 * Method testEngineeredFlowException.
	 * @throws EFSException
	 */
	@Test(expected = EFSException.class)
	public void testEngineeredFlowException()
			throws EFSException {
		throw new EFSException();

	}

	/**
	 * Method testEngineeredFlowExceptionWithErrorMessage.
	 * @throws EFSException
	 */
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithErrorMessage()
			throws EFSException {
		throw new EFSException("Exception Occured");

	}
	
	/**
	 * Method testEngineeredFlowExceptionWithErrorMessageAndErrorCode.
	 * @throws EFSException
	 */
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithErrorMessageAndErrorCode()
			throws EFSException {
		throw new EFSException("Exception Occured",1);

	}
	
	/**
	 * Method testEngineeredFlowExceptionWithWarning.
	 * @throws EFSException
	 */
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithWarning()
			throws EFSException {
		throw new EFSException("Exception Occured",1,true);

	}
	
	/**
	 * Method testEngineeredFlowExceptionWithErrMsgAndCause.
	 * @throws EFSException
	 */
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithErrMsgAndCause()
			throws EFSException {
		Throwable cause = null;
		throw new EFSException("Exception Occured",cause);

	}

}
