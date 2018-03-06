/**
 * 
 */
package agent.strategies;

/**
 * @author Pedro Freire
 *
 */
public class AlwaysDefect extends Strategy {

	public AlwaysDefect() {
		super();
		name = "Always Defect";
	}

	@Override
	public void choose() {
		currChoice = "D";
	}

}
