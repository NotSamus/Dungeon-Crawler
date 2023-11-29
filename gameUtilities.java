import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
/**
 * Interface gameUtilities defines the methods that must be implemented by a game utilities class.
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public interface gameUtilities {

    /**
     * Loads the game map from given file.
     *
     * @throws FileNotFoundException If the game map file does not exist.
     * @return A 2D array of strings representing the game map.
     */
    public String [][] loadMap() throws FileNotFoundException;

    /**
     * Prints the game map to the console.
     *
     * @param gameMap The 2D array of strings representing the game map.
     */
    public void printMatrix(String [][] gameMap);
    
    /**
     * Moves the player up one tile/room on the game map.
     *
     * @param gameMap The 2D array of strings representing the game map.
     * @throws IOException If there is an error saving the updated game map.
     * @return The updated game map.
     */
    public String [][] move_up(String [][] gameMap, String username) throws IOException;

    /**
     * Moves the player down one tile/room on the game map.
     *
     * @param gameMap The 2D array of strings representing the game map.
     * @throws IOException If there is an error saving the updated game map.
     * @return The updated game map.
     */
    public String [][] move_down(String [][] gameMap, String username) throws IOException;

    /**
     * Moves the player left one tile/room on the game map.
     *
     * @param gameMap The 2D array of strings representing the game map.
     * @throws IOException If there is an error saving the updated game map.
     * @return The updated game map.
     */
    public String [][] move_left(String [][] gameMap, String username) throws IOException;

    /**
     * Moves the player right one tile/room on the game map.
     *
     * @param gameMap The 2D array of strings representing the game map.
     * @throws IOException If there is an error saving the updated game map.
     * @return The updated game map.
     */
    public String [][] move_right(String [][] gameMap, String username) throws IOException;

    /**
     * Spawns the user at the start of the game map.
     *
     * @param gameMap The 2D array of strings representing the game map.
     * @return The updated game map with the user spawned at the start of the game map.
     */
    public String [][] spawnUser(String [][] gameMap);

    /**
     * Gets the current position of the user on the game map.
     *
     * @return An array of two integers representing the user's current x and y coordinates on the game map.
     */
    public int[] getCurrentPosition();

    /**
     * Calculates the total playtime of the user.
     *
     * @param start The start time of the game.
     * @param end The end time of the game.
     * @return The total playtime in seconds.
     */
    public int count_playtime(long start, long end);

    /**
     * Creates a new user account.
     *
     * @param username The username of the new user account.
     * @param firstName The first name of the new user.
     * @param lastName The last name of the new user.
     * @param state The state of residence of the new user.
     * @param lastSignIn The last sign-in time of the new user.
     * @param logInTime The current log-in time of the new user.
     * @param pin The PIN of the new user.
     * @param dateOfBirth The date of birth of the new user.
     * @param city The city of residence of the new user.
     * @param zip The zip code of residence of the new user.
     * @param totalPlayTime The total playtime of the new user.
     * @throws IOException If there is an error saving the new user account to a file.
     */
    public void createUser(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) throws IOException;

    /**
     * Searches for a user account based on their username.
     *
     * @param userName The username of the user account to search for.
     * @return True if the user account exists, false otherwise.
     */
    public boolean searchUser(String userName);

    /**
     * Updates the game map with the user's new position and saves it to a file.
     * 
     * @param userName The users username.
     * @param userPosition The new position of the user on the game map.
     * @throws IOException If there is an error saving the updated game map to a file.
     * @return The updated game map.
     */
    public String[][] updateAndSaveMap(String userName, int[] userPosition) throws IOException;

    /**
     * Saves the game map to a file.
     * @param map The 2D array of strings representing the game map.
     * @param filename The name of the file to save the game map to.
     * @throws IOException If there is an error saving the game map to a file.
     */
    public void saveMap(String[][] map, String filename) throws IOException;

    /**
     * Searches for a user's PIN in the user records.

     * @param user The username of the user whose PIN to search for.
     * @param pin The PIN to search for.
     * @return true if the PIN is found, false otherwise.
     */
    public boolean searchPin(String user, int pin);

    /**
     * Tokens the user by creating a new token and saving it to a file.
     * 
     * @throws IOException If there is an error saving the new token to a file.
     */
    public void tokenTheUser() throws IOException;

    /**
     * Saves the given user object to a file.
     * 
     * @param newUser The user object to save to a file.
     * @throws IOException If there is an error saving the user object to a file.
     */
    public void saveUserToFile(user newUser) throws IOException;

    /**
     * Gets the instance of the game utilities class.
     * 
     * @return The instance of the game utilities class.
     */
    public utilities getInstance();

    /**
     * Gets the hashmap of user records.
     * 
     * @return The hashmap of user records.
     */
    public HashMap<String, user> getUser_records();
}
