/**
 * AbstractCoordinate
 * 
 * version 0.1
 * 
 * date 10.11.2015
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

/**
 * Abstract version of a Coordinate to hide implementation from the client
 */
public abstract class AbstractCoordinate implements Coordinate{
	
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
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		
		return new CartesianCoordinate(x, y, z);
	}
	
	/**
	 * @methodtype get
	 */
	public double getDistance(Coordinate cd) {
		if(cd == null)
			throw new IllegalArgumentException("Error: parameter of method getDistance is zero!");
		
		CartesianCoordinate cCd = ((AbstractCoordinate) cd).asCartesianCoordinate();
		
		// Pythagoras' theorem
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		double otherX = cCd.getX();
		double otherY = cCd.getY();
		double otherZ = cCd.getZ();
		return Math.sqrt((otherX - x)*(otherX - x) + (otherY - y)*(otherY - y) + (otherZ - z)*(otherZ - z));
	}
	
	/**
	 * @methodtype comparison
	 */
	public boolean isEqual(Coordinate cd) {
		if (this == cd)
			return true;
		if (cd == null)
			return false;
		if(this.getDistance(cd) == 0.f)
			return true;
		return true;
	}
}
