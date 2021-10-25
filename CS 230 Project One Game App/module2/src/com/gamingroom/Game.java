package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

    /**
     * lists teams that are active
     */
    private List<Team> teams = new ArrayList<Team>();

	/**
	 *  game constructor
	 */
	public Game(long id, String name) {
		super(id, name);
	}

    /**
     * iterator pattern that finds existing team with identical name
     * or adds unique team to list
     */
	public Team addTeam(String name) {

        Team team = null;

        // iterator for instance
        Iterator<Team> teamsIterator = teams.iterator();

        // iterates over teams list
        while (teamsIterator.hasNext()) {

            // sets local Team to next in list
            Team teamInstance = teamsIterator.next();

            // checks if team name already exists
            if (teamInstance.getName().equalsIgnoreCase(name)) {
                // returns team instance if team name exists
                team = teamInstance;
            } else {
                // otherwise adds team to list
                teams.add(team);
            }
        }

        return team;
	}

	@Override
	public String toString() {
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}