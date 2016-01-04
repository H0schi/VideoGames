/**
 * VideoGameType
 * 
 * version 0.2
 * 
 * date 04.01.2016
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Represents a Type of a VideoGame
 */
public class VideoGameType {
	
	private String genre;
	private String platform;
	private String gameInterface;
	
	public VideoGameType superType = null;
	public Set<VideoGameType> subTypes = new HashSet<VideoGameType>();
	
	/**
	 * @methodtype constructor
	 */
	public VideoGameType(String genre, String platform, String gameInterface) {
		this(genre, platform, gameInterface, null);
	}
	
	/**
	 * @methodtype constructor
	 */
	public VideoGameType(String genre, String platform, String gameInterface, VideoGameType superType) {
		this.genre = genre;
		this.platform = platform;
		this.gameInterface = gameInterface;
		this.superType = superType;
	}
	
	public VideoGame createInstance(int releaseYear, String name, String developer, String publisher) {
		return new VideoGame(releaseYear, name, developer, publisher, this);
	}
	
	/**
	 * @methodtype query
	 */
	public boolean isInstance(VideoGame videogame) {
		assert videogame != null : "null is not an instance of this type...";
		if(videogame.getType() == this)
			return true;
		for(VideoGameType type : subTypes) {
			if(type.isInstance(videogame))
				return true;
		}
		
		return false;
	}
	
	/**
	 * @methodtype get
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * @methodtype get
	 */
	public String getPlatform() {
		return platform;
	}
	
	/**
	 * @methodtype get
	 */
	public String getGameInterface() {
		return gameInterface;
	}
	
	/**
	 * @methodtype get
	 */
	public VideoGameType getSuperType() {
		return superType;
	}
	
	/**
	 * @methodtype set
	 */
	public void setSuperType(VideoGameType superType) {
		assert superType != null : "SuperType should not be set to null";
		this.superType = superType;
	}
	
	/**
	 * @methodtype get
	 */
	public Iterator<VideoGameType> getSubTypesIterator() {
		return subTypes.iterator();
	}
	
	/**
	 * @methodtype set
	 */
	public void addSubType(VideoGameType type) {
		assert type != null : "null should not be added to subTypes";
		subTypes.add(type);
	}
	
	/**
	 * @methodtype query
	 */
	public String toString() {
		return genre + platform + gameInterface;
	}
	
}
