/**
 * 
 */
package controller;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author Pedro Freire
 *
 */
public class DisplayControl extends StackPane{
	
	private HashMap<String, Pane> displayMap = new HashMap<>();
  private Scene scene;

  public DisplayControl(Scene main) {
      this.scene = main;
  }

  protected void addDisplay(String name, Pane pane){
       displayMap.put(name, pane);
  }

  protected void removeDisplay(String name){
      displayMap.remove(name);
  }

  protected void activate(String name){
      scene.setRoot( displayMap.get(name) );
  }
}
