/**
 * @author http://software-engineering-lab.com/
 *
 */
public class LinearSearchArray extends SearchArray {

	/**
	 * @param items 探索対象配列
	 */
	public LinearSearchArray(String[] items) {
		super(items);
	}

	/* (non-Javadoc)
	 * @see Search#getIndex(java.lang.String)
	 */
	@Override
	public Integer getIndex(String key) {
		for (int i=0;i<ITEMS.length;i++) {
			if(key.equals(ITEMS[i])) {
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
		Integer per[] = null;
		int ctr = 0;
		for (int i=0;i<ITEMS.length;i++) {
			if(key.equals(ITEMS[i])) {
				// 配列への追加には配列数を再定義する必要があるそのために一時退避
				if(per==null) {
					per = new Integer[ctr+1];
				} else {
					// cloneメソッドでDeepCopy
					Integer tmp[] = per.clone();
					per = new Integer[ctr+1];
					// cloneを使うと配列の数が減るのでループでコピーする
					for(int j=0;j<tmp.length;j++) {
						per[j] = tmp[j];
					}
				}
				per[ctr++] = i;
			}
		}
		return per;
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
}
