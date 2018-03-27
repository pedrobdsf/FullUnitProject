/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Random strategy.
 * 
 * @author Pedro Freire
 *
 */
public class Random extends Strategy {

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
	public Random() {
		super();
		name = "Random";
	}

	@Override
	public void choose() {
		if (Math.random() < 0.5) {
			currChoice = "C";
		} else {
			currChoice = "D";
		}
	}
}
