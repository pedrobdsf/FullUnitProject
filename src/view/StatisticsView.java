/**
 * 
 */
package view;

import java.util.Map;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Pedro Freire
 *
 */
public class StatisticsView {

	private static StatisticsView instance = null;

	@FXML
	private PieChart gamesPlayed;
	@FXML
	private PieChart utilityGained;
	@FXML
	private Label agentNumber;
	@FXML
	private Label totalGames;
	@FXML
	private Label totalUtility;
	@FXML
	private Button exitButton;

	/**
	 * Initialises the view.
	 */
	@FXML
	public void initialize() {
		instance = this;
	}

	/**
	 * Initialises pie chart of games played.
	 * 
	 * @param map
	 *          - the map filled with statistics of games played
	 */
	public void initGamesPlayedChart(Map<String, Integer> map) {
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		Integer totalGames = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			data.add(new PieChart.Data("Agent " + entry.getKey().toString(), entry.getValue()));
			totalGames += entry.getValue();
		}
		gamesPlayed.getData().addAll(data);
		this.totalGames.setText(totalGames.toString());
	}

	/**
	 * Initialises pie chart of utility gain.
	 * 
	 * @param map
	 *          - the map filled with statistics of utility gain
	 */
	public void initUtilityGainedChart(Map<String, Integer> map) {
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		Integer totalUtility = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			data.add(new PieChart.Data("Agent " + entry.getKey().toString(), entry.getValue()));
			totalUtility += entry.getValue();
		}
		utilityGained.getData().addAll(data);
		this.totalUtility.setText(totalUtility.toString());
	}

	/**
	 * Adds listeners to the controller.
	 * 
	 * @param controller
	 *          - the controller of the statistics
	 */
	public void addHandlers(EventHandler<ActionEvent> controller) {
		exitButton.setOnAction(controller);
	}

	/**
	 * @param agentNumber
	 *          - the ID of the agent
	 */
	public void setAgentNumber(Integer agentNumber) {
		this.agentNumber.setText(agentNumber.toString());
	}

	/**
	 * @return the exit button
	 */
	public Button getExitButton() {
		return exitButton;
	}

	/**
	 * @return an instance of this class
	 */
	public static StatisticsView getInstance() {
		return instance;
	}

}
