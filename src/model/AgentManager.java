/**
 * 
 */
package model;

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
public class AgentManager {
	
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
