package com.adp.vehicleidentifier.bll.itf;

import java.io.InputStream;

import com.adp.vehicleidentifier.common.exception.IdentificationException;
import com.adp.vehicleidentifier.dto.VehiclesResponse;
import com.sun.jersey.core.header.FormDataContentDisposition;

/**
 * This is the business layer interface for Management.
 * All the CRUD actions related to management would be defined here.
 * 
 * @author Prabal Srivastava
 * @since  1.0
 */
public interface IdentificationManager {
	/**
     * This API is for parsing uploaded vehicle details.
     * @param vehicleDetailsStream - Vehicle identification xml file content.
     * 
     * @param vehicleDetailsDetail 	- Vehicle identification xml file meta data.
     * @return 					  	- Response contains details of vehicle identifications that was parsed. 
     * 								
     * @see VehiclesResponse
     */
	VehiclesResponse parse(InputStream vehicleDetailsStream, FormDataContentDisposition vehicleDetailsDetail) throws IdentificationException;
}
