/**
 * 
 */
package statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Map.Entry;

import agent.Agent;

/**
 * The model class for the statistics feature.
 * 
 * @author Pedro Freire
 *
 */
public class StatisticsManager extends Observable {

	private Map<String, Integer> gamesPlayed = new HashMap<>();
	private Map<String, Integer> utilityGained = new HashMap<>();

	/**
	 * Transforms the maps of agents and integers in an agent, into maps of
	 * strings and integers.
	 * 
	 * @param agent
	 *          - an agent with statistics
	 */
	public void translateAgentStats(Agent agent) {
		for (Entry<Agent, Integer> entry : agent.getStats().getGamesPlayed().entrySet()) {
			gamesPlayed.put(entry.getKey().getId().toString(), entry.getValue());
		}
		for (Entry<Agent, Integer> entry : agent.getStats().getUtilityGained().entrySet()) {
			utilityGained.put(entry.getKey().getId().toString(), entry.getValue());
		}
	}

	/**
	 * @return the map of games played
	 */
	public Map<String, Integer> getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @return the map of utility gain
	 */
	public Map<String, Integer> getUtilityGained() {
		return utilityGained;
	}

}
