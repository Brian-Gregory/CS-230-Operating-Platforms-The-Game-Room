package com.gamingroom;

/**
 * A simple class to hold information about a player
 *
 * @author eric.slutz@snuh.edu
 */
public class Player extends Entity {
	
	/**
	 * Constructor to create a Player instance with an id and name.
	 * Calls the superclass constructor to set the id and name.
	 */
	public Player(long id, String name) {
		super(id, name);
	}

	/**
	 * Returns player id and name in a formatted string
	 *
	 * @return string of id and name
	 */
	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";
	}
}
