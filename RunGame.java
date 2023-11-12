import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.monitor.GaugeMonitor;

public class RunGame{
	public static String userName;
	public static String num;
	public static String FN;
	public static String LN;
	public static String addy;
	public static String pin;
	public static String dob;
	public static String state;
	public static String city;
	public static String ZIP;
	public static void main(String[]args) throws IOException, FileNotFoundException, ArrayIndexOutOfBoundsException, InputMismatchException{
		
	String map[][] = Utility.load_map(); 

	Scanner input = new Scanner(System.in);
	Utility utility = Utility.getInstance();
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
			utility.createuser(userName,  FN,  LN,  state,  "0",  "0",  pin,  dob,  city,  ZIP,  "0");
			log.loger("Player: " + userName + " Register in to the game " );
			break;
		case"login":
			utility.tokentheUser();
			System.out.print("please enter your username:\n>");
			userName = input.nextLine();
			try{
			System.out.print("please enter your PIN:\n>");
			int password = input.nextInt();
			if (userName.toLowerCase().equals("admin")) {
				if (Utility.searchuser(userName) == true && Utility.searchpin(userName, password)) {
					System.out.println("Welcome back: " + userName);
					// long time_start = System.nanoTime();
					// map = Utility.spawnUser(map);
					// Utility.printMatrix(map);
					log.loger("Player: " + userName + " logged in " );
					System.out.println("Would you like to create a satistic file yes or No?");
					String answer = input.next();
					if (answer.toLowerCase().equals("yes")) {
						GameAdmin newUser = new GameAdmin(userName,  FN,  LN,  state,  "0",  "0",  "1234",  dob,  city,  "7866",  "0",);
						System.out.println("Please enter the username for which you would like to generated a file for: ");
						String infoUser = input.next();
						newUser.createStatisticsFile(infoUser);
						// GameAdmin.saveUserToFile(newUser);
						System.out.println("Statistics are generated. Thanks for stopping by!");
						System.exit(0);
					}else{
						System.out.println("Thanks for stopping by\n");
						System.exit(0);
					}
				}
			}
			else if (Utility.searchuser(userName) == true && Utility.searchpin(userName, password)) {
				System.out.println("Welcome: " + userName);
				long time_start = System.nanoTime();
				map = Utility.spawnUser(map);
				Utility.printMatrix(map);
				log.loger("Player: " + userName + " logged in " );
			}
			else{
				System.out.print("Incorrect username or password\n\n");
			}
			}catch (InputMismatchException e){
				System.out.print("Please enter Numbers\n\n");
			}
			
			break;
		case"new game":
			
			utility.tokentheUser();
			System.out.print("please enter your username to play a new game:\n>");
			String user = input.nextLine();
			System.out.print("please enter your password:\n>");
			
			int passWord = input.nextInt();
			
			
			if (Utility.searchuser(user) == true && Utility.searchpin(userName, passWord)) {
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
	while(!terminalinput.equals("exit")){
		switch(terminalinput){
			case "w":
				map = Utility.move_up(map);
				log.loger(userName + " Moved UP, This is the current position: " + Utility.current_position[0]+","+Utility.current_position[1]);
				Utility.printMatrix(map);
				break;
			case"a":
				map = Utility.move_left(map);
				log.loger(userName + " Moved Left, This is the current position: " + Utility.current_position[0]+","+Utility.current_position[1]);
				Utility.printMatrix(map);
				break;
			case"s":
				map = Utility.move_down(map);
				log.loger(userName + " Moved Down, This is the current position: " + Utility.current_position[0]+","+Utility.current_position[1]);
				Utility.printMatrix(map);
				break;

			case"d":
				map = Utility.move_right(map);
				log.loger(userName + " Moved Right, This is the current position: " + Utility.current_position[0]+","+Utility.current_position[1]);
				Utility.printMatrix(map);
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
