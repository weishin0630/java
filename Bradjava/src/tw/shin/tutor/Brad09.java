package tw.shin.tutor;

public class Brad09 {
//陣列版本的骰子
	public static void main(String[] args) {
		int[] p = new int[7]; //-->宣告有7個值

		for (int i = 0; i < 100; i++) {
			int point = (int) (Math.random() * 6) + 1;  //-->產生變數
			
			if (point >= 1 && point <= 6) {
				p[point]++;
			} else {
				p[0]++;
			}
		}
		System.out.println("---分隔線---");
		//讓骰子多增加7.8.9，但實際7.8.9的數字算在4.5.6裡面
//		for (int i = 0; i < 100; i++) {
//			int point = (int) (Math.random() * 9) + 1; 
//			
//			if (point >= 1 && point <= 9) {
//				p[point>6?point-3:point]++;
//			} else {
//				p[0]++;
//			}
//		}
		
		System.out.println("---分隔線---");
	
		
		
		
		if (p[0] > 0) {
			System.out.println("Err");
		} else {
			for (int i = 1; i < p.length; i++) {
				System.out.printf("%d點出現%d次\n", i, p[i]);
			
			}
		}

	}
}
