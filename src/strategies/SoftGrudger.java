/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class SoftGrudger extends Strategy {

	private int defect;
	private int coop;
	
	public SoftGrudger() {
		super();
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
		} else if (defect > 0) {
			defect--;
			coop = 2;
		} else if (coop > 0) {
			currChoice = "C";
			coop--;
		}
	}

}