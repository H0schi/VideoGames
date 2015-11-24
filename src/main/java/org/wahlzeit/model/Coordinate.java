/**
 * Coordinate
 * 
 * version 0.7
 * 
 * date 24.11.2015
 * 
 * Thorsten Schwachhofer
 * 
 */

package org.wahlzeit.model;

/**
 * A Coordinate represents a place and is able to calculate distances
 */
public interface Coordinate {
	
	/**
	 * @methodtype get
	 * Precondition: cd is valid Coordinate: cd != null && cd.get...() is valid double value
	 * Postcondition: cd stays valid && result is valid double value && result >= 0
	 */
	public double getDistance(Coordinate cd);
	
	/**
	 * @methodtype comparison
	 * Precondition: cd is valid Coordinate: cd != null && cd.get...() is valid double value
	 * Postcondition: cd stays valid
	 */
	public boolean isEqual(Coordinate cd);
	
}
