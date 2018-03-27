/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Always Cooperate strategy.
 * 
 * @author Pedro Freire
 *
 */
public class AlwaysCooperate extends Strategy {

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
	public AlwaysCooperate() {
		super();
		name = "Always Cooperate";
	}

	@Override
	public void choose() {
		currChoice = "C";
	}

}
