package application;

public class Account {
	private String id;
	private String accountname;
	private String username;
	private String password;
	
	public Account(String accountname, String username, String password){
		this.id= java.util.UUID.randomUUID().toString();
		this.accountname = new String(accountname);
		this.username = new String(username);
		this.password = new String(password);		
	}
	
	public Account(String id, String accountname, String username, String password){
		this.id= new String(id);
		this.accountname = new String(accountname);
		this.username = new String(username);
		this.password = new String(password);		
	}
	
	
	public String getAccountname() {
		return new String(accountname);
	}	
	public void setAccountname(String accountname) {
		this.accountname = new String(accountname);
	}
	
	public String getUsername() {
		return new String(username);
	}	
	public void setUsername(String username) {
		this.username =  new String(username);
	}
	
	public String getPassword() {
		return new String(password);
	}
	public void setPassword(String password) {
		this.password = new String(password);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	

}
