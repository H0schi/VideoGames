/**
 * CoordinateTest
 * 
 * version 0.4
 * 
 * date 24.11.2015
 * 
 * Thorsten Schwachhofer
 * 
 */

package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * All test cases of the class Coordinate.
 */
public class CoordinateTest {
	private final double epsilon = 0.0001;
	
	private SphericCoordinate sCdDefault;
	private SphericCoordinate sCd1;
	private SphericCoordinate sCd2;
	private SphericCoordinate sCd3;
	
	private CartesianCoordinate cCdDefault;
	private CartesianCoordinate cCd1;
	private CartesianCoordinate cCd2;
	private CartesianCoordinate cCd3;
	
	@Before
	public void setUp() {
		sCdDefault = new SphericCoordinate();
		sCd1 = new SphericCoordinate(90.0, 90.0);
		sCd2 = new SphericCoordinate(-50.0, 70.0);
		sCd3 = new SphericCoordinate(90.0, 90.0);
		
		cCdDefault = new CartesianCoordinate();
		cCd1 = new CartesianCoordinate(50.0, 50.0, 50.0);
		cCd2 = new CartesianCoordinate(-500.0, 500.0, 750.0);
		cCd3 = new CartesianCoordinate(50.0, 50.0, 50.0);
	}

	@Test
	public void testDefaultConstructor() {
		// default constructor should set latitude and longitude to 0 and radius to the radius of the earth (6371 km)
		assertEquals(0.0, sCdDefault.getLatitude(), epsilon);
		assertEquals(0.0, sCdDefault.getLongitude(), epsilon);
		assertEquals(6371.f, sCdDefault.getRadius(), epsilon);
		
		assertEquals(0.0, cCdDefault.getX(), epsilon);
		assertEquals(0.0, cCdDefault.getY(), epsilon);
		assertEquals(0.0, cCdDefault.getZ(), epsilon);
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
		double res = sCd1.getX();
		assertEquals(-2552.07172, res, epsilon);
	}
	
	@Test
	public void testGetY() {
		double res = sCd1.getY();
		assertEquals(5091.89454, res, epsilon);
	}
	
	@Test
	public void testGetZ() {
		double res = sCd1.getZ();
		assertEquals(-2854.67700, res, epsilon);
	}
	
	@Test
	public void testIsEqual() {
		assertTrue(sCd1.isEqual(sCd1));
		assertTrue(sCd1.isEqual(sCd3));
		
		assertTrue(cCd1.isEqual(cCd1));
		assertTrue(cCd1.isEqual(cCd3));
	}
	
	@Test
	public void testGetDistanceSameCoordinate() {
		double res = sCd1.getDistance(sCd1);
		assertEquals(0.0, res, epsilon);
		
		double res2 = cCd1.getDistance(cCd1);
		assertEquals(0.0, res2, epsilon);
	}
	
	@Test
	public void testGetDistanceWithCoordinateWithSameValues() {
		double res = sCd1.getDistance(sCd3);
		assertEquals(0.0, res, epsilon);
		
		double res2 = cCd1.getDistance(cCd3);
		assertEquals(0.0, res2, epsilon);
	}
	
	@Test
	public void testGetDistance() {
		double res = sCd1.getDistance(sCd2);
		assertEquals(10738.98931, res, epsilon);
		
		double res2 = cCd1.getDistance(cCd2);
		assertEquals(997.49686, res2, epsilon);
	}
	
	@Test
	public void testGetDistanceWithSameCoordinateAndConversionToCartesian() {
		double x = sCd1.getX();
		double y = sCd1.getY();
		double z = sCd1.getZ();
		CartesianCoordinate cd4 = new CartesianCoordinate(x, y, z);
		double res = sCd1.getDistance(cd4);
		assertEquals(0.0, res, epsilon);
	}
	
	@Test
	public void testGetDistanceWithConversionToCartesian() {
		double x = sCd2.getX();
		double y = sCd2.getY();
		double z = sCd2.getZ();
		CartesianCoordinate cd4 = new CartesianCoordinate(x, y, z);
		double res = sCd1.getDistance(cd4);
		assertEquals(10738.98931, res, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceWithNullPointer() {
		sCd1.getDistance(null);
		cCd1.getDistance(null);
	}
	
	@Test
	public void testWithDifferentCoordinates() {
		SphericCoordinate coordinate1 = new SphericCoordinate(90, 90);
		CartesianCoordinate coorindate2 = new CartesianCoordinate(50, 40, 100);
		
		assertEquals(coordinate1.getDistance(coorindate2), coorindate2.getDistance(coordinate1), epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sphericConstructorTest() {
		@SuppressWarnings("unused")
		SphericCoordinate coordinate = new SphericCoordinate(90, 90, Double.NaN);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void cartesianConstructorTest() {
		@SuppressWarnings("unused")
		CartesianCoordinate coordinate2 = new CartesianCoordinate(Double.NaN, Double.NaN, Double.NaN);
	}
	
}
