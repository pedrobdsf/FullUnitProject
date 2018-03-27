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
 * An object that contains all of the information and functionality and agent
 * requires to play the Prisoner's Dilemma.
 * 
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

	/**
	 * Initialises the agent by attributing it a strategy and setting its utility
	 * to zero.
	 * 
	 * @param strat
	 *          - the strategy the agent will be using
	 */
	public Agent(Strategy strat) {
		this.strat = strat;
		this.totalUtility = 0;
	}

	/**
	 * @return the ID if the agent
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *          - the ID of the agent
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the strategy the agent is using
	 */
	public Strategy getStrat() {
		return strat;
	}

	/**
	 * @param utility
	 *          - utility gained in the last round
	 */
	public void incUtility(int utility) {
		this.gameUtility += utility;
	}

	/**
	 * @return the total utility the agent has gained
	 */
	public int getTotalUtility() {
		return totalUtility;
	}

	/**
	 * @return the utility the agent has gained over the last game
	 */
	public int getGameUtility() {
		return gameUtility;
	}

	/**
	 * @return the average utility the agent has gained
	 */
	public double getAvgUtility() {
		return avgUtility;
	}

	/**
	 * Sets the average utility of the agent based on the utility gathered from
	 * every known agent.
	 */
	public void setAvgUtility() {
		Collection<Double> utilities = knownAgents.values();
		int temp = 0;
		for (Double utility : utilities) {
			temp += utility;
		}
		avgUtility = temp / knownAgents.size();
	}

	/**
	 * @param avgUtility
	 *          - the average utility the agent has gained
	 * @return true if the average utility is above the threshold
	 */
	public boolean isInUtilityThreshold(double avgUtility) {
		return avgUtility >= utilityThreshold;
	}

	/**
	 * @return the list of accepted agents
	 */
	public List<Agent> getAcceptedAgents() {
		return acceptedAgents;
	}

	/**
	 * @param opponent
	 *          - the opponent of the agent for the current game
	 */
	public void setOpponent(Agent opponent) {
		strat.setOpponent(opponent.getStrat());
	}

	/**
	 * Maps the current opponent to a list of known agents along with the utility
	 * gained over the last encounter.
	 * 
	 * @param opponent
	 *          - the opponent of the agent for the current game
	 * @param utility
	 *          - the utility gained during the encounter with this opponent
	 */
	public void mapOpponent(Agent opponent, double utility) {
		knownAgents.put(opponent, utility);
		stats.mapAgent(opponent, gameUtility);
	}

	/**
	 * @return the statistics of this agent
	 */
	public Statistics getStats() {
		return stats;
	}

	/**
	 * Prints the map of known agents ina human readable format.
	 * 
	 * @param map
	 *          - the map of agents known to this agent
	 */
	public void printMap(Map<Agent, Integer> map) {
		for (Entry<Agent, Integer> entry : map.entrySet()) {
			System.out.println("Agent: " + entry.getKey().getStrat().getName() + ", Value: " + entry.getValue());
		}
		System.out.println();
	}

	/**
	 * Adds the utility gained over the last game to total utility, sets game
	 * utility back to zero, resets the strategy.
	 */
	public void reset() {
		totalUtility += gameUtility;
		gameUtility = 0;
		strat.reset();
	}

}
