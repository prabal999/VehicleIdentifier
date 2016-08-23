package com.adp.vehicleidentifier.util;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.adp.vehicleidentifier.common.exception.IdentificationException;
import com.adp.vehicleidentifier.dto.Vehicles;
import com.adp.vehicleidentifier.dto.VehiclesResponse;

/**
 * JUnit for utility methods.
 * @author Prabal Srivastava
 * @version 1.0
 */
public class UtilityTest {
	/* This is the reference of the utility class for the testing its methods. */
	private static Utility util;

	@BeforeClass
	public static void init() {
		util = new Utility();
	}

	@AfterClass
	public static void destroy() {
		util = null;
	}

	/**
	 * This JUnit will test if the count of vehicles are correct
	 * for vaid xml or not.
	 */
	@Test
	public void shouldReturnValidVehicleCountForValidXML() throws IdentificationException {
		InputStream vehicleDetailsStream = getClass().getClassLoader().getResourceAsStream("valid-vehicles.xml");
		Vehicles vehicles = util.parse(vehicleDetailsStream);
		assertEquals(2, vehicles.getVehicles().size());
	}

	/**
	 * This JUnit will test and expect custom exception for null data.
	 */
	@Test(expected = IdentificationException.class)
	public void shouldThrowsExceptionForNull() throws IdentificationException {
		util.parse(null);
	}

	/**
	 * This JUnit will test and expect custom exception for invalid xml.
	 */
	@Test(expected = IdentificationException.class)
	public void shouldThrowsExceptionForInvaidXML() throws IdentificationException {
		InputStream vehicleDetailsStream = getClass().getClassLoader().getResourceAsStream("invalid-vehicles.xml");
		util.parse(vehicleDetailsStream);
	}

	/**
	 * This JUnit will test the type vehicle use-case for valid data.
	 */
	@Test
	public void shouldReturnValidVehicleType() throws IdentificationException {
		InputStream vehicleDetailsStream = getClass().getClassLoader().getResourceAsStream("valid-vehicles.xml");
		Vehicles vehicles = util.parse(vehicleDetailsStream);
		VehiclesResponse response = util.formatData(vehicles);
		assertEquals("Big Wheel", response.getVehicles().get(0).getType());
	}

	/**
	 * This JUnit will test and expect custom exception for null data.
	 */
	@Test(expected = IdentificationException.class)
	public void shouldThrowsExceptionForInvaidData() throws IdentificationException {
		util.formatData(null);
	}
}
