package tw.shin.tutor;

import tw.brad.apis.Bike;
//字串物件，沿用bike
public class Brad16 {

	public static void main(String[] args) {
		String s1=new String();
		System.out.println(s1.length());
		
		byte[] b1= {97,98,99,100};		
		String s2=new String(b1);
		System.out.println(s2.length());
		System.out.println(s2);
		
		Bike b2= new Bike();
		System.out.println(b2); //前面為印出記憶體內容
		
		int c=12;
		System.out.println(c);
		
		
		
		String s3="Brad";
		System.out.println(s3);//s3跟s4使用相同的空間，同內容
		String s4="Brad";
		String s5=new String("Brad"); //利用之前的字串內容產生一個新的空間
		String s6=new String("Brad");//這個也是新的空間
		System.out.println(s3==s5);
		//s3=s4，但s3.4不等於s5.6
		
		System.out.println("Brad".charAt(0)); //字串=物件
		
		
	}

}
