import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Date;
import java.util.Random;

/**
 * This class provides utility method implentations for our interface. The actual game utilities being implemented.
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
class utilities implements gameUtilities {
    public static HashMap<String, user> user_records = new HashMap<String, user>();
    /**
     * The singleton instance of the utilities class.
     */
    private static utilities instance;
  
    public static int i=1;

    /**
     * An array of two integers representing the current position of the player on the map.
     */
    public static int[] current_position = new int[2];//map

    /**
     * Gets the singleton instance of the utilities class.
     * 
     * @return The singleton instance of the utilities class.
     */
    public utilities getInstance() {
        if (instance == null) {
            instance = new utilities(); 
        }
        return instance;
    }

    /**
     * Gets a HashMap of user records, indexed by username.
     * 
     * @return A HashMap of user records, indexed by username.
     */
    public HashMap<String, user> getUser_records(){
        return user_records;
    }
    /**
     * Gets the current position of the player on the map.
     * 
     * @return The current position of the player on the map, as an array of two integers.
     */
    public int[] getCurrentPosition(){
        return current_position;
    }

    /**
     * This Method is to load the map, it will call the mthod tokenize the first line of the file and
     * will go through all the file until it does not have another line
     * @return the 2d array with the map in it
     * @throws FileNotFoundException
     */
    public String[][] loadMap()throws FileNotFoundException{
        File filename = new File("Dungeon.csv");
        Scanner file = new Scanner(filename);
        String a[][] = new String[20][24];
        for(int i=0;i<=19;i++) {
            String holder = file.nextLine();
            String token[] = tokenizer(holder);
            for (int j = 0; j < a[i].length; j++) {
                if(!(token[j].equals("-1"))){
                    a[i][j] = token[j];
                }else{
                    a[i][j] = "|";
                } 
            }          
        }
        file.close();
        return a;
    }

    /**
     * Loads the game map from a CSV file. Used specifically for loading a saved map.
     * @return A 2D array of strings representing the game map.
     * @throws FileNotFoundException If the map file cannot be found.
     */
    public String[][] loadingMap()throws FileNotFoundException{
        File filename = new File("Dungeon.csv");
        Scanner file = new Scanner(filename);
        String a[][] = new String[20][24];
        for(int i=0;i<=19;i++) {
            String holder = file.nextLine();
            String token[] = tokenizer(holder);
            for (int j = 0; j < a[i].length; j++) {
                if(!(token[j].equals("-1"))){
                    a[i][j] = token[j];
                }else{
                    a[i][j] = "|";
                } 
            }          
        }
        file.close();
        return a;
    }

    /**
     * This will tokenize the line from the csv
     * @param a the data separated by ,
     * @return an array containing the data separated by ,
     */
    public static String[] tokenizer(String a){
        return a.split(",");
    }

    /**
     * This is a method to print the map
     * @param a the map in a 2d array
     */
    public void printMatrix(String a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(" "+a[i][j]+" ");
            }
            System.out.println();
        }
    }
    /**
     * Updates the game map with the user's new position and saves it to a file.
     * 
     * @param username The username of the user.
     * @param userPosition The new position of the user on the game map.
     * @throws IOException If there is an error saving the updated game map to a file.
     * @return The updated game map.
     */
    public String[][] updateAndSaveMap(String username, int[] userPosition) throws IOException {
                String[][] map = loadingMap();
        
                map[userPosition[0]][userPosition[1]] = "$";
        
                // Save the updated map to the same file
                saveMap(map, username+"-Dungeon.csv");
        
                return map;
            }
    
    
    /**
     * Saves the game map to a file.
     * 
     * @param map The 2D array of strings representing the game map.
     * @param filename The name of the file to save the game map to.
     * @throws IOException If there is an error saving the game map to a file.
     */
    public void saveMap(String[][] map, String filename) throws IOException {
         FileWriter fileWriter = new FileWriter(filename);

         for (int i = 0; i < map.length; i++) {
             for (int j = 0; j < map[i].length; j++) {
                 fileWriter.write(map[i][j]);
                 if (j < map[i].length - 1) {
                     fileWriter.write(",");
                 }
             }
             fileWriter.write("\n");
         }

         fileWriter.close();
    }

    //MOVEMENT OF THE PLAYER

    /**
     * A random number generator.
     */
    public static Random rand = new Random();

    /**
     * The probability of spawning a monster.
     */
    public static int spawnProb = 0;

    /**
     * Gets a user object by username.
     * 
     * @param usernames The username of the user to get.
     * @return The user object, or null if the user does not exist.
     */
    public static user get_user(String usernames){
        
       return user_records.get(usernames);
    }

    /**
     * this method is to move down, it will check
     * it the token that is below the position is a 0
     * if its a 0, we will replace the 0 with $ and update the current position
     * @param a
     * @return the array of 2 dimensions
     */
    public String[][] move_down(String a[][])throws IOException{
        if(a[(current_position[0])+1][current_position[1]].equals("0")||a[(current_position[0])+1][current_position[1]].equals("e")||a[(current_position[0])+1][(current_position[1])].equals("c")||a[(current_position[0])+1][(current_position[1])].equals("@")||a[(current_position[0])+1][(current_position[1])].equals("#")){
            if(a[(current_position[0]+1)][(current_position[1])].equals("c")){
                chest.newChest(true);
            }
             if(a[(current_position[0])+1][(current_position[1])].equals("#")){
                merchant.handle_username(vs.username_holder);
            }
            if(a[(current_position[0]+1)][(current_position[1])].equals("@")){
                printexit();
            }
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])+1][current_position[1]] = "$";
            current_position[0] = current_position[0]+1;
            current_position[1] = current_position[1];
            spawnProb = rand.nextInt(100);
            if (spawnProb > 75){
                vs.ini_fight();
            }
            

        }
        return a;
    }
    /**
     * This one prints the exit and puts it on the log 
     * @throws IOException
     */
    public static void printexit()throws IOException{
        System.out.print(" ### CONGRATULATIONS YOU FOUND THE EXIT ### ");
        log.loger(vs.username_holder + " Found the exit!!!!");
        System.exit(0);
    }
    /**
     * this method is to move up, it will check 
     * if the token that is above is a 0
     * if its a 0, we will replace the 0 with $ and update the current position
     * @param a
     * @return the array of 2 dimensions
     */
    public String[][] move_up(String a[][])throws IOException{
        if(a[(current_position[0])-1][current_position[1]].equals("0")||a[(current_position[0])-1][current_position[1]].equals("e")||a[(current_position[0]-1)][(current_position[1])].equals("c")||a[(current_position[0]-1)][(current_position[1])].equals("@")||a[(current_position[0]-1)][(current_position[1])].equals("#")){
            if(a[(current_position[0]-1)][(current_position[1])].equals("c")){
                chest.newChest(true);
            }
            if(a[(current_position[0]-1)][(current_position[1])].equals("#")){
                merchant.handle_username(vs.username_holder);
            }
            if(a[(current_position[0]-1)][(current_position[1])].equals("@")){
                printexit();
            }
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])-1][current_position[1]] = "$";
            current_position[0] = current_position[0]-1;
            current_position[1] = current_position[1];
           spawnProb = rand.nextInt(100);
            if (spawnProb > 75){
                vs.ini_fight();
            }
            
        }
        
        return a;
    }

    /**
     * This Method is to move to the right
     * @param a this is the map 
     * @return returns the map with the updated position
     */
    public String[][] move_right(String a[][])throws IOException{
        if(a[(current_position[0])][current_position[1]+1].equals("0")||a[(current_position[0])][current_position[1]+1].equals("e")||a[(current_position[0])][(current_position[1])+1].equals("c")||a[(current_position[0])][(current_position[1])+1].equals("@")||a[(current_position[0])][(current_position[1])+1].equals("#")){
            if(a[(current_position[0])][(current_position[1])+1].equals("c")){
                chest.newChest(true);
            }
            if(a[(current_position[0])][(current_position[1])+1].equals("#")){
                merchant.handle_username(vs.username_holder);
            }
            
            if(a[(current_position[0])][(current_position[1]+1)].equals("@")){
                printexit();
            }
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]+1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]+1;

            spawnProb = rand.nextInt(100);
            if (spawnProb > 75){
                vs.ini_fight();
            }
            

        }
        return a;
    }
    /**
     * This method is to move to the left 
     * @param a the map 
     * @return the array with the map with the updated position
     */
    public String[][] move_left(String a[][])throws IOException{
        if(a[(current_position[0])][current_position[1]-1].equals("0")||a[(current_position[0])][current_position[1]-1].equals("e")||a[(current_position[0])][current_position[1]-1].equals("c")||a[(current_position[0])][current_position[1]-1].equals("@")||a[(current_position[0])][current_position[1]-1].equals("#")){
            if(a[(current_position[0])][(current_position[1])-1].equals("c")){
                chest.newChest(true);
            }
             if(a[(current_position[0])][(current_position[1])-1].equals("#")){
                merchant.handle_username(vs.username_holder);
            }
            if(a[(current_position[0])][(current_position[1]-1)].equals("@")){
                printexit();
            }
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]-1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]-1;
            

            spawnProb = rand.nextInt(100);
            if (spawnProb > 75){
                vs.ini_fight();
            }
            
            /**call the 2nd map to update the position of visited */
        }
        return a;
    }
    /**
     * This Method will spawn the user at the specified location
     * @param a 2d array containing the map
     * @return the array with the $ in place
     */
    public String[][] spawnUser(String a[][]){
        //starting position
        current_position[0] = 19;
        current_position[1] = 8;
        a[(current_position[0])][current_position[1]] = "$";
        return a;
    }
    

    public int count_playtime(long start, long end){
        return (int)(end-start)/1000000000;
        
    }

    
    /**
     * This method creates the user
     * @param username
     * @param firstName
     * @param lastName
     * @param state
     * @param lastSignIn
     * @param logInTime
     * @param pin
     * @param dateOfBirth
     * @param city
     * @param zip
     * @param totalPlayTime
     * @return
     * @throws IOException
     */
    public void createUser(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) throws IOException{
        player p1 = new player();
        user newUser = new user( username,  firstName,  lastName,  state,  lastSignIn,  logInTime,  pin,  dateOfBirth,  city,  zip,  totalPlayTime,p1);
        
        user_records.put(username, newUser);
    }
    /**
     * This will look the user in the hashmap
     * @param userName
     * @return return true if found
     */
    public boolean searchUser(String userName) {  
       return user_records.containsKey(userName);
    }
    /**
     * This will look for the pin of the user in hashmap
     * @param pin
     * @return returns true if found
     */
    public boolean searchPin(String player,int pin){
        return user_records.get(player).getPin() == pin;
    
    }
    /**
     * this method will token the user and will also create the user
     * we have a scanner to read from the "Users.csv" we tokenize it and then we just create the user 
     * @throws IOException
     */
    public void tokenTheUser()throws IOException{
        Scanner file = new Scanner(new File("Users.csv"));
        String header = file.nextLine(); //reading header 
        
        while(file.hasNextLine()){
        String holder = file.nextLine();
        String [] a = holder.split(",");
        try {  
            createUser(/*username=*/a[2],a[3],a[5],a[0],a[1],a[4],a[5],a[10],a[8],a[9],a[7]);       
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        System.out.flush();
        }
    }
    /**
     * This Method is here to append the user created into the file "Users.csv"
     * @param newuser that is the user
     * @throws IOException exception in place to read the file
     */
    public void saveUserToFile(user newuser) throws IOException {
        try{
        FileWriter fileWriter = new FileWriter("Users.csv", true);
        fileWriter.write(newuser.getUsername() + "," + newuser.getFirstName() + "," + newuser.getLastName() + "," + newuser.getState() + "," + newuser.getLastSignIn() + "," + newuser.getLoginTime() + "," + newuser.getPin() + "," + newuser.getDateOfBirth() + "," + newuser.getCity() + "," + newuser.getZip() + "," + newuser.getTotalPlayTime() + "\n");

        fileWriter.close();}catch (IOException e){
            System.out.println("The File Does not exist :C ");
        }
    }
    
}
/**
 * InnerUtility
 */

