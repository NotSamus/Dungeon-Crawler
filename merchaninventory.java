public class merchaninventory {
        int hearthUpgrade;
        int swordUpgrade;
        int smokeBomb;
        /**
         * This is the constructor for the inventory of the merchant
         * we used another class, because in the future we want to put 
         * more objects in the store
         */
    public merchaninventory(){
        this.hearthUpgrade=5;
        this.swordUpgrade=3;
        this.smokeBomb=10;
    }

    /**
     * This method will decrease the hearthUpgrade
     */
    public void decreaseHeartU(){
        this.hearthUpgrade=hearthUpgrade-1;
    }
    /**
     * This method will decrease the Sword Upgrade
     */
    public void decreaseSwordU(){
        this.swordUpgrade--;
    }
    /**
     * This method will decrease the smokebomb upgrade
     */
    public void decreaseSmokeBomb(){
        this.smokeBomb--;
    }

    public int get_total_healU(){
        return hearthUpgrade;
    }
    public int get_total_swordU(){
        return swordUpgrade;
    }
    public int get_total_smokeB(){
        return smokeBomb;
    }
}
