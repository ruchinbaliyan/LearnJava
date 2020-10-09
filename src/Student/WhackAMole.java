package Student;

import java.util.Random;
import java.util.Scanner;




public class WhackAMole {

    public int score=0;
    public int molesLeft;
    public int attemptsLeft;

    public char[][] moleGrid;



    public WhackAMole(int numAttempts, int gridDimension)
    {
        attemptsLeft =numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        for(int i=0;i<gridDimension;i++)
        {
            for(int j=0;j<gridDimension;j++)
            {
                moleGrid[i][j]='f';

            }
        }

    }
    public boolean place(int x ,int y)
    {
        moleGrid[x][y] ='t';
        return true;

    }
    public void whack(int x,int y)
    {

         if( molesLeft == 0 || attemptsLeft == 0)
        {
            printGrid();
            return ;

        }
       else if(x == -1 && y == -1)
        {
            System.out.println("user giveup!");
            System.out.println();
            printGrid();

        }
        else if(x>4 || y >4)
        {
            System.out.println("invalid indexes");
            return ;

        }

       else if( moleGrid[x][y] == 't')
       {
           score++;
           attemptsLeft--;
           molesLeft--;
           moleGrid[x][y]= 'w';

       }
       else
       {
           attemptsLeft--;

       }
    printGridUser();

    }
    public void printGridUser()
    {
        for(int i=0;i<moleGrid.length;i++)
        {
            for(int j=0;j<moleGrid.length;j++)
            {
            if(moleGrid[i][j]== 'w')
                System.out.print("W"+" ");
            else
                System.out.print("*"+" ");

            }
            System.out.println();

        }

    }
    public void printGrid()
    {
        System.out.println("Final grid: ");
        for(int i=0;i<moleGrid.length;i++)
        {
            for(int j=0;j<moleGrid.length;j++)
            {
                if(moleGrid[i][j]== 't')
                    System.out.print("M"+" ");
                else if(moleGrid[i][j]== 'w')
                    System.out.print("W"+" ");
                else
                    System.out.print("*"+" ");

            }
            System.out.println();

        }
        return ;



    }

    public static void main(String[] args) {

        WhackAMole w = new WhackAMole(25,5);
        int i,j;
        w.molesLeft =8;
        Random rand = new Random();


        for( int b=0; b<5;b++)
        {
            i= rand.nextInt(5);
            j= rand.nextInt(5);

            w.place(i,j);

        }

        System.out.println("Starting the game");
        System.out.println("Rules: 25 atttempts , 8 moles ");

        Scanner sc =new Scanner(System.in);
        int a,b;
       // w.printGrid();


        for(int it=0;it<25;it++)
        {
            System.out.println("you have "+w.attemptsLeft+"attempts left");
            System.out.println("enter your goess i and j");

            a = sc.nextInt();
            b = sc.nextInt();

             w.whack(a,b);


        }



    }

}
