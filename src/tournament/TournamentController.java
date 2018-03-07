/**
 * 
 */
package tournament;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.TournamentView;

/**
 * @author Pedro Freire
 *
 */
public class TournamentController implements Observer, EventHandler<ActionEvent> {

	private TournamentView view;
	private TournamentManager manager;

	public TournamentController(TournamentManager manager, TournamentView view) {
		this.manager = manager;
		this.view = view;
		view.addHandlers(this);
		manager.addObserver(this);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == view.getPlayButton()) {
			view.clearResultField();
			manager.runGame(view.getAgentSelectList(), Integer.parseInt(view.getRoundsField().getText()));
			for (int index = 0; index < manager.getAgentList().length; index++) {
				if (manager.getAgentList()[index] != null) {
					view.setResultField(String.valueOf(manager.getAgentList()[index].getTotalUtility()), index);
				}
			}
			view.setTotalUtility();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
