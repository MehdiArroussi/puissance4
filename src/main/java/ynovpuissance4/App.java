package ynovpuissance4;


import java.io.BufferedReader;
import java.io.InputStreamReader;






/**
 * This is the Menu app , it's the first thing you see when you launch the game. Display a Menu to select which mode , number of players , rules or exit the game
 *@author Mehdi ARROUSSI
 * !!! IMPORTANT : I've noticed a little bug in the code , when you play on local and you have 4 pawns aligned , the console ask to enter a column to play but when you do, the game stops and the winner is declared ==> you need to "finish" the next turn in order to check if their is a winner.
 *  I tried to fix it but i couldnt , it doesnt have any consequence on the winning player orthe game since it doesnt add any more pawns  !!!
 */
 
public class App 
{
    
    public static void main( String[] args ) throws Exception {
        StartGame();
    }
    
    public static Void StartGame() throws Exception {
        System.out.println("Welcome to Osu! ... Power 4 sorry !!!\n1. Play\n2. Rules\n3. Exit");
        try {
        InputStreamReader bis0 = new InputStreamReader(System.in);
        BufferedReader br0 = new BufferedReader(bis0);
        String choice = br0.readLine();
        switch(choice.charAt(0)) {
            case '1' :
            System.out.println("You want to play , lets play ...");
            InputStreamReader bis = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(bis);
            System.out.println("What mode do you want to play ?\n1. Local \n2. Server \n3. Client");
            String mode = br.readLine();
                switch(mode.charAt(0)) {
                    case '1' : 
                    System.out.println("Local !\n How many players ?\n1. 2 players \n2. 3 players");
                    String nbplayers = br.readLine();
                        switch(nbplayers.charAt(0)) {
                            case '1' :
                            System.out.println("2 players !\n");
                            Grid grid = new Grid(2);
                            
                            while (Conditions.Equal(grid.grille) == false) {
                                Display.printGrid(grid.grille);
                                System.out.print("Player X , It's your turn !\n");
                                Display.TokenPosX(grid.grille);
                                Display.printGrid(grid.grille);
                                System.out.print("Player O , It's your turn !\n");
                                Display.TokenPosO(grid.grille);
                                if (Conditions.Win(grid.grille) == false) {
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                            break;
                            case '2' :
                            System.out.println("3 players !\n");
                            Grid grid2 = new Grid(3);
                            while (Conditions.Equal(grid2.grille) == false) {
                                Display.printGrid(grid2.grille);
                                System.out.print("Player X , It's your turn !\n");
                                Display.TokenPosX(grid2.grille);
                                Display.printGrid(grid2.grille);
                                System.out.print("Player O , It's your turn !\n");
                                Display.TokenPosO(grid2.grille);
                                Display.printGrid(grid2.grille);
                                System.out.print("Player V , It's your turn !\n");
                                Display.TokenPosV(grid2.grille);
                                if (Conditions.Win(grid2.grille) == false) {
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                            break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                        break;
                    case '2' :
                    System.out.println("Server !\n How many players ?\n1. 2 players \n2. 3 players");
                    InputStreamReader bis2 = new InputStreamReader(System.in);
                            BufferedReader br2 = new BufferedReader(bis2);
                    String nbplayers2 = br2.readLine();
                        switch(nbplayers2.charAt(0)) {
                            case '1' :
                            System.out.println("2 players !\n");
                            Server.LaunchServeur(2);
                            break;
                            case '2' :
                            System.out.println("3 players !\n");
                            Server.LaunchServeur(3);
                            break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                        break;
                    case '3' :
                    System.out.println("Client !\n Looking for Players ...");
                        Client.LaunchClient();
                          break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                        break;
                
            case '2' :
            System.out.println("You dont know how to play this , do you ?\n Well , here are the rules : \n The purpose is to align 4 pawns of the same symbol in a row, a column or a diagonal. The First player to align 4 pawns wins the game. GL HF !");
            StartGame();
            break;

            case '3' :
            System.out.println("You wanna exit the game ?\n Well , see you next time !");
            break;
            default :
            StartGame();
            break;
        }
        }catch(Exception e) {
            System.out.println("Wrong input !\n" + e.toString());
            StartGame();
        }
        return null;
    }
}