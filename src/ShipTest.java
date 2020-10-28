
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {


    @Before
    public void setUp() throws Exception {
        System.out.println("------------------");
    }

    @Test
    public void testGetShipType() {
        System.out.println("testing Shiptype ");
        Ship ship = new BattleShip();
        assertEquals("BattleShip", ship.getShipType());
        assertEquals(8, ship.getLength());
    }




    @Test
    public void testOkToPlaceShipAt() {
        System.out.println("is it ok to place ship TEST");
        Ship ship = new BattleShip();
        Ocean ocean = new Ocean();
        assertFalse(ship.okToPlaceShipAt(0, 17, true, ocean));
        assertTrue(ship.okToPlaceShipAt(0, 10, true, ocean));
        assertFalse(ship.okToPlaceShipAt(20, 12, false, ocean));
        assertTrue(ship.okToPlaceShipAt(2, 3, false, ocean));
    }




    @Test
    public void testIsSunk() {
        System.out.println("testing isSunk");
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < 8; j++) {
            ocean.shootAt(0, j);
        }

        assertTrue(ship.isSunk());

    }



    @Test
    public void testToString() {
        System.out.println("testing tostring in ship");
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < 8; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals("x", ship.toString());

    }

    @Test
    public void testToString2() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < 7; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals("S", ship.toString());

    }

    @Test
    public void testShootAt() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);

        assertTrue(ship.shootAt(0, 3));
        assertTrue(ship.shootAt(0, 4));
        assertFalse(ship.shootAt(1, 4));

    }


}
