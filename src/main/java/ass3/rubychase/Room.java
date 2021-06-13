package ass3.rubychase;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *  This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  
 * 
 * The room class has information about the methods used for the rooms.  
 * These include room lock status, room name, room description and other methods.
 * 
 * @author  Rubie Nunnoo
 * @version 2.0
 */

public class Room 
{
    private String description;
    private String name;
    private boolean isLocked;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> roomItem;
    private HashMap<Room, Item> roomHashMapItem;

    /**
     * Create a room described "description". Initially, it has no exits.
     * @param name the name of the room.
     * @param description The room's description.
     * @param isLocked the room lock status.
     */
    public Room(String name, String description, boolean isLocked) 
    {
        this.description = description;
        this.name = name;
        this.isLocked = isLocked;
        exits = new HashMap<>();
        roomItem = new ArrayList();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Given a command, process the command.
     * A short description only
     * @return The short description of the room.
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Given a command, process the command.
     * A long description of the room in the form: 
     * short description + exits + items present.
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are at the " + name + ".\n" + description + ".\n" + getExitString() + ".\n" + getAllItems();
    }

    /**
     * Given a command, process the command.
     * @return a list of all items
     */
    public String getAllItems(){

        return listOfItems();
        
    }

    /**
     * Given a command, process the command.
     * @return a list of all items present in the room
     */
    private String listOfItems(){

        String returnString = "items present:";
        for(Item item : roomItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    
    }

    /**
     * Return a string describing the room's exits
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Method getRoomItem
     * @param stringItem taken from the command which was converted into a String
     * @return Item class according to the input String
     */
    public Item getRoomItem(String stringItem)
    {
        Item itemToReturn = null;
        for(Item item: roomItem)
        {
            if(item.getName().contains(stringItem))
            {
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }

    /**
     * Given a command, process the command.
     * Add an item to a room.
     * @param item item to add.
     */
    public void addItemInRoom(Item item)
    {
        roomItem.add(item);
    }

    /**
     * Given a command, process the command.
     * Remove an item from a room room if it exits in the room.
     * @param item item to remove.
     */
    public void removeItemInRoom(Item item)
    {
        if(roomItem.size() > 0)
        {
            roomItem.remove(item);
        }
    }
    /**
     * Given a command, process the command.
     * Stores items in " key / value " pairs, to be accessed by other index like a string.
     * Return a list of all items present in the room.
     * @param room to access.
     * @param item to access.
     */
    public void addHashMapItemInRoom(Room room, Item item)
    {
        roomHashMapItem.put(room, item);
    }

    /**
     * Method getLockedStatus
     * @return The return value
     */
    public boolean getLockedStatus()
    {
        return isLocked;
    }
   /**
     * Method setLockedStatus.
     * changes the lock status of the room from one state to another.
     * @param newStatus lock or unlocked depending on the player action.
     */
    public void setLockedStatus(boolean newStatus)
    {
        isLocked = newStatus;
    }
    
    /**
     * Given a command, process the command.
     * @return the name of the current Room.
     */
    public String getName()
    {
        return name;
    }

    ////boolean printAllRoomItems() {
       
    ////    return false;
       
    //// }

    
}

