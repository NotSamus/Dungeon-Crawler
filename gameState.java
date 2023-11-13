import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class gameState {
    static HashMap<String, user> user_records = Utility.getInstance().getUser_records();

    public static void saveUsersSheet(String userName) throws IOException {
        FileWriter writer = new FileWriter(userName+ "-Users_Updated.csv",true);
        writer.write("Username,Playtime,LastLogin\n");
        for (user user : user_records.values()) {
            writer.write(user.getUsername() + "," + user.getTotalPlayTime() + "," + user.getLastSignIn() +  "," + user.getTotalPlayTime() +"\n");
        }
        writer.close();
    }

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

    public static void savePlayer(player player, String username) throws IOException {
        FileWriter writer = new FileWriter(username + "Player.csv",true);
        writer.write("HealthPoints,damage,heal_potion\n");
        writer.write(player.get_health() + "," + player.get_damage() +  "," + player.get_heal_potion() + "\n");
        writer.close();
    }

    public static void promptUser(String username) throws IOException {
        String map[][] = Utility.load_map();
        
        System.out.println("Would you like to start the game over or exit the game? (start/exit)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("start")) {
            map = Utility.spawnUser(map);
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
