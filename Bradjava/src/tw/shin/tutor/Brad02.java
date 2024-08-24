package tw.shin.tutor;

import java.util.Scanner;  //搭配Scanner(按ctrl+/)

public class Brad02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input輸入
		Scanner scanner =new Scanner(System.in);//System in=Input in		
		
		System.out.print("x= ");
		int x =scanner.nextInt();
		
		System.out.print("y= ");
		int y =scanner.nextInt();
		
		//op..運算
		int r1=x+y;
		int r2=x-y;
		int r3=x*y;
		int r4=x/y;
		int r5=x%y;
		
		
		//output輸出
		//System.out.println(r);		
		System.out.printf("%d+%d=%d\n",x,y,r1);
		System.out.printf("%d-%d=%d\n",x,y,r2);
		System.out.printf("%d*%d=%d\n",x,y,r3);
		System.out.printf("%d/%d=%d......%d",x,y,r4,r5);
		//\n-->一行一行的排列
		//printf-->顯示出x+多少y加多少
		
	}

}
