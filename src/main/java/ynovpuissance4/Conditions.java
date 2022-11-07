package ynovpuissance4;

import java.util.ArrayList;

public class Conditions {

    /**
     * This method is the gameplay essential , it checks if the grid is full or not . After every checking , if the grid is full, @return true "Grid is full!"
     * @param Grid the checked grid , if it's full or not. 
     */
    protected static boolean Equal(ArrayList<ArrayList<String>> Grid) {
        for (int i = 0; i<Grid.get(0).size();i++) {
            if (Grid.get(0).get(i)==" ") {
                return false;
            }
        }
        System.out.println("Grid is full! Ya all loose!");
        return true;
    }

    /** 
     * * @param Grid the grid concerned by the checking if a player has won or not.
     * This method checks if a player has won or not by checking if a line has been completed ( vertical , horizontal , diagonal). If he has, @return "PlayerName has won!"
     */
    protected static boolean Win(ArrayList<ArrayList<String>> Grid) {
        // horizontalCheck
        for (int j = 0; j<Grid.size()-3 ; j++ ){
            for (int i = 0; i<Grid.get(0).size(); i++){
                if (Grid.get(j).get(i).charAt(0) == Grid.get(j+1).get(i).charAt(0) && Grid.get(j+2).get(i).charAt(0) == Grid.get(j+1).get(i).charAt(0) && Grid.get(j+2).get(i).charAt(0) == Grid.get(j+3).get(i).charAt(0) && Grid.get(j).get(i).charAt(0) != ' ' ){
                    System.out.println("The player " + Grid.get(j).get(i) + " has won ! Congrats !");
                    return true;
                }           
            }
        }
        // verticalCheck
        for (int j = 0; j<Grid.get(0).size()-3 ; j++ ){
            for (int i = 0; i<Grid.size(); i++){
                if (Grid.get(i).get(j).charAt(0) == Grid.get(i).get(j+1).charAt(0) && Grid.get(i).get(j+2).charAt(0) == Grid.get(i).get(j+1).charAt(0) && Grid.get(i).get(j+2).charAt(0) == Grid.get(i).get(j+3).charAt(0) && Grid.get(i).get(j).charAt(0) != ' '){
                    System.out.println("The player " + Grid.get(j).get(i) + " has won ! Congrats !");
                    return true;
                }           
            }
        }
        // ascendingDiagonalCheck 
        for (int j = 3; j<Grid.get(0).size() ; j++ ){
            for (int i=0; i<Grid.size()-3; i++){
                if (Grid.get(i).get(j).charAt(0) == Grid.get(i+1).get(j-1).charAt(0) && Grid.get(i+1).get(j-1).charAt(0) == Grid.get(i+2).get(j-2).charAt(0) && Grid.get(i+2).get(j-2).charAt(0) == Grid.get(i+3).get(j-3).charAt(0) && Grid.get(i).get(j).charAt(0) != ' ') {
                    System.out.println("The player " + Grid.get(j).get(i) + " has won ! Congrats !");
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int j = 3; j<Grid.get(0).size() ; j++ ){
            for (int i=3; i<Grid.size(); i++){
                if (Grid.get(i).get(j).charAt(0) == Grid.get(i-1).get(j-1).charAt(0) && Grid.get(i-1).get(j-1).charAt(0) == Grid.get(i-2).get(j-2).charAt(0) && Grid.get(i-2).get(j-2).charAt(0) == Grid.get(i-3).get(j-3).charAt(0) && Grid.get(i).get(j).charAt(0) != ' ') {
                    System.out.println("The player " + Grid.get(j).get(i) + " has won ! Congrats !");
                    return true;
                }
            }
        }
        return false;
    }
}