/**
 * 
 */
package model;

import java.util.Observable;

import javax.swing.JOptionPane;

import strategies.AlwaysCooperateStrategy;
import strategies.AlwaysDefectStrategy;

/**
 * @author Pedro Freire
 *
 */
public class OneVOneManager extends Observable {

	private GameMatrix matrix = new GameMatrix();
	private Agent agent1;
	private Agent agent2;

	public void runGame(String strat1, String strat2, int numOfRounds) {
		agent1 = stringToAgent(strat1);
		agent2 = stringToAgent(strat2);
		if (agent1 != null && agent2 != null) {
			agent1.setOpponent(agent2);
			agent2.setOpponent(agent1);
			for (int round = 1; round <= numOfRounds; round++) {
				matrix.evaluate(agent1.getStrat().choose(), agent2.getStrat().choose());
				agent1.incUtility(matrix.getResult1());
				agent2.incUtility(matrix.getResult2());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Select two agents.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	private Agent stringToAgent(String strat) {
		switch (strat) {
		case "Always Defect":
			return new Agent(new AlwaysDefectStrategy());
		case "Always Cooperate":
			return new Agent(new AlwaysCooperateStrategy());
		default:
			JOptionPane.showMessageDialog(null, "Invalid agent selection.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public Agent getAgent1() {
		return agent1;
	}
	
	public Agent getAgent2() {
		return agent2;
	}

}
