/**
 * VideoGameManager
 * 
 * version 0.2
 * 
 * date 04.01.2016
 * 
 * Thorsten Schwachhofer
 *
 */

package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

/**
 * A Singleton responsible for managing VideoGame Objects
 */
public class VideoGameManager {
	
	private static VideoGameManager instance = null;
	private Map<String, VideoGame> videoGames = new HashMap<String, VideoGame>();
	private Map<String, VideoGameType> videoGameTypes = new HashMap<String, VideoGameType>();
	
	/**
	 * @methodtype constructor
	 */
	private VideoGameManager() {}

	/**
	 * @methodtype factory method
	 */
	public static synchronized VideoGameManager getInstance() {
		if (instance == null)
			instance = new VideoGameManager();

		return instance;
	}
	
	/**
	 * @methodtype set
	 */
	private VideoGameType addVideoGameType(VideoGameType type) {
		if(!videoGameTypes.containsKey(type.toString()))
			videoGameTypes.put(type.toString(), type);
		else
			type = videoGameTypes.get(type.toString());
		return type;
	}
	
	/**
	 * @methodtype get
	 */
	public VideoGameType createVideoGameType(String genre, String platform, String gameInterface) {
		return addVideoGameType(new VideoGameType(genre, platform, gameInterface));
	}
	
	/**
	 * @methodtype get
	 */
	public VideoGame createVideoGame(VideoGameType type) {
		return createVideoGame(type, 0, null, null, null);
	}
	
	/**
	 * @methodtype get
	 */
	public VideoGame createVideoGame(VideoGameType type, int releaseYear, String name, String developer, String publisher) {
		type = addVideoGameType(type);
		VideoGame result = type.createInstance(releaseYear, name, developer, publisher);
		videoGames.put(result.toString(), result);
		return result;
	}
}
