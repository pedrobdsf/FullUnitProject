/**
 * 
 */
package agent.strategies;

/**
 * @author Pedro Freire
 *
 */
public class Grudger extends Strategy {

	public Grudger() {
		super();
		name = "Grudger";
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else if (opponent.getLastChoice().equals("D")) {
			currChoice = "D";
		}
	}

}
