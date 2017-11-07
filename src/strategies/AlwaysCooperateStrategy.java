/**
 * 
 */
package strategies;

/**
 * @author Pedro Freire
 *
 */
public class AlwaysCooperateStrategy extends Strategy{
	
	public AlwaysCooperateStrategy() {
		super();
	}
	
	public void choose() {
		currChoice = "C";
	}

}
