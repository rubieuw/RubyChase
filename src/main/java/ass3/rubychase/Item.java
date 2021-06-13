
package ass3.rubychase;
/**
 *  This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  
 * 
 *
 * @author Rubie Nunnoo
 * @version 2.0
 */
public class Item
{
    private final String name;
    private final String description;
  
    private final int destructivePower;
    //private double healingPower;
    
    /**
     * Creation of items, (attributing names, descriptions and power).
     * @param name name of item
     * @param description description of item
     * @param destructivePower level of item destructive power
     */
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
    
    /**
     * Given a command, process the command.
     * @return the name of the current item.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Given a command, process the command.
     * @return the current item description.
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Given a command, process the command.
     * @return the destructive power of the current item.
     */
    public int getPower(){
    return destructivePower;
    }
}
    
   
