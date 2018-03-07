/**
 * 
 */
package tournament;

import java.util.List;
import java.util.Observable;

import agent.Agent;
import agent.AgentManager;
import agent.GameMatrix;

/**
 * @author Pedro Freire
 *
 */
public class TournamentManager extends Observable {

	private AgentManager agentManager = new AgentManager();
	private GameMatrix matrix = new GameMatrix();
	private Agent[] agentList;

	public void runGame(List<String> stratList, int numOfRounds) {
		agentList = new Agent[stratList.size()];
		for (int index = 0; index < agentList.length; index++) {
			agentList[index] = agentManager.stringToAgent(stratList.get(index));
		}
		for (Agent agent1 : agentList) {
			for (Agent agent2 : agentList) {
				if (agent1 != null && agent2 != null && agent1 != agent2) {
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
					agent1.reset();
					agent2.reset();
					System.out.println();
				}
			}
		}
	}

	public Agent[] getAgentList() {
		return agentList;
	}

}
