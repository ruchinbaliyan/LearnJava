import java.util.Scanner;

class inputUser{

    static void input(Ocean ocean)
    {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Number of input you want to give ");
            int n =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter "+n+" places you want to shoot at: ");

            //If the input is q user is quiting :(
            for(int i=0;i<n;i++) {
                try {
                    String x = scanner.nextLine();


                    int input1 = Integer.parseInt(x);

                    if (x.equals("q")) {
                        System.out.println("Game over!");
                        break;
                    }

                    String y = scanner.nextLine();
                    int input2 = Integer.valueOf(y);

                    if (input1 >= 0 && input1 <= 19 && input2 >= 0 && input2 <= 19) {
                        if (ocean.shootAt(Integer.valueOf((x)), Integer.valueOf(y))) {
                            System.out.println("hit");
                        } else {
                            System.out.println("miss");
                        }
                    } else {
                        System.out.println("input out of range ");
                        continue;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("please give a valid input ");
                    continue;
                }

            }

    }

}

public class Game {

    public static void main(String[] args) {


        Ocean ocean = new Ocean(); //Setting up the Ocean

        System.out.println("Welcome to the battleShip Game!!");

        ocean.placeAllShipsRandomly();//Placing ships randomly in the ocean
        ocean.printOcean();

        while (true) {

            System.out.println("Shots u have fired : " + ocean.getShotsFired());
            System.out.println("How many correct Hits  : " + ocean.getHitCount());
            System.out.println(" How many ships sunk?: " + ocean.getShipsSunk());
            System.out.println();
            ocean.print();
            inputUser.input(ocean);

            if (ocean.isGameOver()) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Game over! Play again? y or n: ");
                char x = scanner.next().charAt(0);
                if (x == 'y') {
                    ocean = new Ocean();
                    System.out.println("Welcome to the battleShip Game!!");
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


