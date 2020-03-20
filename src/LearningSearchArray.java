import java.util.ArrayList;
import java.util.List;
/**
 * @author http://software-engineering-lab.com/
 * 
 */
public class LearningSearchArray extends SearchArray {

	/**
	 * 線形探索オブジェクト
	 */
	Search linearSerch;
	
	/**
	 * 2分探索オブジェクト
	 */
	Search binarySerch;
	
	/**
	 * 線形探索を実行するデータのリスト
	 */
	static List<String> linearList = new ArrayList<String>();
	
	/**
	 * @param items 探索対象配列
	 */
	public LearningSearchArray(String[] items) {
		super(items);
		learn(items);
	}
	
	/**
	 * 動作確認用のmainルーチン
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * カラーネーム147色配列(ソート済み)
		 */
		final String items[] = {"AliceBlue","AntiqueWhite","Aqua","Aquamarine","Azure","Beige","Bisque","Black","BlanchedAlmond","Blue","BlueViolet","Brown","BurlyWood","CadetBlue","Chartreuse","Chocolate","Coral","CornflowerBlue","Cornsilk","Crimson","Cyan","DarkBlue","DarkCyan","DarkGoldenRod","DarkGray","DarkGrey","DarkSeaGreen","DarkKhaki","DarkKhaki","DarkMagenta","DarkOliveGreen","DarkOrange","DarkOrchid","DarkRed","DarkSalmon","DarkSeaGreen","DarkSlateBlue","DarkSlateGray","DarkSlateGrey","DarkTurquoise","DarkViolet","DeepPink","DeepSkyBlue","DimGray","DimGrey","DodgerBlue","FireBrick","FloralWhite","ForestGreen","Fuchsia","Gainsboro","GhostWhite","Gold","GoldenRod","Gray","Grey","Green","GreenYellow","HoneyDew","HotPink","IndianRed","Indigo","Ivory","Khaki","Lavender","LavenderBlush","LawnGreen","LemonChiffon","LightBlue","LightCoral","LightCyan","LightGoldenRodYellow","LightGray","LightGrey","LightGreen","LightPink","LightSalmon","LightSeaGreen","LightSkyBlue","LightSlateGray","LightSlateGrey","LightSteelBlue","LightYellow","Lime","LimeGreen","Linen","Magenta","Maroon","MediumAquaMarine","MediumBlue","MediumOrchid","MediumPurple","MediumSeaGreen","MediumSlateBlue","MediumSpringGreen","MediumTurquoise","MediumVioletRed","MidnightBlue","MintCream","MistyRose","Moccasin","NavajoWhite","Navy","OldLace","Olive","OliveDrab","Orange","OrangeRed","Orchid","PaleGoldenRod","PaleGreen","PaleTurquoise","PaleVioletRed","PapayaWhip","PeachPuff","Peru","Pink","Plum","PowderBlue","Purple","RebeccaPurple","Red","RosyBrown","RoyalBlue","SaddleBrown","Salmon","SandyBrown","SeaGreen","SeaShell","Sienna","Silver","SkyBlue","SlateBlue","SlateGray","SlateGrey","Snow","SpringGreen","SteelBlue","Tan","Teal","Thistle","Tomato","Turquoise","Violet","Wheat","White","WhiteSmoke","Yellow","YellowGreen"};

		String key = "DeepSkyBlue";
		Search srch = new LearningSearchArray(items).create(key);
		System.out.println(srch.toString()+":"+getSearchTime(key,srch)+"ms");
	}

	/**
	 *  線形探索と2分探索のどちらが早いかをあらかじめデータより学習
	 * 
	 * @param items 探索対象配列
	 */
	public void learn(String[] items){
		linearSerch = new LinearSearchArray(items);
		binarySerch = new BinarySearchArray(items);
		System.out.print("Learning Now");
		for (String string : items) {
			if(getSearchTime(string,linearSerch) < getSearchTime(string,binarySerch)) {
				linearList.add(string);
				System.out.print('.');
			}
		}
		System.out.println("OK");
	}
	
	/**
	 * @param key　探索対象文字列
	 * @return 最適なサーチオブジェクト
	 */
	public Search create(String key) {
		if(linearList.contains(key)) {
			return linearSerch;
		}
		return binarySerch;
	}
	
	/**
	 * 探索時間計測
	 * @param key 探索対象文字列
	 * @param srch サーチオブジェクト
	 * @return 探索時間
	 */
	private static long getSearchTime(String key, Search srch) {
		/**
		 * ループの最大値 
		 */
		final int LOOP_MAX = 1000000;
		
		// 処理前の時刻を取得
        long startTime = System.currentTimeMillis();
        // 1回ではすぐに終了してしまうため複数回実行する
        for (int i=0;i<LOOP_MAX;i++) {
        	srch.getIndex(key);
		}
        // 処理後の時刻を取得
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
	}

	/* (non-Javadoc)
	 * @see Search#getIndex(java.lang.String)
	 */
	@Override
	public Integer getIndex(String key) {
		return create(key).getIndex(key);
	}

	/* (non-Javadoc)
	 * @see Search#getIndexes(java.lang.String)
	 */
	@Override
	public Integer[] getIndexes(String key) {
		return binarySerch.getIndexes(key);
	}

	/* (non-Javadoc)
	 * @see Search#existenceOf(java.lang.String)
	 */
	@Override
	public boolean existenceOf(String key) {
		return create(key).existenceOf(key);
	}
}
