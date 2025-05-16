import java.util.HashMap;

// The Dungeon class manages the dungeon map, including room descriptions,
// enemies, and items placed throughout the map.
public class Dungeon {
    
    //stores descriptions for each room using coordinaes as keys (e.g., "0,0")
    private HashMap<String, String> rooms;

    //stores enimies at specific coordinates
    private HashMap<String, Enemy> enemies;

    //stores items located in rooms
    private HashMap<String, String> roomItems;

    //Constructor initializes the room, enemy, and item maps
    public Dungeon() {
        rooms = new HashMap<>();
        enemies = new HashMap<>();
        roomItems = new HashMap<>();
        populateDungeon(); // Fill the dungeon with initial data
    }

    //populates the dungeon with room descriptions, enemies, and items
    private void populateDungeon() {
        
        // add descriptions for each room. Each key represenmts a coordinate on the map.
        rooms.put("-2,-2", "You stand at the entrance of a dark and musty dungeon.");
        rooms.put("-2,-1", "A moss-covered hallway stretches before you.");
        rooms.put("-2,0", "You enter a dimly lit room.");
        rooms.put("-2,1", "A moss-covered hallway stretches before you.");
        rooms.put("-2,2", "You have stumbled into a room littered with human bones.");
        rooms.put("-1,-2", "A moss-covered hallway stretches before you.");
        rooms.put("-1,-1", "You have entered a chamber filled with eerie statues.");
        rooms.put("-1,0", "A moss-covered hallway stretches before you.");
        rooms.put("-1,1", "You have stumbled into a room thick with fog.");
        rooms.put("-1,2", "A moss-covered hallway stretches before you.");
        rooms.put("0,-2", "You have entered an empty room.");
        rooms.put("0,-1", "A moss-covered hallway stretches before you.");
        rooms.put("0,0", "You stand at what looks to be the center of the dungeon.");
        rooms.put("0,1", "A moss-covered hallway stretches before you.");
        rooms.put("0,2", "You have stumbled into an empty chamber.");
        rooms.put("1,-2", "A moss-covered hallway stretches before you.");
        rooms.put("1,-1", "You find a room littered with dead snake skins.");
        rooms.put("1,0", "A moss-covered hallway stretches before you.");
        rooms.put("1,1", "You have entered a room filled with rotten corpses.");
        rooms.put("1,2", "A moss-covered hallway stretches before you.");
        rooms.put("2,-2", "You enter a den filled with unsettling noises.");
        rooms.put("2,-1", "A moss-covered hallway stretches before you.");
        rooms.put("2,0", "You enter a shadowy room.");
        rooms.put("2,1", "A moss-covered hallway stretches before you.");
        rooms.put("2,2", "You have reached a grand chamber glittering with gold. A terrifying shadow stirs... the Dungeon Lord awaits!");

        // places enimies in specific rooms with health and attack values
        enemies.put("-2,2", new Enemy("Skeleton", 20, 5));
        enemies.put("-1,1", new Enemy("Ghost", 12, 3));
        enemies.put("1,-1", new Enemy("Snake", 3, 4));
        enemies.put("2,-2", new Enemy("Wolf", 10, 5));
        enemies.put("1,1", new Enemy("Zombie", 5, 6));
        enemies.put("-1,-1", new Enemy("Statue", 25, 2));
        enemies.put("2,2", new Enemy("Dungeon Lord", 50, 10));

        // place healing potions in a variety of rooms
        String[] potionLocations = {
            "-2,2", "-2,1", "-2,0", "-2,-1",
            "-1,0", "0,0", "1,0", "2,1", "2,0", "2,-1", "2,-2"
        };
        for (String loc : potionLocations) {
            roomItems.put(loc, "Healing Potion");
        }
    }

    //prints the description of the room at the given coordinates
    public void describeRoom(int x, int y) {
        String key = x + "," + y;

        if (rooms.containsKey(key)) {

            //print the room's description
            System.out.println(rooms.get(key));

            //If therre is a living enemy in the room, describe it
            Enemy enemy = enemies.get(key);
            if (enemy != null && enemy.isAlive()) {
                System.out.println("You see a " + enemy.getName() + " here! It looks hostile.");
            }

            //If there's an item in the room, mention it
            if (roomItems.containsKey(key)) {
                System.out.println("You also notice a " + roomItems.get(key) + " on the ground.");
            }

            System.out.println();
        } else {
            System.out.println("You wander into a dark void... (no room here yet)\n");
        }
    }

    //Adds a new enemy to a room, if one dosent already exsist there
    public void addEnemy(int x, int y, Enemy enemy) {
        String key = x + "," + y;
        enemies.putIfAbsent(key, enemy);
    }

    //Gets the enemy located at a given position
    public Enemy getEnemyAt(int x, int y) {
        return enemies.get(x + "," + y);
    }

    //Adds an item to a specific room
    public void addItemToRoom(int x, int y, String item) {
        roomItems.put(x + "," + y, item);
    }

    //Gets the item located at a specific room
    public String getItemAt(int x, int y) {
        return roomItems.get(x + "," + y);
    }

    //Removes an item from a room (e.g., after player picks it up)
    public void removeItemAt(int x, int y) {
        roomItems.remove(x + "," + y);
    }
}