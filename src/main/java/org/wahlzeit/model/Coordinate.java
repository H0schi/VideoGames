/**
 * Coordinate
 * 
 * version 0.6
 * 
 * date 10.11.2015
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
	 * Precondition: cd is valid Coordinate: cd != null && cd has fields with valid values
	 * Postcondition: cd stays unchanged && cd stays valid && result is valid double value
	 */
	public double getDistance(Coordinate cd);
	
	/**
	 * @methodtype comparison
	 * Precondition: cd is valid Coordinate: cd != null && cd has fields with valid values
	 * Postcondition: cd stays unchanged && cd stays valid
	 */
	public boolean isEqual(Coordinate cd);
	
}
