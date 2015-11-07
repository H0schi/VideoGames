/**
 * CartesianCoordinate
 * 
 * version 0.1
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

public class CartesianCoordinate implements Coordinate{
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		this.x = 0.f;
		this.y = 0.f;
		this.z = 0.f;
	}
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * @methodtype get
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * @methodtype get
	 */
	public double getZ() {
		return this.z;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate cd) {
		if(cd == null)
			throw new IllegalArgumentException("Error: parameter of method getDistance is zero!");
		
		// Pythagoras' theorem
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		double otherX = cd.getX();
		double otherY = cd.getY();
		double otherZ = cd.getZ();
		return Math.sqrt(Math.pow(otherX - x, 2) + Math.pow(otherY - y, 2) + Math.pow(otherZ - z, 2));
	}

	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate cd) {
		if (this == cd)
			return true;
		if (cd == null)
			return false;
		if(this.getDistance(cd) == 0.f)
			return true;
		if (!(cd instanceof CartesianCoordinate))
			return false;
		CartesianCoordinate other = (CartesianCoordinate) cd;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

}
