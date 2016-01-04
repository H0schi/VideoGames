/**
 * VideoGamesPhoto
 * 
 * version 0.3
 * 
 * date 15.12.2015
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Subclass;

/**
 * VideoGamesPhoto is a special domain inheriting the Photo class
 */
@Subclass
public class VideoGamesPhoto extends Photo implements Serializable{

	@Container
	public VideoGame videoGame;
	
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
	public VideoGamesPhoto(PhotoId MyId, VideoGame videoGame) {
		super(MyId);
		this.videoGame = videoGame;
	}
	
	/**
	 * @methodtype get
	 */
	public VideoGame getVideoGame() {
		return videoGame;
	}
	
	/**
	 * @methodtype set
	 */
	public void setVideoGame(VideoGame videoGame) {
		this.videoGame = videoGame;
	}
	
}
