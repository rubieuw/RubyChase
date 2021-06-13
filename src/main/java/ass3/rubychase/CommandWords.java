package ass3.rubychase;

/**
 * This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  .
 * 
 * This class features to command words used in the game.
 * 
 * @author  Rubie Nunnoo
 * @version 2.0
 */

public class CommandWords
    {
    // a constant array that holds all valid command words
    private static final String[] validCommands = 
    {
        "go", "quit", "help", "take", "drop", "use", "inventory", "pull"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, if it isn't false
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
