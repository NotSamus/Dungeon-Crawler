import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main that runs game.
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class RunGame{

	/**
	 * Stores the users's first username
	 */
	public static String userName;

	/**
	 * Stores the user's number
	 */
	public static String num;

	/**
	 *  Stores the users first name
	 */
	public static String FN;
	/**
	 * Stores the users last name
	 */
	public static String LN;
	/**
	 * Stores the users address
	 */
	public static String addy;
	/**
	 * Stores the user password
	 */
	public static String pin;
	/**
	 * Stores the users date of birth
	 */
	public static String dob;
	/**
	 * Stores the users home State
	 */
	public static String state;
	/**
	 * Stores the users home city
	 */
	public static String city;
	/**
	 * Stores the users zip code
	 */
	public static String ZIP;
	/**
	 * Indicates that the game utilities is used throughout the application.
	 */
	public static gameUtilities Utility = new utilities();
	/**
	 * The main method that runs the game.
	 * 
	 * @throws IOException Indicates that an i/o exception has occurred
	 * @throws FileNotFoundException Indicates that an attempt to open a file specifying a pathname has failed
	 * @throws ArrayIndexOutOfBoundsException Indicate that an array has been accessed with an illegal index
	 * @throws InputMismatchException Thrown when a user inputs the wrong data type
	 * 
	 */
	public static void main(String[]args) throws IOException, FileNotFoundException, ArrayIndexOutOfBoundsException, InputMismatchException{
		
	String map[][] = Utility.loadMap(); 

	Scanner input = new Scanner(System.in);
	Utility.getInstance();
	String option;
	/*
	 * Menu
	 */
		
	do{
		System.out.println("Welcome to the dungeon");
	System.out.print("Choose an option:\n");
	System.out.print("\nregister\nlogin\nnew game\nexit\n\n> ");
	option = input.nextLine();
	
	//the switch for picking an option
	switch(option){
		case"register":
			System.out.print("please enter your first name\n>");
			FN = input.nextLine();
			System.out.print("please enter your last name\n>");
			LN = input.nextLine();
			System.out.print("please enter your username\n>");
			userName = input.nextLine();
			System.out.print("please enter a password for your account\n>" );
			pin = input.nextLine();
			System.out.print("please enter you date of birth\n>");
			dob = input.nextLine();
			System.out.print("please enter the state\n>");
			state = input.nextLine();
			System.out.print("please enter the city\n>");
			city = input.nextLine();
			System.out.print("please enter the zip code\n>");
			ZIP = input.nextLine();
			System.out.println("please enter your phone number\n>");
			num = input.nextLine();
			System.out.println("please enter your address\n>");
			addy = input.nextLine();
			// method to register user
			Utility.createUser(userName,  FN,  LN,  state,  "0",  "0",  pin,  dob,  city,  ZIP,  "0");
			log.loger("Player: " + userName + " Register in to the game " );
			break;
		case"login":
			Utility.tokenTheUser();
			System.out.print("please enter your username:\n>");
			userName = input.nextLine();
			try{
			System.out.print("please enter your PIN:\n>");
			int password = input.nextInt();
			if (userName.toLowerCase().equals("admin")) {
				if (Utility.searchUser(userName) == true && Utility.searchPin(userName, password)) {
					System.out.println("Welcome back: " + userName);
					log.loger("Player: " + userName + " logged in " );
					System.out.println("Would you like to create a satistic file yes or No?");
					String answer = input.next();
					if (answer.toLowerCase().equals("yes")) {
						System.out.println("Please enter the username for which you would like to generated a file for: ");
						String infoUser = input.next();
						GameAdmin admin = new GameAdmin(infoUser);
						admin.createStatisticsFile(infoUser);
						//admin.saveUserToFile(infoUser);
						System.exit(0);
					}else{
						System.out.println("Thanks for stopping by\n");
						System.exit(0);
					}
				}
			}
			else if (Utility.searchUser(userName) == true && Utility.searchPin(userName, password)) {
				System.out.println("Welcome: " + userName);
				long time_start = System.nanoTime();
				map = Utility.spawnUser(map);
				Utility.printMatrix(map);
				log.loger("Player: " + userName + " logged in " );
				gameState.saveUsersSheet(userName);
			}
			else{
				System.out.print("Incorrect username or password\n\n");
			}
			}catch (InputMismatchException e){
				System.out.print("Please enter Numbers\n\n");
			}
			
			break;
		case"new game":
			
			Utility.tokenTheUser();
			System.out.print("please enter your username to play a new game:\n>");
			String user = input.nextLine();
			System.out.print("please enter your password:\n>");
			
			int passWord = input.nextInt();
			
			
			if (Utility.searchUser(user) == true && Utility.searchPin(userName, passWord)) {
				System.out.println("Welcome: " + user);
				long time_start = System.nanoTime();
				map = Utility.spawnUser(map);
				Utility.printMatrix(map);
			}
			else{
				System.out.print("Incorrect username or password\n");
			}

			log.loger("Player: " + user + " logged in " );
			System.out.println("creating new game...");
			log.loger("Player: " + user + " started a new game ");
			
			break;
	}
	if(option.equals("exit")){
		log.loger("Player: " + userName + " logged out" );
		System.exit(0);
	}
	//fixed the code
	input.nextLine();
	
	}while(!(option.equals("login")||option.equals("new game")));
	vs.handle_username(userName);
	
	
	try{
	String terminalinput = input.nextLine();
	Utility.getInstance();
	while(!terminalinput.equals("EndGame")){
		switch(terminalinput){
			case "w":
				map = Utility.move_up(map);
				Utility.updateAndSaveMap(userName, utilities.current_position);
				log.loger(userName + " Moved UP, This is the current position: " + utilities.current_position[0]+","+utilities.current_position[1]);
				Utility.printMatrix(map);
				break;
			case"a":
				map = Utility.move_left(map);

				Utility.updateAndSaveMap(userName, utilities.current_position);
				log.loger(userName + " Moved Left, This is the current position: " + utilities.current_position[0]+","+utilities.current_position[1]);
				Utility.printMatrix(map);
				break;
			case"s":
				map = Utility.move_down(map);

				Utility.updateAndSaveMap(userName, utilities.current_position);
				log.loger(userName + " Moved Down, This is the current position: " + utilities.current_position[0]+","+utilities.current_position[1]);
				Utility.printMatrix(map);
				break;

			case"d":
				map = Utility.move_right(map);
        Utility.updateAndSaveMap(userName, utilities.current_position);
				log.loger(userName + " Moved Right, This is the current position: " + utilities.current_position[0]+","+utilities.current_position[1]);
				Utility.printMatrix(map);
				break;

			case "exit":
                log.loger("Player: " + userName + " logged out");
				System.exit(0);
                break;
		}
		System.out.print("\n>");

		terminalinput = input.nextLine();
	}
}catch(ArrayIndexOutOfBoundsException e){
        System.out.println("CONGRATULATIONS YOU FOUND THE EXIT!!!!!!!");
		log.loger(userName + " Found the exit!!!!");
    }
	
	long time_stop = System.nanoTime();
	input.close();
}
}
