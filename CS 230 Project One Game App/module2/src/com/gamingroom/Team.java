
package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{

	/**
	 * list of active teams
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * constructor
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	 * iterator to find existing player with same name or
     * adds player with unique name to list
	 *
	 * @param name
	 * @return Player instance
	 */
	public Player addPlayer(String name) {

		// local instance
		Player player = null;

		// iterator
		Iterator<Player> playersIterator = players.iterator();

		// iterates player list
		while (playersIterator.hasNext()) {

			// sets local player var to next
			Player playerInstance = playersIterator.next();

			if (playerInstance.getName().equalsIgnoreCase(name)) {
				// if player exists, return instance
				player = playerInstance;
			} else {
				// adds player
				players.add(player);
			}
		}

		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}