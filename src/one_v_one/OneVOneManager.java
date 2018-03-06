/**
 * 
 */
package one_v_one;

import java.util.Observable;

import javax.swing.JOptionPane;

import agent.Agent;
import agent.AgentManager;
import agent.GameMatrix;

/**
 * @author Pedro Freire
 *
 */
public class OneVOneManager extends Observable {

	private AgentManager agentManager = new AgentManager();
	private GameMatrix matrix = new GameMatrix();
	private Agent agent1;
	private Agent agent2;

	public void runGame(String strat1, String strat2, int numOfRounds) {
		agent1 = agentManager.stringToAgent(strat1);
		agent2 = agentManager.stringToAgent(strat2);
		if (agent1 != null && agent2 != null) {
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
		} else {
			JOptionPane.showMessageDialog(null, "Select two agents.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	public Agent getAgent1() {
		return agent1;
	}

	public Agent getAgent2() {
		return agent2;
	}

}
