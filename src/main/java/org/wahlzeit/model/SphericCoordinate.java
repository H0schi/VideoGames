/**
 * SphericCoordinate
 * 
 * version 0.1
 * 
 * date 07.11.2015
 * 
 * Copyright (c) by Thorsten Schwachhofer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{

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
	 * @methodtype get
	 */
	public double getDistance(Coordinate cd) {
		if(cd == null)
			throw new IllegalArgumentException("Error: parameter of method getDistance is zero!");
		
		if(cd instanceof SphericCoordinate) {
			SphericCoordinate other = (SphericCoordinate) cd;
			double lat = other.getLatitude();
			double lon = other.getLongitude();
			double lambda = Math.abs(lon-longitude);
			double sigma = Math.acos(Math.sin(latitude)*Math.sin(lat) + Math.cos(latitude)*Math.cos(lat)*Math.cos(lambda));
			return sigma*radius;
		}

		// Pythagoras' theorem
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		double otherX = cd.getX();
		double otherY = cd.getY();
		double otherZ = cd.getZ();
		return Math.sqrt(Math.pow(otherX - x, 2) + Math.pow(otherY - y, 2) + Math.pow(otherZ - z, 2));
	}

	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate cd) {
		if (this == cd)
			return true;
		if (cd == null)
			return false;
		if(this.getDistance(cd) == 0.f)
			return true;
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
