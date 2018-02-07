/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class AlwaysCooperate extends Strategy {

	public AlwaysCooperate() {
		super();
		name = "Always Cooperate";
	}

	@Override
	public void choose() {
		currChoice = "C";
	}

}
