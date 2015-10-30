/**
 * Location
 * 
 * version 0.1
 * 
 * date 30.10.2015
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
 * A Location has a name and a coordinate
 */
public class Location {
	private String name;
	public Coordinate coordinate;
	
	/**
	 * @methodtype constructor
	 */
	public Location() {
		this.name = "";
	}
	
	/**
	 * @methodtype constructor
	 */
	public Location(String name) {
		this.name = name;
	}
	
	/**
	 * @methodtype constructor
	 */
	public Location(String name, Coordinate coordinate) {
		this.name = name;
		this.coordinate = coordinate;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
