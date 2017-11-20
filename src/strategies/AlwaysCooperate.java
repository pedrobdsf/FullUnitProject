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
	}

	@Override
	public void choose() {
		currChoice = "C";
	}

}
