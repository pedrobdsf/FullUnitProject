/**
 * 
 */
package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.EnvironmentManager;
import model.OneVOneManager;
import model.TournamentManager;
import view.EnvironmentView;
import view.MainMenuView;
import view.OneVOneView;
import view.TournamentView;

/**
 * @author Pedro Freire
 *
 */
public class Loader extends Application {

	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Group root = new Group();
		Scene scene = new Scene(root);
		DisplayControl controller = new DisplayControl(scene);
		controller.addDisplay("MainMenu", FXMLLoader.load(getClass().getResource("/view/MainMenuFXML.fxml")));
		controller.addDisplay("OneVOne", FXMLLoader.load(getClass().getResource("/view/OneVOneFXML.fxml")));
		controller.addDisplay("Tournament", FXMLLoader.load(getClass().getResource("/view/TournamentFXML.fxml")));
		controller.addDisplay("Environment", FXMLLoader.load(getClass().getResource("/view/EnvironmentFXML.fxml")));
		controller.activate("MainMenu");
		handleController("MainMenu");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void changeDisplay(String name) throws Exception {
		Parent pane = FXMLLoader.load(getClass().getResource("/view/"+name+"FXML.fxml"));
		handleController(name);
		stage.getScene().setRoot(pane);
	}

	private void handleController(String name) {
		if (name.equals("MainMenu")) {
			new MainMenuController(MainMenuView.getInstance());
		}
		if (name.equals("OneVOne")) {
			OneVOneManager manager = new OneVOneManager();
			new OneVOneController(manager, OneVOneView.getInstance());
		}
		if (name.equals("Tournament")) {
			TournamentManager manager = new TournamentManager();
			new TournamentController(manager, TournamentView.getInstance());
		}
		if (name.equals("Environment")) {
			EnvironmentManager manager = new EnvironmentManager();
			new EnvironmentController(manager, EnvironmentView.getInstance());
		}
	}

}
