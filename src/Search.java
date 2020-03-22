/**
 * @author http://software-engineering-lab.com/
 *
 */
public interface Search {
	
	/**
	 * 探索実行
	 * データの一意制約が担保されているデータストア用
	 * 
	 * @param key 探索対象文字列
	 * @return インデックス
	 */
	public abstract Integer getIndex(String key);
	
	/**
	 * 探索実行
	 * 重複データが存在するデータストア用
	 * 
	 * @param key 探索対象文字列
	 * @return　インデックス配列
	 */
	public abstract Integer[] getIndexes(String key);

	/**
	 * 探索実行
	 * データの存在の有無を返す
	 * 
	 * @param key 探索対象文字列
	 * @return true:対象データあり false:対象データなし
	 */
	public abstract boolean existenceOf(String key);
}
