package io.steria.pox3.got.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.steria.pox3.got.game.Game;
import io.steria.pox3.got.game.Player;
import io.steria.pox3.got.story.House;
import io.steria.pox3.got.story.HouseFactory;

public class GameTest {

	Game game;
	Player a;
	Player b;
	House stark, lannister;

	@Before
	public void setUp() {
		System.out.println("reinitialize new game");
		this.game = new Game();

		HouseFactory factory = new HouseFactory();
		this.stark = factory.getStark();
		this.lannister = factory.getLannister();

		this.a = new Player("Anne", lannister);
		this.b = new Player("Nicolas", stark);
	}

	@Test
	public void testGetAvailableHouses() {
		assertEquals(8, game.getAvailableHouses().size());

		assertTrue(game.getAvailableHouses().size() == 8);

	}

	@Test
	public void testSavePlayer() {
		assertTrue(game.getAvailableHouses().size() == 8);

		a.house = lannister;
		game.savePlayer(a);

		assertTrue(game.getAvailableHouses().size() == 7);
	}

}