/**
 * 
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.StatisticsView;

/**
 * @author Pedro Freire
 *
 */
public class StatisticsController implements EventHandler<ActionEvent> {

	private Loader loader = new Loader();
	private StatisticsView view;
	private Stage stage;

	public StatisticsController(StatisticsView view, Stage stage) {
		this.view = view;
		this.stage = stage;
		view.addHandlers(this);
	}

	@Override
	public void handle(ActionEvent event){
		if (event.getSource() == view.getPrevButton()) {
			try {
				loader.changeDisplay("Statistics");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (event.getSource() == view.getNextButton()) {
			try {
				loader.changeDisplay("Statistics");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (event.getSource() == view.getExitButton()) {
			stage.close();
		}
	}

}
