import java.util.ArrayList;
import java.util.List;
/**
 * @author http://software-engineering-lab.com/
 *
 */
public class TestSearch {

	/**
	 *  テストデータの列挙型
	 *
	 */
	enum TestCase {
		LOWEST_CASE("AliceBlue"),
		QUARTER_CASE("DarkSeaGreen"),
		MULTIPLE_CASE("DarkKhaki"),
		NONEXISTENCE_CASE("nonexistence");
		
		String value;
		
		TestCase(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
	}
		
	/**
	 * カラーネーム147色配列(ソート済み)
	 */
	private static final String ITEMS[] = {TestCase.LOWEST_CASE.getValue(),"AntiqueWhite","Aqua","Aquamarine","Azure","Beige","Bisque","Black","BlanchedAlmond","Blue","BlueViolet","Brown","BurlyWood","CadetBlue","Chartreuse","Chocolate","Coral","CornflowerBlue","Cornsilk","Crimson","Cyan","DarkBlue","DarkCyan","DarkGoldenRod","DarkGray","DarkGrey",TestCase.QUARTER_CASE.getValue(),TestCase.MULTIPLE_CASE.getValue(),TestCase.MULTIPLE_CASE.getValue(),"DarkMagenta","DarkOliveGreen","DarkOrange","DarkOrchid","DarkRed","DarkSalmon","DarkSeaGreen","DarkSlateBlue","DarkSlateGray","DarkSlateGrey","DarkTurquoise","DarkViolet","DeepPink","DeepSkyBlue","DimGray","DimGrey","DodgerBlue","FireBrick","FloralWhite","ForestGreen","Fuchsia","Gainsboro","GhostWhite","Gold","GoldenRod","Gray","Grey","Green","GreenYellow","HoneyDew","HotPink","IndianRed","Indigo","Ivory","Khaki","Lavender","LavenderBlush","LawnGreen","LemonChiffon","LightBlue","LightCoral","LightCyan","LightGoldenRodYellow","LightGray","LightGrey","LightGreen","LightPink","LightSalmon","LightSeaGreen","LightSkyBlue","LightSlateGray","LightSlateGrey","LightSteelBlue","LightYellow","Lime","LimeGreen","Linen","Magenta","Maroon","MediumAquaMarine","MediumBlue","MediumOrchid","MediumPurple","MediumSeaGreen","MediumSlateBlue","MediumSpringGreen","MediumTurquoise","MediumVioletRed","MidnightBlue","MintCream","MistyRose","Moccasin","NavajoWhite","Navy","OldLace","Olive","OliveDrab","Orange","OrangeRed","Orchid","PaleGoldenRod","PaleGreen","PaleTurquoise","PaleVioletRed","PapayaWhip","PeachPuff","Peru","Pink","Plum","PowderBlue","Purple","RebeccaPurple","Red","RosyBrown","RoyalBlue","SaddleBrown","Salmon","SandyBrown","SeaGreen","SeaShell","Sienna","Silver","SkyBlue","SlateBlue","SlateGray","SlateGrey","Snow","SpringGreen","SteelBlue","Tan","Teal","Thistle","Tomato","Turquoise","Violet","Wheat","White","WhiteSmoke","Yellow","YellowGreen"};

	/**
	 * カラーネーム147色リスト(ソート済み)
	 */
	@SuppressWarnings("serial")
	private static final List<String> ITEM_LIST = new ArrayList<String>() {{add(TestCase.LOWEST_CASE.getValue());add("AntiqueWhite");add("Aqua");add("Aquamarine");add("Azure");add("Beige");add("Bisque");add("Black");add("BlanchedAlmond");add("Blue");add("BlueViolet");add("Brown");add("BurlyWood");add("CadetBlue");add("Chartreuse");add("Chocolate");add("Coral");add("CornflowerBlue");add("Cornsilk");add("Crimson");add("Cyan");add("DarkBlue");add("DarkCyan");add("DarkGoldenRod");add("DarkGray");add("DarkGrey");add(TestCase.QUARTER_CASE.getValue());add(TestCase.MULTIPLE_CASE.getValue());add(TestCase.MULTIPLE_CASE.getValue());add("DarkMagenta");add("DarkOliveGreen");add("DarkOrange");add("DarkOrchid");add("DarkRed");add("DarkSalmon");add("DarkSeaGreen");add("DarkSlateBlue");add("DarkSlateGray");add("DarkSlateGrey");add("DarkTurquoise");add("DarkViolet");add("DeepPink");add("DeepSkyBlue");add("DimGray");add("DimGrey");add("DodgerBlue");add("FireBrick");add("FloralWhite");add("ForestGreen");add("Fuchsia");add("Gainsboro");add("GhostWhite");add("Gold");add("GoldenRod");add("Gray");add("Grey");add("Green");add("GreenYellow");add("HoneyDew");add("HotPink");add("IndianRed");add("Indigo");add("Ivory");add("Khaki");add("Lavender");add("LavenderBlush");add("LawnGreen");add("LemonChiffon");add("LightBlue");add("LightCoral");add("LightCyan");add("LightGoldenRodYellow");add("LightGray");add("LightGrey");add("LightGreen");add("LightPink");add("LightSalmon");add("LightSeaGreen");add("LightSkyBlue");add("LightSlateGray");add("LightSlateGrey");add("LightSteelBlue");add("LightYellow");add("Lime");add("LimeGreen");add("Linen");add("Magenta");add("Maroon");add("MediumAquaMarine");add("MediumBlue");add("MediumOrchid");add("MediumPurple");add("MediumSeaGreen");add("MediumSlateBlue");add("MediumSpringGreen");add("MediumTurquoise");add("MediumVioletRed");add("MidnightBlue");add("MintCream");add("MistyRose");add("Moccasin");add("NavajoWhite");add("Navy");add("OldLace");add("Olive");add("OliveDrab");add("Orange");add("OrangeRed");add("Orchid");add("PaleGoldenRod");add("PaleGreen");add("PaleTurquoise");add("PaleVioletRed");add("PapayaWhip");add("PeachPuff");add("Peru");add("Pink");add("Plum");add("PowderBlue");add("Purple");add("RebeccaPurple");add("Red");add("RosyBrown");add("RoyalBlue");add("S;addleBrown");add("Salmon");add("SandyBrown");add("SeaGreen");add("SeaShell");add("Sienna");add("Silver");add("SkyBlue");add("SlateBlue");add("SlateGray");add("SlateGrey");add("Snow");add("SpringGreen");add("SteelBlue");add("Tan");add("Teal");add("Thistle");add("Tomato");add("Turquoise");add("Violet");add("Wheat");add("White");add("WhiteSmoke");add("Yellow");add("YellowGreen");}};
	
	/**
	 * カラーネームW3C基本16色(非ソート)
	 */
	//static final String ITEMS[] = {"black","gray","silver","white","blue","navy","teal","green","lime","aqua","yellow","red","fuchsia","olive","purple","maroon"};
	
	/**
	 * サーチオブジェクト
	 */
	private static Search srch = new LearningSearchArray(ITEMS);
	
	/**
	 * ループの最大値 
	 */
	private static final int LOOP_MAX = 1000000;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(srch.toString());
		
		// データ集合において一意制約が担保されているケース
		System.out.print(TestCase.LOWEST_CASE.toString());
		getIndex(TestCase.LOWEST_CASE.getValue());
		System.out.print(TestCase.QUARTER_CASE.toString());
		getIndex(TestCase.QUARTER_CASE.getValue());
		System.out.print(TestCase.NONEXISTENCE_CASE);
		getIndex(TestCase.NONEXISTENCE_CASE.getValue());
		
		System.out.println();
		
		// データ集合において複数件の重複が送りうるケース
		System.out.print(TestCase.MULTIPLE_CASE.toString());
		getIndexes(TestCase.MULTIPLE_CASE.getValue());
		System.out.print(TestCase.NONEXISTENCE_CASE);
		getIndexes(TestCase.NONEXISTENCE_CASE.getValue());
		
		System.out.println();
		
		// 探索対象データがないケース
		System.out.print(TestCase.LOWEST_CASE.toString());
		existenceOf(TestCase.LOWEST_CASE.getValue());
		System.out.print(TestCase.QUARTER_CASE.toString());
		existenceOf(TestCase.QUARTER_CASE.getValue());
		System.out.print(TestCase.NONEXISTENCE_CASE);
		existenceOf(TestCase.NONEXISTENCE_CASE.getValue());
	}
	
	/**
	 * 探索実行
	 * データの一意制約が担保されているデータストア用
	 * 
	 * @param key　探索対象文字列
	 */
	public static void getIndex(String key) {
		// 処理前の時刻を取得
        long startTime = System.currentTimeMillis();
        // 1回ではすぐに終了してしまうため複数回実行する
        for (int i=0;i<LOOP_MAX;i++) {
        	srch.getIndex(key);
		}
        // 処理後の時刻を取得
        long endTime = System.currentTimeMillis();
        System.out.println(" getIndexの処理時間：" + (endTime - startTime) + "ms");
	}
	
	/**
	 * 探索実行
	 * 重複データが存在するデータストア用
	 * 
	 * @param key 探索対象文字列
	 */
	private static void getIndexes(String key) {
		// 処理前の時刻を取得
        long startTime = System.currentTimeMillis();
        // 1回ではすぐに終了してしまうため複数回実行する
        for (int i=0;i<LOOP_MAX;i++) {
        	srch.getIndexes(key);
		}
        // 処理後の時刻を取得
        long endTime = System.currentTimeMillis();
        System.out.println(" getIndexesの処理時間：" + (endTime - startTime) + "ms");
	}
	
	/**
	 * 探索実行
	 * データの存在の有無を返す
	 * 
	 * @param key 探索対象文字列
	 */
	private static void existenceOf(String key) {
		// 処理前の時刻を取得
        long startTime = System.currentTimeMillis();
        // 1回ではすぐに終了してしまうため複数回実行する
        for (int i=0;i<LOOP_MAX;i++) {
        	srch.existenceOf(key);
		}
        // 処理後の時刻を取得
        long endTime = System.currentTimeMillis();
        System.out.println(" existenceOfの処理時間：" + (endTime - startTime) + "ms");
	}
}
