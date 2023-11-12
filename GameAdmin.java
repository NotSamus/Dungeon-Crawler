import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class GameAdmin{
    // private String name;
    private String username;
    // private String password;

    HashMap<String, user> user_records = Utility.getInstance().getUser_records();

    // public GameAdmin(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime,player mPlayer) {
    //     super(username, firstName, lastName, state, lastSignIn, logInTime, pin, dateOfBirth, city, zip, totalPlayTime,myplayer);
    // }
    public GameAdmin(String username){
        // this.name = name;
        this.username = username;
        // this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public void createStatisticsFile(String username) throws IOException{
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


    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    private static boolean isAdmin(){
        String GameAdministrator = "Admin";
        return true;
    }

    static void saveUserToFile(user newuser) throws IOException {
        try{
        FileWriter fileWriter = new FileWriter("users2.csv", true);
        fileWriter.write("\n" + newuser.getUsername() + "," + newuser.getLastSignIn() + "," + newuser.getTotalPlayTime() + "," + newuser.getPhoneNumber() + "," + newuser.getBattlesWon() + "," + newuser.getBattlesLost() + "," + newuser.getGamesFinished() + "," + newuser.getItemsPickedUp() +"\n");

        fileWriter.close();}catch (IOException e){
            System.out.println("The File Does not exist :C ");
        }
    }
}