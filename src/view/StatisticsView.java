/**
 * 
 */
package view;

import java.util.Map;

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
	private Button prevButton;
	@FXML
	private Button nextButton;
	@FXML
	private Button exitButton;

	@FXML
	public void initialize() {
		instance = this;
		//initGamesPlayedChart();
		//initUtilityGainedChart();
	}

	private void initGamesPlayedChart(Map<String, Integer> map) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Grapefruit", 13),
				new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22),
				new PieChart.Data("Apples", 30));
		gamesPlayed.getData().addAll(pieChartData);
	}

	private void initUtilityGainedChart() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Grapefruit", 13),
				new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22),
				new PieChart.Data("Apples", 30));
		utilityGained.getData().addAll(pieChartData);
	}

	public void addHandlers(EventHandler<ActionEvent> controller) {
		prevButton.setOnAction(controller);
		nextButton.setOnAction(controller);
		exitButton.setOnAction(controller);
	}

	public Button getNextButton() {
		return nextButton;
	}

	public Button getPrevButton() {
		return prevButton;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public static StatisticsView getInstance() {
		return instance;
	}

}
