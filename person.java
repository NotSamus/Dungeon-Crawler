import java.util.*;
import java.io.*;

abstract class person {
    private String firstName;
    private String lastName;
    private String username;


   person(String firstName, String lastName, String username) {
		this.firstName = firstName;
    	this.lastName = lastName;
    	this.username = username;
	}

	public String getFirstName() {
    	return firstName;
	}

	public String getLastName() {
    		return lastName;
	}

	public String getUsername() {
    	return username;
	}

	public void setFirstName(String firstName) {
    	this.firstName = firstName;
	}

	public void setLastName(String lastName) {
    	this.lastName = lastName;
	}

	public void setUsername(String username) {
    	this.username = username;
	}
}

// person person = new person();