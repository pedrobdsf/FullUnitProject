/**
 * 
 */
package agent.strategies;

import agent.GameMatrix;

/**
 * @author Pedro Freire
 *
 */
public class Pavlov extends Strategy {

	GameMatrix matrix = new GameMatrix();

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
