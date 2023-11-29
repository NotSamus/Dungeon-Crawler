
/**
 * This class represents the item inventory and gives an item count.
 * Items: sword, heal potion, clear potion, smokebomb, coin
 * all ints set to 0, since we have no items until we open a chest.
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class item_inventory {
    int sword, heal_potion, clear_potion,smokebomb,coins;
    
    /**
     * Constructs a new item inventory with all item counts set to zero.
     */
    public item_inventory(){
        this.sword =0;
        this.heal_potion=0;
        this.clear_potion=0;
        this.smokebomb=0;
        this.coins=0;
    }

    /**
     * Sets the number of swords in the player's inventory.
     * 
     * @param sword The new number of swords in the player's inventory.
     */
    public void set_sword(int sword1){
         this.sword = sword1;
    }
    
    /**
     * Gets the number of swords in the player's inventory.
     * 
     * @return The number of swords in the player's inventory.
     */
    public int get_sword(){
        return sword;
    }

    /**
     * Sets the number of healing potions in the player's inventory.
     * 
     * @param heal_potion The new number of healing potions in the player's inventory.
     */
    public void set_heal_potion(int heal_potion1){
        this.heal_potion =heal_potion1;
    }

    /**
     * Gets the number of healing potions in the player's inventory.
     * 
     * @return The number of healing potions in the player's inventory.
     */
    public int get_heal_potion(){
        return heal_potion;
    }
    
    /**
     * Sets the number of clearing potions in the player's inventory.
     * 
     * @param clear_potion1 The new number of clearing potions in the player's inventory.
     */
     public void set_clear_potion(int clear_potion1){
        this.clear_potion= clear_potion1;
    }
    
    /**
     * Gets the number of clearing potions in the player's inventory.
     * 
     * @return The number of clearing potions in the player's inventory.
     */
    public int get_clear_potion(){
            return clear_potion;
            
    }
        
        
    /**
     * Sets the number of smoke bombs in the player's inventory.
     * 
     * @param smokebomb1 The new number of smoke bombs in the player's inventory.
     */
    public void set_smokebomb(int smokebomb1){
        this.smokebomb= smokebomb1;
    }

    /**
     * Gets the number of smoke bombs in the player's inventory.
     * 
     * @return The number of smoke bombs in the player's inventory.
     */
    public int get_smokebomb(){
        return smokebomb;
    }
    
    /**
     * Sets the number of coins in the player's inventory.
     * 
     * @param coins1 The new number of coins in the player's inventory.
     */
    public void set_coin(int coins1){
        this.coins= coins + coins1;
    }

    /**
     * Gets the number of coins in the player's inventory.
     * 
     * @return The number of coins in the player's inventory.
     */
    public int get_coins(){
        return coins;
    }

    public void add(String selection) {
    }
    
    
}



