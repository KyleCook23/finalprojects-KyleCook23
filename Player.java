import java.util.Stack;

/*
 * The Player class represents the player-controlled character.
 * It tracks the player's position (x,y), health, and inventory (using a stack).
 */
public class Player {
    private int x; // Player's x-coordinate in the dungeon grid
    private int y; // Player's y-coordinate in the dungeon grid
    private Stack<String> inventory; // Inventory stack to store items
    private int health; // Current health points
    private final int maxHealth = 100; // Maximum health points
    
    //setting up boundries around the dungeon so we dont wonder off the grid
    private final int minX = -2; 
    private final int maxX = 2;
    private final int minY = -2;
    private final int maxY = 2;

    // Constructor initializes the player's position, health, and empty inventory
    public Player() {
        this.x = -2; // Starting position x
        this.y = -2; // Starting position y
        this.inventory = new Stack<>(); // Initialize empty inventory stack
        this.health = maxHealth; // Start at full health
    }

    // Returns the player's current x position
    public int getX() {
        return x;
    }

    // Returns the player's current y position
    public int getY() {
        return y;
    }

    /*
     * Moves the player in the specified direction by updating x or y.
     * Accepts strings: "north", "south", "east", "west".
     */
    public void move(String direction) {
        
        switch (direction) {
            case "north":
                if (y + 1 <= maxY) {
                    y += 1;
                }else {
                    System.out.println("You cant move North, there is a wall there");
                    System.out.println();
                }
                break;
            case "south":
                if (y - 1 >= minY) {
                    y -= 1;
                }else {
                    System.out.println("You cant move South, there is a wall there");
                    System.out.println();
                }
                break;
            case "east":
                if (x + 1 <= maxX) {
                    x += 1;
                }else {
                    System.out.println("You cant move East, there is a wall there");
                    System.out.println();
                }
                break;
            case "west":
                if (x - 1 >= minX){
                    x -= 1;
                }else {
                    System.out.println("You cant move Weast, there is a wall there");
                    System.out.println();
                }
                break;
            default:
                System.out.println("Invalid direction.");
                return;
        }

        System.out.println("Moved " + direction + " to (" + x + ", " + y + ")");
        System.out.println();
    }

    // Adds an item to the player's inventory stack
    public void collectItem(String item) {
        inventory.push(item);
        System.out.println("Collected: " + item);
        System.out.println();
    }

    // Displays all items currently in the player's inventory
    public void showInventory() {
        System.out.println("Your Inventory:");
        System.out.println();
        if (inventory.isEmpty()) {
            System.out.println(" (empty)");
            System.out.println();
        } else {
            for (String item : inventory) {
                System.out.println(" - " + item);
            }
            System.out.println();
        }
    }

    /*
     * Uses the top item in the inventory stack. Healing potions heal the player.
     * If the item is not a Healing Potion, it has no effect.
     */
    public void useItem() {
        if (!inventory.isEmpty()) {
            String used = inventory.pop();
            System.out.println("Used item: " + used);
            System.out.println();

            // Only Healing Potion has an effect
            if (used.equalsIgnoreCase("Healing Potion")) {
                heal(20); // Heal by 20 points
            } else {
                System.out.println("Nothing happens.");
                System.out.println();
            }
        } else {
            System.out.println("No items to use!");
            System.out.println();
        }
    }

    // Returns the player's current health value
    public int getHealth() {
        return health;
    }

    /*
     * Reduces the player's health by a given damage amount.
     * Ensures health doesn't fall below 0.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    // Increases player's health, but does not exceed maxHealth.
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
        System.out.println("Healed " + amount + " HP. Current health: " + health);
        System.out.println();
    }

    // Returns true if the player is still alive (health > 0)
    public boolean isAlive() {
        return health > 0;
    }

    // Returns the inventory stack (used in other parts of the game)
    public Stack<String> getInventory() {
        return inventory;
    }

}