/**
 * 
 */
package tournament;

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
public class TournamentManager extends Observable {

	private AgentManager agentManager = new AgentManager();
	private GameMatrix matrix = new GameMatrix();
	private List<Agent> agentList = new ArrayList<>();;

	public void runGame(List<String> stratList, int numOfRounds) {
		int idx = 0;
		for (String strat : stratList) {
			agentList.add(agentManager.stringToAgent(strat));
			agentList.get(idx).setId(idx + 1);
			idx++;
		}
		int count = 0;
		for (Agent agent1 : agentList) {
			for (int index = count; index < agentList.size(); index++) {
				Agent agent2 = agentList.get(index);
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
					agent1.mapOpponent(agent2, agent1.getGameUtility() / numOfRounds);
					agent2.mapOpponent(agent1, agent2.getGameUtility() / numOfRounds);
					agent1.reset();
					agent2.reset();
					System.out.println();
				}
			}
			count++;
		}
	}
	
	public void clearAgentList() {
		agentList.clear();
	}

	public List<Agent> getAgentList() {
		return agentList;
	}

}
