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
 * @author Pedro Freire
 *
 */
public class StatisticsManager extends Observable {

	private Map<String, Integer> gamesPlayed = new HashMap<>();
	private Map<String, Integer> utilityGained = new HashMap<>();

	public void translateAgentStats(Agent agent) {
		for (Entry<Agent, Integer> entry : agent.getStats().getGamesPlayed().entrySet()) {
			gamesPlayed.put(entry.getKey().getId().toString(), entry.getValue());
		}
		for (Entry<Agent, Integer> entry : agent.getStats().getUtilityGained().entrySet()) {
			utilityGained.put(entry.getKey().getId().toString(), entry.getValue());
		}
	}

	public Map<String, Integer> getGamesPlayed() {
		return gamesPlayed;
	}

	public Map<String, Integer> getUtilityGained() {
		return utilityGained;
	}

}
