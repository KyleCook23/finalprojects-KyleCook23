import java.util.Scanner; // Scanner is used to read player input

/*
 * Main class: Entry point of the game.
 * Handles game loop, player actions, combat, movement, inventory use, and win/lose conditions.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in); // Scanner for user input
    static Player player = new Player(); // Create player object
    static Dungeon dungeon = new Dungeon(); // Create dungeon object

    public static void main(String[] args) {
        boolean running = true;  // Controls the main game loop
        System.out.println("Welcome to the Dungeon Adventure!");
        System.out.println();

        //Main game loop: runs until the player quits or dies
        while (running) {
            // // Show the description of the room the player is currently in
            dungeon.describeRoom(player.getX(), player.getY());

            // Prompt the player for input
            System.out.print("Enter a command (north / south / east / west / inventory / fight / use / quit): ");
            String command = scanner.nextLine().toLowerCase(); // Normalize to lowercase
            System.out.println("--------------------------------------------------");
            System.out.println();

            // Handle the player's command
            switch (command) {
                case "north":
                case "south":
                case "east":
                case "west":
                    
                    // Move the player in the chosen direction
                    player.move(command);

                     // Show current status
                    System.out.println("Status → Health: " + player.getHealth() + " | Inventory Items: " + player.getInventory().size());

                    // Check if there's an enemy in the new room
                    Enemy enemy = dungeon.getEnemyAt(player.getX(), player.getY());
                    if (enemy != null && enemy.isAlive()) {
                        System.out.println("You see a " + enemy.getName() + " here!");
                        System.out.println();
                    }

                    // Check if there's an item in the room and pick it up
                    String item = dungeon.getItemAt(player.getX(), player.getY());
                    if (item != null) {
                        System.out.println("You found a " + item + "!");
                        System.out.println();
                        player.collectItem(item);
                        dungeon.removeItemAt(player.getX(), player.getY());
                    }
                    break;

                case "inventory":
                    
                    // Show the items in the player's inventory
                    player.showInventory();
                    break;

                case "fight":
                    
                    // Attempt to fight an enemy in the current room
                    enemy = dungeon.getEnemyAt(player.getX(), player.getY());

                    if (enemy == null || !enemy.isAlive()) {
                        System.out.println("There's nothing to fight here.");
                        System.out.println();
                        break;
                    }

                    System.out.println("You engage in battle with the " + enemy.getName() + "!");
                    System.out.println();

                    // Simple turn-based battle loop
                    while (enemy.isAlive()) {
                        System.out.print("Choose your action (attack / run): ");
                        String action = scanner.nextLine().toLowerCase(); // Normalize user input
                        System.out.println("--------------------------------------------------");
                        System.out.println();

                        if (action.equals("attack")) {
                            int damage = 5; // Player always deals 5 damage
                            enemy.takeDamage(damage); // Apply damage to enemy
                            System.out.println("You hit the " + enemy.getName() + " for " + damage + " damage!");
                            System.out.println();

                            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " HP remaining.");
                            System.out.println();

                            // Check if enemy was defeated
                            if (!enemy.isAlive()) {
                                if (player.getX() == 2 && player.getY() == 2 && enemy.getName().equalsIgnoreCase("Dungeon Lord")) {
                                    System.out.println("You have defeated the Dungeon Lord!");
                                    System.out.println("The treasure is yours. You win the game!");
                                    running = false;
                                } else {
                                    System.out.println("You defeated the " + enemy.getName() + "!");
                                }
                                System.out.println();
                                break; // Exit the combat loop
                            }

                             // Enemy attacks back
                            int enemyDamage = enemy.getAttack();
                            System.out.println("The " + enemy.getName() + " hits you for " + enemyDamage + "!");
                            System.out.println();
                            player.takeDamage(enemyDamage); // Apply damage to player
                            System.out.println("Your current health: " + player.getHealth());
                            System.out.println();

                            // Check if player died
                            if (!player.isAlive()) {
                                System.out.println("You have been defeated! Game Over.");
                                System.out.println();
                                running = false;
                                break;
                            }
                        } else if (action.equals("run")) {

                            // Player runs away from battle
                            System.out.println("You fled from the fight!");
                            System.out.println();
                            break; // Exit the combat loop without ending game
                        } else {

                            // Invalid battle command
                            System.out.println("Invalid action. Please type 'attack' or 'run'.");
                            System.out.println();
                        }
                    }
                    break;

                case "use":

                    // Use the top item in the player's inventory (e.g., Healing Potion)
                    if (!player.getInventory().isEmpty()) {
                        player.useItem();
                    } else {
                        System.out.println("You have no items to use.");
                        System.out.println();
                    }
                    break;

                case "quit":

                    // Exit the game
                    System.out.println("Thanks for playing!");
                    System.out.println();
                    running = false;
                    break;

                default:

                    // Handle unrecognized commands
                    System.out.println("Invalid command. Try again!");
                    System.out.println();
                    break;
            }
        }
    }
}