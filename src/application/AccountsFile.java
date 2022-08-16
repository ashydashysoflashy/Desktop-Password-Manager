package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The AccountsFile class represents an object that contains data from a csv
 * file of specified format. This data is stored in an ArrayList of type
 * Account. It is used for i) Reading an input file, and input data storing into
 * an ArrayList. ii) Writing to an output file, using output data from an
 * ArrayList. (Overwrites file).
 * 
 * @author youssef.abdelrhafour
 * @author achraf.abdelrhafour
 *
 */
public class AccountsFile {
	// The only instance variable is an ArrayList of type account
	private ArrayList<Account> accounts;

	/**
	 * This constructor creates an AccountsFile from the 'accounts.csv file'. First
	 * reads in all the values, then stores them in an ArrayList 'accounts'.
	 * 
	 * @param fileName always set to the 'accounts.csv' file
	 * @throws IOException
	 */

	public AccountsFile(String fileName) throws IOException {
		fileName = "accounts.csv";
		accounts = new ArrayList<Account>();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line = in.readLine();
		while (line != null) {
			String[] accountValues = line.split(",");
			accounts.add(new Account(accountValues[0], accountValues[1], accountValues[2], accountValues[3]));
			line = in.readLine();
		}
		in.close();
	}

	/**
	 * Used for writing out the file with updated changes to the ArrayList accounts.
	 * After making changes, call writeOut() to update your output file (overwrite).
	 * 
	 * @throws IOException
	 */
	public void writeOut() throws IOException {
		FileWriter accounts_csv = new FileWriter("accounts.csv");
		PrintWriter out = new PrintWriter(accounts_csv);

		for (Account account : accounts) {
			out.printf("%s,%s,%s,%s \n", account.getId(), account.getAccountname(), account.getUsername(),
					account.getPassword());
		}
		out.close();
	}

	/**
	 * Method for adding accounts to the 'accounts' ArrayList
	 * 
	 * @param accountToAdd Account object to add to ArrayList
	 * @throws IOException
	 */
	public void addAccount(Account accountToAdd) throws IOException {
		accounts.add(accountToAdd);
		writeOut();
	}

	/**
	 * Method for removing accounts from the 'accounts' ArrayList. Makes use of the
	 * unique id to find the correct object.
	 * 
	 * @param guid Globally Unique Identifier for Account object
	 * @throws IOException
	 */
	public void removeAccount(String guid) throws IOException {
		int index = 0;
		for (Account n : accounts) {
			if (guid.equals(n.getId())) {
				accounts.remove(index);
				break;
			}
			index++;
		}
		writeOut();
	}

	/**
	 * Gets an ArrayList of accounts.
	 * 
	 * @return ArrayList of type Accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

}
