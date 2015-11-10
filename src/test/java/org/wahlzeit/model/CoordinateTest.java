/**
 * CoordinateTest
 * 
 * version 0.3
 * 
 * date 07.11.2015
 * 
 * Thorsten Schwachhofer
 * 
 */

package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * All test cases of the class Coordinate.
 */
public class CoordinateTest {
	
	private final double epsilon = 0.0001;
	
	@Test
	public void testWithDifferentCoordinates() {
		SphericCoordinate cd1 = new SphericCoordinate(90, 90);
		CartesianCoordinate cd2 = new CartesianCoordinate(50, 40, 100);
		
		assertEquals(cd1.getDistance(cd2), cd2.getDistance(cd1), epsilon);
	}
	
}
