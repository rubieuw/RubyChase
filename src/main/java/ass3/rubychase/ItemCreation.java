package ass3.rubychase;

import java.util.ArrayList;


/**
 * Write a description of class ItemCreation here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
        
        Item ruby, sword, key, lever, orgre;
        
        ruby = new Item("ruby", "The queen of all the gem stone", 999);
        sword = new Item("sword", "The legendary Excalibur", 1000);
        key = new Item("key", "It has the shape of a heart", 100);
        lever = new Item("lever", "To open the front gate", 100);
        orgre = new Item("orgre", "A giant orgre", 600);
        allItemsInGame.add(ruby);
        allItemsInGame.add(sword);
        allItemsInGame.add(key);
        allItemsInGame.add(lever);
        allItemsInGame.add(orgre);
    }
   
    public Item getItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: allItemsInGame){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
  
    
}
