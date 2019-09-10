/**
 *  @author Jake Musleh
 *  Title: Librarian.java
 *  Email: jmusleh@wisc.edu
 *  Description: Creates an instance of a librarian, who has a username and password to access the application
 */
public class Librarian {
	
	private String username; //The librarian's username
	private String password; //The librarian's password
	
	/**
	 * Initializes a new Librarian
	 * @param username - The username of the librarian
	 * @param password - The password of the librarian
	 */
	public Librarian(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Checks whether or not the entered password is valid
	 * @param password - The entered password
	 * @return - Whether or not the entered password matches the actual password
	 */
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}
	
	/**
	 * Gets the librarian's username
	 * @return - The username
	 */
	public String getUsername()
	{
		return username;
	}

}
