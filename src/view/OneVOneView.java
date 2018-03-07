/**
 * 
 */
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * @author Pedro Freire
 *
 */
public class OneVOneView {

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
		instance = this;
		agentSelect1.getItems().removeAll(agentSelect1.getItems());
		agentSelect1.getItems().addAll("Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov", "Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect1.getSelectionModel().select("Adaptive");
		agentSelect2.getItems().removeAll(agentSelect1.getItems());
		agentSelect2.getItems().addAll("Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov", "Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect2.getSelectionModel().select("Adaptive");
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
	}

	public void setResultField2(String result) {
		resultField2.setText(result);
	}

	public static OneVOneView getInstance() {
		return instance;
	}

}
