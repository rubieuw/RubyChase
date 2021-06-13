/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.rubychase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rubie
 */
public class GameTest {
    
    Game game;
    
    public GameTest() {
        game = new Game();
    }

    /**
     * Test of getCurrentRoom method, of class Game.
     */
    @Test
    public void testGetCurrentRoom() {
        System.out.println(game.getCurrentRoom());
        assertEquals("castle", game.getCurrentRoom().getName());
    }

    /**
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
    }

    /**
     * Test of checkActualTime method, of class Game.
     */
    @Test
    public void testCheckActualTime() {
    }

    /**
     * Test of processCommand method, of class Game.
     */
    @Test
    public void testProcessCommand() {
    }

   
    
}
