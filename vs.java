import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


/**
 * This is the combat system. It allows players to engage in battles with enemies
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class vs {
      public static String username_holder ;
      public static int i=0;
      public static int vida;  
      public static gameUtilities Utility = new utilities(); 
/**
 * This throws an exception if an enemy is not found or created in the csv file
 * @throws IOException if an error occurs while creating enemy
 */
public static void token_Enemies()throws IOException {
        Scanner file= new Scanner(new File("Enemies.csv"));
        String header = file.nextLine(); //reading header, just to erase it
      
        while(file.hasNextLine()){
        String holder = file.nextLine();
        String [] a = holder.split(",");
        
        try {
            create_Enemies(a[0],Integer.parseInt(a[1]) , Integer.parseInt(a[2]));
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        System.out.flush();
        }
    }

    /**
     * HashMap to store enemies
     */
    public static HashMap <Integer, Enemies> Enemies_map = new HashMap<Integer, Enemies>();

    /**
     * Creates an enemy with specified name, health, and damage.
     * @param name the name of the enemy
     * @param health The health points of the enemy
     * @param damage The damage dealt by the enemy
     * @throws IOException if an error occurs while creating enemy
     */
    public static void create_Enemies(String name, int health, int damage)throws IOException{
       Enemies en1 = new Enemies(name, health, damage);
       Enemies_map.put(i, en1);
        i++;

   }

    /**
     *  Sets the current username
     * @param userm the name to be set
     */
    public static void handle_username(String userm){
        username_holder=userm;
    }

    /**
     * Initializes a fight using the current username
     * @throws IOException if an error occurs when initializing the fight
     */
    public static void ini_fight()throws IOException{
        ini_fight(username_holder);
    }

    /**
     *  Item inventory for the player
     */
    public static item_inventory inv = new item_inventory();

    /**
     * Sets the player's inventory with the provided item inventory
     * @param a is the item to be set 
     */
    public static void get_inv(item_inventory a){
        inv = a;
    }

    /**
     *  Initates a fight with the user
     * @param username The username of the player
     * @throws IOException if an error occurs durring the ffight initialization.
     */
    private static void ini_fight (String username)throws IOException{
        // chest chest = new chest();
        // chest.newChest(true);

         //user stats
        player player = Utility.getUser_records().get(username).getPlayer();
        int Phealth = player.get_health() ;
        double Pdamage = player.get_damage();
        int Ppotions = player.get_heal_potion();
        int PpotionHeal = 30;
        int runLuck = 0;
        int has_poison = player.player_effect.poison;
        //inputs and randoms
        token_Enemies();
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //enemy stats
        int enemyNum = rand.nextInt(6);
        String Ename = Enemies_map.get(enemyNum).getName();
        int Edamage = Enemies_map.get(enemyNum).getDamage();
        int Ehealth = Enemies_map.get(enemyNum).getHealth();
        
        //items stats
        item_inventory items = player.gItem_inventory();
        items = inv;
        
        int Isword = items.get_sword();
        int Iheal_potion = items.get_heal_potion();
        int Iclear_potion = items.get_clear_potion();
        int Ismokebomb = items.get_smokebomb();
        int Icoin = items.get_coins();

        boolean fighting  = true;
        FIGHT:
        while (fighting){
            System.out.println("----------------------------------------------------");
            System.out.println("\t# " + Ename + " has appeared! #\n");
            
            while (Ehealth > 0){
                System.out.print("\t Your healt is " + Phealth + "\n");
                System.out.println("\t" + Ename + "'s healt is " + Ehealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use item from inventory");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                //ENEMY
                if (input.equals("1")){
                    double damageDealt = Pdamage;
                    int damageTaken = Edamage;
                    // if(Ename.equals("Snake")){
                    //     int random_poison = rand.nextInt(100);
                    //     has_poison = player.player_effect.poison_effect();
                    // }
                    if(has_poison==1){
                        System.out.println("#####################################################");
                        System.out.println("\t> You are poisoned, you recieve 15 damage!");
                        System.out.println("#####################################################");
                        Phealth -= 15; 
                    }
                    Ehealth -= damageDealt;
                    Phealth -= damageTaken;
                    System.out.println("#####################################################");
                    System.out.println("\t> You strike the " + Ename + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
                    System.out.println("#####################################################");
                    if (Phealth < 1){
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                }
                else if (input.equals("2")){
                   
                    if (Iheal_potion > 0 || Iclear_potion>0 || Ismokebomb>0 ||Isword>0){
                         System.out.println("after the 2");
                         System.out.println("\t your items are: ");
                        System.out.println("\t1. Swords: " + Isword);
                        System.out.println("\t2. Heal potions: " + Iheal_potion);
                        System.out.println("\t3. Clear potions: " + Iclear_potion);
                        System.out.println("\t4. Smoke bombs: " + Ismokebomb);
                        System.out.println("\t7. Back");
                        System.out.println("\t> What item would you like to use? ");
                        String input2 = in.nextLine();
                        
                        if(input2.equals("1") && !(items.get_sword() <=0)){
                            player.set_damage(Pdamage * 1.5);
                            System.out.println("\t> You have used a sword, your damage is now " + player.get_damage()+" !!!");
                            items.set_sword(Isword-1); 
                            Isword = items.get_sword();

                        }else if (input2.equals("2") && !(items.get_heal_potion()<=0)){
                            player.set_health(Phealth + PpotionHeal);
                            System.out.println("\t> You drink a health potion, healing yourself for " + PpotionHeal + "." + "\n\t> You now have " + player.get_health()+ " HP.");
                            items.set_heal_potion(Iheal_potion-1);
                            Phealth = player.get_health();
                            Iheal_potion = items.get_heal_potion();
                           

                        }else if(input2.equals("3")&& !(items.get_clear_potion()<=0)){
                            items.set_clear_potion(Iclear_potion-1);
                            Iclear_potion = items.get_clear_potion();
                           //clear efects    
                           
                        }else if (input2.equals("4")&& !(items.get_smokebomb()<=0)){
                            items.set_smokebomb(Ismokebomb-1);
                            int random_run = rand.nextInt(100);
                            runLuck = player.player_effect.get_luck() + 40;
                            player.player_effect.set_luck(runLuck);
                            System.out.println("\t> You have used a smoke bomb, your luck is now " + player.player_effect.get_luck()+" !!!");
                            Ismokebomb = items.get_smokebomb();
                        }
                        
                   

                    } else{
                            System.out.println("\t> you don't have any items left! Search chests for the possibility of a health potion!\n");
                       }
                }
                else if (input.equals("3")){
                    if ( runLuck > 70){
                        System.out.println("\tYou run away from the " + Ename + "!");
                        break;
                    }                    
                    else{
                        System.out.println("\tYou failed to run away from the " + Ename + "!");
                        int damageTaken = Edamage;
                        Phealth -= damageTaken;
                        System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
                        if (Phealth < 1){
                            System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("\tInvalid command!");
                }
            }
            if (Phealth < 1){
                System.out.println("You limp out of the dungeon, weak from battle.");
                System.out.println(" \t ####### GAME OVER ####### \n");
                //CALL THE LOG WITH THE DEAD USER
                log log = new log();
                log.loger(Ename + " killed " + username_holder + " in battle");
                System.exit(0);
            }
            System.out.println("----------------------------------------------------");
            System.out.println(" # " + Ename + " was defeated! # ");
            player.set_health(Phealth);
            System.out.println(" # You have " + player.Health + " HP left. #");

            vida = player.Health;
            System.out.println("----------------------------------------------------");
            
            System.out.println("Press 1 to continue the adventure!");
            String input = in.nextLine();

            while (!(input.equals("1"))){
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if (input.equals("1")){
                System.out.println("You continue your adventure!");
                break;
            }
            else{
                System.out.println("Invalid command!");
                break;
            }
            
            

        }

        
    }
}
