/**
 * 
 */
package agent.strategies;

/**
 * An object containing the algorithm to perform the Soft Grudger strategy.
 * 
 * @author Pedro Freire
 *
 */
public class SoftGrudger extends Strategy {

	private int defect;
	private int coop;

	/**
	 * Initialises the object, the variables used to perform the algorithm and
	 * attributes the strategy its name.
	 */
	public SoftGrudger() {
		super();
		name = "Soft Grudger";
		defect = 0;
		coop = 0;
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else if (defect == 0 && coop == 0 && opponent.getLastChoice().equals("D")) {
			currChoice = "D";
			defect = 3;
			coop = 2;
		} else if (defect > 0) {
			defect--;
		} else if (coop > 0) {
			currChoice = "C";
			coop--;
		}
	}

	@Override
	public void reset() {
		lastChoice = null;
		defect = 0;
		coop = 0;
	}

}
