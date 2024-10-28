package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 *
 * @author eric.slutz@snuh.edu
 *
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static final List<Game> games = new ArrayList<>();

	/**
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/**
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;

	/**
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;

	/**
	 * Holds the single gameService instance
	 */
	private static GameService gameService = null;

	/**
	 * Private constructor for singleton pattern
	 */
	private GameService() {
	}

	/*
	Singleton Pattern Overview:

	The purpose of the singleton pattern is to ensure that only one instance of a particular class
	is created and used throughout the application's lifecycle. In this case, the singleton pattern 
	is applied by making the GameService constructor private. 

	To get the instance of GameService, you must call the public static method getInstance().
	This method checks whether the static gameService field has been initialized. If it hasn’t,
	a new instance is created. If it has, the existing instance is returned, guaranteeing 
	a single instance during the program's execution.
	 */
	/**
	 * Checks if gameService has been initialized
	 * If it has, return that instance
	 * Otherwise, create a new instance of GameService
	 *
	 * @return the single gameService instance
	 */
	public static GameService getInstance() {
		// if not found, make a new GameService instance
		if (gameService == null) {
			gameService = new GameService();
		}

		// return the new/existing gameService instance to the caller
		return gameService;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {
		// a local game instance
		Game game = null;

		// if found, simply return the existing instance
		for (Game existingGame : games) {
			if (existingGame.getName().equals(name)) {
				game = existingGame;
				break; // Exit loop early once game is found
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {
		// a local game instance
		Game game = null;

		// if found, simply assign that instance to the local variable
		for (Game existingGame : games) {
			if (existingGame.getId() == id) {
				game = existingGame;
				break; // Exit loop early once game is found
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {
		// a local game instance
		Game game = null;

		// if found, simply assign that instance to the local variable
		for (Game existingGame : games) {
			if (existingGame.getName().equals(name)) {
				game = existingGame;
				break; // Exit loop early once game is found
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	/**
	 * Returns the next team id
	 *
	 * @return the next team id
	 */
	public long getNextTeamId
