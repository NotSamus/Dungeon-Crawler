public class status_effect {
    int poison;
    int luck;
    int boostPower;
    /*
     * This class is for the states of the player, will be implemented with the player
     * this is for the battle system
     */
    public static int boostPower(double boostedDamage){
        return boostedDamage+25;
    }
    public static int weak(int power){
        return power-25;
    }
}
