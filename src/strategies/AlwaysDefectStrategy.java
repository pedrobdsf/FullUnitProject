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
	
	@Override
	public String choose() {
		return "D";
	}

}
