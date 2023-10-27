import java.io.*;
import java.util.Scanner;

public class Utility {

    private static int[] current_position = new int[2];//map

/**
 * this method will load the map, and will return a 2 dimensional array
 * it willl load the file and use scanner to gather the info
 * we are going to gather the information in a string to tokenize it
 * and the put it into the array
 * if its -1, we are going to put a |, a 0 will remain 0
 * @return 
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
    /**
     * the userDummy will create a copy of the user and the time will be used to update the playtime
     * @param userDummy
     * @param time
     */
    public static void update_playtime(user userDummy,int time){
        userDummy.updatePlaytime(time);
    }
    /**
     * this will return the play time in minutes, the variables are there
     * to hold the start of the time and the end of the time in nano time
     * @param start
     * @param end
     * @return returns the time as int and in minutes
     */
    public static int count_playtime(long start, long end){
        return (int)(end-start)/1000000000;
        
    }
    

    //data structure for the user
    /**
     * we decided to use a queue for the data structure
     */
    public static QueueLinked users_list = new QueueLinked();
    /**
     * This method will create users and add it to the queue
     * @param state
     * @param lastsignin
     * @param username
     * @param fn
     * @param loginttime
     * @param pin
     * @param LN
     * @param totalPlayTime
     * @param city
     * @param ZIP
     * @param dob
     */
    public static void createuser(String state, String lastsignin, String username, String fn, String loginttime,String pin, String LN, String  totalPlayTime, String city,String ZIP, String dob){
        user newUser = new user(state, lastsignin, username, fn, loginttime, pin, LN, totalPlayTime, city, ZIP, dob);
        add_totheQueue(newUser);

    }
    public static void load_users()throws FileNotFoundException{
        tokentheUser();
    }
    /**
     * This Method is to create the tokens for the user, it will call the function create user
     * as a reference, the token is displayed by the next order
     * state, LastSignIn, Username, FN, LogInTime, PIN, LN, TotalPlaytime, City, ZIP, dob
     * @throws FileNotFoundException
     */
    public static void tokentheUser()throws FileNotFoundException{
        Scanner file = new Scanner(new File("Users.csv"));
        while(file.hasNextLine()){
        String holder = file.nextLine();
        String [] a = holder.split(",");
        createuser(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9],a[10]);
        System.out.flush();
        }
    }
    /**
     * This method will add to the queue for new, calling the custom queue
     * @param newUser
     */
    public static void add_totheQueue(user newUser){
        users_list.enqueue(newUser);
    } 
    /**
     * This method will search user in the whole linked list
     * @param username
     * @param userCopy
     * @return returns the user if found, if not, it will return null
     */
    public static user searchuser(String username, QueueLinked userCopy){
        while(users_list!=null){
            if(userCopy.peek().getUsername().equals(username))return userCopy.dequeue();
        }
        return null;
    }
    public static Boolean userlogin(String username, String PIN){
        return userlogin(username,PIN,users_list);
    }
    /**
     * Login checker of the user
     * @param userName
     * @param PIN
     * @param userCopy
     * @return returns true if the username and the PIN are correct or exist
     */
    private static Boolean userlogin(String userName, String PIN,QueueLinked userCopy){
		user dummy = searchuser(userName, userCopy);
        if(dummy.getUsername().equals(userName) && dummy.getPin().equals(PIN)){
			return true;
		}
		else{
		    return false;
		}
	}






}
