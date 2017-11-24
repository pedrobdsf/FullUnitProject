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
	protected String lastChoice;

	public Strategy() {
		lastChoice = null;
	}

	public void choose() {
		currChoice = null;
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
	
	public void resetLastChoice() {
		lastChoice = null;
	}

	public void setLastChoice() {
		lastChoice = currChoice;
	}

	public String getLastChoice() {
		return lastChoice;
	}

}
