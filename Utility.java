import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Utility {
    private static final String USER_FILE = "users.txt";

    public static user readUserFile(String userFile) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
        String line = reader.readLine();
        reader.close();

        if (line == null) {
            return null;
        }

        String[] parts = line.split(",");
        String username = parts[0];
        String password = parts[1];

        return new user(username, password);
    }

    public static void writeUserFile(String userFile, user newUser) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE));
        writer.write(user.getUsername() + "," + user.getPassword());
        writer.close();
    }

}
