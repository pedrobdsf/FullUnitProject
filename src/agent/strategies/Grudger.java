/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Grudger strategy.
 * 
 * @author Pedro Freire
 *
 */
public class Grudger extends Strategy {

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
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
