/**
 * SphericCoordinate
 * 
 * version 0.2
 * 
 * date 10.11.2015
 * 
 * Thorsten Schwachhofer
 * 
 */

package org.wahlzeit.model;

/**
 * Spherical representation of a Coordinate
 */
public class SphericCoordinate extends AbstractCoordinate{

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
	 */
	public SphericCoordinate(double latitude, double longitude){
		checkLatLon(latitude, longitude);
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = 6371.f; //earth radius
	}
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		checkLatLon(latitude, longitude);
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	/**
	 * @methodtype assertion
	 */
	private void checkLatLon(double latitude, double longitude) {
		if(latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180)
			throw new IllegalArgumentException("Latitude must be between -90 and 90, Longitude between -180 and 180!");
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
		if(!super.isEqual(cd))
			return false;
		if (!(cd instanceof SphericCoordinate))
			return false;
		SphericCoordinate other = (SphericCoordinate) cd;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	

}
