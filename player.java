    public class player extends item_inventory{
        int Health;
        int numLives;
        long score;
        int damage;
        public static item_inventory playerInventory = new item_inventory();

        public player(){
            this.Health=100;
            this.numLives=3;
            this.score=0;  
            this.damage = 50;
        }
        public int get_damage(){
            return damage;
        }
        public void set_damage(int dam){
            this.damage = dam;
        }
        public void decNumLives(){
            numLives--;
            gameOVer(numLives);
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

        public void add_sword(){
            this.damage = player.playerInventory.got_sword(damage);
        }
        public void rem_sword(){
            this.damage = player.playerInventory.got_sword(damage);
        }
    
}
