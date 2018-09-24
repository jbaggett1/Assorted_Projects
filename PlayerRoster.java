//Jillian Baggett and Leah Kuperman
//PlayerRoster Lab 0
//9/6/18
//MWF 4-5 PM


import java.util.*;
public class PlayerRoster
{   public static int[] jerseyNum = new int[6];
    public static int[] ratings = new int[6];
    public static Scanner scnr;
    public static char userPick;
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        PlayerRoster jimmy = new PlayerRoster(scnr);
        output();
        menu(scnr);
    }

    /**
     * Constructor for objects of class PlayerRoster
     */
    public PlayerRoster(Scanner scnr) {

        scnr = scnr;
        for (int i=1; i<=5; i++)
        {

            System.out.println("Enter player " + i + "'s jersey number:");
            jerseyNum[i] = scnr.nextInt();
            System.out.println("Enter player " + i + "'s rating:\n");
            ratings[i] = scnr.nextInt();
        }


    }
    //controls the output directed to user screen
    public static void output()
    {
        System.out.println("ROSTER");
        for (int j=1; j<=5; j++)
        {
            System.out.println("Player " + j + " -- Jersey number: " + jerseyNum[j] + ", Rating: " +
                    ratings[j]);
        }
    }


    //prints menu for the user
    public static void menuPrint()
    {
        System.out.println("\nMENU");
        System.out.println("u - Update player rating");
        System.out.println("a - Output players above a rating");
        System.out.println("r - Replace player");
        System.out.println("o - Output roster");
        System.out.println("q - Quit");
        System.out.println("\nChoose an option:");
    }
    //Interactive menu, allows user to chose and directs to appropriate method
    public static void menu(Scanner scnr)
    {   scnr = scnr;
        menuPrint();
        userPick = scnr.next().charAt(0);
        while (userPick != 'q')
        {
            if (userPick == 'u')
            {
                update(scnr);
                menuPrint();
                userPick = scnr.next().charAt(0);
            }
            else if (userPick == 'a')
            {
                outputAbove(scnr);
                menuPrint();
                userPick = scnr.next().charAt(0);
            }
            else if (userPick == 'r')
            {
                replace(scnr);
                menuPrint();
                userPick = scnr.next().charAt(0);
            }
            else if (userPick == 'o')
            {
                output();
                menuPrint();
                userPick = scnr.next().charAt(0);
            }
        }
    }
    //Updates player based on user input
    public static void update(Scanner scnr)
    {   scnr = scnr;
        System.out.println("Enter a jersey number: ");
        int num = scnr.nextInt();
        System.out.println("Enter a new rating for player: ");
        int newRate = scnr.nextInt();
        for (int x=0; x<jerseyNum.length; x++)
        {
            if (jerseyNum[x] == num)
            {
                ratings[x] = newRate;
            }
        }
    }
    //outputs players above a certain rating
    public static void outputAbove(Scanner scnr)
    {   scnr = scnr;
        System.out.println("Enter a rating: ");
        int num = scnr.nextInt();
        System.out.println("\n\nABOVE " + num);
        for (int j=1; j<=5; j++)
        {
            if (ratings[j]>num)
            {
                System.out.println("Player " + j + " -- Jersey number: " + jerseyNum[j] + ", Rating: " +
                        ratings[j]);
            }
        }
    }
    //replaces a player
    public static void replace(Scanner scnr)
    {   scnr = scnr;
        System.out.println("Enter a jersey number: ");
        int num = scnr.nextInt();
        for (int x=0; x<jerseyNum.length; x++)
        {
            if (jerseyNum[x] == num)
            {
                System.out.println("Enter a new jersey number: ");
                int numNew = scnr.nextInt();
                System.out.println("Enter a rating for the new player: ");
                int newRate = scnr.nextInt();
                jerseyNum[x] = numNew;
                ratings[x] = newRate;
            }
        }


    }

}
