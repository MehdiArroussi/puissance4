package ynovpuissance4;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * We are Mainly Testing the Conditions Class
     * @test 1st Test : We check if the grid is full >>> Equality or not ( should return false )
     * @test 2nd Test : We check if the winner is X ( should return true )
     * @test 3rd Test : We check if the winner is O ( should return true )
     * @test 4th Test : We check if we win when grid is initialized ( should return false )
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void IsEqual() {
        Grid grid = new Grid(3);
        for (int i = 0; i < grid.grille.get(0).size(); i++) {
            grid.grille.get(0).set(i, "X");
        }
        assertTrue(Conditions.Equal(grid.grille));
        grid.grille.get(0).set(0, " ");
        assertFalse(Conditions.Equal(grid.grille));
    }

    @Test
    public void IsWinning() {
        Grid grid = new Grid(3);
        grid.grille.get(0).set(0, "X");
        grid.grille.get(0).set(1, "X");
        grid.grille.get(0).set(2, "X");
        grid.grille.get(0).set(3, "X");
        assertTrue(Conditions.Win(grid.grille));
    }
    @Test
    public void IsWinning2() {
        Grid grid = new Grid(3);
        grid.grille.get(0).set(0, "O");
        grid.grille.get(1).set(0, "O");
        grid.grille.get(2).set(0, "O");
        grid.grille.get(3).set(0, "O");
        assertTrue(Conditions.Win(grid.grille));
    }
    @Test
    public void IsWinnning3() {
        Grid grid = new Grid(3);
        assertFalse(Conditions.Win(grid.grille));
    }
}

