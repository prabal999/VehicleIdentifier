
package com.adp.vehicleidentifier.dto;

/**
 * This class will be used to build the error responses.
 * It will contain error codes as well as error description.
 * 
 * @author Prabal Srivastava
 * @since  1.0
 */
public class ErrorResponse {
    
    /**
     * This will represent the error code i.e Standard HTTP Codes. Default error
     * code = 500
     */
    private int errorCode = 500;
    /**
     * This will represent the error description
     */
    private String errorDescr;
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
     * @param errorCode
     * @param errorDescr
     */
    public ErrorResponse(int errorCode, String errorDescr) {
        super();
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
    }
    /**
     * 
     */
    public ErrorResponse() {
        super();
    }   
    
}
