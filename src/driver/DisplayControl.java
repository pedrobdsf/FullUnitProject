/**
 * 
 */
package driver;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * A class that allows predefined GUI to be loaded by name.
 * 
 * @author Pedro Freire
 *
 */
public class DisplayControl extends StackPane {

	private HashMap<String, Pane> displayMap = new HashMap<>();
	private Scene scene;

	/**
	 * @param main
	 *          - the scene of the current stage
	 */
	public DisplayControl(Scene main) {
		this.scene = main;
	}

	/**
	 * Adds a GUI to the map of available displays
	 * 
	 * @param name
	 *          - the name of the GUI
	 * @param pane
	 *          - the fxml pane of the GUI
	 */
	protected void addDisplay(String name, Pane pane) {
		displayMap.put(name, pane);
	}

	/**
	 * Removes an element from the map of available displays
	 * 
	 * @param name
	 *          - the name of the GUI
	 */
	protected void removeDisplay(String name) {
		displayMap.remove(name);
	}

	/**
	 * Displays the GUI if it is in the map of available displays
	 * 
	 * @param name
	 *          - the name of the GUI
	 */
	protected void activate(String name) {
		scene.setRoot(displayMap.get(name));
	}

}
