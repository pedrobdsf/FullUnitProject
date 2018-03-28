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
	private Button backButton;
	@FXML
	private TextField resultField1;
	@FXML
	private TextField resultField2;

	/**
	 * Initialises the view and the agent choice boxes.
	 */
	@FXML
	public void initialize() {
		instance = this;
		agentSelect1.getItems().removeAll(agentSelect1.getItems());
		agentSelect1.getItems().addAll("Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect1.getSelectionModel().select("Adaptive");
		agentSelect2.getItems().removeAll(agentSelect1.getItems());
		agentSelect2.getItems().addAll("Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect2.getSelectionModel().select("Adaptive");
	}

	/**
	 * Adds listeners to the controller.
	 * 
	 * @param controller
	 *          - the controller of the one v one
	 */
	public void addHandlers(EventHandler<ActionEvent> controller) {
		playButton.setOnAction(controller);
		backButton.setOnAction(controller);
	}

	/**
	 * @return the choice box for agent 1
	 */
	public ChoiceBox<String> getAgentSelect1() {
		return agentSelect1;
	}

	/**
	 * @return the choice box for agent 2
	 */
	public ChoiceBox<String> getAgentSelect2() {
		return agentSelect2;
	}

	/**
	 * @return the text field for number of rounds
	 */
	public TextField getRoundsField() {
		return roundsField;
	}

	/**
	 * @return the play button
	 */
	public Button getPlayButton() {
		return playButton;
	}

	/**
	 * @return the back button
	 */
	public Button getBackButton() {
		return backButton;
	}

	/**
	 * @param result
	 *          - the text field for result 1
	 */
	public void setResultField1(String result) {
		resultField1.setText(result);
	}

	/**
	 * @param result
	 *          - the text field for result 2
	 */
	public void setResultField2(String result) {
		resultField2.setText(result);
	}

	/**
	 * @return an instance of this class
	 */
	public static OneVOneView getInstance() {
		return instance;
	}

}
