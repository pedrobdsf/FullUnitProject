/**
 * 
 */
package agent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import agent.strategies.Strategy;

/**
 * @author Pedro Freire
 *
 */
public class Agent {

	private Integer id;
	private Strategy strat;
	private int totalUtility;
	private int gameUtility;
	private double avgUtility = 0;
	private double utilityThreshold = 1;
	private Map<Agent, Double> knownAgents = new HashMap<>();
	private List<Agent> acceptedAgents = new ArrayList<>();
	private Statistics stats = new Statistics();

	public Agent(Strategy strat) {
		this.strat = strat;
		this.totalUtility = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public double getAvgUtility() {
		return avgUtility;
	}

	public void setAvgUtility() {
		Collection<Double> utilities = knownAgents.values();
		int temp = 0;
		for (Double utility : utilities) {
			temp += utility;
		}
		avgUtility = temp / knownAgents.size();
	}

	public boolean isInUtilityThreshold(double avgUtility) {
		return avgUtility >= utilityThreshold;
	}

	public List<Agent> getAcceptedAgents() {
		return acceptedAgents;
	}

	public void setOpponent(Agent opponent) {
		strat.setOpponent(opponent.getStrat());
	}

	public void mapOpponent(Agent opponent, double utility) {
		knownAgents.put(opponent, utility);
		stats.mapAgent(opponent, gameUtility);
	}

	public Statistics getStats() {
		return stats;
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
