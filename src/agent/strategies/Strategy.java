/**
 * 
 */
package agent.strategies;

/**
 * An object that contains all of the information and functionality required to
 * perform a strategy for the Prisoner's Dilemma.
 * 
 * @author Pedro Freire
 *
 */
public class Strategy {

	protected String name;
	protected Strategy opponent;
	protected String currChoice;
	protected String lastChoice;

	/**
	 * Initialises the strategy.
	 */
	public Strategy() {
		lastChoice = null;
	}

	/**
	 * Chooses the next move the agent will perform in the game.
	 */
	public void choose() {
		currChoice = null;
	}

	/**
	 * @param opponent
	 *          - the strategy of the current opponent of the agent
	 */
	public void setOpponent(Strategy opponent) {
		this.opponent = opponent;
	}

	/**
	 * @return the strategy of the current opponent of the agent
	 */
	public Strategy getOpponent() {
		return opponent;
	}

	/**
	 * @return the current choice for the game
	 */
	public String getCurrChoice() {
		return currChoice;
	}

	/**
	 * Resets the state of the strategy.
	 */
	public void reset() {
		lastChoice = null;
	}

	/**
	 * Attribute the current choice to last choice.
	 */
	public void setLastChoice() {
		lastChoice = currChoice;
	}

	/**
	 * @return the last choice made by the strategy
	 */
	public String getLastChoice() {
		return lastChoice;
	}

	/**
	 * @return the name of the strategy
	 */
	public String getName() {
		return name;
	}

}
