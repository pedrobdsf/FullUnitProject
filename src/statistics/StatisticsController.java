/**
 * 
 */
package statistics;

import agent.Agent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.StatisticsView;

/**
 * @author Pedro Freire
 *
 */
public class StatisticsController implements EventHandler<ActionEvent> {

	private StatisticsView view;
	private StatisticsManager manager = new StatisticsManager();
	private Stage stage;

	public StatisticsController(StatisticsView view, Stage stage, Agent agent) {
		this.view = view;
		this.stage = stage;
		view.addHandlers(this);
		manager.translateAgentStats(agent);
		view.setAgentNumber(agent.getId());
		view.initGamesPlayedChart(manager.getGamesPlayed());
		view.initUtilityGainedChart(manager.getUtilityGained());
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getExitButton()) {
			stage.close();
		}
	}

}
