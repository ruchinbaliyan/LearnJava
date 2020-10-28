import java.util.Random;

public class Ocean {

    private Ship[][] ships = new Ship[20][20]; // Used to quickly determine which ship is in any given location.
    private int shotsFired; // The total number of shots fired by the user.
    private int hitCount; // The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, every hit is counted, even though the additional ”hits” don’t do the user any good.
    private int shipsSunk; // The number of ships sunk. Remember that you have a total of 13 ships.

    public Ship[][] getShipArray() {
        return ships;
    }

    public Ship[][] getShips() {
        return ships;
    }

    public void setShips(Ship[][] ships) {
        this.ships = ships;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public void setShipsSunk(int shipsSunk) {
        this.shipsSunk = shipsSunk;
    }



    public Ocean() {
        shotsFired = 0; hitCount = 0; shipsSunk = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                EmptySea emptySea = new EmptySea();
                //Initially filling sea with emptysea objects ,we could have given null ,but we would have to check for null every time

                emptySea.placeShipAt(i, j, true, this);
                //emptySea class extends Ship class and hence can call parent methods (inhertance)

            }
        }
    }
//Randomly place ships in the ocean

    public void placeAllShipsRandomly() {
        Random random = new Random();
        //In the game there are 13 ships in total


        Ship[] ships = new Ship[13];
        for (int i = 0; i < 13; i++) {
            if (i == 0) {
                ships[i] = new BattleShip();
            } else if (i == 1) {
                ships[i] = new BattleCruiser();
            } else if (i < 4) {
                ships[i] = new Cruiser();
            } else if (i < 6) {
                ships[i] = new LightCruiser();
            } else if (i < 9) {
                ships[i] = new Destroyer();
            } else {
                ships[i] = new Submarine();
            }
        }
        //placing ships randomly
        for (Ship ship : ships) {
            while (true) {
                int row = random.nextInt(20);
                int column = random.nextInt(20);
                boolean horizontal = random.nextBoolean();//where ship is placed horizontally or vertically

                if (ship.okToPlaceShipAt(row, column, horizontal, this)) {
                    ship.placeShipAt(row, column, horizontal, this);
                    break;
                }
            }
        }
    }

    //Return true if location has some ship instance else return false
    public boolean isOccupied(int row, int column) {

        String type =ships[row][column].getShipType();

        if( type.equals("empty"))
            return false;
        else
            return true;



    }

    public boolean shootAt(int row, int column) {
        this.shotsFired++;
        if (isOccupied(row, column)) {
            if (ships[row][column].shootAt(row, column)) {
                if (ships[row][column].isSunk()) {
                    System.out.println("One " + ships[row][column].getShipType()+" is sanked");
                    shipsSunk++;
                }
                hitCount++;
                return true;
            }
            return false;
        } else {
            ships[row][column].shootAt(row, column);
        }
        return false;
    }


    public void print() {
        System.out.println(toString());
    }

    public  String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < 20; j++) {
//				sb.append(ships[i][j].toString());

                if (!ships[i][j].wasShootAt(i, j)) { // never been fired
                    sb.append(".");
                }

                else {
                    //toString will give output accordingly
                    // if ship[i][j] is a emptyShip instance =>> ( o printed if hitted and . printed if not )
                    //if ship[i][j] is other ship instance =>> ( x if ship is not sank ,,,If sank changes to S)
                    sb.append(ships[i][j].toString());
//
                }



                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void printOcean()
    {
        StringBuilder result = new StringBuilder();
        result.append(" ");
        for (int i = 0; i < 20; i++) {
            result.append(String.format("%3d", i));
        }
        result.append("\n");

        for (int i = 0; i < 20; i++) {
            result.append(String.format("%2d ", i));
            for (int j = 0; j < 20; j++) {
//				sb.append(ships[i][j].toString());


                    //toString will give output accordingly
                    // if ship[i][j] is a emptyShip instance =>> ( o printed if hitted and . printed if not )
                    //if ship[i][j] is other ship instance =>> ( x if ship is not sank ,,,If sank changes to S)
                    if(ships[i][j].getShipType()!="empty")
                    {
                        result.append("x");

                    }
                    else
                    {
                        result.append(".");

                    }
//



                result.append("  ");
            }
            result.append("\n");
        }
        System.out.println(result.toString());

    }
    public boolean isGameOver() {
        return shipsSunk == 13;
    }

}
