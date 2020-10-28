public abstract class Ship {

    private int frontRow;
    private int frontColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    // the row (0 to 19) which contains the bow (front) of the ship.
    // the number of squares occupied by the ship. An ”empty sea” location has length 1.
    //  the column which contains the bow (front) of the ship.
    //  true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.
    // this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.
    //this is the abstract method implemented by the type of ship

    abstract String getShipType();
    abstract String Power();

//Checking if location is ok to place a ship (horizontally or vertically ) also the  ships must not be adjacent to each other
    protected boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

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

    protected void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        frontRow = row;
        frontColumn = column;
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
    protected boolean wasShootAt(int row, int column) {
        boolean h;
        if (horizontal) {

            h =hit[column-this.frontColumn] ;

            return h;
        } else {
            h=hit[row - this.frontRow];
            return  h;
        }
    }

//Setting value in hit[boolean] array of the ship t/f
    protected boolean shootAt(int row, int column)
    {
        if (!isSunk()) {
            if (horizontal) {
                if (row == this.frontRow  && column < this.frontColumn + length) {
                    hit[column - this.frontColumn] = true;
                    return true;
                }
            }
            else {
                if (column == this.frontColumn && row < this.frontRow + length) {
                    hit[row - this.frontRow] = true;
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isSunk()
    {
        for (boolean b : hit)
            if (!b)
                return false;
        return true;
    }



    public String toString()
    {
        return isSunk() ? "S" : "H";

    }



    public int getfrontRow() {
        return frontRow;
    }

    public void setfrontRow(int frontRow) {
        this.frontRow = frontRow;
    }

    public int getfrontColumn() {
        return frontColumn;
    }

    public void setfrontColumn(int frontColumn) {
        this.frontColumn = frontColumn;
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
