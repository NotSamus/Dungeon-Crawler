

public class item_inventory {
    int sword, heal_potion, clear_potion,smokebomb,coins;
    
    public item_inventory(){
        this.sword =0;
        this.heal_potion=0;
        this.clear_potion=0;
        this.smokebomb=0;
        this.coins=0;
    }
    /*
     * TODO: SWORD
     * state from 0 -> 1 to mark that we have a sword and it will last N movements 
     * boost damage by .5 percent, this means 1.5 in total
     */
    public void set_sword(int sword1){
         this.sword= sword1;
    }
    
    public int get_sword(){
        return sword;
    }
    /*
     * TODO: Heal potion
     * change the state of the life with a caping limit of 100
     *  if updated_life_of_user > 100?  life_of_user=100;
     */
    public void set_heal_potion(int heal_potion1){
        this.heal_potion =heal_potion1;
    }
    public int get_heal_potion(){
        return heal_potion;
    }
     /*
      * TODO: clear potion
      * clears all the states from a user poison, etc
      * set all the states to 0
      */
     public void set_clear_potion(int clear_potion1){
        this.clear_potion= clear_potion1;
    }
    
    public int get_clear_potion(){
            return clear_potion;
            
    }
        
        
      /* 
       * TODO: SMOKE BOMB
       * implement luck
       * this will give you 25 points of luck when you use it, it will last 3 seconds
       * the way it works is when you click run, it will generate a random number then it will ad 25 points to that 
       * and see if you can run.
       */
    public void set_smokebomb(int smokebomb1){
        this.smokebomb= smokebomb1;
    }
    public int get_smokebomb(){
        return smokebomb;
    }
    
       /*
        * TODO: COIN
        * this is the currency of the game
        */
    public void set_coin(int coins1){
        this.coins= coins1;
    }
    public int get_coins(){
        return coins;
    }
    
    
}



