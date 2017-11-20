/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class Random extends Strategy {

	public Random() {
		super();
	}

	@Override
	public void choose() {
		if (Math.random() < 0.5) {
			currChoice = "C";
		} else {
			currChoice = "D";
		}
	}
}
