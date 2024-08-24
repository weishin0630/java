package tw.shin.tutor;

import tw.brad.apis.Bike;

public class Brad12 {
	// Bike
	public static void main(String[] args) {

		Bike myBike = new Bike(); // 已完成初始化(所以已自行帶入預設值0)
		Bike uBike = new Bike(); // 第二個
		System.out.println(myBike.getSpeed()); //呼叫知道速度的getSpeed()
		myBike.upspeed();myBike.upspeed();
		myBike.upspeed();myBike.upspeed();
		myBike.upspeed();myBike.upspeed();
		myBike.upspeed();myBike.upspeed();
		myBike.upspeed();myBike.upspeed();
		myBike.downspeed();
		System.out.println(myBike.getSpeed());
		
		
		System.out.println("---分隔---");
		//第二個
		System.out.println(uBike.getSpeed());
		uBike.upspeed();
		uBike.upspeed();
		uBike.upspeed();
		uBike.downspeed();
		System.out.println(uBike.getSpeed());

	}

}
