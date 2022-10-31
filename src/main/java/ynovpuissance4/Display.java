package ynovpuissance4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Display {
    /**
     * This method displays the grid after every move gameplaywise.
     * @param grid the grid we wanna show
     */
     



    protected static void printGrid(ArrayList<ArrayList<String>> grid) {
        for (List<String> list : grid) {
            for (String caraString : list) {
                switch (caraString) {
                    case "X" :
                        System.out.print(">" + caraString + "<");
                        continue;
                    case "O" : 
                        System.out.print(">" + caraString + "<");
                        continue;
                    case "V" :
                        System.out.print(">" + caraString + "<");
                        continue;
                    default : 
                        System.out.print(">" + caraString + "<");
                        continue;
                }
            }
            System.out.print("\n");
        }
        System.out.print("└"+ "┴".repeat((grid.get(0).size()*3)-2)+"┘"+"\n");
        if (grid.get(0).size() == 8) {
            System.out.println(" A B C D E F G H ");
        }else {
            System.out.println(" A B C D E F G H I J K L ");
        }
    }

    /**
     * @param player this is the playing player
     * @param Grid this is the grid where the players can play
     * This method is for the gameplay, it asks the player to choose a column and verify if its possible or not
     */
    
    protected static String TokenPos(ArrayList<ArrayList<String>> Grid) {
        String letter = "abcdefghijkl";
        System.out.println("Where do you wanna play? (From A to "+letter.charAt(Grid.get(0).size()-1)+")");
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        String choose = "";
        try {
            choose = var2.readLine();                                                               // get the value of the column where token has been thrown
            number = letter.indexOf(choose);
            if (number>Grid.get(0).size()-1 || number<0) {                                    // if the value is in the grid or not
                System.err.println("Please choose a correct value (A- "+letter.charAt(Grid.get(0).size()-1)+")");
                return TokenPos(Grid);                                                               // if not we ask again and reload method
            } 
        }catch (IOException e){
            System.err.println("Please choose a correct value (A- "+letter.charAt(Grid.get(0).size()-1)+")" + e.toString()); 
            return TokenPos(Grid);                                                                  // get the value != of A to H or L  ==> throw exception

        }catch(NumberFormatException e) {
            System.err.println("We need a NUMBER! : " + e.toString());                              // get != number ==> throw exception
            return TokenPos(Grid); 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {                                  
            if (Grid.get(i).get(number) == " ") {
                return choose;
            }
        }
        System.err.println("The column is full already, please choose another one");
        return TokenPos(Grid);                                                               // if the column is full, we ask again and reload method 
    }
    
    /**
     * @param player this is the playing player
     * @param index this is the index of the column where the token has been thrown
     * @param Grid the Grid players are playing on
     * This method puprpose is to add the token in the grid after the player has chosen a column where he wants to play
     */

    public static void Turn(ArrayList<ArrayList<String>> Grid,String player, String indexString ) {
        String letter = "ABCDEFGHIJKL";
        int index = letter.indexOf(indexString);
        for (int i = Grid.size()-1; i >= 0; i--) {
            if (Grid.get(i).get(index) == " ") {
                Grid.get(i).set(index, player);
                return;
        }

    }
    }
}