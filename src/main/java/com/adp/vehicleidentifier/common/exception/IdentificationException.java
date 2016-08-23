/**
 * 
 */
package com.adp.vehicleidentifier.common.exception;


/**
 * This is the application specific exception class for Vehicles Identification.
 * Any custom error codes or exceptions due to business validations or
 * business rules-engine will be defined here.
 * @author Prabal Srivastava
 * @since  1.0
 */
public class IdentificationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -97489601876868146L;
	
	/**
	 * This will represent the error code i.e Standard HTTP Codes.
	 * 
	 */
	private int errorCode;
	/**
	 * This will represent the error description
	 */
	private String errorDescr;
	
	/**
	 * @param message
	 * @param cause
	 */
	public IdentificationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public IdentificationException(String message) {
		super(message);
	}

	/**
	 * Default Constructor
	 */
	public IdentificationException() {
        super();
    }

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescr
	 */
	public String getErrorDescr() {
		return errorDescr;
	}

	/**
	 * @param errorDescr the errorDescr to set
	 */
	public void setErrorDescr(String errorDescr) {
		this.errorDescr = errorDescr;
	}

	/**
	 * @param errorCode
	 * @param errorDescr
	 */
	public IdentificationException(int errorCode, String errorDescr) {
		this.errorCode = errorCode;
		this.errorDescr = errorDescr;
	}
}
