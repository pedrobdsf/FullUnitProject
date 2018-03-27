/**
 * 
 */
package agent.strategies;

import agent.GameMatrix;

/**
 * An object containing the algorithm to perform the Adaptive strategy.
 * 
 * @author Pedro Freire
 *
 */
public class Adaptive extends Strategy {

	GameMatrix matrix = new GameMatrix();
	private int defectCount;
	private int totalDefectGain;
	private double avgDefectScore;
	private int coopCount;
	private int totalCoopGain;
	private double avgCoopScore;
	private int defect;
	private int coop;

	/**
	 * Initialises the object, the variables used to perform the algorithm and
	 * attributes the strategy its name.
	 */
	public Adaptive() {
		super();
		name = "Adaptive";
		defectCount = 0;
		totalDefectGain = 0;
		coopCount = 0;
		totalCoopGain = 0;
		defect = 5;
		coop = 5;
	}

	@Override
	public void choose() {

		if (lastChoice != null) {
			matrix.evaluate(lastChoice, opponent.getLastChoice());
			if (matrix.getResult1() == 5 || matrix.getResult1() == 1) {
				totalDefectGain += matrix.getResult1();
				if (defectCount != 0) {
					avgDefectScore = totalDefectGain / defectCount;
				}
			} else {
				totalCoopGain += matrix.getResult1();
				avgCoopScore = totalCoopGain / coopCount;
			}
		}

		if (opponent.getLastChoice() == null) {
			currChoice = "C";
			coopCount++;
		} else if (defect == 0 && coop == 0) {
			System.out.println(avgDefectScore + " " + avgCoopScore);
			if (avgDefectScore > avgCoopScore) {
				currChoice = "D";
				defectCount++;
			} else {
				currChoice = "C";
				coopCount++;
			}
		} else if (coop > 0) {
			currChoice = "C";
			coopCount++;
			coop--;
		} else if (defect > 0) {
			currChoice = "D";
			defectCount++;
			defect--;
		}

	}

	@Override
	public void reset() {
		lastChoice = null;
		defectCount = 0;
		totalDefectGain = 0;
		coopCount = 0;
		totalCoopGain = 0;
		defect = 5;
		coop = 5;
	}

}
