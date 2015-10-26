/**
 * Coordinate
 * 
 * version 0.1
 * 
 * date 21.10.2015
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

/**
 * A Coordinate is defined by latitude and longitude
 */
public class Coordinate {
	
	private double latitude;
	private double longitude;
	
	private final double earth = 6371; //earth radius
	
	public Coordinate() {
		this.latitude = 0;
		this.longitude = 0;
	}
	
	public Coordinate(double latitude, double longitude){
		checkLatLon(latitude, longitude);
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	private void checkLatLon(double latitude, double longitude) {
		if(latitude < -180 || latitude > 180 || longitude < -90 || longitude > 90)
			throw new IllegalArgumentException("Latitude must be between -180 and 180, Longitude between -90 and 90!");
	}

	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public double getDistance(Coordinate cd) {
		double lat = cd.getLatitude();
		double lon = cd.getLongitude();
		double lambda = Math.abs(lon-longitude);
		double sigma = Math.acos(Math.sin(latitude)*Math.sin(lat) + Math.cos(latitude)*Math.cos(lat)*Math.cos(lambda));
		return sigma*earth;
	}
	
	public double getLatitudinalDistance(Coordinate cd) {
		return cd.getLatitude() - this.latitude;
	}

	public double getLongitudinalDistance(Coordinate cd) {
		return cd.getLongitude() - this.longitude;
	}
	
}
