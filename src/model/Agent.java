/**
 * 
 */
package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
	private boolean open = true;
	private Agent prevOpponent;
	private Map<Agent, Integer> knownAgents = new HashMap<>();
	private Map<Agent, Integer> sortedKnownAgents = new LinkedHashMap<>();

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

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public void setOpponent(Agent opponent) {
		strat.setOpponent(opponent.getStrat());
	}

	public void mapOpponent(Agent opponent, int utility) {
		knownAgents.put(opponent, utility);
	}

	public boolean isPrevOpponent(Agent agent) {
		return agent.equals(prevOpponent);
	}

	public void setPrevOpponent(Agent agent) {
		prevOpponent = agent;
	}

	public void sortKnownAgents() {
		printMap(knownAgents);
		List<Entry<Agent, Integer>> list = new LinkedList<Entry<Agent, Integer>>(knownAgents.entrySet());
		Collections.sort(list, new Comparator<Entry<Agent, Integer>>() {
			public int compare(Entry<Agent, Integer> agent1, Entry<Agent, Integer> agent2) {
				return agent2.getValue().compareTo(agent1.getValue());
			}
		});
		for (Entry<Agent, Integer> entry : list) {
			sortedKnownAgents.put(entry.getKey(), entry.getValue());
		}
		printMap(sortedKnownAgents);
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
