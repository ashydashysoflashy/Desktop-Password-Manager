package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller for main password manager interface (post login)
 * 
 * @author youssef.abdelrhafour
 * @author achraf.abdelrhafour
 *
 */
public class MainScreenController implements Initializable {

	@FXML
	private Label mainErrorLabel;

	@FXML
	private TableView<Account> table;

	@FXML
	private TableColumn<Account, String> id;

	@FXML
	private TableColumn<Account, String> account;

	@FXML
	private TableColumn<Account, String> username;

	@FXML
	private TableColumn<Account, String> password;

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

	/*
	 * This initializes our scene when first changing it. Sets the values in table
	 * equal to whatever currently stored in the 'accounts.csv' file.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			if (getCurrentAccounts().size() >= 0) {
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

	/**
	 * This method returns an ObservableArrayList of the current accounts in the
	 * 'accounts.csv' file.
	 * 
	 * @return ObservableArrayList of type Account
	 * @throws IOException
	 */
	public ObservableList<Account> getCurrentAccounts() throws IOException {
		AccountsFile file = new AccountsFile("accounts.csv");
		ObservableList<Account> accounts = FXCollections.observableArrayList(file.getAccounts());
		return accounts;
	}

	/**
	 * Generates random password, when user clicks the random password button
	 * 
	 * @param event ActionEvent for random password generation
	 */
	@FXML
	public void randomPassword(ActionEvent event) {
		int length = (int) lengthSlider.getValue();
		String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789!@#$%^&*()+-?";
		String password = "";
		for (int i = 1; i <= length; i++) {
			int random = (int) (Math.random() * chars.length());
			password += chars.charAt(random);
		}
		passwordInput.setText(password);
	}

	/**
	 * Edits an account in the 'accounts.csv' file, then displays the changes
	 * 
	 * @param event ActionEvent for editing accounts in file
	 * @throws IOException
	 */
	@FXML
	public void editAccount(ActionEvent event) throws IOException {
		AccountsFile file = new AccountsFile("accounts.csv");
		ObservableList<Account> allAccounts, singleAccount;
		allAccounts = table.getItems();
		singleAccount = table.getSelectionModel().getSelectedItems();
		accountInput.setText(singleAccount.get(0).getAccountname().strip());
		usernameInput.setText(singleAccount.get(0).getUsername().strip());
		passwordInput.setText(singleAccount.get(0).getPassword().strip());
		for (Account n : allAccounts) {
			if (singleAccount.get(0).equals(n)) {
				file.removeAccount(n.getId());
			}
		}
		table.setItems(getCurrentAccounts());
	}

	/**
	 * Removes an account in the 'accounts.csv' file, then displays the changes
	 * 
	 * @param event ActionEvent for deleting an account
	 * @throws IOException
	 */
	@FXML
	public void removeAccount(ActionEvent event) throws IOException {
		AccountsFile file = new AccountsFile("accounts.csv");
		ObservableList<Account> allAccounts, singleAccount;
		allAccounts = table.getItems();
		singleAccount = table.getSelectionModel().getSelectedItems();
		for (Account n : allAccounts) {
			if (singleAccount.get(0).equals(n)) {
				file.removeAccount(n.getId());
			}
		}
		table.setItems(getCurrentAccounts());
	}

	/**
	 * Adds a new account in the 'accounts.csv' file, then displays the changes
	 * 
	 * @param event ActionEvent for adding a new account
	 * @throws IOException
	 */
	@FXML
	public void addNewAccount(ActionEvent event) throws IOException {
		AccountsFile file = new AccountsFile("accounts.csv");
		String account = accountInput.getText();
		String user = usernameInput.getText();
		String password = passwordInput.getText();
		boolean emptyInput = (account == "" || user == "" || password == "");
		boolean passwordSpace = password.contains(" ");
		if (emptyInput) {
			mainErrorLabel.setText("Please fill all fields with an input.");
		} else if (passwordSpace) {
			mainErrorLabel.setText("Do not include any whitespace characters in password.");
		} else {
			Account newAccount = new Account(account, user, password);
			file.addAccount(newAccount);
			table.setItems(getCurrentAccounts());
			accountInput.clear();
			usernameInput.clear();
			passwordInput.clear();
		}
	}

}
