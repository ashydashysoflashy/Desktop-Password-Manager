package application;

import java.io.*;
import java.util.ArrayList;

public class AccountsFile {
	private ArrayList<Account> accounts;
	
	// Constructing Accounts File and Reading Current Values Stored
	public AccountsFile(String fileName) throws IOException {
		fileName = "accounts.csv";
		accounts = new ArrayList<Account>();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line = in.readLine();
		while(line != null) {
			String[] accountValues = line.split(",");
			accounts.add(new Account(accountValues[0],accountValues[1], accountValues[2], accountValues[3]));
			line = in.readLine(); }
		in.close();
		}
	
	
	public void writeOut() throws IOException {
		FileWriter accounts_csv = new FileWriter("accounts.csv");
		PrintWriter out = new PrintWriter(accounts_csv);
		
		for (Account account : accounts) {
			out.printf("%s,%s,%s,%s \n", account.getId(), account.getAccountname(), account.getUsername(), account.getPassword());
		}
		out.close();
	}
	
	public void addAccount(Account accountToAdd) throws IOException{
		accounts.add(accountToAdd);
		writeOut();
	}
	public void removeAccount(String guid) {
		int index = 0;
		for (Account n : accounts ) {
			if (guid.equals(n.getId())) {
				accounts.remove(index);
				break;
			}		
			index ++;
		}
	}
	
	public  ArrayList<Account> getAccounts(){
		return accounts;
	}
	
	
	
	

	

	
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		AccountsFile file = new AccountsFile("accounts.csv");
		Account A = new Account("Gmail", "UsernameABCD123", "Password123");
		file.addAccount(A);
		//File created and read

		 
		 
		
		



		
	
	
		
			
		
	}
}