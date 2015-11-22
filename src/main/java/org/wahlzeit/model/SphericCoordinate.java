/**
 * SphericCoordinate
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
 * Spherical representation of a Coordinate
 */
public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		this.latitude = 0;
		this.longitude = 0;
		this.radius = 6371.f;
	}
	
	/**
	 * @methodtype constructor
	 * Precondition: parameters are valid double values, latitude and longitude are valid
	 */
	public SphericCoordinate(double latitude, double longitude) {
		// Preconditions
		if(!isValidDoubleValue(latitude) || !isValidDoubleValue(longitude))
			throw new IllegalArgumentException("Error: Parameter is not a valid double value");
		if(!isLatLonValid(latitude, longitude))
			throw new IllegalArgumentException("Error: Latitude must be between -90 and 90, Longitude between -180 and 180!");
		
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = 6371.f; //earth radius
	}
	
	/**
	 * @methodtype constructor
	 * Precondition: parameters are valid double values, latitude and longitude are valid
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		// Preconditions
		if(!isValidDoubleValue(latitude) || !isValidDoubleValue(longitude) || !isValidDoubleValue(radius))
			throw new IllegalArgumentException("Error: Parameter is not a valid double value");
		if(!isLatLonValid(latitude, longitude))
			throw new IllegalArgumentException("Error: Latitude must be between -90 and 90, Longitude between -180 and 180!");
		
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
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
		return this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getY() {
		return this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getZ() {
		return this.radius * Math.cos(this.longitude);
	}

	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate cd) {
		// Preconditons: see superclass
		Coordinate copy = cd;
		
		boolean isEqual = true;
		if(!super.isEqual(cd))
			isEqual = false;
		if(!(cd instanceof SphericCoordinate))
			isEqual = false;
		if(isEqual == false) {
			// Postcondition
			assert hasSameFields(cd, copy);
			return isEqual;
		}
		
		SphericCoordinate other = (SphericCoordinate) cd;
		if(Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			isEqual = false;
		if(Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			isEqual = false;
		if(Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			isEqual = false;
		
		// Postcondition
		assert hasSameFields(cd, copy);
		
		return isEqual;
	}

	

}
