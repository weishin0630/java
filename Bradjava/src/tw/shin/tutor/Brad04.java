package tw.shin.tutor;

public class Brad04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double temp=Math.random();
		
		int score = (int)(temp*101); //-->101為0~100為101個數字 也可改寫為(100)+1 
		//-->先計算temp裡的再把double轉int
		
		System.out.println(score);
		
//		if(score>=90) {
//			System.out.println("Pass");
//		}else {
//		System.out.println("Down");
//		}
			if (score>=90) {
				System.out.println("A");
			}else if(score>=80) {
				System.out.println("B");
			}else if(score>=70) {
				System.out.println("C");
			}else if(score>=60) {
				System.out.println("D");
			}else {System.out.println("E");
			}
				
	
	}
			
}


					

