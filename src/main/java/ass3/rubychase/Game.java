package ass3.rubychase;

/**
 * This class is part of the "Ruby Chase" game.
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  *
 * "Ruby Chase" game is about a queen who lost a ruby (gemstone)
 * and a Knight (the player) who sets out to find the precious stone for her majesty.
 * Otherwise, the queen will be banned from the kingdom for ever.
 *
 * @author  Rubie Nunnoo
 * @version 2.0
 */

 //import java.util.ArrayList;
 //import java.util.HashMap;

public class Game {

    private final Parser parser;
    private final Player player;
    private Room currentRoom;
    private final RoomCreation rooms;

    //private HashMap<Item, Room> roomItem;
    //private HashMap<Item, Room> roomKey;
    //private int timeCounter; // to count the steps
    private final long startTime;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        startTime = System.currentTimeMillis(); // use the real time
        //timeCounter = 50;

        parser = new Parser();
        player = new Player();
        rooms = new RoomCreation();

        currentRoom = rooms.getRoom("castle");
        // start game in the castle.
        //System.out.println(createRoom.getcurrentRoom().getName());
    }

    /**
     * Given a command, process the command.
     *
     * @return the current Room.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            //long currentTime = System.currentTimeMillis();
            Command command = parser.getCommand();
            // count the delta (currentTime - startTime)            
            finished = processCommand(command);
            finished = checkActualTime();
        }
        System.out.println("                   ---------------------------------------");
        System.out.println("                      Thank you for playing.  Good bye.");
    }

    /**
     * time counter check how long the player has been playing and stop the game
     * at 12 min.
     * @return finish
     */
    public boolean checkActualTime() {
        boolean check = false;
        long currentTime = System.currentTimeMillis();
        if ((currentTime - startTime) / 1000 / 60 > 12) {
            check = true;
            System.out.println("                                  Time Over!");
            System.out.println("                                  Game Over!");
        }
        return check;
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("                                  Welcome to 'The Ruby Chase'");
        System.out.println("                             **************************************");
        System.out.println("                      In this game, you have to find a Ruby for the Queen!");
        System.out.println("                  If the Queen does not find her precious gem before midnight,");
        System.out.println("                        the cruel king will ban her from the kingdom.");
        System.out.println("                             Quick! you have only 12 minutes left!");
        System.out.println("                      --------------------------------------------------");
        System.out.println("                                  Type 'help' if you are lost!");

        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.getCommandWord();

        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("inventory")) {
            printInventory(); // print player inventory item list
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("take")) {
            takeItem(command);
        } else if (commandWord.equals("drop")) {
            dropItem(command);
        } else if (commandWord.equals("pull")) {
            pullItem(command);
        } else if (commandWord.equals("use")) {
            useItem(command);
        } //else if (commandWord.equals("inspect")) 
        //{
        //lookItem(command);
        //} 
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        //else command not recognised.
        return wantToQuit;
    }

    /**
     * Print out some help information. Here we print the list of command words,
     * the current room description.
     */
    private void printHelp() {
        //System.out.println("");

        //implement random Hints -> massive bonus points 
        //System.out.println("you can open the door using the 'use' command");
        //System.out.println("you need to clear the ogre before you can open the museum door");
        System.out.println(currentRoom.getLongDescription());
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void printInventory() {
        System.out.println(player.printAllInventory());
    }

    /**
     * Try to go in to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            //if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        //Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Invalid command!");
        } else if ((currentRoom.getLockedStatus() == true) && (currentRoom.getName().equals("forest"))) { // The player must clear the ogre to unlock the current room and before moving to the next.
            System.out.println("You must clear the Ogre to continue your quest!");
        } else if (currentRoom.getLockedStatus() == true) { //the door is locked
            System.out.println("The door is locked, you need to find a way to open it");
            //System.out.println(currentRoom.getLongDescription());
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            //System.out.println(currentRoom.printAllRoomItems());
            //increment the timeCounter
        }
    }

    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            //if there is no second word, we don't know what to take
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);
        //get item from room

        if ((currentItem == null) || currentItem.getName().equals("lever")) // cannot take lever, it is part of the gate
        {
            System.out.println("Invalid command!");
        } else if (currentItem.getName().equals("ogre")) {
            System.out.println("Don't even think about it!");
        } else if ((currentItem.getName().equals("sword")) || (currentItem.getName().equals("ruby")) || (currentItem.getName().equals("key"))) {
            // Add item to inventory
            currentRoom.removeItemInRoom(currentItem);
            player.addItemInventory(currentItem);

            //roomItem.remove(currentItem);
            //addItemInventory(currentItem);
            System.out.println(currentItem.getDescription() + " was taken!");
        }
        //taking the sword results in locking the museum door
        //drop sword to unlock or use key
        if (currentRoom.getName().equals("museum") && currentItem.getName().equals("sword")) {
            currentRoom.setLockedStatus(true);
            System.out.println("The Museum door is now locked");
        }

    }

    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop
            System.out.println("Drop what?");
            return;
        }
        String itemFromCommand = command.getSecondWord();
        Item currentItem = player.getPlayerItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("Invalid command!");
        }
        if (currentRoom.getName().equals("castle") && currentItem.getName().equals("ruby")) // if the player drop the ruby at the castle. the queen will get it
        {
            System.out.println("                  You gave the Queen her Ruby! You saved the Queen!");

            System.out.println("                                       YOU WIN!");
            System.out.println("                                   CONGRATULATIONS!");
            System.out.println("                              --------------------------");
            System.out.println("                                 Type 'quit' to leave!");
        } else {
            // Do the transaction here to remove item from inventory
            player.removeItemInventory(currentItem);
            currentRoom.addItemInRoom(currentItem);

            //removeItemInventory(currentItem);
            //roomItem.put(currentItem, currentRoom);
            System.out.println(currentItem.getName() + " dropped!");
        }
        //taking the sword results in locking the museum door
        //drop sword to unlock or use key
        if (currentRoom.getName().equals("museum") && currentItem.getName().equals("sword")) {
            currentRoom.setLockedStatus(false);
            System.out.println("The Museum door is now unlocked");
        }
    }

    private void pullItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to pull.
            System.out.println("Pull what?");
            return;
        }
        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("Invalid command!");
        }
        if (currentItem.getName().equals("ogre")) //the player cannot pull the ogre
        {
            System.out.println("Don't even try!");
        } else if (currentRoom.getName().equals("gate") && currentItem.getName().equals("lever")) //pulling the gate lever will open the gate
        {
            currentRoom.setLockedStatus(false);
            System.out.println(currentItem.getName() + " pulled!");
            System.out.println("The gate is now open!");
        }
    }

    private void useItem(Command command) // use key
    {
        if (!command.hasSecondWord()) {
            //if there is no second word, we don't know what to use
            System.out.println("Use what?");
            return;
        }
        String itemFromCommand = command.getSecondWord();
        Item currentItem = player.getPlayerItem(itemFromCommand);
        //player cannot use items that are not in the inventory

        if (currentItem == null) {
            System.out.println("Invalid command!");
        } else {
            // you want make sure that the currentRoom is the room where you want to open the door (before the nextdoor).
            // you want to make sure the currentItem matches the key to open the next door.

            if (currentRoom.getName().equals("museum") && currentItem.getName().equals("key")) {
                //unlock museum door from inside
                currentRoom.setLockedStatus(false);
                System.out.println(currentItem.getName() + " used!");
                System.out.println("The Museum door is now unlocked");
            } else if (currentRoom.getName().equals("forest") && currentItem.getName().equals("sword")) {
                //kill the ogre with the sword
                currentRoom.setLockedStatus(false);
                System.out.println(currentItem.getName() + " used!");
                System.out.println("You have killed the giant Ogre!");
            } else if (currentRoom.getName().equals("castle") && currentItem.getName().equals("key")) {
                // cannot use museum door key when in the castle
                //currentRoom.checkRoom("castle");
                //roomKey.get(currentItem).setLockedStatus(false);

                System.out.println("You cannot use this item here");
            }
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}
