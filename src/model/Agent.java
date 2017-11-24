/**
 * 
 */
package model;

import strategies.Strategy;

/**
 * @author Pedro Freire
 *
 */
public class Agent {

	private Strategy strat;
	private int utility;

	public Agent(Strategy strat) {
		this.strat = strat;
		this.utility = 0;
	}

	public Strategy getStrat() {
		return strat;
	}

	public void incUtility(int utility) {
		this.utility += utility;
	}

	public int getUtility() {
		return utility;
	}

	public void setOpponent(Agent opponent) {
		strat.setOpponent(opponent.getStrat());
	}

	public void reset() {
		strat.reset();
	}

}
