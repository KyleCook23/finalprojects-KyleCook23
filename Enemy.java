//The enemy class represents any enemy character in the dungeon.
//Such as Skeletons, Ghosts, or the Dungeon Lord.
//It stores the enemy's name, health points, and attack damage.

public class Enemy {
    private String name;
    private int health;
    private int attack;

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