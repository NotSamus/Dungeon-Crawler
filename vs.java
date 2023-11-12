import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the combat system
 */
public class vs {
      public static String username_holder ;
      public static int i=0;
      public static int vida;    
public static void token_Enemies()throws IOException{
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


    public static HashMap <Integer, Enemies> Enemies_map = new HashMap<Integer, Enemies>();

    public static void create_Enemies(String name, int health, int damage)throws IOException{
       Enemies en1 = new Enemies(name, health, damage);
       Enemies_map.put(i, en1);
        i++;

   }

    public static void handle_username(String userm){
        username_holder=userm;
    }
    public static void ini_fight()throws IOException{
        ini_fight(username_holder);
    }
    
    private static void ini_fight (String username)throws IOException{
        //hardcode player variable for now
        //needs to be conected to player class
        player player = Utility.user_records.get(username).getPlayer();
        int Phealth = player.get_health() ;
        int Pdamage = (int) player.get_damage();
        int Ppotions = player.get_heal_potion();
        int PpotionHeal = 30;
        



        //objects
        token_Enemies();
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int enemyNum = rand.nextInt(6);
        String Ename = Enemies_map.get(enemyNum).getName();
        int Edamage = Enemies_map.get(enemyNum).getDamage();
        int Ehealth = Enemies_map.get(enemyNum).getHealth();
        
       
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
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if (input.equals("1")){
                    int damageDealt = Pdamage;
                    int damageTaken = Edamage;

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
                    if (Ppotions > 0){
                        Phealth += PpotionHeal;
                        Ppotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + PpotionHeal + "."
                        + "\n\t> You now have " + Phealth + " HP."
                        + "\n\t> You have " + Ppotions + " health potions left.\n");
                    }
                    else{
                        System.out.println("\t> You have no health potions left! Search chests for the possibility of a health potion!");
                    }
                }
                else if (input.equals("3")){
                    System.out.println("\tYou run away from the " + Ename + "!");
                    //continue FIGHT;
                    /*
                     * Aqui tambien hay que cargar el mapa de nuevo en la posicion donde se quedo y seguir avanzando.
                     */
                    break;
                }
                else{
                    System.out.println("\tInvalid command!");
                }
            }
            if (Phealth < 1){
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
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
