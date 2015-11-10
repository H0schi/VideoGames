/**
 * CartesianCoordinateTest
 * 
 * version 0.1
 * 
 * date 07.11.2015
 * 
 * Thorsten Schwachhofer
 * 
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {

	private final double epsilon = 0.0001;
	
	private CartesianCoordinate cdDefault;
	private CartesianCoordinate cd1;
	private CartesianCoordinate cd2;
	private CartesianCoordinate cd3;
	
	@Before
	public void setUp() {
		cdDefault = new CartesianCoordinate();
		cd1 = new CartesianCoordinate(50.0, 50.0, 50.0);
		cd2 = new CartesianCoordinate(-500.0, 500.0, 750.0);
		cd3 = new CartesianCoordinate(50.0, 50.0, 50.0);
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, cdDefault.getX(), epsilon);
		assertEquals(0.0, cdDefault.getY(), epsilon);
		assertEquals(0.0, cdDefault.getZ(), epsilon);
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
		assertEquals(997.49686, res, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceWithNullPointer() {
		cd1.getDistance(null);
	}
	
}
