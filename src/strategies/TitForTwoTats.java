/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class TitForTwoTats extends Strategy {

	private String lastOppChoice;

	public TitForTwoTats() {
		super();
		name = "Tit For Two Tats";
	}

	@Override
	public void choose() {
		if (opponent.getLastChoice() == null) {
			currChoice = "C";
		} else if (opponent.getLastChoice().equals(lastOppChoice)) {
			currChoice = opponent.getLastChoice();
		} else {
			lastOppChoice = opponent.getLastChoice();
		}
	}

}
