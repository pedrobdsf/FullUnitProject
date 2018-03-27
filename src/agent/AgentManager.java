/**
 * 
 */
package agent;

import agent.strategies.Adaptive;
import agent.strategies.AlwaysCooperate;
import agent.strategies.AlwaysDefect;
import agent.strategies.Gradual;
import agent.strategies.Grudger;
import agent.strategies.Pavlov;
import agent.strategies.Random;
import agent.strategies.SoftGrudger;
import agent.strategies.TitForTat;
import agent.strategies.TitForTwoTats;

/**
 * A class that contains functionalities that are required by multiple
 * Prisoner's Dilemma game modes.
 * 
 * @author Pedro Freire
 *
 */
public class AgentManager {

	/**
	 * Recognises the name of a strategy and initialises an agent with the desired
	 * strategy.
	 * 
	 * @param strat
	 *          - the name of a strategy
	 * @return an initialised agent with the desired strategy attributed
	 */
	public Agent stringToAgent(String strat) {
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

}
