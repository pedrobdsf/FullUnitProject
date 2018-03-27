/**
 * 
 */
package agent;

/**
 * A class that contains the algorithm of a standard Prisoner's Dilemma matrix.
 * 
 * @author Pedro Freire
 *
 */
public class GameMatrix {

	private int result1;
	private int result2;
	private String round;

	/**
	 * Receives the choices of two agents and attributes each of them their
	 * respective utility based on the combination of Prisoner's Dilemma matrix.
	 * 
	 * @param choice1
	 *          - the choice made by agent 1
	 * @param choice2
	 *          - the choice made by agent 2
	 */
	public void evaluate(String choice1, String choice2) {
		round = choice1 + choice2;
		switch (round) {
		case "CC":
			result1 = 3;
			result2 = 3;
			break;
		case "CD":
			result1 = 0;
			result2 = 5;
			break;
		case "DC":
			result1 = 5;
			result2 = 0;
			break;
		case "DD":
			result1 = 1;
			result2 = 1;
			break;
		}
	}

	/**
	 * @return the utility gained by agent 1
	 */
	public int getResult1() {
		return result1;
	}

	/**
	 * @return the utility gained by agent 2
	 */
	public int getResult2() {
		return result2;
	}

	/**
	 * Prints the result of the last round
	 */
	public void printRound() {
		System.out.println(round);
	}

}
