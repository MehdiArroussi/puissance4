package ynovpuissance4;
import java.util.ArrayList;

public class Grid {

    protected ArrayList<ArrayList<String>> grille;

    /**
     * This method is the constructor of the Grid class. It makes a grid accordingly to the number of players.
     * @param number The number of players.
     */
    protected Grid(int number) {
        if (number == 2) {                                                                      ///Grid w/ 2 players
            grille = new ArrayList<ArrayList<String>>();
            for (int j = 0 ; j < 6; j++) {
                ArrayList<String> tempo = new ArrayList<String>();                                          
                for (int i = 0; i <8; i++) {
                    tempo.add(" ");
                }
                grille.add(tempo);
            }
        }else {                                                                                  ///Grid w/ 3 players
            grille = new ArrayList<ArrayList<String>>();
            for (int j = 0 ; j < 10; j++) {
                ArrayList<String> tempo = new ArrayList<String>();
                for (int i = 0; i <12; i++) {
                    tempo.add(" ");
                }
                grille.add(tempo);
            }
        }
    }

}