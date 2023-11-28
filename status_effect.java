public class status_effect {
    int poison;
    int luck;
    double boostPower;
    /*
     * This class is for the states of the player, will be implemented with the player
     * this is for the battle system
     */
    public void set_luck(int luck){
        this.luck=luck;
    }
    public int get_luck(){
        return luck;
    }
    /**
     * This will take as a parameter a double containing the Boosted damage of the player
     * the damage of the player is over 100
     * @param boostedDamage
     * @return return the damage of the user *1.5
     */
    public static double boostPower(double boostedDamage){
        return boostedDamage +25;
    }
    /**
     * this method will return the weak power of a player by 0.5
     * @param power
     * @return power * 0.5
     */
    public static int weak(int power){
        return power - 25;
    }
}
