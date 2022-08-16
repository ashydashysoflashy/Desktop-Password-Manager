package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for Login Scene.
 * 
 * @author youssef.abdelrhafour
 * @author achraf.abdelrhafour
 *
 */
public class LoginScreenController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private PasswordField passwordEntered;

	@FXML
	private TextField usernameEntered;

	@FXML
	private Label errorLabel;

	/**
	 * Defines a login event, changes scene to our main UI (MainScreen.fxml)
	 * Validates username and password inputs (Username: FinalProject , Password:
	 * CPSC233)
	 * 
	 * @param event ActionEvent for login attempt
	 * @throws IOException
	 */
	@FXML
	public void login(ActionEvent event) throws IOException {
		String correctUsername = "FinalProject";
		String correctPassword = "CPSC233";

		if (usernameEntered.getText().equals(correctUsername) && passwordEntered.getText().equals(correctPassword)) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
			root = loader.load();
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			errorLabel.setText("Wrong login credentials, try again.");
		}

	}
}