/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Pedro Freire
 *
 */
public class TournamentView {

	private static TournamentView instance = null;

	@FXML
	private ChoiceBox<String> agentSelect;
	@FXML
	private TextField roundsField;
	@FXML
	private Button playButton;
	@FXML
	private Button plusButton;
	@FXML
	private TextField addField;
	@FXML
	private Button minusButton;
	@FXML
	private Button addButton;
	@FXML
	private Button backButton;
	@FXML
	private VBox agentsListBox;
	@FXML
	private TextField totalAgentsField;
	@FXML
	private TextField totalUtilityField;

	private List<HBox> agentsList;
	private List<TextField> resultsList;
	private List<Button> statsList;

	@FXML
	public void initialize() {
		instance = this;
		agentSelect.getItems().removeAll(agentSelect.getItems());
		agentSelect.getItems().addAll("Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect.getSelectionModel().select("Adaptive");
		resultsList = new ArrayList<>();
		agentsList = new ArrayList<>();
		statsList = new ArrayList<>();
	}

	public void addHandlers(EventHandler<ActionEvent> controller) {
		playButton.setOnAction(controller);
		plusButton.setOnAction(controller);
		minusButton.setOnAction(controller);
		addButton.setOnAction(controller);
		backButton.setOnAction(controller);
	}

	public void addAgentToList(String strat) {
		int id = agentsList.size() + 1;
		agentsList.add(addAgent(String.valueOf(id), strat));
		agentsListBox.getChildren().add(agentsList.get(id - 1));
	}

	public HBox addAgent(String id, String strat) {
		HBox agent = new HBox();
		Label idLb = new Label(id);
		idLb.setPrefSize(150, 35);
		idLb.setPadding(new Insets(0, 0, 0, 70));
		idLb.setFont(new Font(24));;
		Label stratLb = new Label(strat);
		stratLb.setPrefSize(550, 35);
		stratLb.setPadding(new Insets(0, 0, 0, 170));
		stratLb.setFont(new Font(24));;
		TextField utilityTf = new TextField();
		utilityTf.setPrefSize(280, 35);
		utilityTf.setPadding(new Insets(0, 0, 0, 270));
		utilityTf.setFont(new Font(24));;
		Button statsBt = new Button("STATS");
		statsBt.setPrefSize(150, 35);
		statsBt.setFont(new Font(15));;
		if (Integer.valueOf(id)%2 == 0) {
			agent.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		} else {
			agent.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
		}
		agent.getChildren().addAll(idLb, stratLb, utilityTf, statsBt);
		return agent;
	}

	public String getAgentSelect() {
		return agentSelect.getValue();
	}

	public List<String> getAgentSelectList() {
		List<String> list = new ArrayList<>();
		/*
		 * for (Label tf : agentsList) { list.add(tf.getText()); }
		 */
		return list;
	}

	public List<String> getResultsList() {
		List<String> list = new ArrayList<>();
		for (TextField tf : resultsList) {
			list.add(tf.getText());
		}
		return list;
	}

	public void setResultField(String result, int index) {
		resultsList.get(index).setText(result);
	}

	public void clearResultField() {
		if (resultsList.size() > 0) {
			for (TextField tf : resultsList) {
				tf.setText("");
			}
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

	public TextField getRoundsField() {
		return roundsField;
	}

	public TextField getAddField() {
		return addField;
	}

	public void incAddField() {
		int temp = Integer.valueOf(addField.getText());
		temp++;
		addField.setText(String.valueOf(temp));
	}

	public void decAddField() {
		int temp = Integer.valueOf(addField.getText());
		if (temp > 1) {
			temp--;
			addField.setText(String.valueOf(temp));
		}
	}

	public Button getPlayButton() {
		return playButton;
	}

	public Button getPlusButton() {
		return plusButton;
	}

	public Button getMinusButton() {
		return minusButton;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getBackButton() {
		return backButton;
	}

	public static TournamentView getInstance() {
		return instance;
	}

}
