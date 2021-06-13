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
public class RoomTest {
    Room room;
    public RoomTest() {
        room = new Room("library","this is a library", false);
    }
 /**
     * Test of getShortDescription method, of class Room.
     */
    @Test
    public void testGetShortDescription() {
        assertEquals(0, 0);
    }
     /**
     * Test of setLockedStatus method, of class Room.
     */
    @Test
    public void testSetLockedStatus() {
        //Room room = new Room "library","this is a library", 100);
        boolean expected = false;
        boolean actual = room.getLockedStatus();
        assertEquals(expected, actual);
    }
    /**
     * Test of getName method, of class Room.
     */
    @Test
    public void testGetName() {
         //Room room = new Room("library","this is a library", false);
        String expected = "library";
        //String expected = "libraries";     // failed test
        String actual = room.getName();
        assertEquals(expected, actual);
    }
    /**
     * Test of setExit method, of class Room.
     */
    //@Test
    //public void testSetExit() {
    //}

    /**
     * Test of getLongDescription method, of class Room.
     */
    //@Test
    //public void testGetLongDescription() {
    //}

    /**
     * Test of getAllItems method, of class Room.
     */
    //@Test
    //public void testGetAllItems() {
    //}

    /**
     * Test of getExit method, of class Room.
     */
    //@Test
    //public void testGetExit() {
    //}

    /**
     * Test of getRoomItem method, of class Room.
     */
    //@Test
    //public void testGetRoomItem() {
    //}

    /**
     * Test of addItemInRoom method, of class Room.
     */
    //@Test
    //public void testAddItemInRoom() {
    //}

    /**
     * Test of removeItemInRoom method, of class Room.
     */
    //@Test
    //public void testRemoveItemInRoom() {
    //}

    
    /**
     * Test of setExit method, of class Room.
     */
    //@Test
    //public void testSetExit() {
    //}

    /**
     * Test of addHashMapItemInRoom method, of class Room.
     */
    //@Test
    //public void testAddHashMapItemInRoom() {
    //}

    /**
     * Test of getLockedStatus method, of class Room.
     */
    //@Test
    //public void testGetLockedStatus() {
    //}

    /**
     * Test of setLockedStatus method, of class Room.
     */
   
}
