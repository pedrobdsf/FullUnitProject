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
public class TournementView {

	private static TournementView instance = null;

	@FXML
	private ChoiceBox<String> agentSelect1;
	@FXML
	private ChoiceBox<String> agentSelect2;
	@FXML
	private ChoiceBox<String> agentSelect3;
	@FXML
	private ChoiceBox<String> agentSelect4;
	@FXML
	private ChoiceBox<String> agentSelect5;
	@FXML
	private ChoiceBox<String> agentSelect6;
	@FXML
	private ChoiceBox<String> agentSelect7;
	@FXML
	private ChoiceBox<String> agentSelect8;
	@FXML
	private ChoiceBox<String> agentSelect9;
	@FXML
	private ChoiceBox<String> agentSelect10;
	@FXML
	private TextField resultField1;
	@FXML
	private TextField resultField2;
	@FXML
	private TextField resultField3;
	@FXML
	private TextField resultField4;
	@FXML
	private TextField resultField5;
	@FXML
	private TextField resultField6;
	@FXML
	private TextField resultField7;
	@FXML
	private TextField resultField8;
	@FXML
	private TextField resultField9;
	@FXML
	private TextField resultField10;
	@FXML
	private TextField roundsField;
	@FXML
	private Button playButton;

	@FXML
	public void initialize() {
		instance = this;
		agentSelect1.getItems().removeAll(agentSelect1.getItems());
		agentSelect1.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect1.getSelectionModel().select("");
		agentSelect2.getItems().removeAll(agentSelect2.getItems());
		agentSelect2.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect2.getSelectionModel().select("");
		agentSelect3.getItems().removeAll(agentSelect3.getItems());
		agentSelect3.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect3.getSelectionModel().select("");
		agentSelect4.getItems().removeAll(agentSelect4.getItems());
		agentSelect4.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect4.getSelectionModel().select("");
		agentSelect5.getItems().removeAll(agentSelect5.getItems());
		agentSelect5.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect5.getSelectionModel().select("");
		agentSelect6.getItems().removeAll(agentSelect6.getItems());
		agentSelect6.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect6.getSelectionModel().select("");
		agentSelect7.getItems().removeAll(agentSelect7.getItems());
		agentSelect7.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect7.getSelectionModel().select("");
		agentSelect8.getItems().removeAll(agentSelect8.getItems());
		agentSelect8.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect8.getSelectionModel().select("");
		agentSelect9.getItems().removeAll(agentSelect9.getItems());
		agentSelect9.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect9.getSelectionModel().select("");
		agentSelect10.getItems().removeAll(agentSelect10.getItems());
		agentSelect10.getItems().addAll("", "Always Defect", "Always Cooperate");
		agentSelect10.getSelectionModel().select("");
	}

	public void addHandlers(EventHandler<ActionEvent> controller) {
		playButton.setOnAction(controller);
	}

	public String[] getAgentSelectList() {
		return new String[] { agentSelect1.getValue(), agentSelect2.getValue(), agentSelect3.getValue(),
				agentSelect4.getValue(), agentSelect5.getValue(), agentSelect6.getValue(), agentSelect7.getValue(),
				agentSelect8.getValue(), agentSelect9.getValue(), agentSelect10.getValue() };
	}

	public void setResultField(String result, int num) {
		switch (num) {
		case 0:
			resultField1.setText(result);
			break;
		case 1:
			resultField2.setText(result);
			break;
		case 2:
			resultField3.setText(result);
			break;
		case 3:
			resultField4.setText(result);
			break;
		case 4:
			resultField5.setText(result);
			break;
		case 5:
			resultField6.setText(result);
			break;
		case 6:
			resultField7.setText(result);
			break;
		case 7:
			resultField8.setText(result);
			break;
		case 8:
			resultField9.setText(result);
			break;
		case 9:
			resultField10.setText(result);
			break;
		}
	}

	public void setResultField(String result) {
		resultField2.setText(result);
	}

	public TextField getRoundsField() {
		return roundsField;
	}

	public Button getPlayButton() {
		return playButton;
	}

	public static TournementView getInstance() {
		return instance;
	}

}
