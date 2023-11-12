
/**
 * Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 *
 */

import java.io.*;
import java.util.*;

public class user extends person{
    player myplayer = new player();
    private String state;
    private long lastSignIn;
    private static String username;
    private String firstName;
    private String loginTime;
    private int pin;
    private String lastName;
    public static long totalPlayTime;
    private String city;
    private int zip;
    private String dateOfBirth;

	public user(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime, player myplaye1) {
        super(firstName, lastName, username);
        this.state = state;
        this.lastSignIn = Long.parseLong(lastSignIn);
        this.loginTime = loginTime;
        user.totalPlayTime = Long.parseLong(totalPlayTime);
        this.pin = Integer.parseInt(pin);
        this.city = city;
        this.zip = Integer.parseInt(zip);
        this.dateOfBirth = dateOfBirth;
        this.myplayer = myplaye1;
    }

    public player getPlayer(){
        return myplayer;
    }
    public String getState() {
        return state;
    }
    public String getUsername() {
        return username;
    }
    
    public long getLastSignIn() {
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

    public long getTotalPlayTime(){
        return totalPlayTime;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public void setLastSignIn(long lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
    
    public void setLoginTime(long loginTime) {
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
    public void setTotalPlayTime(long l){
        user.totalPlayTime = (int) l;
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