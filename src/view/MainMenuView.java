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
	private Button infoButton;

	@FXML
	public void initialize() {
		instance = this;
	}

	public void addHandlers(EventHandler<ActionEvent> controller) {
		oneVOneButton.setOnAction(controller);
		tournamentButton.setOnAction(controller);
		environmentButton.setOnAction(controller);
		infoButton.setOnAction(controller);
	}

	public Button getOneVOneButton() {
		return oneVOneButton;
	}

	public Button getTournamentButton() {
		return tournamentButton;
	}

	public Button getEnvironmentButton() {
		return environmentButton;
	}

	public Button getInfoButton() {
		return infoButton;
	}

	public static MainMenuView getInstance() {
		return instance;
	}

}
