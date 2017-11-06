/**
 * 
 */
package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Pedro Freire
 *
 */
public class OneVOneView extends Application{
	
	@FXML
	private ChoiceBox agentSelect1;
	@FXML
	private ChoiceBox agentSelect2;
	@FXML
	private TextField roundsField;
	@FXML
	private Button playButton;
	@FXML
	private TextField resultField1;
	@FXML
	private TextField resultField2;
	
	public void initialise() {
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/MenuFXML.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Cooperative Strategies in Multi-Agent Systems");
		stage.setScene(scene);
		stage.show();
	}
	
	public ChoiceBox getAgentSelect1() {
		return agentSelect1;
	}
	
	public ChoiceBox getAgentSelect2() {
		return agentSelect2;
	}
	
	public TextField getRoundsField() {
		return roundsField;
	}
	
	public Button getPlayButton() {
		return playButton;
	}
	
	public TextField getResultField1() {
		return resultField1;
	}
	
	public TextField getResultField2() {
		return resultField2;
	}

}
