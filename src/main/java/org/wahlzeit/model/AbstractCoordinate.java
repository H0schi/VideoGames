/**
 * AbstractCoordinate
 * 
 * version 0.4
 * 
 * date 09.12.2015
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

import java.util.HashMap;

/**
 * Abstract version of a Coordinate to hide implementation from the client. Standard representation of a Coordinate is a CartesianCoordinate
 */
public abstract class AbstractCoordinate implements Coordinate {
	
	static final double EPSILON = 0.00001;
	static final int MAX_SIZE = 1024;
	
	protected static HashMap<Integer, AbstractCoordinate> instances = new HashMap<>(MAX_SIZE);
	
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
	 * Postcondition: cd stays valid && result is valid double value && result >= 0
	 */
	public double getDistance(Coordinate cd) {
		// Preconditions
		if(cd == null)
			throw new IllegalArgumentException("Error: Parameter must not be null!");
		if(!isAbsCoordinateValid(cd))
			throw new IllegalArgumentException("Error: Coordinate is not valid!");
		
		AbstractCoordinate absCd = (AbstractCoordinate) cd;
		
		// Pythagoras' theorem
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		double otherX = absCd.getX();
		double otherY = absCd.getY();
		double otherZ = absCd.getZ();
		double result = Math.sqrt((otherX - x)*(otherX - x) + (otherY - y)*(otherY - y) + (otherZ - z)*(otherZ - z));
		
		// Postconditions
		assert isValidDoubleValue(result);
		assert result >= 0: "Result of getDistance is negative!";
		assert isAbsCoordinateValid(cd);
		assertClassInvariants();
		
		return result;
	}

	/**
	 * @methodtype comparison
	 * Precondition: cd is valid Coordinate: cd != null && cd.get...() is valid double value
	 * Postcondition: cd stays valid
	 */
	public boolean isEqual(Coordinate cd) {
		// Preconditions
		if(cd == null)
			throw new IllegalArgumentException("Error: Parameter must not be null!");
		if(!isAbsCoordinateValid(cd))
			throw new IllegalArgumentException("Error: Coordinate is not valid!");
				
		boolean isEqual = false;
		if(this == cd)
			isEqual = true;
		if(this.getDistance(cd) <= EPSILON)
			isEqual = true;	
		
		AbstractCoordinate absCd = (AbstractCoordinate) cd;
		if((this.getX() - absCd.getX()) <= EPSILON
				&&(this.getY() - absCd.getY()) <= EPSILON
				&&(this.getZ() - absCd.getZ()) <= EPSILON)
			isEqual = true;
		
		// Postconditions
		assert isAbsCoordinateValid(cd);
		assertClassInvariants();
		
		return isEqual;
	}
		
	/**
	 * @methodtype comparison
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.getZ());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/**
	 * 
	 */
	
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
	 */
	protected boolean isAbsCoordinateValid(Coordinate cd) {
		AbstractCoordinate absCd = (AbstractCoordinate) cd;
		boolean validX = isValidDoubleValue(absCd.getX());
		boolean validY = isValidDoubleValue(absCd.getY());
		boolean validZ = isValidDoubleValue(absCd.getZ());
		
		if(validX && validY && validZ)
			return true;
		return false;
	}
	
	/**
	 * @methodtype assertion
	 */
	protected abstract void assertClassInvariants();

}
