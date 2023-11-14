import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class provides methods for updating and loading users csv, dungeon csv, and players csv files.
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class gameState {

    /**
     * A utility class for interacting with the game.
     */
    public static gameUtilities Utility = new utilities();

    /**
     * A HashMap of user records, indexed by username.
     */
    static HashMap<String, user> user_records = Utility.getInstance().getUser_records();

    /**
     * Saves the user records to a file called `Users_Updated.csv`. 
     * 
     * @param userName The username of the user to save the records for.
     * @throws IOException If there is an error saving the user records to a file.
     */
    public static void saveUsersSheet(String userName) throws IOException {
        FileWriter writer = new FileWriter(userName+ "-Users_Updated.csv",true);
        writer.write("Username,Playtime,LastLogin\n");
        for (user user : user_records.values()) {
            writer.write(user.getUsername() + "," + user.getTotalPlayTime() + "," + user.getLastSignIn() +  "," + user.getTotalPlayTime() +"\n");
        }
        writer.close();
    }

    /**
     * Saves the dungeon to a file called `[username]-SavedDungeon.csv`.
     * @param dungeon The 2D array of strings representing the dungeon.
     * @param username The username of the user to save the dungeon for.
     * @throws IOException If there is an error saving the dungeon to a file.
     */
    public static void saveDungeon(String[][] dungeon, String username) throws IOException {
        FileWriter fileWriter = new FileWriter(username+"-SavedDungeon.csv");

        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                fileWriter.write(dungeon[i][j]);
                if (j < dungeon[i].length - 1) {
                    fileWriter.write(",");
                }
            }
            fileWriter.write("\n");
        }

        fileWriter.close();
    }

    /**
     * Saves the player to a file called `[username]Player.csv`.
     * 
     * @param player The player object to save.
     * @param username The username of the user to save the player for.
     * @throws IOException If there is an error saving the player to a file.
     */
    public static void savePlayer(player player, String username) throws IOException {
        FileWriter writer = new FileWriter(username + "Player.csv",true);
        writer.write("HealthPoints,damage,heal_potion\n");
        writer.write(player.get_health() + "," + player.get_damage() +  "," + player.get_heal_potion() + "\n");
        writer.close();
    }

    /**
     * Prompts the user to start a new game or exit the game.
     * 
     * @param username The username of the user to prompt.
     * @throws IOException If there is an error prompting the user.
     */
    public static void promptUser(String username) throws IOException {
        String map[][] = Utility.loadMap();
        
        System.out.println("Would you like to start the game over or exit the game? (start/exit)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("start")) {
            // map = Utility.spawnUser(map);
				Utility.printMatrix(map);
				log.loger("Player: " + username + " logged in " );
        } else if (input.equals("exit")) {
            System.exit(0);
        } else {
            System.out.println("Invalid input. Please try again.");
            promptUser(username);
        }
    }

    
}
