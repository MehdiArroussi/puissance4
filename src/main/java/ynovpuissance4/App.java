package ynovpuissance4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





/**
 * This is the Menu app , it's the first thing you see when you launch the game. Display a Menu to select which mode , number of players , rules or exit the game
 *@author Mehdi ARROUSSI
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception {
        StartGame();
    }
    
    public static Void StartGame() {
        System.out.println("Welcome to the game Power 4!\n1. Play\n2. Rules\n3. Exit");
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
                            //local 2 players
                             break;
                            case '2' :
                            System.out.println("3 players !\n");
                            //local 3 players
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
                            // As a server , 2 players
                            break;
                            case '2' :
                            System.out.println("3 players !\n");
                            // As a server , 3 players
                            break;
                            default :
                            System.out.println("Wrong input !\n");
                            StartGame();
                            break;
                        }
                        break;
                    case '3' :
                    System.out.println("Client !\n Looking for Players ...");
                        //client launch here
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












   