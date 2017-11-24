/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class TitForTat extends Strategy {

	public TitForTat() {
		super();
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else {
			currChoice = opponent.getLastChoice();
		}
	}

}