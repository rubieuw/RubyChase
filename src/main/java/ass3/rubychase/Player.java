package ass3.rubychase;

import java.util.ArrayList;


/**
 * This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  
 * 
 * This class has information about the player's inventory.
 * The inventory consist of item that the player takes as he travels in the game.
 * 
 * @author Rubie Nunnoo
 * @version 1.0
 */
public class Player
{
    
    private ArrayList<Item> playerItem;
    
    public Player()
    {
        playerItem = new ArrayList();
    }
    
    /**
    * Write a description of class Player here.
    *
    * @param (your name)
    * @return (a version number or a date)
    * @exception (a version number or a date)
    * @see (a version number or a date)
    */
    
    public void addItemInventory(Item item){
        playerItem.add(item);
        //System.out.println(item.getDescription() + " was taken ");
        ////System.out.println(item.getDescription() + " was removed from the room"); // add extra information to inform user that the item has been taken
    }

    public void removeItemInventory(Item item){
        playerItem.remove(item);
        //// System.out.println(item.getName() + " was removed from your inventory");
    }
    
    public Item getPlayerItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: playerItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
    
    public String printAllInventory(){

        String returnString = "Items:";
        for(Item item : playerItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    
}
