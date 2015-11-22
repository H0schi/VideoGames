/**
 * AbstractCoordinate
 * 
 * version 0.2
 * 
 * date 17.11.2015
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

/**
 * Abstract version of a Coordinate to hide implementation from the client. Standard representation of a Coordinate is a CartesianCoordinate
 */
public abstract class AbstractCoordinate implements Coordinate {
	
	static final double EPSILON = 0.00001;
	
	/**
	 * @methodtype get
	 */
	public abstract double getX();
	
	/**
	 * @methodtype get
	 */
	public abstract double getY();
	
	/**
	 * @methodtype get
	 */
	public abstract double getZ();
	
	/**
	 * @methodtype get
	 * Precondition: cd is valid Coordinate: cd != null && cd.get...() is valid double value
	 * Postcondition: cd stays unchanged && cd stays valid && result is valid double value
	 */
	public double getDistance(Coordinate cd) {
		// Preconditions
		if(!isCoordinateValid(cd))
			throw new IllegalArgumentException("Error: Parameter is not a valid Coordinate object!");
		
		AbstractCoordinate absCd = (AbstractCoordinate) cd;
		
		// Pythagoras' theorem
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		double otherX = absCd.getX();
		double otherY = absCd.getY();
		double otherZ = absCd.getZ();
		double result = Math.sqrt((otherX - x)*(otherX - x) + (otherY - y)*(otherY - y) + (otherZ - z)*(otherZ - z));
		
		assert isCoordinateValid(this); // Invariant
		
		// Postcondition
		assert isValidDoubleValue(result);
		
		return result;
	}

	/**
	 * @methodtype comparison
	 * Precondition: cd is valid Coordinate: cd != null && cd.get...() is valid double value
	 * Postcondition: cd stays unchanged && cd stays valid
	 */
	public boolean isEqual(Coordinate cd) {
		// Preconditions
		if(!isCoordinateValid(cd))
			throw new IllegalArgumentException("Error: Parameter is not a valid Coordinate object!");
				
		boolean isEqual = false;
		if(this == cd)
			isEqual = true;
		if(this.getDistance(cd) == (0.f - EPSILON))
			isEqual = true;
		if(hasSameFields(this, cd))
			isEqual = true;		
		
		// Postconditions: none
		
		return isEqual;
	}
	
	/**
	 * @methodtype query
	 */
	protected boolean isCoordinateValid(Coordinate cd) {
		if(cd == null)
			return false;
		
		AbstractCoordinate absCd = (AbstractCoordinate) cd;
		boolean validX = isValidDoubleValue(absCd.getX());
		boolean validY = isValidDoubleValue(absCd.getY());
		boolean validZ = isValidDoubleValue(absCd.getZ());
		
		if(validX && validY && validZ)
			return true;
		return false;
	}
	
	/**
	 * @methodtype query
	 */
	protected boolean isValidDoubleValue(double value) {
		if(Double.isNaN(value) || Double.isInfinite(value))
			return false;
		return true;
	}
	
	/**
	 * @methodtype query
	 * Intended to check if a Coordinate Objekt is changed during a method
	 * Unnecessary, as Java passes parameters by value, see http://stackoverflow.com/a/40523
	 */
	protected boolean hasSameFields(Coordinate cd1, Coordinate cd2) {
		AbstractCoordinate absCd1 = (AbstractCoordinate) cd1;
		AbstractCoordinate absCd2 = (AbstractCoordinate) cd2;
		if(absCd1.getX() == absCd2.getX() && absCd1.getY() == absCd2.getY() && absCd1.getZ() == absCd2.getZ())
			return true;
		return false;
	}

}
