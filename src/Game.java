import java.util.Scanner;

/*
In this class we will setup the ocean( using  Ocean.java )
Took 5 shots inputs at a time (input from user )

 */

public class Game {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Ocean ocean = new Ocean();//Setting up the Ocean

        System.out.println("Welcome to the battle!!");

        ocean.placeAllShipsRandomly();//Placing ships randomly in the ocean

        while (true) {

            System.out.println("Shots u have fired : " + ocean.getShotsFired());
            System.out.println("How many correct Hits  : " + ocean.getHitCount());
            System.out.println(" How many ships sunk?: " + ocean.getShipsSunk());
            System.out.println();
            ocean.print();
            /*
             * autoplay the game
             */


            System.out.print("5 places to shoot at: ");
            String input = scanner.nextLine();
            //If the input is q user is quiting :(

            if (input.equals("q")) {
                System.out.println("Game over!");
                break;
            }

            //sample input be like : 0, 0;1,2;2,3;4,6;3,5
            String[] pairs = input.split("; ");
            try {
                for (String pair : pairs) {
                    String[] locations = pair.split(", ");
                    if (ocean.shootAt(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]))) {
                        System.out.println("hit");
                    } else {
                        System.out.println("miss");
                    }
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("input integer values"+e);
                break;

            }

            if (ocean.isGameOver()) {
                System.out.print("Game over! Play again? y or n: ");
                 input = scanner.nextLine();
                if (input.equals("y")) {
                    ocean = new Ocean();
                    ocean.placeAllShipsRandomly();
                } else {
                    System.out.println("Total shot fired: " + ocean.getShotsFired());
                    System.out.println("ships you sunked :" + ocean.getShipsSunk());
                    break;
                }
            }


        }


    }
}

