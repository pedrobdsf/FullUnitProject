/**
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.OneVOneManager;
import view.OneVOneView;

/**
 * @author Pedro Freire
 *
 */
public class OneVOneController implements Observer, EventHandler<ActionEvent> {

	private OneVOneView view;
	private OneVOneManager manager;

	public OneVOneController(OneVOneManager manager, OneVOneView view) {
		this.manager = manager;
		this.view = view;
		view.addHandlers(this);
		manager.addObserver(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getPlayButton()) {
			manager.runGame(view.getAgentSelect1().getValue(), view.getAgentSelect2().getValue(),
					Integer.parseInt(view.getRoundsField().getText()));
			view.setResultField1(String.valueOf(manager.getAgent1().getUtility()));
			view.setResultField2(String.valueOf(manager.getAgent2().getUtility()));
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public OneVOneView getView() {
		return view;
	}

}
