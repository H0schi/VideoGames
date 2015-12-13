/**
 * SphericCoordinate
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
 * Spherical representation of a Coordinate
 */
public class SphericCoordinate extends AbstractCoordinate {

	private final double latitude;
	private final double longitude;
	private final double radius;
	
	/**
	 * @methodtype factory method
	 */
	public static SphericCoordinate getInstance() {
		return getInstance(0.f, 0.f, 6371.f);
	}
	
	/**
	 * @methodtype factory method
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude) {
		return getInstance(latitude, longitude, 6371.f);
	}
	
	/**
	 * @methodtype factory method
	 * Precondition: latitude, longitude and radius are valid doubles and valid spheric values -> see constructor
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
		SphericCoordinate tmp = new SphericCoordinate(latitude, longitude, radius);
		AbstractCoordinate res = instances.get(tmp.hashCode());
		if(res == null || !res.equals(tmp) || !(res instanceof SphericCoordinate)) {
			synchronized(instances) {
				if(res == null || !res.equals(tmp) || !(res instanceof SphericCoordinate)) {
					instances.put(tmp.hashCode(), tmp);
					res = tmp;
				}
			}
		}
		
		return (SphericCoordinate) res;
	}

	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate() {
		this(0.f, 0.f, 6371.f);
	}
	
	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate(double latitude, double longitude) {
		this(latitude, longitude, 6371.f);
	}
	
	/**
	 * @methodtype constructor
	 * Precondition: parameters are valid double values, latitude, longitude and radius are valid, radius > 0
	 * Postcondition: assertClassInvariants
	 */
	private SphericCoordinate(double latitude, double longitude, double radius) {
		// Preconditions
		if(!isValidDoubleValue(latitude) || !isValidDoubleValue(longitude) || !isValidDoubleValue(radius))
			throw new IllegalArgumentException("Error: Parameter is not a valid double value");
		if(!isLatLonValid(latitude, longitude))
			throw new IllegalArgumentException("Error: Latitude must be between -90 and 90, Longitude between -180 and 180!");
		if(radius < 0)
			throw new IllegalArgumentException("Error: Radius must not be negative!");
		
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
		// Postcondition
		assertClassInvariants();
	}
	
	/**
	 * @methodtype query
	 */
	private boolean isLatLonValid(double latitude, double longitude) {
		if(latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180)
			return false;
		return true;
	}

	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * @methodtype get
	 */
	@Override
	public double getX() {
		// for conversion spherical -> cartesian see http://mathinsight.org/spherical_coordinates
		double result = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		
		// Postcondition
		assert isValidDoubleValue(result);
		assertClassInvariants();
		
		return result;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getY() {
		double result = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		
		// Postcondition
		assert isValidDoubleValue(result);
		assertClassInvariants();
		
		return result;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getZ() {
		double result = this.radius * Math.cos(this.longitude);
		
		// Postcondition
		assert isValidDoubleValue(result);
		assertClassInvariants();
		
		return result;
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() {
		assert isValidDoubleValue(latitude);
		assert isValidDoubleValue(longitude);
		assert isValidDoubleValue(radius);
		assert isLatLonValid(latitude, longitude);
		assert radius > 0;
	}

}
