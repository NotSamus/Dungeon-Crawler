import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * This class that represents a game administrator.
 * Game admin attributes: 
 * String username
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class GameAdmin{
    /**
     * Game admin username.
     */
    private static String username;
    /**
     * A utility class for interacting with the game.
     */
    public static gameUtilities Utility = new utilities();
    
    /**
     * A HashMap of user records, indexed by username.
     */
    public static HashMap<String, user> user_records = Utility.getUser_records();
    /** 
     * Creates a statistics file for the given user.
     * 
     * @param username The user that we are creating statistics file for.
     * @throws IOException If there is an error creating the statistics file.
     */
    public static void createStatisticsFile(String username) throws IOException{
        // System.out.println("U: "+username);
        if (isAdmin()) {
            if (!user_records.containsKey(username)) {
                throw new IllegalArgumentException("User not found");
            }

            user newuser = user_records.get(username);
            String stats = "Username: " + newuser.getUsername() + "\n" +
                "Last sign in time: " + newuser.getLastSignIn() + "\n" +
                "Total Play time: " + newuser.getTotalPlayTime() + "\n" +
                "Number of battles won: " + newuser.getBattlesWon() + "\n" +
                "Number of battles lost: " + newuser.getBattlesLost() + "\n" +
                "Number of times user finished the game: " + 
                newuser.getGamesFinished() + "\n" + 
                "Number of items picked up overall from all games played: " +
                newuser.getItemsPickedUp();

            try(FileWriter writer = new FileWriter(username + "GameStatistics.csv")){
                writer.write(stats);
                writer.close();
                System.out.println("Statistics are generated. Thanks for stopping by!");
            }
            
        }
        else{
            System.out.println("Permission denied. only a game administrator can create stats file ");
        }
    }

    /**
     * Gets the current time.
     * 
     * @return The current time.
     */
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    /**
     * Checks if the current user is an administrator.
     * 
     * @return true if the current user is an administrator, false otherwise.
     */
    private static boolean isAdmin(){
        String GameAdministrator = "Admin";
        return true;
    }

    /**
     * Saves the given user to a file.
     * 
     * @param newuser Username of the user to save.
     * @throws IOException If there is an error saving the user to a file.
     */
    public static void saveUserToFile(String newuser) throws IOException {

        user savUser = user_records.get(username);
        try{
        FileWriter fileWriter = new FileWriter(newuser + "-SavedDungeon.csv");
        fileWriter.write("\n" + savUser.getUsername() + "," + savUser.getLastSignIn() + "," + savUser.getTotalPlayTime() + "," + savUser.getPhoneNumber() + "," + savUser.getBattlesWon() + "," + savUser.getBattlesLost() + "," + savUser.getGamesFinished() + "," + savUser.getItemsPickedUp() +"\n");

        fileWriter.close();}catch (IOException e){
            System.out.println("The File Does not exist :C ");
        }
    }
    /**
     * This method will generate a random map
     * @param a this is the number for the map
     * @param size this is the size of the map
     * @throws IOException
     */
    public static void RandomMapGenerators(int a, int size)throws IOException{
        RandomMapGenerator.createNewMap(a, size);
    }
}