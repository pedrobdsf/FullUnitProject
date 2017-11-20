/**
 * 
 */
package controller;

import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * @author Pedro Freire
 *
 */
public class DisplayControl extends StackPane{
	
	public void setDisplay(String name, HashMap<String, Node> displays) {
      DoubleProperty opacity = opacityProperty();
      if (!getChildren().isEmpty()) {
        Timeline fade = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
            new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent t) {

                getChildren().remove(0);

                getChildren().add(0, displays.get(name));
                //Loader.resizeScreen();

                Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                    new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                fadeIn.play();
              }
            }, new KeyValue(opacity, 0.0)));
        fade.play();

      } else {
        setOpacity(0.0);
        getChildren().add(displays.get(name));
        Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
            new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
        fadeIn.play();
      }
	}
}
