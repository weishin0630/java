package tw.shin.tutor;

import tw.brad.apis.Scooter;

public class Brad13 {

	public static void main(String[] args) {
		Scooter s1=new Scooter(); 
		//↑new格式化.產生物件實體
		//調為1檔		
		s1.changeGear(1);
		s1.upspeed();s1.upspeed();s1.upspeed();
		s1.downspeed();
		System.out.println(s1.getSpeed());
		
		//升級到4檔		
		s1.changeGear(4);
		s1.upspeed();
		s1.downspeed();
		System.out.println(s1.getSpeed());
		//增加顏色
		System.out.println(s1.getColor());
	}

}
