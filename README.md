# Axolots

## Things To do for Part 2:
### This is not coding
- Write a Level II UML Use Case Diagram based on part B (4 Use Cases, 2 Actors, 2 Extends, 3 Includes.)
- Write 2 Use case scenarios based on part B
- Write a refractored UML Class Diagram to structure your code using the classes, requirements, and concepts described in PART B
### This is Coding
- Refractor you Existing Code 
  - fix anything that should be corrected
- Handle receiving an input file that does not have the information listed instandard column orders as previous assignment. (For instance, Identification Number is not column 1, First Name is not column 2, etc).
- Create and use and interface in your system.
  - the system should be used in at least 2 different classes.
  - it may be necessary to refractor your code
  - Consider using a design patter to meet this requirement.
- Use a design patter as part of your refractoring process.
  - select one of the design patterns discussed in class or use one that you have researched on your own.
  - discuss its use in the lab report.
-   add new user functionality 
    -   add attributes for statistics of battles won, battles lost, number of times they have finished the game, number of items picked up.
- add new player functionality 
    - the player will describe new attributes 
      - health points = 5
      - attack power = 5
      - inventory
      - battle won/lost
    - an inventory has a maximum capacity of 5 items.
    - a player should be able to open their inventory and see the contents inside.
    - a player should have the option to use an item in their inventory
    - a player should have the option to discard an item in their inventory.
- add an item class 
  - When the player reaches a chest symbol, a random Item should be generated, and give the player the option to add the Item to their inventory or discard them 
  - Items include :
    - Sword Upgrade (Boosts player damage)
    - Heart Upgrade (Gives Player more health points)
    - Clear Potion (Clears all Player status effects)
    - Smoke Bomb (increases player chances of escaping a battle)
    - Coin(s)
- Add new dungeon Crawler game functionality (create the battle system and the randomization of items in chests)
  - cells that a player has not been to must be set to not explored, while cells that a player has been to, must be set as explored. (Hint: you can use characters to denote each).
  - Add a Status effect class
    - boost attack effect 
      - lasts a single turn or cleared by the clear potion
    - Lower Attack Effect
      - Lasts Two turns or cleared bt the Clear potion
    - Poisoned Effect
      - Lasts until only one remaining health point is left or cleared by the clear potion.
  - Battle System: the battle system for the game is a sequence of alternating turns, such as
    - Player Turn -> Enemy Turn -> Player turn ->....
  - This repeats until the end of combat, where either the player runs out of health points, resulting in a game over, or the enemy runs out of health points. Note: if the player exits the game mid battle, the attributes of battle won and lost wont be updated but the time played will. you must implement the following:
    - Combat Turns:
      - combat turns will be menu based, allowing for the user to choose between the options
        - attack
        - use Item
        - Escape
      - Random Battle starts
      - Status effects that can affect players and enemies (status effects are modifiers that occur every turn change.)
      - a player can use items in their inventory during battle.
      - enemies should be automated to-do as minimum an attack to the player, you are free to add more to the actions an enemy can do.
      - Example of the battle system ui can be:

        EnemyName HP : 10 

        Player HP: 5

        ------
        Actions
        attack
        use items
        escape
        ------


Team members:
- Isaac Borjon
- Alejandro Rodriguez
- Don Rotchie
- Jesus Lopez

