/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.HashMap;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.EnvironmentManager;
import model.OneVOneManager;
import model.TournamentManager;
import view.EnvironmentView;
import view.OneVOneView;
import view.TournamentView;

/**
 * @author Pedro Freire
 *
 */
public class Loader extends Application {

	private static Stage stage;
	private HashMap<String, Node> displays = new HashMap<>();
	private String mainMenu = "MainMenu";
	private String mainMenuFXML = "/view/MainMenuFXML.fxml";
	private String oneVOne = "OneVOne";
	private String oneVOneFXML = "/view/OneVOneFXML.fxml";
	private String tournament = "Tournament";
	private String tournamentFXML = "/view/TournamentFXML.fxml";
	private String environment = "Environment";
	private String environmentFXML = "/view/EnvironmentFXML.fxml";

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		DisplayControl controller = new DisplayControl();
		loadDisplay(mainMenu, mainMenuFXML);
		loadDisplay(oneVOne, oneVOneFXML);
		loadDisplay(tournament, tournamentFXML);
		loadDisplay(environment, environmentFXML);
		setDisplay(mainMenu, controller);
		Group root = new Group();
		root.getChildren().add(controller);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void loadDisplay(String name, String path) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		Parent loadDisplay = (Parent) loader.load();
		displays.put(name, loadDisplay);
	}

	public void setDisplay(String name, DisplayControl controller) {
		handleController(name);
		if (displays.get(name) != null) {
      controller.setDisplay(name, displays);
    } else {
      System.out.println("Display was not loaded");
    }
	}

	private void handleController(String name) {
		if (name.equals(oneVOne)) {
			OneVOneManager manager = new OneVOneManager();
			new OneVOneController(manager, OneVOneView.getInstance());
		}
		if (name.equals(tournament)) {
			TournamentManager manager = new TournamentManager();
			new TournamentController(manager, TournamentView.getInstance());
		}
		if (name.equals(environment)) {
			EnvironmentManager manager = new EnvironmentManager();
			new EnvironmentController(manager, EnvironmentView.getInstance());
		}
	}
}
