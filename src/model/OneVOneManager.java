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

	private GameMatrix matrix;
	private Agent agent1;
	private Agent agent2;

	public void runGame(String strat1, String strat2, int numOfRounds) {
		stringToAgent(agent1, strat1);
		stringToAgent(agent2, strat2);
		if (agent1 != null && agent2 != null) {
			for (int round = 1; round <= numOfRounds; round++) {
				matrix.evaluate(agent1.getStrat().getCurrChoice(), agent2.getStrat().getCurrChoice());
				agent1.incUtility(matrix.getResult1());
				agent2.incUtility(matrix.getResult2());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Select two agents.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		System.out.println(agent1.getUtility());
		System.out.println(agent2.getUtility());
	}

	private void stringToAgent(Agent agent, String strat) {
		switch (strat) {
		case "AlwaysDefect":
			agent = new Agent(new AlwaysDefectStrategy());
			break;
		case "AlwaysCooperate":
			agent = new Agent(new AlwaysCooperateStrategy());
			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid agent selection.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
