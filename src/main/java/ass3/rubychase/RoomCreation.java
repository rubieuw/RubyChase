package ass3.rubychase;

import java.util.ArrayList;

/**
 *  This class is part of the "Ruby Chase" game. 
 * "Ruby Chase" is a very simple, text based adventure and thriller game.  
 * 
 * The RoomCreation class has information about the rooms in the game.  
 * There are five rooms and some are locked.
 * The Ogre's Den has a secret passage under the royal museum.
 * 
 * @author  Rubie Nunnoo
 * @version 2.0
 */

public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    
    private void createRooms() {

        Room castle, museum, gate, forest, den;

        castle = new Room("castle", "The Queen's is here waiting for her Ruby!", false);
        museum = new Room("museum", "The Museum door lock has the shape of a heart", false);
        gate = new Room("gate", "The Gate protects the Castle against the giant ogre from the outside Forest", true);
        forest = new Room("forest", "You are out in the wilderness. Beware of the lumbering grim creatures!", true);
        den = new Room("Den", "You are at the Ogre's Den", false);
        
        
        // creating the exits in the rooms
        castle.setExit("east", museum);
        castle.setExit("south", gate);
        museum.setExit("west", castle);
        gate.setExit("north", castle);
        gate.setExit("south", forest);
        forest.setExit("north", gate);
        forest.setExit("underground", den);
        den.setExit("upstairs", museum);

        
        // add the items in their respective rooms
        museum.addItemInRoom(itemCreation.getItem("sword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        gate.addItemInRoom(itemCreation.getItem("lever"));
        forest.addItemInRoom(itemCreation.getItem("ogre"));
        den.addItemInRoom(itemCreation.getItem("ruby"));

        
        // add the rooms in the game
        allRoomInGame.add(castle);
        allRoomInGame.add(gate);
        allRoomInGame.add(museum);
        allRoomInGame.add(forest);
        allRoomInGame.add(den);

    }

    public Room getRoom(String stringRoom) {
        Room roomToReturn = null;
        for (Room room : allRoomInGame) {
            if (room.getName().contains(stringRoom)) {
                roomToReturn = room;
            }
        }
        return roomToReturn;
    }

}
