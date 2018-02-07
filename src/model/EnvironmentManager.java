/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Pedro Freire
 *
 */
public class EnvironmentManager extends Observable {

	private AgentManager agentManager = new AgentManager();
	private GameMatrix matrix = new GameMatrix();
	private Agent[] agentList;
	// private ArrayList<Agent> openAgentsList;

	public void runGame(String[] stratList, int numOfRounds, int numOfGames) {
		agentList = new Agent[stratList.length];
		for (int num = 0; num < agentList.length; num++) {
			agentList[num] = agentManager.stringToAgent(stratList[num]);
		}
		reconnaissance(numOfRounds);
		for (int gameCount = 1; gameCount < numOfGames; gameCount++) {
			/*
			 * while (!openAgentsList.isEmpty()) { for (Agent agent : agentList) { } }
			 */
			agentList[0].sortKnownAgents();
		}

	}

	public void reconnaissance(int numOfRounds) {
		int count = 0;
		for (Agent agent1 : agentList) {
			for (int index = count; index < agentList.length; index++) {
				Agent agent2 = agentList[index];
				if (agent1 != null && agent2 != null && agent1 != agent2) {
					agent1.setOpponent(agent2);
					agent2.setOpponent(agent1);
					runRounds(agent1, agent2, numOfRounds);
					agent1.mapOpponent(agent2, agent1.getGameUtility());
					agent2.mapOpponent(agent1, agent2.getGameUtility());
					agent1.reset();
					agent2.reset();
					System.out.println();
				}
			}
			count++;
		}
	}

	public void runRounds(Agent agent1, Agent agent2, int numOfRounds) {
		for (int round = 1; round <= numOfRounds; round++) {
			agent1.getStrat().choose();
			agent2.getStrat().choose();
			matrix.evaluate(agent1.getStrat().getCurrChoice(), agent2.getStrat().getCurrChoice());
			matrix.printRound();
			agent1.incUtility(matrix.getResult1());
			agent2.incUtility(matrix.getResult2());
			agent1.getStrat().setLastChoice();
			agent2.getStrat().setLastChoice();
		}
	}

	public Agent[] getAgentList() {
		return agentList;
	}

}
