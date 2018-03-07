/**
 * 
 */
package driver;

import environment.EnvironmentController;
import environment.EnvironmentManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main_menu.MainMenuController;
import one_v_one.OneVOneController;
import one_v_one.OneVOneManager;
import tournament.TournamentController;
import tournament.TournamentManager;
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
		controller.addDisplay("Statistics", FXMLLoader.load(getClass().getResource("/view/StatisticsFXML.fxml")));
		controller.activate("MainMenu");
		handleController("MainMenu");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void changeDisplay(String name, Stage stage) throws Exception {
		Parent pane = FXMLLoader.load(getClass().getResource("/view/" + name + "FXML.fxml"));
		handleController(name);
		stage.getScene().setRoot(pane);
	}

	public Stage newDisplay(String name) throws Exception {
		Stage newStage = new Stage();
		Parent pane = FXMLLoader.load(getClass().getResource("/view/" + name + "FXML.fxml"));
		newStage.setScene(new Scene(pane));
		newStage.show();
		return newStage;
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
	
	public Stage getStage() {
		return stage;
	}

}
