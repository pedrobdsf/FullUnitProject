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
public class EnvironmentView {

	private static EnvironmentView instance = null;

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
	private Button stats1;
	@FXML
	private Button stats2;
	@FXML
	private Button stats3;
	@FXML
	private Button stats4;
	@FXML
	private Button stats5;
	@FXML
	private Button stats6;
	@FXML
	private Button stats7;
	@FXML
	private Button stats8;
	@FXML
	private Button stats9;
	@FXML
	private Button stats10;
	@FXML
	private TextField gamesField;
	@FXML
	private Button playButton;
	@FXML
	private TextField totalUtilityField;

	@FXML
	public void initialize() {
		instance = this;
		agentSelect1.getItems().removeAll(agentSelect1.getItems());
		agentSelect1.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect1.getSelectionModel().select("");
		agentSelect2.getItems().removeAll(agentSelect2.getItems());
		agentSelect2.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect2.getSelectionModel().select("");
		agentSelect3.getItems().removeAll(agentSelect3.getItems());
		agentSelect3.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect3.getSelectionModel().select("");
		agentSelect4.getItems().removeAll(agentSelect4.getItems());
		agentSelect4.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect4.getSelectionModel().select("");
		agentSelect5.getItems().removeAll(agentSelect5.getItems());
		agentSelect5.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect5.getSelectionModel().select("");
		agentSelect6.getItems().removeAll(agentSelect6.getItems());
		agentSelect6.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect6.getSelectionModel().select("");
		agentSelect7.getItems().removeAll(agentSelect7.getItems());
		agentSelect7.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect7.getSelectionModel().select("");
		agentSelect8.getItems().removeAll(agentSelect8.getItems());
		agentSelect8.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect8.getSelectionModel().select("");
		agentSelect9.getItems().removeAll(agentSelect9.getItems());
		agentSelect9.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect9.getSelectionModel().select("");
		agentSelect10.getItems().removeAll(agentSelect10.getItems());
		agentSelect10.getItems().addAll("", "Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect10.getSelectionModel().select("");
	}

	public void addHandlers(EventHandler<ActionEvent> controller) {
		playButton.setOnAction(controller);
		stats1.setOnAction(controller);
		stats2.setOnAction(controller);
		stats3.setOnAction(controller);
		stats4.setOnAction(controller);
		stats5.setOnAction(controller);
		stats6.setOnAction(controller);
		stats7.setOnAction(controller);
		stats8.setOnAction(controller);
		stats9.setOnAction(controller);
		stats10.setOnAction(controller);
	}

	public String[] getAgentSelectList() {
		return new String[] { agentSelect1.getValue(), agentSelect2.getValue(), agentSelect3.getValue(),
				agentSelect4.getValue(), agentSelect5.getValue(), agentSelect6.getValue(), agentSelect7.getValue(),
				agentSelect8.getValue(), agentSelect9.getValue(), agentSelect10.getValue() };
	}

	public String[] getResultsList() {
		return new String[] { resultField1.getText(), resultField2.getText(), resultField3.getText(),
				resultField4.getText(), resultField5.getText(), resultField6.getText(), resultField7.getText(),
				resultField8.getText(), resultField9.getText(), resultField10.getText() };
	}

	public void setResultField(String result, int num) {
		TextField[] fields = new TextField[] { resultField1, resultField2, resultField3, resultField4, resultField5,
				resultField6, resultField7, resultField8, resultField9, resultField10 };
		fields[num].setText(result);
	}

	public void clearResultField() {
		TextField[] fields = new TextField[] { resultField1, resultField2, resultField3, resultField4, resultField5,
				resultField6, resultField7, resultField8, resultField9, resultField10 };
		for (TextField field : fields) {
			field.setText("");
		}
	}

	public void setTotalUtility() {
		int value = 0;
		for (String text : getResultsList()) {
			if (!text.equals("")) {
				value += Integer.valueOf(text);
			}
		}
		totalUtilityField.setText(String.valueOf(value));
	}

	public int getNumberOfRounds() {
		return Integer.parseInt(roundsField.getText());
	}

	public int getNumberOfGames() {
		return Integer.parseInt(gamesField.getText());
	}

	public Button getPlayButton() {
		return playButton;
	}

	public Button[] getStatsButtons() {
		return new Button[] { stats1, stats2, stats3, stats4, stats5, stats6, stats7, stats8, stats9, stats10 };
	}

	public static EnvironmentView getInstance() {
		return instance;
	}

}
