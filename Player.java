import java.util.Stack;

// The Player class represents the user-controlled character in the dungeon.
// It keeps track of the player's position, health, inventory, and actions.
public class Player {
    private int x; // Player's x-coordinate in the dungeon grid
    private int y; // Player's y-coordinate in the dungeon grid
    private Stack<String> inventory; // Inventory stack to store items
    private int health; // Current health points
    private final int maxHealth = 100; // Maximum health points

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

    // Moves the player one tile in the specified direction
    public void move(String direction) {
        switch (direction) {
            case "north":
                y += 1;
                break;
            case "south":
                y -= 1;
                break;
            case "east":
                x += 1;
                break;
            case "west":
                x -= 1;
                break;
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

    // Uses the top item in the inventory (like a healing potion)
    public void useItem() {
        if (!inventory.isEmpty()) {
            String used = inventory.pop();
            System.out.println("Used item: " + used);
            System.out.println();

            // Only Healing Potion has an effect
            if (used.equalsIgnoreCase("Healing Potion")) {
                heal(20);
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

    // Reduces the player's health by a specified damage amount
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    // Increases the player's health by a set amount (e.g., healing)
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