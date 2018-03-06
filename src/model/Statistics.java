/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pedro Freire
 *
 */
public class Statistics {

	private Map<Agent, Integer> gamesPlayed;
	private Map<Agent, Integer> utilityGained;

	public Statistics() {
		gamesPlayed = new HashMap<>();
		utilityGained = new HashMap<>();
	}

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
	
	public Map<Agent, Integer> getGamesPlayed() {
		return gamesPlayed;
	}
	
	public Map<Agent, Integer> getUtilityGained() {
		return utilityGained;
	}

}
