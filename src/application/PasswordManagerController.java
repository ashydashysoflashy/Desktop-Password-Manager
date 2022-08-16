package application;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PasswordManagerController {
	Stage applicationStage;



	@FXML
	private PasswordField passwordEntered;

	@FXML
	private TextField usernameEntered;
	
	@FXML
	private Label errorLabel;

	@FXML
	private TableView<?> table;

	@FXML
	private TableColumn<?, ?> password;

	@FXML
	private TableColumn<?, ?> account;

	@FXML
	private TableColumn<?, ?> username;


//

// Gets current Accounts
public ObservableList<Account> getCurrentAccounts() throws IOException {
	AccountsFile currentAccounts = new AccountsFile();
	ObservableList<Account> accounts = FXCollections.observableArrayList(currentAccounts.getAccounts());
	
	return accounts;
}

// Successful login
@FXML
void switchMainScene(ActionEvent event) throws IOException {
	errorLabel.setText("");
	String usernameInput = usernameEntered.getText();
	String passwordInput = passwordEntered.getText();
	
	
	if (usernameInput.equals("FinalProject") && passwordInput.equals("CPSC233")) {
		Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		Scene mainScene = new Scene(root);
		applicationStage.setScene(mainScene);
	}
	else errorLabel.setText("Wrong login info, please try again.");
	
	
	}
}