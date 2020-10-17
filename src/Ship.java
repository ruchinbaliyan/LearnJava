public abstract class Ship {

    private int bowRow; // the row (0 to 19) which contains the bow (front) of the ship.
    private int bowColumn; //  the column which contains the bow (front) of the ship.
    private int length; // the number of squares occupied by the ship. An ”empty sea” location has length 1.
    private boolean horizontal; //  true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.
    boolean[] hit; // this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.

    //this is the abstract method implemented by the type of ship
    abstract String getShipType();
    abstract String Power();

//Checking if location is ok to place a ship (horixinatlly or vertically ) also the  ships must not be adjacent to each other
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        if (!horizontal) {
            if (row + getLength() > 20) {
                return false;
            }
            for (int i = row - 1; i < row + getLength() + 1; i++) {  // from start to the end of the ship
                for (int j = column - 1; j <= column + 1; j++) {
                    try {
//						System.out.println(i + " " + j + " " + ocean.getShipArray()[i][j].getShipType().equals("empty"));
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                            return false;
                        }
                    } catch (Exception e) {

                    }
                }
            }

            ////

        }
        else {
            if (column + getLength() > 20) {
                return false;
            }
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = column - 1; j < column + getLength() + 1; j++) {
                    try {
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                            return false;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }

        }
//		System.out.println("");
        return true;
    }

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        bowRow = row;
        bowColumn = column;
        this.horizontal = horizontal;


        if (horizontal) {
            for (int j = column; j < column + getLength(); j++) {
                //setting a reference on the ship array = typeof ship object
                ocean.getShipArray()[row][j] = this;
            }
        } else {
            for (int i = row; i < row + getLength(); i++) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }
/*
checking if tthe location is hit or not  used to print . if false else {x,S} depends*/
    public boolean wasShootAt(int row, int column) {
        boolean h;
        if (horizontal) {

            h =hit[column-this.bowColumn] ;

            return h;
        } else {
            h=hit[row - this.bowRow];
            return  h;
        }
    }

//Setting value in hit[boolean] array of the ship t/f
    boolean shootAt(int row, int column)
    {
        if (!isSunk()) {
            if (horizontal) {
                if (row == this.bowRow && column < this.bowColumn + length) {
                    hit[column - this.bowColumn] = true;
                    return true;
                }
            }
            else {
                if (column == this.bowColumn && row < this.bowRow + length) {
                    hit[row - this.bowRow] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSunk()
    {
        for (boolean b : hit)
            if (!b)
                return false;
        return true;
    }



    public String toString()
    {
        return isSunk() ? "x" : "S";

    }



    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }




}
