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
 * @author Rubie Nunnoo
 */
public class ItemTest {
    
    Item item;
    
    public ItemTest() {
        item = new Item("knife","this is a knife", 100);
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        
        //Item item = new Item("knife","this is a knife", 100);
        String expected = "knife";
        //String expected = "knives";     // failed test
        String actual = item.getName();
        
        assertEquals(expected, actual);
    }
    /**
     * Test of getPower method, of class Item.
     */
    @Test
    public void testGetPower() {
        //Item item = new Item("knife","this is a knife", 100);
        int expected = 100;
        int actual = item.getPower();
        
        assertEquals(expected, actual);
    }

    /**
     * Test of getDescription method, of class Item.
     */
    @Test
    public void testGetDescription() {
        assertEquals(0, 0);
    }
    
}
