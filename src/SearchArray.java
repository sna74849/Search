
/**
 * @author http://software-engineering-lab.com/
 *
 */
public abstract class SearchArray implements Search {
	
	/**
	 * 探索対象配列
	 */
	protected String ITEMS[];
	
	/**
	 * @param items 探索対象配列
	 */
	public SearchArray(String items[]) {
		this.ITEMS = items;
	}
}
