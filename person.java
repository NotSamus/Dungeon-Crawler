import java.sql.Date;

public abstract class person{
	// String state, firstName,lastName, city, ZIP, dob;
	private String firstName;
	private String lastName;
	private String city;
	private int ZIP;
	private Date dateOfBirth;

	/**
	 * this is the method get fisrt name
	 * @return
	 */
	 public String getFirstName() {
		return firstName;
	  }
	  
	  public void setFirstName(String firstName) {
		this.firstName = firstName;
	  }
	  
	  public String getLastName() {
		return lastName;
	  }
	  
	  public void setLastName(String lastName) {
		this.lastName = lastName;
	  }
	  
	  public String getCity() {
		return city;
	  }
	  
	  public void setCity(String city) {
		this.city = city;
	  }
	  
	  public int getZIP() {
		return ZIP;
	  }
	  
	  public void setZIP(int ZIP) {
		this.ZIP = ZIP;
	  }
	  
	  public Date getDateOfBirth() {
		return dateOfBirth;
	  }
	  
	  public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	  }
	public String toString() {
		return "Person{" +
			"firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", city='" + city + '\'' +
			", zipCode=" + ZIP +
			", dateOfBirth=" + dateOfBirth +
			'}';
	  }
}


