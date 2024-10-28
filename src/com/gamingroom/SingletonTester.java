package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		GameService service = GameService.getInstance();
		
		// Print all the games in the service
		for (Game game : service.getGames()) { // Assuming a getGames() method exists to return the list
			System.out.println(game);
		}
	}
	
}
