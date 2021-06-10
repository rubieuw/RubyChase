package ass3.rubychase;


import java.util.ArrayList;

public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    
    private void createRooms() {

        Room castle, museum, gate, forest;

        castle = new Room("castle", "You are at the castle", false);
        museum = new Room("museum", "You are at the museum. The museum door lock has the shape of a heart", true);
        gate = new Room("gate", "There is a giant ogre forest", true);
        forest = new Room("forest", "You are out in the wild. The ruby is somewhere here!", false);

        castle.setExit("east", museum);
        castle.setExit("south", gate);
        museum.setExit("west", castle);
        gate.setExit("north", castle);
        gate.setExit("south", forest);
        forest.setExit("north", gate);

        museum.addItemInRoom(itemCreation.getItem("sword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        gate.addItemInRoom(itemCreation.getItem("lever"));
        forest.addItemInRoom(itemCreation.getItem("ruby"));
        forest.addItemInRoom(itemCreation.getItem("orgre"));

        allRoomInGame.add(castle);
        allRoomInGame.add(gate);
        allRoomInGame.add(museum);
        allRoomInGame.add(forest);

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
