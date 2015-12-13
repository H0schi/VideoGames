/**
 * CartesianCoordinate
 * 
 * version 0.6
 * 
 * date 09.12.2015
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

/**
 * Cartesian representation of a Coordinate
 */
public class CartesianCoordinate extends AbstractCoordinate {
	
	private final double x;
	private final double y;
	private final double z;
	
	/**
	 * @methodtype factory method
	 */
	public static CartesianCoordinate getInstance() {
		return getInstance(0.f, 0.f, 0.f);
	}
	
	/**
	 * @methodtype factory method
	 */
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
		AbstractCoordinate res = instances.get(tmp.hashCode());
		if(res == null || !res.equals(tmp) || !(res instanceof CartesianCoordinate)) {
			synchronized(instances) {
				if(res == null || !res.equals(tmp) || !(res instanceof CartesianCoordinate)){
					instances.put(tmp.hashCode(), tmp);
					res = tmp;
				}
			}
		}
		
		return (CartesianCoordinate) res;
	}
	
	/**
	 * @methodtype constructor
	 */
	private CartesianCoordinate() {
		this(0.f, 0.f, 0.f);
	}
	
	/**
	 * @methodtype constructor
	 * Precondition: parameters are valid double values
	 */
	private CartesianCoordinate(double x, double y, double z) {
		// Precondition
		if(!isValidDoubleValue(x) || !isValidDoubleValue(y) || !isValidDoubleValue(z))
			throw new IllegalArgumentException("Error: Parameter is not a valid double value");
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		// Postcondition
		assertClassInvariants();
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
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() {
		assert isValidDoubleValue(x);
		assert isValidDoubleValue(y);
		assert isValidDoubleValue(z);
	}

}
