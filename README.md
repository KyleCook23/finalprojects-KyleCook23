[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19545059)
# cpsc39-finalProjects

## Name and Date
Kyle Cook
- May 15, 2025

# Dungeon Adventure Game

### Game Summary

You play as an adventurer exploring a mysterious dungeon made up of connected rooms arranged on a grid. As you move from room to room, you encounter enemies and find items like Healing Potions. Your goal is to survive by managing your health, collecting useful items, and defeating hostile creatures. To win, you must explore the dungeon, defeat all enemies you encounter, and keep your player alive by strategically using your inventory and engaging in combat.

---

## Description

This is a simple text-based dungeon adventure game written in Java. The game uses multiple classes to simulate a grid-based dungeon with rooms, enemies, and items. The player navigates the dungeon using commands, fights enemies, collects and uses items like healing potions, and tries to reach the final boss—the Dungeon Lord.

## Features
- Grid-based dungeon exploration
- Combat system with enemy attacks and health management
- Inventory system using a stack to store and use items
- Multiple enemy types with varying health and attack power
- Clear win and lose conditions

## How to Play
- Use commands like `north`, `south`, `east`, `west` to move around.
- Collect items automatically when entering rooms.
- Use `fight` to engage enemies in battle.
- Use `inventory` to view items you have.
- Use `use` to consume an item (e.g., Healing Potion).
- Use `quit` to exit the game.

## Requirements & Implementation Details

1. **Proper citation of code:** All code was written and explained by the developer with comments.
2. **Substantial code base:** The project consists of multiple classes totaling well over 40 lines.
3. **Comments & citations:** Each file and major code block contains comments explaining its function.
4. **Complete understanding:** Each line and method is written with clear purpose and understanding.
5. **Written in Java:** Entire project is implemented in Java.
6. **Algorithms used:**
   - Player movement and coordinate updating
   - Combat turn-based logic
   - Inventory management using stack operations
7. **Data Structures:**
   - `HashMap` for rooms, enemies, and items for efficient lookups
   - `Stack` for player inventory to model last-in-first-out item usage
   - Basic Java primitives (ints for coordinates and health)
8. **Multiple files:**
   - `Dungeon.java`
   - `Player.java`
   - `Enemy.java`
   - `Main.java`

---

