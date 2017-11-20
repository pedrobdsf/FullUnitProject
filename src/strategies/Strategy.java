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
	protected String choice;

	public Strategy() {
		choice = "";
	}
	
	public String choose() {
		return "";
	}

	public void setOpponent(Strategy opponent) {
		this.opponent = opponent;
	}

	public Strategy getOpponent() {
		return opponent;
	}

	public String getChoice() {
		return choice;
	}

}
