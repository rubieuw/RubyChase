
package ass3.rubychase;
/**
 *  This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  
 * 
 *
 * @author Rubie Nunnoo
 * @version 1.0
 */
public class Item
{
    private final String name;
    private final String description;
  
    private int destructivePower;
    //private double healingPower;
    
    public Item(String name, String description, int destructivePower)
    {
        this.name = name;
        this.description = description;
        
        this.destructivePower = destructivePower;
    }

    
    //public Item(String name, String description, double healingPower)
    //{
       // this.name = name;
       // this.description = description;
       // this.healingPower = healingPower;
    //}
    
    //write accessors and mutators
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    //@return
    
    public int getPower(){
    return destructivePower;
    }
}
    
   
