package 


import java.util.ArrayList;





/**
 * This is the Menu app , it's the first thing you see when you launch the game. Display a Menu to select which mode , number of players , rules or exit the game
 *@author Mehdi ARROUSSI
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        public static void StartGame() 
    {
        System.out.println("Welcome to Power 4 , the one and only !\n1. Play\n2. Rules\n3. Exit");
        String choice = br0.readLine();
        switch(choice.charAt(0)) {
            case '1' :
            System.out.println("You want to play , lets play ...");
            System.out.println("What mode do you want to play ?\n1. Local \n2. Server \n3. Client");
            String mode = br0.readLine();
                switch(mode.charAt(0)) {
                    case '1' : 
                    System.out.println("Local !\n How many players ?\n1. 2 players \n2. 3 players");
                    String nbplayers = br0.readLine();
                        switch(players.charAt(0)) {
                            case '1' :
                            System.out.println("2 players !\n");
                            Grid grid = new Grid(2);
                            break;
                            case '2' :
                            System.out.println("3 players !\n");
                            Grid grid2 = new Grid(3);
                            break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                    case "2" :
                    System.out.println("Server !\n How many players ?\n1. 2 players \n2. 3 players");
                    String nbplayers2 = br0.readLine();
                        switch(nbplayers2.charAt(0)) {
                            case '1' :
                            System.out.println("2 players !\n");
                            Grid grid = new Grid(2);
                            break;
                            case '2' :
                            System.out.println("3 players !\n");
                            Grid grid2 = new Grid(3);
                            break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                    case "3" :
                    System.out.println("Client !\n How many players ?\n1. 2 players \n2. 3 players");
                    String nbplayers3 = br0.readLine();
                        switch(nbplayers3.charAt(0)) {
                            case '1' :
                            System.out.println("2 players !\n");
                            Grid grid = new Grid(2);
                            break;
                            case '2' :
                            System.out.println("3 players !\n");
                            Grid grid2 = new Grid(3);
                            break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                }
            case '2' :
            System.out.println("You dont know how to play this , do you ?\n Well , here are the rules : \n The purpose is to align 4 pawns of the same symbol in a row, a column or a diagonal. The First player to align 4 pawns wins the game. GL HF !");
            StartGame();
            break;

            case '3' :
            System.out.println("You wanna exit the game ?\n Well , see you next time !");
            break;
            default :
            StartGame();
        }
    












    }
}
}