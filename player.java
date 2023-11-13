    public class player extends vs{
        int Health;
        long score;
        double damage;
        int heal_potion;
        public static item_inventory playerInventory = new item_inventory();
        public static status_effect player_effect = new status_effect();
        public player(){
            this.Health = 100 ;
            this.score=0;  
            this.damage = 4.0;
            this.heal_potion=3;

        }
        public void set_health(int health){
           this.Health = health;
           
        }
        public int get_health(){
            return Health;
        }
        public double get_damage(){
            return damage;
        }
        public void set_damage(double dam){
            this.damage = dam;
        }
        public int get_heal_potion(){
            return heal_potion;
        }
        public void set_heal_potion(int heal){
            this.heal_potion = heal;
        } 
        
        public static item_inventory gItem_inventory(){
            return playerInventory;
        }
        // public void update_score(){
        //     long score_new = //method pulled from the main local_score
        //     this.update_score(score_new);
        // }
        private void update_score(long score_new){
            this.score = score+score_new;
        }
        public void gameOVer (int numLives){
            if (numLives == 0){
                System.out.println("Game Over");
            }
            // update_score();//update the score
            /**
             * FIX: the score is the one you get when you defeat enemies. opens chest,etc.
             */
        }

        
    
}
