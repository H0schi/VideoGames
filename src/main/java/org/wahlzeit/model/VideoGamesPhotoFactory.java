/**
 * VideoGamesPhotoFactory
 * 
 * version 0.2
 * 
 * date 15.12.2015
 * 
 * Thorsten Schwachhofer
 * 
 */

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
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
	public VideoGamesPhoto createPhoto(PhotoId id, VideoGame videogame) {
		return new VideoGamesPhoto(id, videogame);
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
