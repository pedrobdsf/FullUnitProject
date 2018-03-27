/**
 * 
 */
package agent.strategies;

import agent.GameMatrix;

/**
 * An object containing the algorithm to perform the Pavlov strategy.
 * 
 * @author Pedro Freire
 *
 */
public class Pavlov extends Strategy {

	GameMatrix matrix = new GameMatrix();

	/**
	 * Initialises the object and attributes the strategy its name.
	 */
	public Pavlov() {
		super();
		name = "Pavlov";
	}

	@Override
	public void choose() {
		matrix.evaluate(lastChoice, opponent.getLastChoice());
		System.out.println(matrix.getResult1());
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else if (matrix.getResult1() == 5 || matrix.getResult1() == 3) {
			currChoice = lastChoice;
		} else if (lastChoice.equals("C")) {
			currChoice = "D";
		} else {
			currChoice = "C";
		}
	}

}
