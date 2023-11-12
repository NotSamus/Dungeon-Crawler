import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Date;
import java.util.Random;


class Utility {
    public static int i=1;
    /**
     * This is to keep track of the current position
     */
    public static int[] current_position = new int[2];//map

    /**
     * This Method is to load the map, it will call the mthod tokenize the first line of the file and
     * will go through all the file until it does not have another line
     * @return the 2d array with the map in it
     * @throws FileNotFoundException
     */
    public static String[][] load_map()throws FileNotFoundException{
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
    public static void printMatrix(String a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(" "+a[i][j]+" ");
            }
            System.out.println();
        }
    }

    //MOVEMENT OF THE PLAYER
    /**
     * this method is to move down, it will check
     * it the token that is below the position is a 0
     * if its a 0, we will replace the 0 with $ and update the current position
     * @param a
     * @return the array of 2 dimensions
     */

    public static Random rand = new Random();
    public static int spawnProb = 0;
    public static user get_user(String usernames){
       return user_records.get(usernames);
    }
    public static String[][] move_down(String a[][])throws IOException{
        if(a[(current_position[0])+1][current_position[1]].equals("0")||a[(current_position[0])+1][current_position[1]].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])+1][current_position[1]] = "$";
            current_position[0] = current_position[0]+1;
            current_position[1] = current_position[1];
            spawnProb = rand.nextInt(100);
            if (spawnProb > 65){
                vs.ini_fight();
            }

        }
        return a;
    }
    /**
     * this method is to move up, it will check 
     * if the token that is above is a 0
     * if its a 0, we will replace the 0 with $ and update the current position
     * @param a
     * @return the array of 2 dimensions
     */
    public static String[][] move_up(String a[][])throws IOException{
        if(a[(current_position[0])-1][current_position[1]].equals("0")||a[(current_position[0])-1][current_position[1]].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])-1][current_position[1]] = "$";
            current_position[0] = current_position[0]-1;
            current_position[1] = current_position[1];
           spawnProb = rand.nextInt(100);
            if (spawnProb > 65){
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
    public static String[][] move_right(String a[][])throws IOException{
        if(a[(current_position[0])][current_position[1]+1].equals("0")||a[(current_position[0])][current_position[1]+1].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]+1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]+1;

            spawnProb = rand.nextInt(100);
            if (spawnProb > 65){
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
    public static String[][] move_left(String a[][])throws IOException{
        if(a[(current_position[0])][current_position[1]-1].equals("0")||a[(current_position[0])][current_position[1]-1].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]-1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]-1;


            spawnProb = rand.nextInt(100);
            if (spawnProb > 65){
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
    public static String[][] spawnUser(String a[][]){
        //starting position
        current_position[0] = 19;
        current_position[1] = 8;
        a[(current_position[0])][current_position[1]] = "$";
        return a;
    }
    

    public static int count_playtime(long start, long end){
        return (int)(end-start)/1000000000;
        
    }

    public static HashMap<String, user> user_records = new HashMap<String, user>();
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
    public static void createuser(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) throws IOException{
        player p1 = new player();
        user newUser = new user( username,  firstName,  lastName,  state,  lastSignIn,  logInTime,  pin,  dateOfBirth,  city,  zip,  totalPlayTime,p1);
        
        user_records.put(username, newUser);
    }
    /**
     * This will look the user in the hashmap
     * @param userName
     * @return return true if found
     */
    public static boolean searchuser(String userName) {  
       return user_records.containsKey(userName);
    }
    /**
     * This will look for the pin of the user in hashmap
     * @param pin
     * @return returns true if found
     */
    public static boolean searchpin(int pin){
        for (user u : user_records.values()) {
            if (u.getPin() == pin) {
                return true;
            }
        }
        return false;
    }

    /*
    * create a method that will return a hashmap updated 
    * map1 = has the old users that were given to us
    * map2 = the map of the new users 
    * map3 = the register users 
    * add map1+map2 = map 1 =+map3
    */






    /**
     * this method will token the user and will also create the user
     * we have a scanner to read from the "Users.csv" we tokenize it and then we just create the user 
     * @throws IOException
     */
    public static void tokentheUser()throws IOException{
        Scanner file = new Scanner(new File("Users.csv"));
        String header = file.nextLine(); //reading header 
        
        while(file.hasNextLine()){
        String holder = file.nextLine();
        String [] a = holder.split(",");
        try {
            createuser(/*username=*/a[2],a[3],a[5],a[0],a[1],a[4],a[5],a[10],a[8],a[9],a[7]);       
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
    static void saveUserToFile(user newuser) throws IOException {
        try{
        FileWriter fileWriter = new FileWriter("Users.csv", true);
        fileWriter.write(newuser.getUsername() + "," + newuser.getFirstName() + "," + newuser.getLastName() + "," + newuser.getState() + "," + newuser.getLastSignIn() + "," + newuser.getLoginTime() + "," + newuser.getPin() + "," + newuser.getDateOfBirth() + "," + newuser.getCity() + "," + newuser.getZip() + "," + newuser.getTotalPlayTime() + "\n");

        fileWriter.close();}catch (IOException e){
            System.out.println("The File Does not exist :C ");
        }
    }
    
}