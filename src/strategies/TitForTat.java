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
		name = "Tit For Tat";
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
