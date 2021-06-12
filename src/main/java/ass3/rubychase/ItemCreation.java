package ass3.rubychase;

import java.util.ArrayList;


/**
 *  This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  
 * 
 * This class features all the items found in the game.
 * There are 5 items which means 1 item in each room.
 *
 * @author Rubie Nunnoo
 * @version 1.0
 */
public class ItemCreation
{
    
    private final ArrayList<Item> allItemsInGame;
    
    public ItemCreation()
    {       
        allItemsInGame = new ArrayList();
        createItems();
    }
    
    public final void createItems(){
        
        Item ruby, sword, key, lever, ogre;
        
        ruby = new Item("ruby", "The ruby, also known as the queen of gems", 1001);
        sword = new Item("sword", "The legendary Excalibur sword", 1000);
        key = new Item("key", "The heart shape key", 1);
        lever = new Item("lever", "The gate lock mechanism",1);
        ogre = new Item("ogre", "The giant ogre", 800);
        allItemsInGame.add(ruby);
        allItemsInGame.add(sword);
        allItemsInGame.add(key);
        allItemsInGame.add(lever);
        allItemsInGame.add(ogre);
    }
   
    public Item getItem(String stringItem)
    {
        Item itemToReturn = null;
        for(Item item: allItemsInGame)
        {
            if(item.getName().contains(stringItem))
            {
                itemToReturn = item;
            }
        }
    return itemToReturn;
    }
}
