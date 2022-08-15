package application;

import java.io.*;
import java.util.ArrayList;

public class AccountsFile {
	private String fileName ;
	private ArrayList<Account> accounts;
	
	//reads current passwords.csv file
	public AccountsFile() throws IOException {
		fileName = "accounts.csv";
		accounts = new ArrayList<Account>();
		
		}
	
	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line = in.readLine();
		while(line != null) {
			String[] accountValues = line.split(",");
			if (accountValues.length == 3)accounts.add(new Account(accountValues[0], accountValues[1], accountValues[2]));
			System.out.println(line);
			line = in.readLine(); }
		in.close();

	}
	public void writeFile() throws IOException {
		FileWriter accounts_csv = new FileWriter("accounts.csv");
		PrintWriter out = new PrintWriter(accounts_csv);
		
		for (Account account : accounts) {
			out.printf("%s,%s,%s \n", account.getAccountname(), account.getUsername(), account.getPassword());
		}
		out.close();
	}
	
	public void addAccount(Account accountToAdd){
		accounts.add(accountToAdd);
	}
	public void removeAccount(Account accountToRemove) {
		int index = accounts.indexOf(accountToRemove)+1;
		System.out.println(index);
		accounts.remove(index);
	}
	

	
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		 Account A = new Account("Google", "Achraf", "passwordABC");
		 Account B = new Account("Youtube", "Ashydashy", "1234567");
		 Account C = new Account("TikTok", "Flashy", "xcvbmn");

		 
		 AccountsFile file = new AccountsFile();
		 file.readFile();
		 file.addAccount(A);
		 file.addAccount(B);
		 file.addAccount(C);
		 file.writeFile();
	
	
		
		
		
		
	
		
		
	}
}