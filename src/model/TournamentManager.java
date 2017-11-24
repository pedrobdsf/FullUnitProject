/**
 * 
 */
package model;

import java.util.Observable;

import strategies.Adaptive;
import strategies.AlwaysCooperate;
import strategies.AlwaysDefect;
import strategies.Gradual;
import strategies.Grudger;
import strategies.Pavlov;
import strategies.Random;
import strategies.SoftGrudger;
import strategies.TitForTat;
import strategies.TitForTwoTats;

/**
 * @author Pedro Freire
 *
 */
public class TournamentManager extends Observable {

	private GameMatrix matrix = new GameMatrix();
	private Agent[] agentList;

	public void runGame(String[] stratList, int numOfRounds) {
		agentList = new Agent[stratList.length];
		for (int num = 0; num < agentList.length; num++) {
			agentList[num] = stringToAgent(stratList[num]);
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

	private Agent stringToAgent(String strat) {
		switch (strat) {
		case "Adaptive":
			return new Agent(new Adaptive());
		case "Always Defect":
			return new Agent(new AlwaysDefect());
		case "Always Cooperate":
			return new Agent(new AlwaysCooperate());
		case "Gradual":
			return new Agent(new Gradual());
		case "Grudger":
			return new Agent(new Grudger());
		case "Pavlov":
			return new Agent(new Pavlov());
		case "Random":
			return new Agent(new Random());
		case "Soft Grudger":
			return new Agent(new SoftGrudger());
		case "Tit For Tat":
			return new Agent(new TitForTat());
		case "Tit For Two Tats":
			return new Agent(new TitForTwoTats());
		default:
			return null;
		}
	}

	public Agent[] getAgentList() {
		return agentList;
	}

}
