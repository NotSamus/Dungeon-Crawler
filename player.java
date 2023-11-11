    public class player {
        public int Health = 100;
        public int numLives = 3;
        public int score = 0;
        
        public int decNumLives(){
            numLives--;
            return numLives;
        }
        
        public void gameOVer (int numLives){
            if (numLives == 0){
                System.out.println("Game Over");
            }
            score++;
            
        }

    
}
