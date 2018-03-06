/**
 * 
 */
package environment;

import java.util.Observable;
import java.util.Observer;

import driver.Loader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import statistics.StatisticsController;
import view.EnvironmentView;
import view.StatisticsView;

/**
 * @author Pedro Freire
 *
 */
public class EnvironmentController implements Observer, EventHandler<ActionEvent> {

	private Loader loader = new Loader();
	private EnvironmentView view;
	private EnvironmentManager manager;

	public EnvironmentController(EnvironmentManager manager, EnvironmentView view) {
		this.manager = manager;
		this.view = view;
		view.addHandlers(this);
		manager.addObserver(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getPlayButton()) {
			view.clearResultField();
			manager.runGame(view.getAgentSelectList(), view.getNumberOfRounds(), view.getNumberOfGames());
			for (int index = 0; index < manager.getAgentList().size(); index++) {
				if (manager.getAgentList().get(index) != null) {
					view.setResultField(String.valueOf(manager.getAgentList().get(index).getTotalUtility()), index);
				}
			}
			view.setTotalUtility();
		}
		for (int index = 0; index < view.getStatsButtons().length; index++) {
			if (event.getSource() == view.getStatsButtons()[index]) {
				try {
						Stage stage = loader.newDisplay("Statistics");
						new StatisticsController(StatisticsView.getInstance(), stage, manager.getAgentList().get(index));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
