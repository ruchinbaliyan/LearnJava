import org.junit.*;

import static org.junit.Assert.*;

public class OceanTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("------------------");
    }

    @Test
    public void testConstructor() {
        System.out.println("testing constructor");
        Ocean ocean = new Ocean();
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                assertEquals("empty", ocean.getShipArray()[i][j].getShipType());
            }
        }

    }
    @Test
    public void testIsOccupied()
    {
        System.out.println("testing tesIsoccupied");
    Ocean ocean =new Ocean();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) assertFalse(ocean.isOccupied(i, j));
        }

    }

    @Test
    public void testShootAt1() {
        System.out.println("testshootat1 tesitng ");
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 0);
        ocean.shootAt(1, 0);
        assertEquals(2, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(3, ocean.getShotsFired());
    }
    @Test
    public void testShootAt2()
    {
        System.out.println("testshootat2 tesitng ");
        Ocean oc =new Ocean();
        Submarine sub =new Submarine();
        sub.placeShipAt(1,0,true,oc);
        oc.shootAt(1,0);
        oc.shootAt(1,2);
        oc.shootAt(1,3);
        assertEquals(2,oc.getHitCount());
        assertEquals(0,oc.getShipsSunk());
        assertEquals(3,oc.getShotsFired());
        oc.shootAt(1,1);
        assertEquals(1,oc.getShipsSunk());

        }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("after class");
    }
}