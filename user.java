/**
 * Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 *
 */

import java.sql.Date;

public class user extends person{
    private String state;
    private String lastsignin;
    private String username;
    private String first_name;
    private String logintime;
    private String pin;
    private String Last_Name;
    private String totalplayT;
    private String city;
    private String ZIP;
    private String dob;
    private Date lastLogin;
	// long logInTime, totalPlayTime;
	// int PIN; 
    
    /**
     * This is the constructor for the object user
     * @param state
     * @param lastsignin
     * @param username
     * @param fn
     * @param logintime
     * @param pin
     * @param LN
     * @param totalplayT
     * @param city
     * @param ZIP
     * @param dob
     */

	public user(String state, String lastsignin,String username, String fn, String logintime, String pins, String LN, String totalplayT, String city, String ZIP, String dob ){
		this.state = state;
        this.lastsignin = lastsignin;
        this.username = username;
        this.first_name = fn;
        this.logintime = logintime;
        this.pin = pins;
        this.Last_Name = LN;
        this.totalplayT =totalplayT;
        this.city = city;
        this.ZIP = ZIP;
        this.dob = dob;
	}

	
	//getters

    public String getPin(){
        return pin;
    }
    /**
     * This Method gathers the username of our user
     * @return username
     */
	public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        // TODO Auto-generated method stub
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        // TODO Auto-generated method stub
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        // TODO Auto-generated method stub
        super.setLastName(lastName);
    }
    @Override
    public String getCity() {
        // TODO Auto-generated method stub
        return super.getCity();
    }

    @Override
    public void setCity(String city) {
        // TODO Auto-generated method stub
        super.setCity(city);
    }

    @Override
    public int getZIP() {
        // TODO Auto-generated method stub
        return super.getZIP();
    }
    @Override
    public void setZIP(String ZIP) {
        // TODO Auto-generated method stub
        super.setZIP(ZIP);
    }
    @Override
    public Date getDateOfBirth() {
        // TODO Auto-generated method stub
        return super.getDateOfBirth();
    }

    /**
     * gets the playtime
     * @return playtime
     */
    public int getPlaytime() {
        return Integer.parseInt(totalplayT);
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
        this.totalplayT = totalplayT + time;
    }
    /**
     * this method sets the last login of the user
     * @param lastLogin
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        // TODO Auto-generated method stub
        super.setDateOfBirth(dateOfBirth);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
		
}
