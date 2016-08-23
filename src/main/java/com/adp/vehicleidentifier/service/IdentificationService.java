/**
 * 
 */
package com.adp.vehicleidentifier.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adp.vehicleidentifier.bll.impl.IdentificationManagerImpl;
import com.adp.vehicleidentifier.bll.itf.IdentificationManager;
import com.adp.vehicleidentifier.common.exception.IdentificationException;
import com.adp.vehicleidentifier.dto.ErrorResponse;
import com.adp.vehicleidentifier.dto.Vehicles;
import com.adp.vehicleidentifier.dto.VehiclesResponse;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * This is a REST Endpoint for the Identification Management. 
 * All the HTTP based REST API will be exposed via this service class.
 * @author Prabal Srivastava
 * @since 1.0
 */
@Path("/identification")
public class IdentificationService {
	private static final Logger log = LoggerFactory.getLogger(IdentificationService.class);
	
	/**
     * REST API for uploading vehicle details.
     * @param vehicleDetailsStream - Vehicle identification xml file content.
     * 
     * @param vehicleDetailsDetail 	- Vehicle identification xml file meta data.
     * @return 					  	- Response contains details of vehicle identifications that was parsed. 
	 * @throws IdentificationException 
     * 								
     * @see UserResource
     */
	@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
	public Response parse(@FormDataParam("vehicleDetails") InputStream vehicleDetailsStream, @FormDataParam("vehicleDetails") FormDataContentDisposition vehicleDetailsDetail){
		log.info("Start parsing for file details {}", vehicleDetailsDetail);
		try {
			IdentificationManager manager = new IdentificationManagerImpl();
			VehiclesResponse response = manager.parse(vehicleDetailsStream, vehicleDetailsDetail);
			return Response.status(Status.fromStatusCode(200)).entity(response).build();
		} catch (IdentificationException e) {
            log.error(e.toString(), e);
            ErrorResponse error = new ErrorResponse(e.getErrorCode(), e.getErrorDescr());
            return Response.status(Status.fromStatusCode(e.getErrorCode())).entity(error).build();
        }
	}
}
