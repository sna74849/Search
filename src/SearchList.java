import java.util.List;
/**
 * @author http://software-engineering-lab.com/
 *
 */
public abstract class SearchList implements Search {

	/**
	 * 探索対象リスト
	 */
	protected List<String> itemList;
	
	/**
	 * @param itemList 探索対象リスト
	 */
	public SearchList(List<String> itemList) {
		this.itemList = itemList;
	}
}
