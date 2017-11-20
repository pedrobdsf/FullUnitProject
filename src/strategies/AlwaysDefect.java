/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class AlwaysDefect extends Strategy {

	public AlwaysDefect() {
		super();
	}

	@Override
	public void choose() {
		currChoice = "D";
	}

}
