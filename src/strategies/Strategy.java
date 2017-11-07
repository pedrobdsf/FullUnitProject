/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class Strategy {

	protected Strategy opponent;
	protected String currChoice;
	private String nextChoice;

	public Strategy() {
		currChoice = "";
		nextChoice = "";
	}

	public void setOpponent(Strategy opponent) {
		this.opponent = opponent;
	}

	public Strategy getOpponent() {
		return opponent;
	}

	public String getCurrChoice() {
		return currChoice;
	}

	public String getNextChoice() {
		return nextChoice;
	}

}
