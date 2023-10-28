import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Scanner;

import javax.swing.text.Utilities;
public class RunGame{

	private static final String USER_FILE = "User.java";
	private static final String LOG_FILE = "game.log";

	public static void main(String[]args) throws IOException{
	//read the users file 

	/** these are just a variable to the options menu and the scanner */
	Scanner input = new Scanner(System.in);
	String option;
	/**menu*/
	do{
	System.out.println("Welcome to the dungeon");
	System.out.print("Choose an option:\n");
	System.out.print("\nregister\nlogin\nnew game\nexit\n\n> ");
	option = input.nextLine();
	//the switch for picking an option
	switch(option){
		case"register":
			System.out.print("please enter your first name\n>");
			String FN = input.nextLine();
			System.out.print("please enter your last name\n>");
			String LN = input.nextLine();
			System.out.print("please enter your username\n>");
			String username = input.nextLine();
			System.out.print("please enter a password for your account\n>" );
			String pin = input.nextLine();
			System.out.print("please enter you date of birth\n>");
			String dob = input.nextLine();
			System.out.print("please enter the state\n>");
			String state = input.nextLine();
			System.out.print("please enter the city\n>");
			String city = input.nextLine();
			System.out.print("please enter the zip code\n>");
			String ZIP = input.nextLine();
			// method to register user
			// Utility utility = new Utility();
			// log log = new log();
			// try {
    		// BufferedReader br = new BufferedReader(new FileReader("Users.csv"));
    		// String line;
    		// while ((line = br.readLine()) != null) {
        	// String[] data = line.split(",");
			// user user = new user(username, FN, LN, state, 0, 0, pin, dob, city, ZIP, 0);
        	// utility.createUser(user);
    		// }
    		// br.close();
			// } catch (IOException e) {
    		// 	log.log("Failed to read the Users file");
			// }
			// Utility.updateUser(FN);
			// Utility.createuser(username, username, dob, state, 0, 0, pin, state, city, ZIP, 0);
			Utility.addNewUser(FN, LN,  username,  state,  "0",  "0",  pin,  city,  ZIP,  "0",  "0");
			//Utility.createuser(state, "0", username, FN, "0", pin, LN, "0",city, ZIP, dob);
			break;
		case"login":
			System.out.print("please enter your username:\n>");
			String userName = input.nextLine();
			System.out.print("please enter your password:\n>");
			String password = input.nextLine();
			
			Utility.invokeList();
		
			// user user = Utility.findUserInFile(userName);
        	// if (user.getUsername() == userName) {
            // 	System.out.println("Invalid username or password");
        	// }
        	// // user currentUser = user;
			// System.out.println("welcome: " + user.getUsername());

			// dungeon.searchuser(userName,null);
			// if(dungeon.userlogin(userName, password) == true){
			// 	Utility.loadMap();
			// }else{
			// 	System.out.println("Incorect username or password.");
			// }



			break;
		case"new game":
			System.out.println("creating new game...");
			break;
	}
	if(option.equals("exit")){
		System.exit(0);
	}
	}while(!(option.equals("login")||option.equals("new game")));
	
}
}
