

public class item_inventory {
    int sword, heal_potion, clear_potion,smokebomb,coin;
    public item_inventory(){
        this.sword =0;
        this.heal_potion=0;
        this.clear_potion=0;
        this.smokebomb=0;
        this.coin=0;
    }
    /*
     * TODO: SWORD
     * state from 0 -> 1 to mark that we have a sword and it will last N movements 
     * boost damage by .5 percent, this means 1.5 in total
     */
    public Double got_sword(Double  damage){
        this.sword=1;
       
        double boostedDamage = damage * 1.5; // Boost the damage by 50%
        return (double) status_effect.boostPower(boostedDamage);
    }
    public int rem_sword(int damage){
        this.sword=0;
        //calls the weak
        return status_effect.weak(damage);
    }
    /*
     * TODO: Heal potion
     * change the state of the life with a caping limit of 100
     *  if updated_life_of_user > 100?  life_of_user=100;
     */

     /*
      * TODO: clear potion
      * clears all the states from a user poison, etc
      * set all the states to 0
      */

      /* 
       * TODO: SMOKE BOMB
       * implement luck
       * this will give you 25 points of luck when you use it, it will last 3 seconds
       * the way it works is when you click run, it will generate a random number then it will ad 25 points to that 
       * and see if you can run.
       */

       /*
        * TODO: COIN
        * this is the currency of the game
        */
    
    
    
    
}



