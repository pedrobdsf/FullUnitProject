/**
 * 
 */
package model;

import java.util.Observable;

import strategies.AlwaysCooperateStrategy;
import strategies.AlwaysDefectStrategy;
/**
 * @author Pedro Freire
 *
 */
public class TournementManager extends Observable{
	
	private GameMatrix matrix = new GameMatrix();
	private Agent[] agentList;
	
	public void runGame(String[] stratList, int numOfRounds) {
		agentList = new Agent[stratList.length];
		for (int num = 0; num < agentList.length - 1; num++) {
			agentList[num] = stringToAgent(stratList[num]);
		}
		for (Agent agent1 : agentList) {
			for (Agent agent2 : agentList) {
				if (agent1 != null && agent2 != null && agent1 != agent2) {
					agent1.setOpponent(agent2);
					agent2.setOpponent(agent1);
					for (int round = 1; round <= numOfRounds; round++) {
						matrix.evaluate(agent1.getStrat().choose(), agent2.getStrat().choose());
						agent1.incUtility(matrix.getResult1());
						agent2.incUtility(matrix.getResult2());
					}
				}
			}
		}
	}
	
	private Agent stringToAgent(String strat) {
		switch (strat) {
		case "Always Defect":
			return new Agent(new AlwaysDefectStrategy());
		case "Always Cooperate":
			return new Agent(new AlwaysCooperateStrategy());
		default:
			return null;
		}
	}
	
	public Agent[] getAgentList() {
		return agentList;
	}

}
