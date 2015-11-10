/**
 * CartesianCoordinate
 * 
 * version 0.2
 * 
 * date 10.11.2015
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

/**
 * Cartesian representation of a Coordinate
 */
public class CartesianCoordinate extends AbstractCoordinate {
	
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
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate cd) {
		if(!super.isEqual(cd))
			return false;
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
