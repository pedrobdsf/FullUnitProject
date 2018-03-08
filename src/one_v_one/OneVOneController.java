/**
 * 
 */
package one_v_one;

import java.util.Observable;
import java.util.Observer;

import driver.Loader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.OneVOneView;

/**
 * @author Pedro Freire
 *
 */
public class OneVOneController implements Observer, EventHandler<ActionEvent> {

	private Loader loader = new Loader();
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
			view.setResultField1(String.valueOf(manager.getAgent1().getTotalUtility()));
			view.setResultField2(String.valueOf(manager.getAgent2().getTotalUtility()));
		}
		if (event.getSource() == view.getBackButton()) {
			System.out.println("Pressed");
			try {
				loader.changeDisplay("MainMenu", loader.getStage());
				System.out.println("Changed display");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

	public OneVOneView getView() {
		return view;
	}

}