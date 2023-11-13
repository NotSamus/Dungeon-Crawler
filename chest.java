import java.util.Random;
import java.util.Scanner;


public class chest { 
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();
    public static item_inventory Citems = vs.inv;
   
    public static int Csword = Citems.get_sword();
    public static int CIheal_potion = Citems.get_heal_potion();
    public static int Cclear_potion = Citems.get_clear_potion();
    public static int Csmokebomb = Citems.get_clear_potion();
    public static int Ccoin = Citems.get_coins();

    public static void newChest(boolean chest){
        int totalItems = 0;
        totalItems = Csword + CIheal_potion + Cclear_potion + Csmokebomb ;
        if (chest == true && totalItems < 5){
            System.out.println("You found a chest!");
            System.out.println("Do you want to open it?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = in.nextInt();
            if (choice == 1){
                openChest();
            }
            else if (choice == 2){
                System.out.println("You leave the chest alone.");
            }
            else{
                System.out.println("Invalid input");
            }
        }
        

    }

    public static void openChest(){

            int item = rand.nextInt(5);

            if (item == 0 ){
                System.out.println("You found a sword!");
                Citems.set_sword(Csword + 1);
                Csword = Csword + 1;
            }
            else if (item == 1){
                System.out.println("You found a heal potion!");
                Citems.set_heal_potion(CIheal_potion + 1);
                CIheal_potion = CIheal_potion + 1;
            }
            else if (item == 2){
                System.out.println("You found a clear potion!");
                Citems.set_clear_potion(Cclear_potion + 1);
                Cclear_potion = Cclear_potion + 1;
            }
            else if (item == 3){
                System.out.println("You found a smoke bomb!");
                Citems.set_smokebomb(Csmokebomb + 1);
                Csmokebomb = Csmokebomb + 1;
            }
            else if (item == 4){
                System.out.println("You found a coin!");
                Citems.set_coin(Ccoin + 1);
                Ccoin = Ccoin + 1;
            }
            vs.set_inv(Citems);
        }
       
    }

