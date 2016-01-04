/**
 * VideoGame
 * 
 * version 0.2
 * 
 * date 04.01.2016
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

/**
 * Represents a video game
 */
public class VideoGame {
	
	private int releaseYear;
	private String name;
	private String developer;
	private String publisher;
	
	public VideoGameType type = null;
	
	/**
	 * @methodtype constructor
	 */
	public VideoGame(VideoGameType type) {
		this(0, null, null, null, type);
	}

	/**
	 * @methodtype constructor
	 * Precondition: type is not null
	 */
	public VideoGame(int releaseYear, String name, String developer, String publisher, 
			VideoGameType type) {
		if(type == null)
			throw new IllegalArgumentException("Error: VideoGameType of VideoGame must not be null!");
		
		this.releaseYear = releaseYear;
		this.name = name;
		this.developer = developer;
		this.publisher = publisher;
		this.type = type;
	}
	
	/**
	 * @methodtype get
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	
	/**
	 * @methodtype set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public String getDeveloper() {
		return developer;
	}
	
	/**
	 * @methodtype set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	/**
	 * @methodtype get
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * @methodtype set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * @methodtype get
	 */
	public VideoGameType getType() {
		return type;
	}
	
	/**
	 * @methodtype set
	 */
	public void setType(VideoGameType type) {
		if(type == null)
			throw new IllegalArgumentException("Error: VideoGameType of VideoGame must not be null!");
		this.type = type;
	}

	/**
	 * @methodtype query
	 */
	public String toString() {
		return name + developer + publisher;
	}

}
