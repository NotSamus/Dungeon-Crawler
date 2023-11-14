import java.util.Random;
import java.util.Scanner;

/** 
 * This class represents the chests in our dungeon game.
 * It has each type of item and generates a random one if a chest is opened.
 * 
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class chest { 
    /**
     * Scanner used to read input.
     */
    public static Scanner in = new Scanner(System.in);
    /**
     * Random number generator used to generate chest contents.
     */
    public static Random rand = new Random();
    /**
     * The player's item inventory.
     */
    public static item_inventory Citems = vs.inv;
    /**
     * Gets sword from inventory.
     */
    public static int Csword = Citems.get_sword();
    /**
     * Gets heal potion from inventory.
     */
    public static int CIheal_potion = Citems.get_heal_potion();
    /**
     * Gets clear potion from inventory.
     */
    public static int Cclear_potion = Citems.get_clear_potion();
    /** 
     * Gets smoke bomb from inventory.
     */
    public static int Csmokebomb = Citems.get_smokebomb();
    /**
     * Gets coins from invetory.
     */
    public static int Ccoin = Citems.get_coins();
    /**
     * If the room you moved to has a chest (labeled 'c' for chest in dungeon) AND you have not exceeded inventory limit, it will prompt message for if you would like to open the chest.
     * @param chest true if you move to a room/spot in the dungeon that marks 'c' for a chest, false otherwise.
     */
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
    /**
     * Updates players inventory with new items from chest.
     */
    public static void call(){
          vs.get_inv(Citems);
    }

    /**
     * Opens chest, randomly generates one of the 5 items available for player, and stores it in their inventory.
     */
    public static void openChest(){

            int item = rand.nextInt(5);

            if (item == 0 ){
                System.out.println("You found a sword!");
                Citems.set_sword(Csword + 1);
                Csword = Csword + 1;
                call();
            }
            else if (item == 1){
                System.out.println("You found a heal potion!");
                Citems.set_heal_potion(CIheal_potion + 1);
                CIheal_potion = CIheal_potion + 1;
                call();
            }
            else if (item == 2){
                System.out.println("You found a clear potion!");
                Citems.set_clear_potion(Cclear_potion + 1);
                Cclear_potion = Cclear_potion + 1;
                call();
            }
            else if (item == 3){
                System.out.println("You found a smoke bomb!");
                Citems.set_smokebomb(Csmokebomb + 1);
                Csmokebomb = Csmokebomb + 1;
                call();
            }
            else if (item == 4){
                System.out.println("You found a coin!");
                Citems.set_coin(Ccoin + 1);
                Ccoin = Ccoin + 1;
                call();
            }
          
        }
       
    }

