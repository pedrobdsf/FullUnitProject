/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Tit for Two Tats strategy.
 * 
 * @author Pedro Freire
 *
 */
public class TitForTwoTats extends Strategy {

	private String lastOppChoice;

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
	public TitForTwoTats() {
		super();
		name = "Tit For Two Tats";
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else if (opponent.getLastChoice().equals(lastOppChoice)) {
			currChoice = opponent.getLastChoice();
		} else {
			lastOppChoice = opponent.getLastChoice();
		}
	}

}
