/**
 * 
 */
package model;

/**
 * @author Pedro Freire
 *
 */
public class GameMatrix {

	private int result1;
	private int result2;
	private String round;

	public void evaluate(String choice1, String choice2) {
		round = choice1 + choice2;
		switch (round) {
		case "CC":
			result1 = 2;
			result2 = 2;
			break;
		case "CD":
			result1 = 0;
			result2 = 3;
			break;
		case "DC":
			result1 = 3;
			result2 = 0;
			break;
		case "DD":
			result1 = 1;
			result2 = 1;
			break;
		}
	}

	public int getResult1() {
		return result1;
	}

	public int getResult2() {
		return result2;
	}

	public void printRound() {
		System.out.println(round);
	}

}
