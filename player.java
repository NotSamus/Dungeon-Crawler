//class player extends user {

    //public player(String firstName, String lastName, String username, String state, String lastSignIn, String loginTime,
            //String pin, String city, String zip, String dateOfBirth, String totalPlayTime) {
        //super(firstName, lastName, username, state, lastSignIn, loginTime, pin, city, zip, dateOfBirth, totalPlayTime);
        //TODO Auto-generated constructor stub
    //}
    class player {
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
        
            public int addScore(int score){
                score++;
                return score;
            }
        
            public int decHealth(int attack){
                Health-=attack;
                return Health;
            }
    
}
