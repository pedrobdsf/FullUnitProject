/**
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.TournementManager;
import view.TournementView;

/**
 * @author Pedro Freire
 *
 */
public class TournementController implements Observer, EventHandler<ActionEvent> {

	private TournementView view;
	private TournementManager manager;

	public TournementController(TournementManager manager, TournementView view) {
		this.manager = manager;
		this.view = view;
		view.addHandlers(this);
		manager.addObserver(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getPlayButton()) {
			System.out.println("pressed play");
			manager.runGame(view.getAgentSelectList(), Integer.parseInt(view.getRoundsField().getText()));
			for (int num = 0; num < manager.getAgentList().length - 1; num++) {
				if (manager.getAgentList()[num] != null) {
					view.setResultField(String.valueOf(manager.getAgentList()[num].getUtility()), num);
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
