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
	
	@Override
	public String choose() {
		return "C";
	}

}
