/**
 * 
 */
package com.adp.vehicleidentifier.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.adp.vehicleidentifier.common.exception.IdentificationException;
import com.adp.vehicleidentifier.dto.Vehicles;
import com.adp.vehicleidentifier.dto.Vehicles.Powertrain;
import com.adp.vehicleidentifier.dto.Vehicles.Vehicle;
import com.adp.vehicleidentifier.dto.Vehicles.Wheel;
import com.adp.vehicleidentifier.dto.Vehicles.Wheels;
import com.adp.vehicleidentifier.dto.VehiclesResponse;
import com.adp.vehicleidentifier.dto.VehiclesResponse.Summary;
import com.adp.vehicleidentifier.dto.VehiclesResponse.VehicleDto;

/**
 * This is a utility class and will be used to perform various helper 
 * methods to perform various task within the application.
 * @author Prabal Srivastava
 * @version 1.0
 */
public class Utility {

	public Vehicles parse(InputStream vehicleDetailsStream) throws IdentificationException {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (Vehicles) jaxbUnmarshaller.unmarshal(vehicleDetailsStream);
		}catch(JAXBException e){
			throw new IdentificationException(500, "XML format is not proper.");
		}catch(IllegalArgumentException e){
			throw new IdentificationException(500, "No data found.");
		}
	}

	public VehiclesResponse formatData(Vehicles vehicles) throws IdentificationException {
		if(null == vehicles){
			throw new IdentificationException(500, "Invalid input date.");
		}
		VehiclesResponse vehiclesResponse = new VehiclesResponse();
		List<VehicleDto> vehicleDtos = new ArrayList<VehicleDto>();
		Map<String,Long> summaryData  = new HashMap<String, Long>();
		List<Summary> summarys = new ArrayList<Summary>();
		VehicleDto vehicleDto = null;
		for(Vehicle vehicle : vehicles.getVehicles()){
			vehicleDto = new VehicleDto();
			
			vehicleDto.setId(vehicle.getId());
			vehicleDto.setFrame(vehicle.getFrame().getMaterial());
			vehicleDto.setPowertrain(getPowertrain(vehicle.getPowertrain()));
			vehicleDto.setType(getVehicleType(vehicleDto.getPowertrain(), vehicleDto.getFrame(), vehicle.getWheels()));
			vehicleDto.setWheels(getVehicleWheels(vehicle.getWheels()));
			
			Long count = summaryData.get(vehicleDto.getType());
			if(null == count){
				count = 1l;
			}else{
				count ++;
			}
			summaryData.put(vehicleDto.getType(), count);
			vehicleDtos.add(vehicleDto);
		}
		for(String type : summaryData.keySet()){
			summarys.add(new Summary(type, summaryData.get(type)));
		}
		vehiclesResponse.setVehicles(vehicleDtos);
		vehiclesResponse.setSummary(summarys);
		return vehiclesResponse;
	}

	private String getVehicleWheels(Wheels wheels) {
		String wheelDetails = null;
		if(null == wheels || wheels.getWheel().isEmpty()){
			wheelDetails = "NONE";
		}else {
			wheelDetails = String.valueOf(wheels.getWheel().size())+ " "+ wheels.getWheel().get(0).getMaterial() + " (";
			for(Wheel wheel : wheels.getWheel()){
				wheelDetails += wheel.getPosition() + ", ";
			}
			wheelDetails += ")";
		}
		
		return wheelDetails;
	}

	private String getVehicleType(String powertrain, String frame, Wheels wheels) {
		String type = null;
		if(powertrain.equals("HUMAN") && frame.equals("plastic") && wheels.getWheel().size() == 3){
			type = "Big Wheel";
		} else if(powertrain.equals("HUMAN") && frame.equals("metal") && wheels.getWheel().size() == 2){
			type = "Bicycle";
		} else if(powertrain.equals("INTERNAL COMBUSTION") && frame.equals("metal") && wheels.getWheel().size() == 2){
			type = "Motor Cycle";
		} else if(powertrain.equals("BERNOULLI") && frame.equals("plastic") && null == wheels || wheels.getWheel().isEmpty()){
			type = "Hang Glider";
		} else if(powertrain.equals("INTERNAL COMBUSTION") && frame.equals("metal") &&  wheels.getWheel().size() == 4){
			type = "Car";
		} else {
			type = "UNKNOWN";
		}
		return type;
	}

	private String getPowertrain(Powertrain powertrain) {
		String powertrainDto  = null;
		if(null != powertrain.getHuman()){
			powertrainDto = "HUMAN";
		}else if(null != powertrain.getBernoulli()){
			powertrainDto = "BERNOULLI";
		}else if(null != powertrain.getInternalCombustion()){
			powertrainDto = "INTERNAL COMBUSTION";
		}else {
			powertrainDto = "UNKNOWN";
		}
		return powertrainDto;
	}
}
