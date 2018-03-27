/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Tit for Tat strategy.
 * 
 * @author Pedro Freire
 *
 */
public class TitForTat extends Strategy {

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
	public TitForTat() {
		super();
		name = "Tit For Tat";
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else {
			currChoice = opponent.getLastChoice();
		}
	}

}
