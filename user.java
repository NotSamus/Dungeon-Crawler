
/**
 * Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 *
 */
public class user extends person{

    private String state;
    private String lastSignIn;
    private String username;
    private String loginTime;
    private int pin;
    public static String totalPlayTime;
    private String city;
    private int zip;
    private String dateOfBirth;
    private String phoneNumber;
	private String address;
    private int battlesWon;
    private int battlesLost;
    private int gamesFinished;
    private int itemsPrickedUp;

	public user(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) {
        super(firstName, lastName);
        this.username = username;
        this.state = state;
        this.lastSignIn = lastSignIn;
        this.loginTime = loginTime;
        user.totalPlayTime = totalPlayTime;
        this.pin = Integer.parseInt(pin);
        this.city = city;
        this.zip = Integer.parseInt(zip);
        this.dateOfBirth = dateOfBirth;
        this.battlesLost = 0;
        this.battlesWon = 0;
        this.gamesFinished = 0;
        this.itemsPrickedUp = 0;
    }

    public String getState() {
        return state;
    }
    public String getUsername() {
        return username;
    }
    
    public String getLastSignIn() {
        return lastSignIn;
    }
    
    public String getLoginTime() {
        return loginTime;
    }
    
    public int getPin() {
        return pin;
    }
    
    public String getCity() {
        return city;
    }
    
    public int getZip() {
        return zip;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTotalPlayTime(){
        return totalPlayTime;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public void setLastSignIn(String lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
    
    public void setLoginTime(String loginTime) {
        this.loginTime = ""+loginTime;
    }
    
    public void setPin(int pin) {
        this.pin = pin;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setZip(int zip){
        this.zip = zip;
    }
   
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setTotalPlayTime(String l){
        user.totalPlayTime = l;
    }

    public  String getPhoneNumber() {
    	return phoneNumber;
	}

	public String getAddress() {
    	return address;
	}

    public int getBattlesWon(){
        return battlesWon;
    }

    public int getBattlesLost(){
        return battlesLost;
    }

    public int getGamesFinished(){
        return gamesFinished;
    }

    public int getItemsPickedUp(){
        return itemsPrickedUp;
    }

    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
    	this.address = address;
	}

    public void addBattlesWon(){
        battlesWon++;
    }

    public void addBattlesLost(){
        battlesLost++;
    }

    public void addGamesFinished(){
        gamesFinished++;
    }

    public void addItemsPickedUp(){
        itemsPrickedUp++;
    }
    // public static void updatePlayTime(user userDummy) {
    //      //  current time
    //      long startTime = System.currentTimeMillis();
    //      //long elapsedTime = currentTime - startTime;

    //      // Calculate the elapsed time since the user logged in
    //      long elapsedTime = startTime - Long.parseLong(userDummy.getLoginTime());
    //      // Add the elapsed time to the user's total playtime
    //      //userDummy.setTotalPlayTime(userDummy.getTotalPlayTime() + elapsedTime);

    //      // Update the user's last sign-in time
    //     // userDummy.setLastSignIn(elapsedTime);
    //     userDummy.setTotalPlayTime(userDummy.getTotalPlayTime() + elapsedTime);
    //  }

    public Object getPassword() {
        return null;
    }
}