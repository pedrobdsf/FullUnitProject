/**
 * 
 */
package environment;

import driver.Loader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import statistics.StatisticsController;
import view.EnvironmentView;
import view.StatisticsView;

/**
 * The controller class of the Environment.
 * 
 * @author Pedro Freire
 *
 */
public class EnvironmentController implements EventHandler<ActionEvent> {

	private Loader loader = new Loader();
	private EnvironmentView view;
	private EnvironmentManager manager;

	/**
	 * @param manager - the model of the environment
	 * @param view - the view of the environment
	 */
	public EnvironmentController(EnvironmentManager manager, EnvironmentView view) {
		this.manager = manager;
		this.view = view;
		view.addHandlers(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getPlusButton()) {
			view.incAddField();
		}
		if (event.getSource() == view.getMinusButton()) {
			view.decAddField();
		}
		if (event.getSource() == view.getAddButton()) {
			for (int count = 0; count < Integer.valueOf(view.getAddField().getText()); count++) {
				view.addAgentToList(view.getAgentSelect());
				view.addButtonHandler(this);
			}
		}
		if (event.getSource() == view.getClearButton()) {
			view.clearAgentList();
		}
		if (event.getSource() == view.getPlayButton()) {
			view.clearResultField();
			manager.clearAgentList();
			manager.runGame(view.getAgentsList(), Integer.valueOf(view.getRoundsField().getText()),
					Integer.valueOf(view.getGamesField().getText()));
			for (int index = 0; index < manager.getAgentList().size(); index++) {
				if (manager.getAgentList().get(index) != null) {
					view.setResultField(String.valueOf(manager.getAgentList().get(index).getTotalUtility()), index);
				}
			}
			view.setTotalAgents();
			view.setTotalUtility();
		}
		if (event.getSource() == view.getBackButton()) {
			try {
				loader.changeDisplay("MainMenu", loader.getStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (Button stats : view.getStatsList()) {
			if (event.getSource() == stats) {
				try {
					Stage stage = loader.newDisplay("Statistics");
					new StatisticsController(StatisticsView.getInstance(), stage,
							manager.getAgentList().get(view.getStatsList().indexOf(stats)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (int index = 0; index < view.getDeleteList().size(); index++) {
			if (event.getSource() == view.getDeleteList().get(index)) {
				try {
					view.deleteAgent(index);
				} catch (Exception e) {
				}
			}
		}
	}
}
