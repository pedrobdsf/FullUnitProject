/**
 * 
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Agent;
import view.StatisticsView;

/**
 * @author Pedro Freire
 *
 */
public class StatisticsController implements EventHandler<ActionEvent> {

	// private Loader loader = new Loader();
	private StatisticsView view;

	public StatisticsController(StatisticsView view, Agent agent) {
		this.view = view;
		view.addHandlers(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getPrevButton()) {

		}
		if (event.getSource() == view.getNextButton()) {

		}
		if (event.getSource() == view.getExitButton()) {

		}
	}

}
