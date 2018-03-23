/**
 * 
 */
package environment;

import java.util.ArrayList;
import java.util.List;

import agent.Agent;
import agent.AgentManager;
import agent.GameMatrix;

/**
 * @author Pedro Freire
 *
 */
public class EnvironmentManager {

	private AgentManager agentManager = new AgentManager();
	private GameMatrix matrix = new GameMatrix();
	List<Agent> agentList = new ArrayList<>();

	public void runGame(List<String> stratList, int numOfRounds, int numOfGames) {
		int idx = 0;
		for (String strat : stratList) {
			agentList.add(agentManager.stringToAgent(strat));
			agentList.get(idx).setId(idx + 1);
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
							runRounds(agent1, agent2, numOfRounds);
						}
					}
				}
				agent1.setAvgUtility();
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

	public void clearAgentList() {
		agentList.clear();
	}

	public List<Agent> getAgentList() {
		return agentList;
	}

}
