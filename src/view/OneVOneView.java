/**
 * 
 */
package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class OneVOneView extends Application {

	private static OneVOneView instance = null;
	
	@FXML
	private ChoiceBox<String> agentSelect1;
	@FXML
	private ChoiceBox<String> agentSelect2;
	@FXML
	private TextField roundsField;
	@FXML
	private Button playButton;
	@FXML
	private TextField resultField1;
	@FXML
	private TextField resultField2;

	@FXML
	public void initialize() {
		agentSelect1.getItems().removeAll(agentSelect1.getItems());
		agentSelect1.getItems().addAll("Always Defect", "Always Cooperate");
		agentSelect1.getSelectionModel().select("Always Defect");
		agentSelect2.getItems().removeAll(agentSelect1.getItems());
		agentSelect2.getItems().addAll("Always Defect", "Always Cooperate");
		agentSelect2.getSelectionModel().select("Always Defect");
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/OneVOneFXML.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Cooperative Strategies in Multi-Agent Systems");
		stage.setScene(scene);
		stage.show();
	}

	public void addHandlers(EventHandler<ActionEvent> controller) {
		playButton.setOnAction(controller);
	}

	public ChoiceBox<String> getAgentSelect1() {
		return agentSelect1;
	}

	public ChoiceBox<String> getAgentSelect2() {
		return agentSelect2;
	}

	public TextField getRoundsField() {
		return roundsField;
	}

	public Button getPlayButton() {
		return playButton;
	}

	public void setResultField1(String result) {
		resultField1.setText(result);
		;
	}

	public void setResultField2(String result) {
		resultField2.setText(result);
		;
	}

	public static OneVOneView getInstance() {
		return instance;
	}

}
