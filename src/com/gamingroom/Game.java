package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 *
 * @author eric.slutz@snuh.edu
 *
 */
public class Game extends Entity {
	private final List<Team> teams = new ArrayList<>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Construct a new team instance
	 *
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addTeam(String name) {
		// a local team instance
		Team team = null;

		// Check for an existing team by name
		for (Team existingTeam : teams) {
			if (existingTeam.getName().equals(name)) {
				team = existingTeam;
				break; // Exit loop early once found
			}
		}

		// if not found, create a new team instance and add to list of teams
		if (team == null) {
			team = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(team);
		}

		// return the new/existing team instance to the caller
		return team;
	}

	/**
	 * Returns game id and name in a formatted string
	 *
	 * @return string of id and name
	 */
	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}
}
