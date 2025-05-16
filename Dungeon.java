import java.util.HashMap;

/*
 * The Dungeon class manages all the rooms, enemies, and items in the dungeon.
 * It uses HashMaps to map coordinates (as string keys) to their room description,
 * any enemy present, or items in that room.
 */
public class Dungeon {
    
    // A HashMap that maps coordinates (like "0,1") to a String description of the room.
    private HashMap<String, String> rooms;

    // A HashMap that maps coordinates to an Enemy object, if an enemy exists at that position.
    private HashMap<String, Enemy> enemies;

    // A HashMap that maps coordinates to item names, used to track what item is on the ground.
    private HashMap<String, String> roomItems;

    // Constructor initializes all room, enemy, and item maps and populates the dungeon data.
    public Dungeon() {
        rooms = new HashMap<>();
        enemies = new HashMap<>();
        roomItems = new HashMap<>();
        populateDungeon(); // Sets up all initial data.
    }

    // This private method sets up the room descriptions, enemy placements, and items.
    private void populateDungeon() {
        
        // Populate descriptions for each room using its coordinate key.
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

        // Populate enemies in specific rooms.
        enemies.put("-2,2", new Enemy("Skeleton", 20, 5));
        enemies.put("-1,1", new Enemy("Ghost", 12, 3));
        enemies.put("1,-1", new Enemy("Snake", 3, 4));
        enemies.put("2,-2", new Enemy("Wolf", 10, 5));
        enemies.put("1,1", new Enemy("Zombie", 5, 6));
        enemies.put("-1,-1", new Enemy("Statue", 25, 2));
        enemies.put("2,2", new Enemy("Dungeon Lord", 50, 10));

        // Place healing potions in several rooms
        String[] potionLocations = {
            "-2,2", "-2,1", "-2,0", "-2,-1",
            "-1,0", "0,0", "1,0", "2,1", "2,0", "2,-1", "2,-2"
        };
        for (String loc : potionLocations) {
            roomItems.put(loc, "Healing Potion");
        }
    }

    /*
     * Outputs a description of the current room based on the player's x and y position.
     * Also shows enemies and items if present.
     */
    public void describeRoom(int x, int y) {
        String key = x + "," + y; // Convert coordinates to a key string.

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

    // Adds a new enemy to a specific room only if no enemy is already there.
    public void addEnemy(int x, int y, Enemy enemy) {
        String key = x + "," + y;
        enemies.putIfAbsent(key, enemy);
    }

    // Retrieves the Enemy object at a given coordinate.
    public Enemy getEnemyAt(int x, int y) {
        return enemies.get(x + "," + y);
    }

     // Adds an item to a specific room (e.g., Healing Potion).
    public void addItemToRoom(int x, int y, String item) {
        roomItems.put(x + "," + y, item);
    }

    // Gets the item in the room, if any.
    public String getItemAt(int x, int y) {
        return roomItems.get(x + "," + y);
    }

    // Removes the item after the player picks it up.
    public void removeItemAt(int x, int y) {
        roomItems.remove(x + "," + y);
    }
}