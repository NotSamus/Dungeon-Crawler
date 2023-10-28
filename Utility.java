import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


class Utility {

    private static int[] current_position = new int[2];//map

    public static String[][] load_map()throws FileNotFoundException{
        File filename = new File("csv");
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
    public static String[][] Random_spawn(String a[][]){
        int spawns[][]= {{2,12},{15,0,},{15,22}};//random positions
        int random = (int) (Math.random()*3);
        current_position[0] = spawns[random][0];
        current_position[1] = spawns[random][1];
        if(a[spawns[random][0]][spawns[random][1]].equals("0")){
            a[spawns[random][0]][spawns[random][1]] = "$ ";
        } 
        return a;
    }
    /**
     * this method is to check if we are on the exit, instead of adding 
     * the lines of code to each movement, we created a separate method
     * @param a
     */
    private static void check_exit(String a[][]){
        if(a[(current_position[0])][current_position[1]].equals("e")){
            System.out.println("CONGRATULATIONS YOU FOUND THE EXIT!!!!!!!");
            
        }
    }

    // public static void update_playtime(user userDummy,int time){
    //     userDummy.updatePlaytime(time);
    // }

    public static int count_playtime(long start, long end){
        return (int)(end-start)/1000000000;
        
    }

    public static ArrayList<user> user_list = new ArrayList<>();
    
    public static void createuser(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) throws IOException{
        user user = new user(firstName, lastName, username, state, lastSignIn, logInTime, pin, city, zip, dateOfBirth, totalPlayTime);
        tokentheUser();
        user_list.add(user);
        iterateList(user_list);

    }
    
    public static void tokentheUser()throws IOException{
        Scanner file = new Scanner(new File("Users.csv"));
        
        while(file.hasNextLine()){
        String holder = file.nextLine();
        String [] a = holder.split(",");
        createuser(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9],a[10]);
        }
    }
    
    public static void iterateList(ArrayList<user> sumlist){

        for (user user : sumlist) {
            System.out.println(user);
        }
        // list = sumlist;
        // for(i = 0; i < list.length; i++){
        //     System.out.print(list.get(i) + " ");
        // }
    }

    public static void invokeList() throws IOException{
        tokentheUser();
        iterateList(user_list);
    }

    // static void findUserInFile(String username) throws IOException {
    //     // Open the user file for reading
    //     FileReader fileReader = new FileReader("Users.csv");
    public static user searchuser(String username, ArrayList<user> userCopy){
        for (user u : user_list) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    //     // Create a scanner to read the file
    //     Scanner scanner = new Scanner(fileReader);

    //     // Read each line of the file and check if the username matches
    //     while (scanner.hasNextLine()) {
    //         String line = scanner.nextLine();

    //         // Split the line into an array of strings
    //         String[] userData = line.split(",");
    //         System.out.println(userData[0]);
    //         //If the username matches, create a new User object from the string array
    //         if (userData[0].equals(username)) {
    //             user user = new user(userData[1], userData[2], userData[0], userData[3], userData[4], userData[5], userData[6], userData[10], userData[8], userData[9], userData[7]);

    //             System.out.println(userData[0]);
    //         }

    //     }

        // Close the scanner
        // scanner.close();

        // Return null if the user is not found
        // return null;
    //}

    static void saveUserToFile(user user) throws IOException {
        FileWriter fileWriter = new FileWriter("Users.csv", true);
        fileWriter.write(user.getUsername() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getState() + "," + user.getLastSignIn() + "," + user.getLoginTime() + "," + user.getPin() + "," + user.getDateOfBirth() + "," + user.getCity() + "," + user.getZip() + "," + user.getTotalPlayTime() + "\n");

        fileWriter.close();
    }

    // public void readUserFile() throws FileNotFoundException {
    //     FileReader fileReader = new FileReader("Users.csv");

    //     // Create a scanner to read the file
    //     Scanner scanner = new Scanner(fileReader);

    //     // Read each line of the file and create a User object for each line
    //     while (scanner.hasNextLine()) {
    //         String line = scanner.nextLine();

    //         // Split the line into an array of strings
    //         String[] userData = line.split(",");

    //         // Create a new User object from the string array
    //         //user user = new user(userData[1], userData[2], userData[0], userData[3], Long.parseLong(userData[4]), Long.parseLong(userData[5]), userData[6], userData[10], userData[8], userData[9], Long.parseLong(userData[7]));

    //     }


    //     scanner.close();
    // }

    // public static void updateUser(String username) throws IOException {
    //     // Find the user in the user file
    //     user user = findUserInFile(username);

    //     // Update the user's data
    //     // ...

    //     // Save the user object to the user file
    //     saveUserToFile(user);
    // }

    public static void addNewUser(String firstName, String lastName, String username, String state, String lastSignIn, String loginTime, String pin, String city, String zip, String dateOfBirth, String totalPlayTime) throws IOException {
        user newUser = new user( firstName,  lastName,  username,  state,  lastSignIn,  loginTime,  pin,  city,  zip,  dateOfBirth,  totalPlayTime);
        saveUserToFile(newUser);
    }
}
