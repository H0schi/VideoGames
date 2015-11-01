/**
 * VideoGamesPhotoFactory
 * 
 * version 0.1
 * 
 * date 31.10.2015
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

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class VideoGamesPhotoFactory extends PhotoFactory {
	
	private static final Logger log = Logger.getLogger(VideoGamesPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static VideoGamesPhotoFactory instance = null;
	
	/**
	 *	methodtype constructor
	 */
	public VideoGamesPhotoFactory() {
		//do nothing
	}
	
	/**
	 * @methodtype factory
	 */
	public VideoGamesPhoto createPhoto() {
		return new VideoGamesPhoto();
	}

	/**
	 * @methodtype factory
	 */
	public VideoGamesPhoto createPhoto(PhotoId id) {
		return new VideoGamesPhoto(id);
	}
	
	/**
	 * @methodtype factory
	 */
	public VideoGamesPhoto createPhoto(int release, PhotoId id, GameGenre genre, GamePerspective perspective) {
		return new VideoGamesPhoto(release, id, genre, perspective);
	}
	
	/**
	 * methodtype get
	 */
	public static synchronized VideoGamesPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting VideoGamesPhotoFactory").toString());
			setInstance(new VideoGamesPhotoFactory());
		}

		return instance;
	}
	
	/**
	 * methodtype set
	 */
	protected static synchronized void setInstance(VideoGamesPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize VideoGamesPhotoFactory twice");
		}

		instance = photoFactory;
	}
	
}
