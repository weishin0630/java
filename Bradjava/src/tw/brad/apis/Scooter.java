package tw.brad.apis;

public class Scooter extends Bike {// extends-->延伸.擴大
//↑上面的類別只有沒寫跟public	
	private int gear; // 增加檔位
	private String color;
	
	public Scooter() {
		System.out.println("Scooter()");//(無傳參數建構式)
		color="Yellow";
	} //建構式1(進行物件初始化)
	
	public Scooter(String color) {
		//super() 引用Bike的建構式
		System.out.println("Scooter(String)");
	this.color=color; 
	} //建構式2(長相方法一樣)
	
	
	//在JAVA裡，所有類別「一定」有建構式
	//但不一定有定義
	//沒有定義建構式，沿用父類別的建構式
		

	// 檔位
	public void changeGear(int gear) {
		if (gear >= 0 && gear <= 4) {
			this.gear = gear; // this-->使用上面void那裡的gear參數
		}
	}

	// 速度
	public void upSpeed() {
//		super.upspeed(); //super是父類別
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed * 1.8 * gear;
		}
	}

	// 顏色
	public String getColor() {
		return color;
	}

}
