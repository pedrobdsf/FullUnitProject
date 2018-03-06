/**
 * 
 */
package environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import agent.Agent;
import agent.AgentManager;
import agent.GameMatrix;

/**
 * @author Pedro Freire
 *
 */
public class EnvironmentManager extends Observable {

	private AgentManager agentManager = new AgentManager();
	private GameMatrix matrix = new GameMatrix();
	List<Agent> agentList = new ArrayList<>();
	// private ArrayList<Agent> openAgentsList;

	public void runGame(String[] stratList, int numOfRounds, int numOfGames) {
		int idx = 0;
		while (idx < 10 && stratList[idx] != "") {
			agentList.add(agentManager.stringToAgent(stratList[idx]));
			System.out.println(stratList[idx]);
			agentList.get(idx).setId(idx+1);
			idx++;
		}
		for (int gameCount = 1; gameCount <= numOfGames; gameCount++) {
			int count = 0;
			for (Agent agent1 : agentList) {
				for (int index = count; index < agentList.size(); index++) {
					Agent agent2 = agentList.get(index);
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

	public List<Agent> getAgentList() {
		return agentList;
	}

}
