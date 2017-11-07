/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class AlwaysDefectStrategy extends Strategy{
	
	public AlwaysDefectStrategy() {
		super();
	}
	
	public void choose() {
		currChoice = "D";
	}

}
