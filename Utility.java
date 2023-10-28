import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;


class Utility {

    private static int[] current_position = new int[2];//map

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
     * this is the tokenizer 
     * @param a
     * @return return an array with the tokenized string
     */
    public static String[] tokenizer(String a){
        return a.split(",");
    }
    /**
     * this method is set to print the matrix, since this is not an obj
     * we are not going to override the toString() method
     * @param a
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
    public static String[][] move_down(String a[][]){
        if(a[(current_position[0])+1][current_position[1]].equals("0")||a[(current_position[0])+1][current_position[1]].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])+1][current_position[1]] = "$";
            current_position[0] = current_position[0]+1;
            current_position[1] = current_position[1];
            check_exit(a);
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
    public static String[][] move_up(String a[][]){
        if(a[(current_position[0])-1][current_position[1]].equals("0")||a[(current_position[0])-1][current_position[1]].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])-1][current_position[1]] = "$";
            current_position[0] = current_position[0]-1;
            current_position[1] = current_position[1];
            check_exit(a);
        }
        
        return a;
    }


    public static String[][] move_right(String a[][]){
        if(a[(current_position[0])][current_position[1]+1].equals("0")||a[(current_position[0])][current_position[1]+1].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]+1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]+1;
            check_exit(a);
        }
        return a;
    }
    public static String[][] move_left(String a[][]){
        if(a[(current_position[0])][current_position[1]-1].equals("0")||a[(current_position[0])][current_position[1]-1].equals("e")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]-1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]-1;
            check_exit(a);
        }
        
        return a;
    }
    /**
     * to make it a little more fun, we implemented a method
     * for a random spawn, at the moment there is just 3 positions to spawn
     * but we can add more in the future
     * @param a
     * @return the 2 dimension array
     */
    // public static String[][] Random_spawn(String a[][]){
    //     int spawns[][]= {{2,12},{15,0,},{15,22}};//random positions
    //     int random = (int) (Math.random()*3);
    //     current_position[0] = spawns[random][0];
    //     current_position[1] = spawns[random][1];
    //     if(a[spawns[random][0]][spawns[random][1]].equals("0")){
    //         a[spawns[random][0]][spawns[random][1]] = "$ ";
    //     } 
    //     return a;
    // }
    public static String[][] spawnUser(String a[][]){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j].equals("e")){
                    current_position[0] = i;
                    current_position[1] = j;
                    a[i][j] = "$";
                    return a;
                }
            }
        }
        return a;
    }
    /**
     * this method is to check if we are on the exit, instead of adding 
     * the lines of code to each movement, we created a separate method
     * @param a
     */
    private static void check_exit(String a[][]){
        if(a[(current_position[0])][current_position[1]].equals("0")){
            System.out.println("CONGRATULATIONS YOU FOUND THE EXIT!!!!!!!");
            
        }
    }

    public static int count_playtime(long start, long end){
        return (int)(end-start)/1000000000;
        
    }

    public static HashMap<String, user> user_records = new HashMap<String, user>();
    
    public static user createuser(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) throws IOException{
        System.out.println("username: " + username);
        System.out.println("fist name: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("state: "+ state);
          System.out.println("lastSignIn: "+ lastSignIn);
        System.out.println("logInTime: "+ logInTime);
        System.out.println("pin: "+ pin);
        System.out.println("dateOfBirth: "+ dateOfBirth);
        System.out.println("city: "+ city);
          System.out.println("zip: "+ zip);
        System.out.println("totalPlayTime: "+ totalPlayTime);
       
        user newUser = new user( username,  firstName,  lastName,  state,  lastSignIn,  logInTime,  pin,  dateOfBirth,  city,  zip,  totalPlayTime);
        
        user_records.put(username, newUser);
        
        return newUser;

    }
    
    public static boolean searchuser(String userName) {  
       return user_records.containsKey(userName);
    }
    public static boolean searchpin(int pin){  
       return user_records.containsValue(pin);
    }

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

    static void saveUserToFile(user newuser) throws IOException {
        FileWriter fileWriter = new FileWriter("Users.csv", true);
        fileWriter.write(newuser.getUsername() + "," + newuser.getFirstName() + "," + newuser.getLastName() + "," + newuser.getState() + "," + newuser.getLastSignIn() + "," + newuser.getLoginTime() + "," + newuser.getPin() + "," + newuser.getDateOfBirth() + "," + newuser.getCity() + "," + newuser.getZip() + "," + newuser.getTotalPlayTime() + "\n");

        fileWriter.close();
    }
    // public static void updateUser(String username, String newFirstName, String newLastName, String newState, String newPin, String newCity, String newZIP, String newDateOfBirth){
    //     user newUser = user_records.get(username);
    //     if (newUser!=null) {
    //         newUser.setFirstName(newFirstName);
    //         newUser.setLastName(newLastName);
    //         newUser.setState(newState);
    //         newUser.setPin(0);
    //         newUser.setCity(newCity);
    //         newUser.setZip(0);
    //         newUser.setDateOfBirth(newDateOfBirth);
    //     }
    // }
}