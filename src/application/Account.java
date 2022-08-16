package application;

/**
 * The Account class represents an account object. Meant to model a real life
 * online account, containing username, password, and an account name. This
 * class contains getter methods to retrieve information for account objects.
 * Contains two constructors, one for creating objects with parameters for each
 * instance variables, another for creating objects from a csv file of specified
 * format.
 *
 * @author youssef.abdelrhafour
 * @author achraf.abdelrhafour
 *
 */
public class Account {
	private String id;
	private String accountname;
	private String username;
	private String password;

	/**
	 * This constructor creates a new Account object using 3 string parameters
	 * (accountname, username, password), the remaining instance variable 'id' is
	 * randomly generated using the UUID class. Used for any Account data not
	 * currently stored in the 'accounts.csv' file.
	 * 
	 * @param accountname the name of the account
	 * @param username    the account username
	 * @param password    the account password
	 */

	public Account(String accountname, String username, String password) {

		this.id = java.util.UUID.randomUUID().toString();
		this.accountname = new String(accountname);
		this.username = new String(username);
		this.password = new String(password);
	}

	/**
	 * This constructor creates a new Account object using 4 string parameters. This
	 * would be used for any Account data that is already stored in the
	 * 'accounts.csv' file. No id is generated, but id is read from existing file
	 * accounts file.
	 * 
	 * @param id          the unique id for the account
	 * @param accountname the name of the account
	 * @param username    the account username
	 * @param password    the account password
	 */
	public Account(String id, String accountname, String username, String password) {
		this.id = new String(id);
		this.accountname = new String(accountname);
		this.username = new String(username);
		this.password = new String(password);
	}

	// Getter methods for retrieving values (copies) of all instance variables

	public String getAccountname() {
		return new String(accountname);
	}

	public String getId() {
		return new String(id);
	}

	public String getPassword() {
		return new String(password);
	}

	public String getUsername() {
		return new String(username);
	}

}
