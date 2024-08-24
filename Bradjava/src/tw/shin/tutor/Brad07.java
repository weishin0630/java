package tw.shin.tutor;

public class Brad07 {

	public static void main(String[] args) {
		int[] ary1;  //除基本型別可以直接丟數字，其餘都需要創建一個物件才丟
		ary1=new int[3]; //把3進行初始化(第一次給值就叫初始化)=有三個空間
		System.out.println(ary1[0]);
		System.out.println(ary1[1]);  //代表位置，從0開始計算
		System.out.println(ary1[2]);
		System.out.println(ary1.length);
		System.out.println("---分隔線---");
		ary1[1]=100;
		ary1[2]=123;
//		ary1[3000]=44;
		for(int i=0;i<ary1.length;i++) {
			System.out.println(ary1[i]);  //尋訪元素
		}
		System.out.println("---分隔線---");
		for(int v:ary1) {   //(元素型別 命名:要尋訪的對象)
			System.out.println(v);
		}    //針對每個元素尋訪
		System.out.println("---分隔線---");
		
		byte[]ary2;
		ary2=new byte[2];
		System.out.println(ary2[0]);   //基本型別的測出來都會是0
		
		boolean[]ary3;
		ary3=new boolean[2];
		System.out.println(ary3[0]);  //布林值出來的會是false
		
		
		
		

	}

}
