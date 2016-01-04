/**
 * VideoGamesPhotoManager
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

public class VideoGamesPhotoManager extends PhotoManager {
	
	protected static final VideoGamesPhotoManager instance = new VideoGamesPhotoManager();
	
	public void savePhoto(VideoGamesPhoto photo) {
		updateObject(photo); //No need to overload this, as every instanceof VideoGamesPhoto is also a instanceof Photo
	}
	
}
