package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainScreenController implements Initializable {
	
 

    @FXML
    private TableView<Account> table;
    
    @FXML
    private TableColumn<Account,String> id;

    @FXML
    private TableColumn<Account,String> account;

    @FXML
    private TableColumn<Account,String> username;
    
    @FXML
    private TableColumn<Account,String> password;
    
    @FXML
    private TextField idField;
    
    @FXML
    private TextField usernameInput;
    
    @FXML
    private TextField accountInput;
    
    @FXML
    private TextField passwordInput;
    
    @FXML
    private Slider lengthSlider;
    
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	try {
    		if(getCurrentAccounts().size() > 0){
    			id.setCellValueFactory(new PropertyValueFactory<>("id"));
				account.setCellValueFactory(new PropertyValueFactory<>("accountname"));
				username.setCellValueFactory(new PropertyValueFactory<>("username"));
				password.setCellValueFactory(new PropertyValueFactory<>("password"));					
				table.setItems(getCurrentAccounts());		
    		}	
		} catch (IOException e) {
				e.printStackTrace();
		}	
    }

    public ObservableList<Account> getCurrentAccounts() throws IOException{
        AccountsFile file = new AccountsFile("accounts.csv");
    	ObservableList<Account> accounts = FXCollections.observableArrayList(file.getAccounts());
    	return accounts;  	    	
    }
  
    @FXML 
    public void randomPassword(ActionEvent event){
    	int length = (int) lengthSlider.getValue();
    	String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789!@#$%^&*()+-?";
		String password = "";
		for (int i = 1; i <= length; i++) {
			int random = (int) (Math.random()*chars.length());			
			password += chars.charAt(random);
		}	
		
		passwordInput.setText(password);
				
    }
   
    
    @FXML
    public void addNewAccount(ActionEvent event) throws IOException {
    	AccountsFile file = new AccountsFile("accounts.csv");
    	String account = accountInput.getText();
    	String user = usernameInput.getText();
    	String password = passwordInput.getText();
    	
    	
    	
    	Account newAccount = new Account(account,user,password); 
    	file.addAccount(newAccount);
    	
		table.setItems(getCurrentAccounts());		    	
    }
}
