/**
 * 
 */
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author Pedro Freire
 *
 */
public class MainMenuView {

	private static MainMenuView instance = null;

	@FXML
	private Button oneVOneButton;
	@FXML
	private Button tournamentButton;
	@FXML
	private Button environmentButton;
	@FXML
	private Button helpButton;

	/**
	 * Initialises the view.
	 */
	@FXML
	public void initialize() {
		instance = this;
	}

	/**
	 * Adds listeners to the controller.
	 * 
	 * @param controller
	 *          - the controller of the main menu
	 */
	public void addHandlers(EventHandler<ActionEvent> controller) {
		oneVOneButton.setOnAction(controller);
		tournamentButton.setOnAction(controller);
		environmentButton.setOnAction(controller);
		helpButton.setOnAction(controller);
	}

	/**
	 * @return the one v one button
	 */
	public Button getOneVOneButton() {
		return oneVOneButton;
	}

	/**
	 * @return the tournament button
	 */
	public Button getTournamentButton() {
		return tournamentButton;
	}

	/**
	 * @return the environment button
	 */
	public Button getEnvironmentButton() {
		return environmentButton;
	}

	/**
	 * @return the help button
	 */
	public Button getHelpButton() {
		return helpButton;
	}

	/**
	 * @return an instance of this class
	 */
	public static MainMenuView getInstance() {
		return instance;
	}

}
