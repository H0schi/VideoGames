/**
 * VideoGamesPhoto
 * 
 * version 0.2
 * 
 * date 01.11.2015
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

import java.io.Serializable;

import com.googlecode.objectify.annotation.Subclass;

/**
 * VideoGamesPhoto is a special domain inheriting the Photo class
 */
@Subclass
public class VideoGamesPhoto extends Photo implements Serializable{

	public static final String GENRE = "genre";

	private int releaseYear;
	
	private GameGenre genre;
	private GamePerspective perspective; 
	
	/**
	 * @methodtype constructor
	 */
	public VideoGamesPhoto() {
		super(); //TODO: necessary...? http://stackoverflow.com/a/6318640
	}
	
	/**
	 * @methodtype constructor
	 */
	public VideoGamesPhoto(PhotoId MyId) {
		super(MyId);
	}
	
	/**
	 * @methodtype constructor
	 */
	public VideoGamesPhoto(int releaseYear, PhotoId MyId, GameGenre genre, GamePerspective perspective) {
		super(MyId);
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.perspective = perspective;
	}
	
	/**
	 * @methodtype get
	 */
	public int getReleaseYear() {
		return this.releaseYear;
	}
	
	/**
	 * @methodtype get
	 */
	public GameGenre getGameGenre() {
		return this.genre;
	}
	
	/**
	 * @methodtype get
	 */
	public GamePerspective getGamePerspective() {
		return this.perspective;
	}
	
	/**
	 * @methodtype set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	/**
	 * @methodtype set
	 */
	public void setGameGenre(GameGenre genre) {
		this.genre = genre;
	}
	
	/**
	 * @methodtype set
	 */
	public void setGamePerspective(GamePerspective perspective) {
		this.perspective = perspective;
	}
	
}
