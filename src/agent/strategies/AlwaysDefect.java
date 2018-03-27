/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Always Defect strategy.
 * 
 * @author Pedro Freire
 *
 */
public class AlwaysDefect extends Strategy {

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
	public AlwaysDefect() {
		super();
		name = "Always Defect";
	}

	@Override
	public void choose() {
		currChoice = "D";
	}

}
