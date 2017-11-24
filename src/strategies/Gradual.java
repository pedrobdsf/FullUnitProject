/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class Gradual extends Strategy {

	private int totalDefect;
	private int defect;
	private int coop;
	
	public Gradual() {
		super();
		totalDefect = 0;
		defect = 0;
		coop = 0;
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() != null && opponent.getLastChoice().equals("D")) {
			totalDefect++;
		}
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else if (defect == 0 && coop == 0 && opponent.getLastChoice().equals("D")) {
			currChoice = "D";
			defect = totalDefect - 1;
			coop = 2;
		} else if (defect > 0) {
			defect--;
		} else if (coop > 0) {
			currChoice = "C";
			coop--;
		} else {
			currChoice = "C";
		}
	}
	
	@Override
	public void reset() {
		lastChoice = null;
		totalDefect = 0;
		defect = 0;
		coop = 0;
	}

}
