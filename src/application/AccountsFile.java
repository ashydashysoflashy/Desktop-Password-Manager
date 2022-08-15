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
			accounts.add(new Account(accountValues[0],accountValues[1], accountValues[2], accountValues[3]));
			line = in.readLine(); }
		in.close();
	}
	
	public void writeFile() throws IOException {
		FileWriter accounts_csv = new FileWriter("accounts.csv");
		PrintWriter out = new PrintWriter(accounts_csv);
		
		for (Account account : accounts) {
			out.printf("%s,%s,%s,%s \n", account.getId(), account.getAccountname(), account.getUsername(), account.getPassword());
		}
		out.close();
	}
	
	public void addAccount(Account accountToAdd){
		accounts.add(accountToAdd);
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
	
	
	
	

	

	
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		 
		 AccountsFile file = new AccountsFile();
		 file.readFile();
		 
		 
		//Account toAdd =  new Account( "Google", "user123", "asdasd");
		//file.addAccount(toAdd);
		file.removeAccount("8a3d8e74-8196-4f44-ae1a-2789055a02af");

		 
		
		 file.writeFile();
	
	
		
			
		
	}
}