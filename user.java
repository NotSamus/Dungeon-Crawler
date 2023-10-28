
/**
 * Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 *
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class user extends person{

    private String state;
    private int lastSignIn;
    private static String username;
    private String firstName;
    private String loginTime;
    private int pin;
    private String lastName;
    public static int totalPlayTime;
    private String city;
    private int zip;
    private String dateOfBirth;

	public user(String username, String firstName, String lastName, String state, String lastSignIn, String logInTime, String pin, String dateOfBirth, String city, String zip, String totalPlayTime) {
        super(firstName, lastName, username);
        this.state = state;
        this.lastSignIn = Integer.parseInt(lastSignIn);
        this.loginTime = loginTime;
        this.totalPlayTime = Integer.parseInt(totalPlayTime);
        this.pin = Integer.parseInt(pin);
        this.city = city;
        this.zip = Integer.parseInt(zip);
        this.dateOfBirth = dateOfBirth;
    }


    public String getState() {
        return state;
    }
    public String getUsername() {
        return username;
    }
    
    public int getLastSignIn() {
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

    public int getTotalPlayTime(){
        return totalPlayTime;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public void setLastSignIn(int lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
    
    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
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
    public void setTotalPlayTime(int totalPlayTime){
        this.totalPlayTime = totalPlayTime;
    }


    public Object getPassword() {
        return null;
    }
		
}