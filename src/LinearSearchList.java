import java.util.ArrayList;
import java.util.List;

/**
 * @author http://software-engineering-lab.com/
 *
 */
public class LinearSearchList extends SearchList {
	
	/**
	 * @param itemList
	 */
	public LinearSearchList(List<String> itemList) {
		super(itemList);
	}

	/* (non-Javadoc)
	 * @see Search#getIndex(java.lang.String)
	 */
	@Override
	public Integer getIndex(String key) {
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).equals(key)) {
				return i;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see Search#getIndexes(java.lang.String)
	 */
	@Override
	public Integer[] getIndexes(String key) {
		List<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).equals(key)) {
				lst.add(i);
			}
		}
		return lst.toArray(new Integer[lst.size()]);
	}

	/* (non-Javadoc)
	 * @see Search#existenceOf(java.lang.String)
	 */
	@Override
	public boolean existenceOf(String key) {
		if(getIndex(key)==null) {
			return false;
		}
		return true;
	}
}
