/**
 * @author http://software-engineering-lab.com/
 *
 */
public class BinarySearchArray extends SearchArray {
	
	/**
	 * 最小値の初期値
	 */
	final int MIN = 0;
	
	/**
	 * 最大値の初期値
	 */
	final int MAX = items.length-1;

	/**
	 * 探索対象の文字列
	 */
	String target;
	
	/**
	 * @param items 探索対象配列
	 */
	public BinarySearchArray(String[] items) {
		super(items);
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
		Integer tmp = seek(MIN,MAX);
		// 0件であればばブレークする
		if(tmp==null) {
			return null;
		}
		// ソート順されている前提なので取得した配列の後ろにあるか探索
		int ctrOne = 0;
		for(int i=tmp+1;i<items.length;i++) {
			if(items[i]==key) {
				ctrOne++;
			} else {
				break;
			}
		}
		// ソート順されている前提なので取得した配列の前ににあるか探索
		int ctrTwo = 0;
		for(int i=tmp-1;i<0;i--) {
			if(items[i]==key) {
				ctrTwo++;
			} else {
				break;
			}
		}
		// 引数用の配列を定義する
		Integer per[] = new Integer[1+ctrOne+ctrTwo];
		per[0] = tmp;
		// 後ろにあったものを入れる
		for(int i=1;i<=ctrOne;i++) {
			per[i] = tmp + i; 
		}
		// 前にあったものを入れる
		for(int i=1;i<=ctrTwo;i++) {
			per[i+ctrOne] = tmp - i; 
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
		if(target.compareTo(items[i]) < 0) {
			return seek(min,i-1);
		} else if(target.compareTo(items[i]) > 0) {
			return seek(i+1,max);
		}
		return i;	
	}
}
