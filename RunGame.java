import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunGame{

	// private static final String USER_FILE = "User.java";
	// private static final String LOG_FILE = "game.log";
	public static String userName;
	public static void main(String[]args) throws IOException, FileNotFoundException, ArrayIndexOutOfBoundsException{
		String map[][] = Utility.load_map();
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
					userName = input.nextLine();
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
					
					Utility.createuser(userName,  FN,  LN,  state,  "0",  "0",  pin,  dob,  city,  ZIP,  "0");
					log.loger("Player: " + userName + " Register in to the game " );
					break;
		case"login":
					
					Utility.tokentheUser();
					System.out.print("please enter your username:\n>");
					userName = input.nextLine();
					System.out.print("please enter your password:\n>");
					int password = input.nextInt();
					

					if (Utility.searchuser(userName) == true && Utility.searchpin(password) == true) {
					
						System.out.println("Welcome: " + userName);

						long time_start = System.nanoTime();
						
						// String map[][] = Utility.load_map();
						map = Utility.spawnUser(map);
						Utility.printMatrix(map);
					}else{
						System.out.println("Incorrect username or password");
					}
					log.loger("Player: " + userName + " logged in " );
					break;
		case"new game":
					Utility.tokentheUser();
					System.out.print("please enter your username to play a new game:\n>");
					String user = input.nextLine();
					System.out.print("please enter your password:\n>");
					int passWord = input.nextInt();
					

					if (Utility.searchuser(user) == true && Utility.searchpin(passWord) == true) {
					
						System.out.println("Welcome: " + user);

						long time_start = System.nanoTime();
						
						// String map[][] = Utility.load_map();
						map = Utility.spawnUser(map);
						Utility.printMatrix(map);
					}else{
						System.out.println("Incorrect username or password");
					}
					log.loger("Player: " + user + " logged in " );
					System.out.println("creating new game...");
					log.loger("Player: " + user + " started a new game " );

					break;
	}
	if(option.equals("exit")){
		log.loger("Player: " + userName + " logged out" );
		System.exit(0);
	}
	}while(!(option.equals("login")||option.equals("new game")));

	// String map[][] = Utility.load_map();
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
	}}catch(ArrayIndexOutOfBoundsException e){
        System.out.println("CONGRATULATIONS YOU FOUND THE EXIT!!!!!!!");
		log.loger(userName + " Found the exit!!!!");
        
    }
	
	long time_stop = System.nanoTime();
	input.close();
}
}
