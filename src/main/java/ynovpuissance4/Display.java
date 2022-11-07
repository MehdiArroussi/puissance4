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
                        System.out.print("├" + "X" + "┤");
                        continue;
                    case "O" : 
                        System.out.print("├" + "O" + "┤");
                        continue;
                    case "V" :
                        System.out.print("├" + "V" + "┤");
                        continue;
                    default : 
                        System.out.print("├" + caraString + "┤");
                        continue;
                }
            }
            System.out.print("\n");
        }
        System.out.print("└"+ "┴".repeat((grid.get(0).size()*3)-2)+"┘"+"\n");
        if (grid.get(0).size() == 8) {
            System.out.println(" A  B  C  D  E  F  G  H  ");
        }else {
            System.out.println(" A  B  C  D  E  F  G  H  I  J  K  L  ");
        }
    }

    /**
     * @param player this is the playing player
     * @param Grid this is the grid where the players can play
     * This method is for the gameplay, it asks the player to choose a column and verify if its possible or not
     */
    
    protected static String TokenPos(ArrayList<ArrayList<String>> Grid) {
        String letter = "abcdefghijkl";
        System.out.println("Where do you wanna play? (From a to "+letter.charAt(Grid.get(0).size()-1)+")");
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        String choose = "";
        
        try {
            choose = var2.readLine();                                                               // get the value of the column where token has been thrown
            number = letter.indexOf(choose);
            if (number>Grid.get(0).size()-1 || number<0) {                                    // if the value is in the grid or not
                System.err.println("Please choose a correct value (a - "+letter.charAt(Grid.get(0).size()-1)+")");
                return TokenPos(Grid);                                                               // if not we ask again and reload method
            } 
        }catch (IOException e){
            System.err.println("Please choose a correct value (a - "+letter.charAt(Grid.get(0).size()-1)+")" + e.toString()); 
            return TokenPos(Grid);                                                                  // get the value != of A to H or L  ==> throw exception

        }catch(NumberFormatException e) {
            System.err.println("We need a NUMBER! : " + e.toString());                              // get != number ==> throw exception
            return TokenPos(Grid); 
        }
        for (int j = Grid.size()-1; j >=0 ; j--) {                                  
            if (Grid.get(j).get(number) == " ") {
                return choose;
            }
        }
        System.err.println("The column is full already, please choose another one");
        return TokenPos(Grid);                                                               // if the column is full, we ask again and reload method 
    }
/*Those Methods are for the local part , we make 3 possibilities since we have a max of 3 players at a time */

public static void TokenPosX(ArrayList<ArrayList<String>> Grid) {
    String letter = " abcdefghijkl";
    System.out.println("Where do you wanna play? (on your keyboard, from a to  "+Grid.get(0).size()+")");
    InputStreamReader var = new InputStreamReader(System.in);
    BufferedReader var2 = new BufferedReader(var);
    int number = 0;
    try {
        number = letter.indexOf(var2.readLine());
        if (number>Grid.get(0).size() || number<1) {
            System.err.println("choose a correct value ( on your keyboard , from a - "+Grid.get(0).size()+")");
            TokenPosX(Grid);
            return; 
        } 
    }catch (IOException e){
        System.err.println("choose a correct value ( on your keyboard , from a - "+Grid.get(0).size()+")" + e.toString());
        TokenPosX(Grid);
        return; 
    }catch(NumberFormatException e) {
        System.err.println("Choose a correct String not a number ! : " + e.toString());
        TokenPosX(Grid);
        return; 
    }
    for (int i = Grid.size()-1; i >=0 ; i--) {
        if (Grid.get(i).get(number-1) == " ") {
            Grid.get(i).set(number-1,"X");
            return;
        }
    }
    printGrid(Grid);
    System.err.println("The column is full! Put it somewhere else , pretty please ! ");
    TokenPosX(Grid);
    return; 
}


public static void TokenPosO(ArrayList<ArrayList<String>> Grid) {
    String letter = " abcdefghijkl";
    System.out.println("Where do you wanna play? (on your keyboard, from a to  "+Grid.get(0).size()+")");
    InputStreamReader var = new InputStreamReader(System.in);
    BufferedReader var2 = new BufferedReader(var);
    int number = 0;
    try {
        number = letter.indexOf(var2.readLine());
        if (number>Grid.get(0).size() || number<1) {
            System.err.println("choose a correct value ( on your keyboard , from a - "+Grid.get(0).size()+")");
            TokenPosO(Grid);
            return; 
        } 
    }catch (IOException e){
        System.err.println("choose a correct value ( on your keyboard , from a -  "+Grid.get(0).size()+")" + e.toString());
        TokenPosO(Grid);
        return; 
    }catch(NumberFormatException e) {
        System.err.println("Choose a correct String not a number ! : " + e.toString());
        TokenPosO(Grid);
        return; 
    }
    for (int i = Grid.size()-1; i >=0 ; i--) {
        if (Grid.get(i).get(number-1) == " ") {
            Grid.get(i).set(number-1,"O");
            return;
        }
    }
    printGrid(Grid);
    System.err.println("The column is full! Put it somewhere else , pretty please ! ");
    TokenPosO(Grid);
    return; 
}


public static void TokenPosV(ArrayList<ArrayList<String>> Grid) {
    String letter = " abcdefghijkl";
    System.out.println("Where do you wanna play? (on your keyboard, from a to  "+Grid.get(0).size()+")");
    InputStreamReader var = new InputStreamReader(System.in);
    BufferedReader var2 = new BufferedReader(var);
    int number = 0;
    try {
        number = letter.indexOf(var2.readLine());
        if (number>Grid.get(0).size() || number<1) {
            System.err.println("choose a correct value ( on your keyboard , from a -  "+Grid.get(0).size()+")");
            TokenPosV(Grid);
            return; 
        } 
    }catch (IOException e){
        System.err.println("choose a correct value ( on your keyboard , from a - "+Grid.get(0).size()+")" + e.toString());
        TokenPosV(Grid);
        return; 
    }catch(NumberFormatException e) {
        System.err.println("Choose a correct String not a number ! :" + e.toString());
        TokenPosV(Grid);
        return; 
    }
    for (int i = Grid.size()-1; i >=0 ; i--) {
        if (Grid.get(i).get(number-1) == " ") {
            Grid.get(i).set(number-1,"V");
            return;
        }
    }
    printGrid(Grid);
    System.err.println("The column is full! Put it somewhere else , pretty please !");
    TokenPosV(Grid);
    return; 
    }
}