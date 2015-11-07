/**
 * CoordinateTest
 * 
 * version 0.3
 * 
 * date 07.11.2015
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
	
	@Test
	public void testWithDifferentCoordinates() {
		SphericCoordinate cd1 = new SphericCoordinate(90, 90);
		CartesianCoordinate cd2 = new CartesianCoordinate(50, 40, 100);
		
		assertEquals(cd1.getDistance(cd2), cd2.getDistance(cd1), epsilon);
	}
	
}
