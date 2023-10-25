/*
 * Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 *
 * */

import java.sql.Date;

public class user extends person{
	private static String username;
    private static String password;
    private int playtime;
    private Date lastLogin;
	// long logInTime, totalPlayTime;
	// int PIN; 
	public user(String username, String password, String dob, String states, String city, String ZIP){
		this.username = username;
        this.password = password;
        this.playtime = 0;
        this.lastLogin = new Date(playtime);
	}

	
	//getters
	public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public int getPlaytime() {
        return playtime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void updatePlaytime() {
        playtime++;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    //general info

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", playtime=" + playtime +
                ", lastLogin=" + lastLogin +
                '}';
    }
		
}
