package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * lists active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * contains next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * contains next team identifier
	 */
	private static long nextPlayerId = 1;

    /*
     * contains next player identifier
     */
    private static long nextTeamId = 1;

    // uses private var to track gameservice instance
    private static GameService service = null;

    private GameService() {
    }

    /**
     * checks for existing GameService instance
     * @return
     */
	public static GameService getInstance() {

	    if (service == null) {
            // if no GameService instance exists, creates one
	        service = new GameService();
	        System.out.println("New Game Service created.");
        } else {
            // prints if already existing
            System.out.println("Game Service already instantiated.");
        }

        // returns only single instance, new or existing
        return service;
    }

	/**
	 * creates new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// local game instance
		Game game = null;

        // iterator for game instance
        Iterator<Game> gamesIterator = games.iterator();

        // iterates over game list
        while (gamesIterator.hasNext()) {

            // sets var local game to next in list
            Game gameInstance = gamesIterator.next();

            if (gameInstance.getName().equalsIgnoreCase(name)) {
                // returns game instance if already exists
                return gameInstance;
            }
        }

		// if none, makes new game instance and adds to list
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// returns new/existing game
		return game;
	}
	
	/**
	 * returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

        // instance iterator
        Iterator <Game> gamesIterator = games.iterator();

        // iterate over game list
        while (gamesIterator.hasNext()) {

            // sets local game var next in list
            Game gameInstance = gamesIterator.next();

            if (gameInstance.getId() == id) {
                // returns game instance if already exists
                return gameInstance;
            }
        }


		return game;
	}

	/**
	 * returns game instance specified name
	 * 
	 * @param game to search for
	 * @return game instance
	 */
	public Game getGame(String name) {

		// local instance
		Game game = null;

        // instance iterator
        Iterator<Game> gamesIterator = games.iterator();

        // iterates over game
        while (gamesIterator.hasNext()) {

            // sets local game to next
            Game gameInstance = gamesIterator.next();

            if (gameInstance.getName().equalsIgnoreCase(name)) {
                // returns game instance if pre-existing
                game = gameInstance;
            }
        }

		return game;
	}

	/**
	 * returns active games
	 * 
	 * @return active games
	 */
	public int getGameCount() {
		return games.size();
	}

    /**
     * returns player with next turn
     *
     * @return the player whose turn is next
     */
    public long getNextPlayerId() {
	    return nextPlayerId;
    }

    /**
     * returns team with next turn
     *
     * @return the team whose turn is next
     */
    public long getNextTeamId() {
        return nextTeamId;
    }
}
