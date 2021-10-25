package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");

		// tests singleton behavior with local reference
		GameService service = GameService.getInstance();
		
		// prints names
		for (int i = 1; i <= service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}