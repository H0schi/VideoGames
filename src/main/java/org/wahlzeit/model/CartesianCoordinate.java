/**
 * CartesianCoordinate
 * 
 * version 0.4
 * 
 * date 22.11.2015
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
	 * Precondition: parameters are valid double values
	 */
	public CartesianCoordinate(double x, double y, double z) {
		// Precondition
		if(!isValidDoubleValue(x) || !isValidDoubleValue(y) || !isValidDoubleValue(z))
			throw new IllegalArgumentException("Error: Parameter is not a valid double value");
		
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
		// Preconditons: see superclass
		Coordinate copy = cd;
		
		boolean isEqual = true;
		if (!super.isEqual(cd))
			isEqual = false;
		if (!(cd instanceof CartesianCoordinate))
			isEqual = false;
		if (isEqual == false) {
			// Postcondition
			assert hasSameFields(cd, copy);
			return isEqual;
		}
			
		CartesianCoordinate other = (CartesianCoordinate) cd;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			isEqual = false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			isEqual = false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			isEqual = false;
		
		// Postcondition
		assert hasSameFields(cd, copy);
		
		return isEqual;
	}

}
