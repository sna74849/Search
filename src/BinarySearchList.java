import java.util.ArrayList;
import java.util.List;
/**
 * @author http://software-engineering-lab.com/
 *
 */
public class BinarySearchList extends SearchList {

	/**
	 * 最小値の初期値
	 */
	final int MIN = 0;
	
	/**
	 * 最大値の初期値
	 */
	final int MAX = itemList.size()-1;

	/**
	 * 探索対象の文字列
	 */
	String target;

	/**
	 * @param itemList
	 */
	public BinarySearchList(List<String> itemList) {
		 super(itemList);
	}

	/* (non-Javadoc)
	 * @see Search#getIndex(java.lang.String)
	 */
	@Override
	public Integer getIndex(String key) {
		target = key;
		return seek(MIN,MAX);
	}

	/* (non-Javadoc)
	 * @see Search#getIndexes(java.lang.String)
	 */
	@Override
	public Integer[] getIndexes(String key) {
		target = key;
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(seek(MIN,MAX));
		// 0件であればばブレークする
		if(lst.get(0)==null) {
			return null;
		}
		
		// ソート順されている前提なので取得した配列の後ろにあるか探索
		for(int i=lst.get(0)+1;i<itemList.size();i++) {
			if(itemList.get(i)==key) {
				lst.add(i);
			} else {
				break;
			}
		}
		// ソート順されている前提なので取得した配列の前ににあるか探索
		for(int i=lst.get(0)-1;i<0;i--) {
			if(itemList.get(i)==key) {
				lst.add(i);
			} else {
				break;
			}
		}
		return lst.toArray(new Integer[lst.size()]);
	}

	/* (non-Javadoc)
	 * @see Search#existenceOf(java.lang.String)
	 */
	@Override
	public boolean existenceOf(String key) {
		if(getIndex(key)!=null) {
			return true;
		}
		return false;
	}

	/**
	 * 再帰的に2分探索を実行
	 * 
	 * @param min
	 * @param max
	 * @return インデックス
	 */
	private Integer seek(int min, int max) {
		if(min > max) {
			return null;
		}
		int i = min + (max - min) / 2;
		if(target.compareTo(itemList.get(i)) < 0) {
			return seek(min,i-1);
		} else if(target.compareTo(itemList.get(i)) > 0) {
			return seek(i+1,max);
		}
		return i;	
	}
}
