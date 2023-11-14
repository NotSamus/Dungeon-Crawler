    public class player extends vs{
        int Health;
        long score;
        double damage;
        int heal_potion;
        public static item_inventory playerInventory = new item_inventory();
        public static status_effect player_effect = new status_effect();

        /**
         * This is the constructor for the player object
         */
        public player(){
            this.Health = 100 ;
            this.score=0;  
            this.damage = 7.0;
            this.heal_potion=3;
        }
        /**
         * This method will set the health of the player, this is to update the health when we get hit
         * it will take health as a parameter, to update.
         * @param health
         */
        public void set_health(int health){
           this.Health = health;
           
        }
        /**
         * this method will retrieve the health of the player. 
         * @return the health of the player
         */
        public int get_health(){
            return Health;
        }
        /**
         * this method will retrieve the damage of the player.
         * @return the damage of the player
         */
        public double get_damage(){
            return this.damage;
        }
        /**
         * this will take as a parameter an updated damage 
         * @param dam damage updated
         */
        public void set_damage(double dam){
            this.damage = dam;
        }
        
        /**
         * will return the item inventory of and specific user
         * @return the player inventory
         */
        public static item_inventory gItem_inventory(){
            return playerInventory;
        }
        /**
         * this method will retrieve the heal potion for the player.
         * @return heal potion
         */
        public int get_heal_potion(){
            return heal_potion;
        }
        /**
         * update the heal potion of the player
         * @param heal
         */
        public void set_heal_potion(int heal){
            this.heal_potion = heal;
        } 
        /**
         * will update the score of the player
         * @param score_new
         */
        private void update_score(long score_new){
            this.score = score+score_new;
        }
        /**
         * will check if it is a game over
         * @param numLives
         */
        public void gameOVer (int numLives){
            if (numLives == 0){
                System.out.println("Game Over");
            }
            
        }

}
