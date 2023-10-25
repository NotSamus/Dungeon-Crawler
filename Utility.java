import java.io.*;
import java.util.Scanner;

public class Utility {

    private static int[] current_position = new int[2];//map
    private static final String USER_FILE = "users.txt";//user

    // public static user readUserFile(String userFile) throws Exception{
    //     BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
    //     String line = reader.readLine();
    //     reader.close();

    //     if (line == null) {
    //         return null;
    //     }

    //     String[] parts = line.split(",");
    //     String username = parts[0];
    //     String password = parts[1];

    //     return new user(username, password);
    // }

    // public static void writeUserFile(String userFile, user newUser) throws Exception {
    //     BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE));
    //     writer.write(user.getUsername() + "," + user.getPassword());
    //     writer.close();
    // }






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
    public static String[] tokenizer(String a){
        return a.split(",");
    }
    public static void printMatrix(String a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(" "+a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.flush();
    }
    
    //MOVEMENT OF THE PLAYER
    public static String[][] move_down(String a[][]){
        if(a[(current_position[0])+1][current_position[1]].equals("0")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])+1][current_position[1]] = "$";
            current_position[0] = current_position[0]+1;
            current_position[1] = current_position[1];
        }return a;
    }
    public static String[][] move_up(String a[][]){
        if(a[(current_position[0])-1][current_position[1]].equals("0")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])-1][current_position[1]] = "$";
            current_position[0] = current_position[0]-1;
            current_position[1] = current_position[1];
        }return a;
    }
    public static String[][] move_right(String a[][]){
        if(a[(current_position[0])][current_position[1]+1].equals("0")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]+1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]+1;
        }return a;
    }
    public static String[][] move_left(String a[][]){
        if(a[(current_position[0])][current_position[1]-1].equals("0")){
            a[(current_position[0])][current_position[1]] = "0";
            a[(current_position[0])][current_position[1]-1] = "$";
            current_position[0] = current_position[0];
            current_position[1] = current_position[1]-1;
        }return a;
    }
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















}
