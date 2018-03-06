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

	private Loader loader = new Loader();
	private MainMenuView view;

	public MainMenuController(MainMenuView view) {
		this.view = view;
		view.addHandlers(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getOneVOneButton()) {
			try {
				loader.changeDisplay("OneVOne");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (event.getSource() == view.getTournamentButton()) {
			try {
				loader.changeDisplay("Tournament");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (event.getSource() == view.getEnvironmentButton()) {
			try {
				loader.changeDisplay("Environment");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (event.getSource() == view.getInfoButton()) {
			try {
				loader.newDisplay("Statistics");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
