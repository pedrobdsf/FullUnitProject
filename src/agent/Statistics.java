/**
 * 
 */
package agent;

import java.util.HashMap;
import java.util.Map;

/**
 * An object that contains the statistics of a specific Agent object.
 * 
 * @author Pedro Freire
 *
 */
public class Statistics {

	private Map<Agent, Integer> gamesPlayed;
	private Map<Agent, Integer> utilityGained;

	/**
	 * Initialises the list of games played and utility gained.
	 */
	public Statistics() {
		gamesPlayed = new HashMap<>();
		utilityGained = new HashMap<>();
	}

	/**
	 * Adds an opponent to both the map of games played and utility gained.
	 * 
	 * @param agent
	 *          - the current opponent of the agent
	 * @param utility
	 *          - the utility gained against the opponent
	 */
	public void mapAgent(Agent agent, int utility) {
		if (!(gamesPlayed.containsKey(agent) && utilityGained.containsKey(agent))) {
			gamesPlayed.put(agent, 1);
			utilityGained.put(agent, utility);
		} else {
			int utilityInc = utilityGained.get(agent) + utility;
			utilityGained.put(agent, utilityInc);
			int gamesInc = gamesPlayed.get(agent) + 1;
			gamesPlayed.put(agent, gamesInc);
		}
	}

	/**
	 * @return the map with the amount of games played against each opponent
	 */
	public Map<Agent, Integer> getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @return the map with utility gained against each each opponent
	 */
	public Map<Agent, Integer> getUtilityGained() {
		return utilityGained;
	}

}
