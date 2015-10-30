/**
 * CoordinateTest
 * 
 * version 0.2
 * 
 * date 30.10.2015
 * 
 * Copyright (c) by Thorsten Schwachhofer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
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
	
	private Coordinate cdDefault;
	private Coordinate cd1;
	private Coordinate cd2;
	
	@Before
	public void setUp() {
		cdDefault = new Coordinate();
		cd1 = new Coordinate(100.0, 90.0);
		cd2 = new Coordinate(-50.0, 70.0);
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, cdDefault.getLatitude(), epsilon);
		assertEquals(0.0, cdDefault.getLongitude(), epsilon);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructorWithIllegalArguments() {
		try {
			Coordinate wrong1 = new Coordinate(1000, 0);
			fail("Should throw IllegalArgumentException because of latitude!");
		} catch (IllegalArgumentException e) {}
		try {
			Coordinate wrong2 = new Coordinate(0, 100);
			fail("Should throw IllegalArgumentException because of longitude!");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetLatitudeDistance() {
		double res = cd1.getLatitudinalDistance(cd2);
		assertEquals(-150.0, res, epsilon); // -50 - 100
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetLatitudeWithNullPointer() {
		cd1.getLatitudinalDistance(null);
	}
	
	@Test
	public void testGetLongitudeDistance() {
		double res = cd1.getLongitudinalDistance(cd2);
		assertEquals(-20.0, res, epsilon); // 70 - 90
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetLongitudeWithNullPointer() {
		cd1.getLongitudinalDistance(null);
	}
	
	@Test
	public void testGetDistanceSameCoordinate() {
		double res = cd1.getDistance(cd1);
		assertEquals(0.0, res, epsilon);
	}
	
	@Test
	public void testGetDistance() {
		double res = cd1.getDistance(cd2);
		assertEquals(8681.02436, res, epsilon);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetDistanceWithNullPointer() {
		cd1.getDistance(null);
	}
	
}
