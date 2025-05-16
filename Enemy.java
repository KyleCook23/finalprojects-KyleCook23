/*
 * The Enemy class represents a hostile creature that the player can fight.
 * It contains properties such as name, health, and attack power.
 * It also provides methods for combat interactions.
 */
public class Enemy {
    private String name; // Name of the enemy (e.g., "Goblin", "Dungeon Lord")
    private int health; // Current health of the enemy
    private int attack; // Attack strength (how much damage it deals per attack)

    //Constructor: creates a new enemy with a name, starting health, and attack value
    public Enemy(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    // Returns the name of the enemy (for display or identification)
    public String getName() {
        return name;
    }

    // Returns the current health of the enemy
    public int getHealth() {
        return health;
    }

    // Reduces the enemy's health by a certain amount of damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Prevent negative health
        }
    }

    // Returns the attack strength of the enemy
    public int getAttack() {
        return attack;
    }

    // Checks if the enemy is still alive
    public boolean isAlive() {
        return health > 0;
    }
}