/**
 * SphericCoordinateTest
 * 
 * version 0.2
 * 
 * date 10.11.2015
 * 
 * Copyright (c) by Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {
	private final double epsilon = 0.0001;
	private final double largeEpsilon = 1200;
	
	private SphericCoordinate cdDefault;
	private SphericCoordinate cd1;
	private SphericCoordinate cd2;
	private SphericCoordinate cd3;
	
	@Before
	public void setUp() {
		cdDefault = new SphericCoordinate();
		cd1 = new SphericCoordinate(90.0, 90.0);
		cd2 = new SphericCoordinate(-50.0, 70.0);
		cd3 = new SphericCoordinate(90.0, 90.0);
	}
	
	@Test
	public void testDefaultConstructor() {
		// default constructor should set latitude and longitude to 0 and radius to the radius of the earth (6371 km)
		assertEquals(0.0, cdDefault.getLatitude(), epsilon);
		assertEquals(0.0, cdDefault.getLongitude(), epsilon);
		assertEquals(6371.f, cdDefault.getRadius(), epsilon);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructorWithIllegalArguments() {
		try {
			Coordinate wrong1 = new SphericCoordinate(1000, 0);
			fail("Should throw IllegalArgumentException because of latitude!");
		} catch (IllegalArgumentException e) {}
		try {
			Coordinate wrong2 = new SphericCoordinate(0, 1000);
			fail("Should throw IllegalArgumentException because of longitude!");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetX() {
		double res = cd1.getX();
		assertEquals(-2552.07172, res, epsilon);
	}
	
	@Test
	public void testGetY() {
		double res = cd1.getY();
		assertEquals(5091.89454, res, epsilon);
	}
	
	@Test
	public void testGetZ() {
		double res = cd1.getZ();
		assertEquals(-2854.67700, res, epsilon);
	}
	
	@Test
	public void testIsEqual() {
		assertTrue(cd1.isEqual(cd1));
		assertTrue(cd1.isEqual(cd3));
	}
	
	@Test
	public void testGetDistanceSameCoordinate() {
		double res = cd1.getDistance(cd1);
		assertEquals(0.0, res, epsilon);
	}
	
	@Test
	public void testGetDistanceWithCoordinateWithSameValues() {
		double res = cd1.getDistance(cd3);
		assertEquals(0.0, res, epsilon);
	}
	
	@Test
	public void testGetDistance() {
		double res = cd1.getDistance(cd2);
		assertEquals(9637.06850, res, largeEpsilon);
	}
	
	@Test
	public void testGetDistanceWithSameCoordinateAndConversionToCartesian() {
		double x = cd1.getX();
		double y = cd1.getY();
		double z = cd1.getZ();
		CartesianCoordinate cd4 = new CartesianCoordinate(x, y, z);
		double res = cd1.getDistance(cd4);
		assertEquals(0.0, res, epsilon);
	}
	
	@Test
	public void testGetDistanceWithConversionToCartesian() {
		double x = cd2.getX();
		double y = cd2.getY();
		double z = cd2.getZ();
		CartesianCoordinate cd4 = new CartesianCoordinate(x, y, z);
		double res = cd1.getDistance(cd4);
		assertEquals(9637.06850, res, largeEpsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceWithNullPointer() {
		cd1.getDistance(null);
	}
}
