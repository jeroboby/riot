package io.steria.pox3.tile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import io.steria.pox3.got.story.House;
import io.steria.pox3.got.story.HouseFactory;

public class WorldTest {

	World map;

	@Before
	public void setUp() throws Exception {
		map = new World();
	}

	@Test
	public void testGenerate() {
		// map generate(); not needed, done by constructor
		assertTrue(map.tiles.length == 12);
		assertTrue(map.tiles[0].length == 11);
	}

	@Test
	public void testAssignFreeDomain() {
		map.assignFreeDomain(1, 0, 4, 2, "North");
		assertTrue(map.tiles[1][0] instanceof Domain);
		Domain north1 = (Domain) map.tiles[1][0];
		assertTrue(north1.name.equals("North-1"));

		map.assignFreeDomain(8, 6, 2, 2, "Volantis");
		assertTrue(map.tiles[8][6] instanceof Domain);
		Domain volantis2 = (Domain) map.tiles[9][6];
		assertTrue(volantis2.name.equals("Volantis-2"));
	}

	@Test
	public void testAssignDomainWithHouse() {

		House stark = new HouseFactory().getStark();
		map.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);
		assertTrue(map.tiles[1][2] instanceof Domain);
		Domain winterfell2 = (Domain) map.tiles[2][2];
		assertTrue(winterfell2.name.equals("Winterfell-2"));
		assertTrue(winterfell2.house.equals(Optional.of(stark)));

		House martell = new HouseFactory().getMartell();
		map.assignDomainWithHouse(3, 8, 2, 2, "Dorne", martell);
		assertTrue(map.tiles[3][8] instanceof Domain);
		Domain dorne2 = (Domain) map.tiles[4][8];
		assertTrue(dorne2.name.equals("Dorne-2"));
		assertTrue(dorne2.house.equals(Optional.of(martell)));
	}

	@Test
	public void testFillWater() {
		House stark = new HouseFactory().getStark();
		map.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);

		map.fillWater();

		Domain winterfell2 = (Domain) map.tiles[2][2];
		assertTrue(winterfell2.name.equals("Winterfell-2"));

		assertTrue(map.tiles[6][6] instanceof WaterTile);
	}

	@Test
	public void testAllowMove() {
		fail("fail");

	}

	@Test
	public void testIsWinter() {
		assertFalse(map.winter);
		map.startWinter();
		assertTrue(map.winter);
	}

}
