package com.adp.vehicleidentifier.bll.impl;

import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adp.vehicleidentifier.bll.itf.IdentificationManager;
import com.adp.vehicleidentifier.common.exception.IdentificationException;
import com.adp.vehicleidentifier.dto.Vehicles;
import com.adp.vehicleidentifier.dto.VehiclesResponse;
import com.adp.vehicleidentifier.util.Utility;
import com.sun.jersey.core.header.FormDataContentDisposition;

/**
 * This is the business layer interface for Management. All the CRUD actions
 * related to management would be defined here.
 * 
 * @author Prabal Srivastava
 * @since 1.0
 */
public class IdentificationManagerImpl implements IdentificationManager {
	private static final Logger log = LoggerFactory.getLogger(IdentificationManagerImpl.class);

	@Override
	public VehiclesResponse parse(InputStream vehicleDetailsStream, FormDataContentDisposition vehicleDetailsDetail)
			throws IdentificationException {
		VehiclesResponse response = null;
		Utility utility = new Utility();
		// parse the data
		Vehicles vehicles = utility.parse(vehicleDetailsStream);
		// format the data
		response = utility.formatData(vehicles);
		return response;
	}
}
