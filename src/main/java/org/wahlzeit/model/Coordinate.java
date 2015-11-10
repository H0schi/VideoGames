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
	 */
	public double getDistance(Coordinate cd);
	
	/**
	 * @methodtype comparison
	 */
	public boolean isEqual(Coordinate cd);
	
}
