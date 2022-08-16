package application;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
	

// Successful login
@FXML
public void login(ActionEvent event) throws IOException {
	 
	 
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
	 root = loader.load();
	 
	 stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	 scene = new Scene(root);
	 stage.setScene(scene); 
	 stage.show();
	
	}
}