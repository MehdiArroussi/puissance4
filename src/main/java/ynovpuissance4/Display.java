package ynovpuissance4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    
    /**
     * @param player this is the playing player
     * @param index this is the index of the column where the token has been thrown
     * @param Grid the Grid players are playing on
     * This method puprpose is to add the token in the grid after the player has chosen a column where he wants to play. This meethod has a server/client approach.
     */

    /*public static void Turn(ArrayList<ArrayList<String>> Grid,String player, String indexString ) {
        String letter = "abcdefghijkl";
        int index = letter.indexOf(indexString);
        for (int i = Grid.size()-1; i >= 0; i--) {
            if (Grid.get(i).get(index) == " ") {
                Grid.get(i).set(index, player);
                return;
        } 

    } 
    }*/


    /**
     *This Method have the purpose to have the next player playing after the current one. 
     * @param playerNb the number of players concerned in the game
     * @param player the current player playing.
     * @return Next player playing.
     */

    public static Player NextPlayer(int playerNb,Player player) {
        switch (player) {
            case Player1:
                return Player.Player2;
            case Player2:
                if (playerNb == 3) {
                    return Player.Player3;
                }
                return Player.Player1;
            case Player3:
                return Player.Player1;
        }
        return NextPlayer(playerNb, player);
}
/*
 * This Method have the purpose of randomizing the first player playing in the game.
 */

public static Player PlayerRandomizer(int playerNb) {
    Random rnd = new Random();
    int random = rnd.nextInt(playerNb);
    System.out.println(random);
    switch(random) {
        case 0 : 
            return Player.Player1;
        case 1 :
            return Player.Player2;
        case 2 :
            return Player.Player3;
    }
    return PlayerRandomizer(playerNb);
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