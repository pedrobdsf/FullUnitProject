/**
 * 
 */
package one_v_one;

import driver.Loader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.OneVOneView;

/**
 * The controller class for the One V One game mode.
 * 
 * @author Pedro Freire
 *
 */
public class OneVOneController implements EventHandler<ActionEvent> {

	private Loader loader = new Loader();
	private OneVOneView view;
	private OneVOneManager manager;

	/**
	 * @param manager
	 *          - the manager of the One V One mode
	 * @param view
	 *          - the view of the One V One mode
	 */
	public OneVOneController(OneVOneManager manager, OneVOneView view) {
		this.manager = manager;
		this.view = view;
		view.addHandlers(this);
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
			try {
				loader.changeDisplay("MainMenu", loader.getStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the view of the One V One mode
	 */
	public OneVOneView getView() {
		return view;
	}

}
