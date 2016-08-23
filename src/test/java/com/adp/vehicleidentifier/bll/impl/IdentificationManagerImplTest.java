/**
 * 
 */
package com.adp.vehicleidentifier.bll.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.adp.vehicleidentifier.bll.itf.IdentificationManager;

/**
 * JUnit for utility methods.
 * @author Prabal Srivatava
 * @version 1.0
 */
public class IdentificationManagerImplTest {
	/* This is the reference of the utility class for the testing its methods. */
	private static IdentificationManager manager;

	@BeforeClass
	public static void init() {
		manager = new IdentificationManagerImpl();
	}

	@AfterClass
	public static void destroy() {
		manager = null;
	}
}
