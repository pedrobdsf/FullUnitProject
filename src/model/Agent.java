/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import strategies.Strategy;

/**
 * @author Pedro Freire
 *
 */
public class Agent {

	private Strategy strat;
	private int totalUtility;
	private int gameUtility;
	private int avgUtility = 0;
	private int utilityThreshold = 2;
	private Map<Agent, Integer> knownAgents = new HashMap<>();
	private List<Agent> acceptedAgents = new ArrayList<>();

	public Agent(Strategy strat) {
		this.strat = strat;
		this.totalUtility = 0;
	}

	public Strategy getStrat() {
		return strat;
	}

	public void incUtility(int utility) {
		this.gameUtility += utility;
	}

	public int getTotalUtility() {
		return totalUtility;
	}

	public int getGameUtility() {
		return gameUtility;
	}

	public int getAvgUtility() {
		return avgUtility;
	}

	public void setAvgUtility(int avgUtility) {
		this.avgUtility = avgUtility;
	}

	public int calculateAvgUtility() {
		Collection<Integer> utilities = knownAgents.values();
		for (Integer utility : utilities) {
			totalUtility += utility;
		}
		return totalUtility / knownAgents.size();
	}

	public boolean isInUtilityThreshold(int avgUtility) {
		if (utilityThreshold > 0) {
			return avgUtility >= utilityThreshold;
		} else {
			return avgUtility > utilityThreshold;
		}
	}

	public void decAvgUtilityThreshold() {
		utilityThreshold--;
	}

	public List<Agent> getAcceptedAgents() {
		return acceptedAgents;
	}

	public void setOpponent(Agent opponent) {
		strat.setOpponent(opponent.getStrat());
	}

	public void mapOpponent(Agent opponent, int utility) {
		knownAgents.put(opponent, utility);
	}

	public void printMap(Map<Agent, Integer> map) {
		for (Entry<Agent, Integer> entry : map.entrySet()) {
			System.out.println("Agent: " + entry.getKey().getStrat().getName() + ", Value: " + entry.getValue());
		}
		System.out.println();
	}

	public void reset() {
		totalUtility += gameUtility;
		gameUtility = 0;
		strat.reset();
	}

}
