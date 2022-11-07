package ynovpuissance4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Server {
    /**
     * @param player this is the playing player
     * @param index this is the index of the column where the token has been thrown
     * @param Grid the Grid players are playing on
     * This method puprpose is to add the token in the grid after the player has chosen a column where he wants to play. This meethod has a server/client approach.
     */

    public static void Turn(ArrayList<ArrayList<String>> Grid,String player, String indexString ) {
        String letter = "abcdefghijkl";
        int index = letter.indexOf(indexString);
        for (int i = Grid.size()-1; i >= 0; i--) {
            if (Grid.get(i).get(index) == " ") {
                Grid.get(i).set(index, player);
                return;
        } 

    } 
    }


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
}
