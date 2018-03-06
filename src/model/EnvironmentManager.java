/**
 * 
 */
package model;

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
		for (int gameCount = 1; gameCount <= numOfGames; gameCount++) {
			int count = 0;
			for (Agent agent1 : agentList) {
				for (int index = count; index < agentList.length; index++) {
					Agent agent2 = agentList[index];
					if (agent1 != null && agent2 != null && agent1 != agent2) {
						if (gameCount == 1
								|| agent1.getAcceptedAgents().contains(agent2) && agent2.getAcceptedAgents().contains(agent1)) {
							System.out.println("Accepted agents");
							runRounds(agent1, agent2, numOfRounds);
							System.out.println("Finished rounds");
							System.out.println();
						} else {
							System.out.println("Rejected agents");
						}
					}
				}
				if (agent1 != null) {
					agent1.setNewAvgUtility();
					System.out.println(agent1.getNewAvgUtility() + " " + agent1.getAvgUtility());
					if (agent1.getNewAvgUtility() < agent1.getAvgUtility()) {
						System.out.println("Decrement threshold");
						agent1.decAvgUtilityThreshold();
					}
					agent1.setAvgUtility(agent1.getNewAvgUtility());
					System.out.println("Keep threshold");
					agent1.printMap(agent1.getStats().getGamesPlayed());
					agent1.printMap(agent1.getStats().getUtilityGained());
				}
				count++;
			}
		}

	}

	public void runRounds(Agent agent1, Agent agent2, int numOfRounds) {
		agent1.setOpponent(agent2);
		agent2.setOpponent(agent1);
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
		agent1.mapOpponent(agent2, agent1.getGameUtility() / numOfRounds);
		agent2.mapOpponent(agent1, agent2.getGameUtility() / numOfRounds);
		if (agent1.isInUtilityThreshold(agent1.getGameUtility() / numOfRounds)) {
			agent1.getAcceptedAgents().add(agent2);
		}
		if (agent2.isInUtilityThreshold(agent2.getGameUtility() / numOfRounds)) {
			agent2.getAcceptedAgents().add(agent1);
		}
		agent1.reset();
		agent2.reset();
	}

	public Agent[] getAgentList() {
		return agentList;
	}

}
