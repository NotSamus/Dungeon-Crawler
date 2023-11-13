public class status_effect {
    int poison;
    int luck;
    double boostPower;
    /*
     * This class is for the states of the player, will be implemented with the player
     * this is for the battle system
     */
    public status_effect(){
        this.poison=0;
        this.luck=25; //this is base luck
        this.boostPower=0.0;
    }
    
    public double boostPower(double boostedDamage){
        return boostedDamage+25;
    }
    public int lower_attack_effect(int power){
        return power-25;
    }
    //the poison will last 3 trns
    public static int poison_effect(){
        this.poison=1;
        return poison;
    }

    public int get_luck(){
        return luck;
    }
    public void set_luck(int l){
        this.luck=l;
    }
}
