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
public class EnvironmentView {

	private static EnvironmentView instance = null;

	@FXML
	private ChoiceBox<String> agentSelect;
	@FXML
	private TextField roundsField;
	@FXML
	private TextField gamesField;
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
	private Button clearButton;
	@FXML
	private Button backButton;
	@FXML
	private VBox agentsBoxListBox;
	@FXML
	private TextField totalAgentsField;
	@FXML
	private TextField totalUtilityField;

	private List<HBox> agentsBoxList;
	private List<String> agentsList;
	private List<Label> idList;
	private List<TextField> resultsList;
	private List<Button> statsList;
	private List<Button> deleteList;

	/**
	 * Initialises the view, the choice box of agents and the list of agents and
	 * its components.
	 */
	@FXML
	public void initialize() {
		instance = this;
		agentSelect.getItems().removeAll(agentSelect.getItems());
		agentSelect.getItems().addAll("Adaptive", "Always Defect", "Always Cooperate", "Gradual", "Grudger", "Pavlov",
				"Random", "Soft Grudger", "Tit For Tat", "Tit For Two Tats");
		agentSelect.getSelectionModel().select("Adaptive");
		agentsBoxList = new ArrayList<>();
		agentsList = new ArrayList<>();
		idList = new ArrayList<>();
		resultsList = new ArrayList<>();
		statsList = new ArrayList<>();
		deleteList = new ArrayList<>();
	}

	/**
	 * Adds listeners to the controller.
	 * 
	 * @param controller
	 *          - the controller of the environment
	 */
	public void addHandlers(EventHandler<ActionEvent> controller) {
		playButton.setOnAction(controller);
		plusButton.setOnAction(controller);
		minusButton.setOnAction(controller);
		addButton.setOnAction(controller);
		clearButton.setOnAction(controller);
		backButton.setOnAction(controller);
	}

	/**
	 * Adds an agent with the specified strategy to the list of agents
	 * 
	 * @param strat
	 *          - name of the strategy
	 */
	public void addAgentToList(String strat) {
		int id = agentsBoxList.size() + 1;
		agentsBoxList.add(addAgent(String.valueOf(id), strat));
		agentsBoxListBox.getChildren().add(agentsBoxList.get(id - 1));
	}

	/**
	 * Creates an agent and all of its components so it can be added to the list
	 * in the GUI.
	 * 
	 * @param id
	 *          - the id of the agent
	 * @param strat
	 *          - the strategy of the agent
	 * @return HBox with all of the agent components
	 */
	private HBox addAgent(String id, String strat) {
		HBox agent = new HBox();
		Label idLb = new Label(id);
		idLb.setPrefSize(150, 35);
		idLb.setPadding(new Insets(0, 0, 0, 70));
		idLb.setFont(new Font(24));
		Label stratLb = new Label(strat);
		stratLb.setPrefSize(550, 35);
		stratLb.setPadding(new Insets(0, 0, 0, 170));
		stratLb.setFont(new Font(24));
		TextField utilityTf = new TextField();
		utilityTf.setPrefSize(280, 35);
		utilityTf.setPadding(new Insets(0, 0, 0, 30));
		utilityTf.setFont(new Font(24));
		Button statsBt = new Button("STATS");
		statsBt.setPrefSize(150, 35);
		statsBt.setFont(new Font(15));
		Button deleteBt = new Button("X");
		deleteBt.setPrefSize(50, 35);
		deleteBt.setFont(new Font(15));
		if (Integer.valueOf(id) % 2 == 0) {
			agent.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		} else {
			agent.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
		}
		agent.getChildren().addAll(idLb, stratLb, utilityTf, statsBt, deleteBt);
		agentsList.add(strat);
		idList.add(idLb);
		resultsList.add(utilityTf);
		statsList.add(statsBt);
		deleteList.add(deleteBt);
		return agent;
	}

	/**
	 * Adds listeners for the statistics/delete buttons to the controller.
	 * 
	 * @param controller
	 *          - the controller of the environment
	 */
	public void addButtonHandler(EventHandler<ActionEvent> controller) {
		int index = agentsList.size() - 1;
		statsList.get(index).setOnAction(controller);
		deleteList.get(index).setOnAction(controller);
	}

	/**
	 * @return the name the strategy in the choice box
	 */
	public String getAgentSelect() {
		return agentSelect.getValue();
	}

	/**
	 * @return the list of agents
	 */
	public List<String> getAgentsList() {
		return agentsList;
	}

	/**
	 * @return the list of results
	 */
	public List<String> getResultsList() {
		List<String> list = new ArrayList<>();
		for (TextField tf : resultsList) {
			list.add(tf.getText());
		}
		return list;
	}

	/**
	 * @param result
	 *          - the result for a specific agent
	 * @param index
	 *          - the index of the agent on the list
	 */
	public void setResultField(String result, int index) {
		resultsList.get(index).setText(result);
	}

	/**
	 * @return the list of statistics buttons
	 */
	public List<Button> getStatsList() {
		return statsList;
	}

	/**
	 * @return the list of delete buttons
	 */
	public List<Button> getDeleteList() {
		return deleteList;
	}

	/**
	 * @param index
	 *          - index of the agent on the list
	 * @throws Exception
	 */
	public void deleteAgent(int index) throws Exception {
		agentsBoxListBox.getChildren().remove(index);
		agentsBoxList.remove(index);
		agentsList.remove(index);
		idList.remove(index);
		resultsList.remove(index);
		statsList.remove(index);
		deleteList.remove(index);
		for (int idx = 0; idx < agentsList.size(); idx++) {
			if (idx >= index) {
				int temp = Integer.valueOf(idList.get(idx).getText());
				idList.get(idx).setText(String.valueOf(temp - 1));
				if ((idx + 1) % 2 == 0) {
					agentsBoxList.get(idx).setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				} else {
					agentsBoxList.get(idx).setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
				}
			}
		}
	}

	/**
	 * Clears the list agents and its components.
	 */
	public void clearAgentList() {
		agentsBoxListBox.getChildren().clear();
		agentsBoxList.clear();
		agentsList.clear();
		idList.clear();
		resultsList.clear();
		statsList.clear();
		deleteList.clear();
	}

	/**
	 * Clears all the results.
	 */
	public void clearResultField() {
		if (resultsList.size() > 0) {
			for (TextField tf : resultsList) {
				tf.setText("");
			}
		}
	}

	/**
	 * Evaluates the number of agents on the list and sets it to a text field.
	 */
	public void setTotalAgents() {
		totalAgentsField.setText(String.valueOf(agentsList.size()));
	}

	/**
	 * Evaluates the amount of utility gained over all agents and sets it to a
	 * text field.
	 */
	public void setTotalUtility() {
		int value = 0;
		for (String text : getResultsList()) {
			if (!text.equals("")) {
				value += Integer.valueOf(text);
			}
		}
		totalUtilityField.setText(String.valueOf(value));
	}

	/**
	 * @return the text field for number of rounds
	 */
	public TextField getRoundsField() {
		return roundsField;
	}

	/**
	 * @return the text field for number of games
	 */
	public TextField getGamesField() {
		return gamesField;
	}

	/**
	 * @return the text field for number of agents to add to list
	 */
	public TextField getAddField() {
		return addField;
	}

	/**
	 * Increments the value in the add agent text field.
	 */
	public void incAddField() {
		int temp = Integer.valueOf(addField.getText());
		temp++;
		addField.setText(String.valueOf(temp));
	}

	/**
	 * Decrements the value in the add agent text field.
	 */
	public void decAddField() {
		int temp = Integer.valueOf(addField.getText());
		if (temp > 1) {
			temp--;
			addField.setText(String.valueOf(temp));
		}
	}

	/**
	 * @return the play button
	 */
	public Button getPlayButton() {
		return playButton;
	}

	/**
	 * @return the plus button
	 */
	public Button getPlusButton() {
		return plusButton;
	}

	/**
	 * @return the minus button
	 */
	public Button getMinusButton() {
		return minusButton;
	}

	/**
	 * @return the add button
	 */
	public Button getAddButton() {
		return addButton;
	}

	/**
	 * @return the clear all button
	 */
	public Button getClearButton() {
		return clearButton;
	}

	/**
	 * @return the back button
	 */
	public Button getBackButton() {
		return backButton;
	}

	/**
	 * @return an instance of this class
	 */
	public static EnvironmentView getInstance() {
		return instance;
	}

}
