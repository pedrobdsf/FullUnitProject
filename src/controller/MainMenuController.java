/**
 * 
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.MainMenuView;

/**
 * @author Pedro Freire
 *
 */
public class MainMenuController implements EventHandler<ActionEvent> {

	private MainMenuView view;

	public MainMenuController(MainMenuView view) {
		this.view = view;
		view.addHandlers(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getOneVOneButton()) {

		}
		if (event.getSource() == view.getTournamentButton()) {

		}
		if (event.getSource() == view.getEnvironmentButton()) {

		}
		if (event.getSource() == view.getInfoButton()) {

		}
	}

}
