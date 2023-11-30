import java.io.IOException;
import java.util.Scanner;

public class merchant {
    public static gameUtilities Utility = new utilities(); 
    /**
     * This is the class to interact with the merchant
     * @param userm
     * @throws IOException
     */
    public static void handle_username(String userm)throws IOException{
        String username=userm;
        player player1= Utility.getUser_records().get(username).getPlayer();
        System.out.println(username);
        Scanner in = new Scanner(System.in);
        log.loger(vs.username_holder + " Spoke with the Wizard");
        int choice=0;
            do{

            if((inv.get_total_healU()!=0)||(inv.get_total_smokeB()!=0)||(inv.get_total_swordU()!=0)){
            System.out.println("Welcome to Wizard of Oz shop");
            System.out.println("What you buying ? ");
            System.out.println("1. Heart Upgrade");
            System.out.println("2. Sword Upgrade");
            System.out.println("3. Smoke Bomb");
            System.out.println("4. exit");
            System.out.println("Select an option");
            choice = in.nextInt();
            int Pcoins = player1.get_coins();
            switch (choice) {
                case 1:
                    //this cost 5 coins
                    if(inv.get_total_healU()!=0){
                    if(Pcoins < 5){
                        System.out.println("you do not have enough money");
                        break;
                    }else{
                        int PhealP = player1.get_heal_potion();
                        player1.set_coins(Pcoins-5);
                        inv.decreaseHeartU();
                        player1.set_heal_potion(PhealP+1);
                        System.out.println(" ### you got a heal potion ### ");
                        log.loger(vs.username_holder + " got a heal potion");
                        break;
                    }
                }
                else{
                    break;
                }
                case 2:
                    if(Pcoins < 3){
                        System.out.println("you do not have enough money");
                        break;
                    }else{
                        int Pswrd = player1.getSwordU();
                        player1.set_coins(Pcoins-3);
                        inv.decreaseSwordU();
                        player1.set_heal_potion(Pswrd+1);
                        System.out.println(" ### you got a sword upgrade ### ");
                        log.loger(vs.username_holder + " got a sword");
                    }
                    break;
                case 3:
                    if(Pcoins <10){
                        System.out.println(" ### you do not have enough money ### ");
                        break;
                    }else{
                        int PsmokeB = player1.get_smokebombU();
                        player1.set_coins(Pcoins-10);
                        inv.decreaseSmokeBomb();
                        player1.set_smokeBU(PsmokeB+1);
                        System.out.println(" ### you got a smoke bomb ### ");
                        log.loger(vs.username_holder + " got a smoke bomb");
                    }
                    break;
            }
        }else{
            System.out.println("I do not have anything else to sell");
            // System.out.println("want to break from the matrix ? it costs 100 coins");
        }
    }while(choice!=4);
    return;
    }
    /**
     * this is the merchan inventory
     */
    public static merchaninventory inv = new merchaninventory();
    


}
