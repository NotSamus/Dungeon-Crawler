import java.io.FileNotFoundException;
import java.time.*;
import java.util.Scanner;
public class RunGame{

	private static final String USER_FILE = "users.txt";
	private static final String LOG_FILE = "game.log";

	public static void main(String[]args) throws FileNotFoundException{
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
			System.out.print("please enter a pin for your account\n>" );
			String pin = input.nextLine();
			System.out.print("please enter you date of birth\n>");
			String dob = input.nextLine();
			System.out.print("please enter the state\n>");
			String state = input.nextLine();
			System.out.print("please enter the city\n>");
			String city = input.nextLine();
			System.out.print("please enter the zip code\n>");
			String ZIP = input.nextLine();
			//method to register user
			Utility.createuser(state, "0", username, FN, "0", pin, LN, "0",city, ZIP, dob);
			// Utility.writeUserFile(USER_FILE, newUser);

			break;
		case"login":
			System.out.print("please enter your username:\n>");
			String userName = input.nextLine();
			System.out.print("please enter your pin:\n>");
			pin = input.nextLine();

			break;
		case"new game":
			System.out.println("creating new game...");
			break;
	}
	if(option.equals("exit")){
		System.exit(0);
	}
	}while(!(option.equals("login")||option.equals("new game")));




	long time_start = System.nanoTime();

	// load map

	String map[][] = Utility.load_map();
	map = Utility.Random_spawn(map);
	Utility.printMatrix(map);
	System.out.print("\n>");

	String terminalinput = input.nextLine();
	while(!terminalinput.equals("exit")){
		switch(terminalinput){
			case "w":
				map = Utility.move_up(map);
				Utility.printMatrix(map);
				break;
			case"a":
				map = Utility.move_left(map);
				Utility.printMatrix(map);
				break;
			case"s":
				map = Utility.move_down(map);
				Utility.printMatrix(map);
				break;

			case"d":
				map = Utility.move_right(map);
				Utility.printMatrix(map);
				break;
		}
		System.out.print("\n>");
		terminalinput = input.nextLine();
	}
	
	long time_stop = System.nanoTime();
	// Utility.update_playtime(Utility.getuser(),Utility.count_playtime(time_start, time_stop));	

}


}
