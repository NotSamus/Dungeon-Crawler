/**
 * Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 *
 */

import java.sql.Date;

public class user extends person{
	private  String username;
    private  String password;
    private int playtime;
    private Date lastLogin;
	// long logInTime, totalPlayTime;
	// int PIN; 
    
    /**
     * this is a constructor for the user object
     * @param username
     * @param password
     * @param dob
     * @param states
     * @param city
     * @param ZIP
     */
	public user(String username , String password, String dob, String states, String city, String ZIP){
		this.username = username;
        this.password = password;
        this.playtime = 0;
        this.lastLogin = new Date(playtime);
	}

	
	//getters

    /**
     * This Method gathers the username of our user
     * @return username
     */
	public static String getUsername() {
        return username;
    }
    /**
     * This Method gets the password
     * @return password
     */
    public static String getPassword() {
        return password;
    }
    /**
     * gets the playtime
     * @return playtime
     */
    public int getPlaytime() {
        return playtime;
    }
    /**
     * gets the date of the last login
     * @return lastlogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }
    /**
     * this method will update the play time of the user
     * @param time
     */

    public void updatePlaytime(int time) {
        this.playtime = playtime + time;
    }
    /**
     * this method sets the last login of the user
     * @param lastLogin
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", playtime=" + playtime +
                ", lastLogin=" + lastLogin +
                '}';
    }
		
}
