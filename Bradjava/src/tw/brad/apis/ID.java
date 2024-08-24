package tw.brad.apis;

import java.util.Random;


//台灣身分證類別

public class ID {
	private String id; // id內容不會改變，因使用String
	static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

	
	//隨機產生
	public ID() {
		this(new Random().nextInt(2)==0); //呼叫本類別的其他建構式
	}
	public ID(boolean isMale) {
		this(isMale, letters.charAt(new Random().nextInt(26)));
	}
	public ID(char area) {
		this(new Random().nextInt(2)==0,area);
	}
	public ID(boolean isMale,char area) {
		String c1=new String(new char[] {area});
		StringBuffer sb=new StringBuffer(c1);
		sb.append(isMale?"1":"2");
		for(int i=0; i<7; i++)sb.append(new Random().nextInt(10));
		
		for(int i=0;i<10;i++)
			if(isRight(sb.toString()+i)) {
				id=sb.toString()+i;
				break;
			}
	}
	//引用34號檔案
//	public ID(String id) throws Exception{
//		if(isRight(id)) {
//			this.id=id;
//		}else {
//			throw new Exception();
//		}
//	}
	//引用34號檔案
	
	//原本
	private ID(String id) {
		this.id=id;
	}
	
	public static ID newID(String id) {
		if(isRight(id)) {
			return new ID(id);
		}else {
			return null;
		}
	}
	//原本
	
	
	public String getID() {
		return id;
	}
	
	
	
	

	// 判斷id是否正確合理 //static放哪個類別沒有差別
	public static boolean isRight(String id) { // 這邊的id是呼叫使用
		boolean isRight = false; // 預設為錯誤，以致結果為正確
//		String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; //-->區域(獨立這區使用)
//回家功課:使用字串
//		if (id.length() == 10) { // 判斷是否為10碼
////			isRight=true;
////		}else { //如果不是，那是多少
////			System.out.println(id.length());
////		}
//			if (letters.indexOf(id.charAt(0)) != -1) {
//				if (id.charAt(1) == '1' || id.charAt(1) == '2') {// 判斷是男還是女
//
//				}
//			}
//		}
		// 使用正規化表示法
		if (id.matches("[A-Z][12][0-9]{8}")) {
			char c1 = id.charAt(0);
			int a12 = letters.indexOf(c1) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10; // a1.2為驗證碼數字

			String s1 = id.substring(1, 2); // 第10碼驗證碼
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));

			int sum = a1 * 1 + a2 * 9 + n1 * 8 + n2 * 7 + n3 * 6 
			+ n4 * 5 + n5 * 4 + n6 * 3 + n7 * 2 + n8 * 1 + n9 * 1;
		
			isRight=sum % 10 == 0; //被10整除要是0
		}
		return isRight;
	}

}
