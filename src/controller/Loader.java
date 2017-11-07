/**
 * 
 */
package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.OneVOneManager;
import view.OneVOneView;

/**
 * @author Pedro Freire
 *
 */
public class Loader extends Application{
	
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		OneVOneController controller = new OneVOneController(new OneVOneManager(), new OneVOneView());
    controller.getView().start(stage);
    System.out.println(controller.getView().getPlayButton());
    //controller.getView().addHandlers(controller);
	}
}
