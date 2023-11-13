import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface gameUtilities {
    public String [][] loadMap() throws FileNotFoundException;

    public void printMatrix(String [][] gameMap);
    
    public String [][] move_up(String [][] gameMap) throws IOException;

    public String [][] move_down(String [][] gameMap) throws IOException;

    public String [][] move_left(String [][] gameMap) throws IOException;

    public String [][] move_right(String [][] gameMap) throws IOException;

    public String [][] spawnUser(String [][] gameMap);

    public int[] getCurrentPosition();

    public int count_playtime(long start, long end);

    public void createUser(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) throws IOException;

    public boolean searchUser(String userName);

    public String[][] updateAndSaveMap(String userName, int[] userPosition) throws IOException;

    public void saveMap(String[][] map, String filename) throws IOException;

    public boolean searchPin(String user, int pin);

    public void tokenTheUser() throws IOException;

    public void saveUserToFile(user newUser) throws IOException;

    public utilities getInstance();

    public HashMap<String, user> getUser_records();
}
