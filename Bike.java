package tw.brad.apis;

import java.io.Serializable;
//implements Serializable-->沿用49號(序列化)
public class Bike extends Object implements Serializable { //extends Object為源頭，可省略
	protected double speed; 
	//添加public裡面的屬性也可找到,private改為私人,protected:scooter裡extends沿用的可以使用
	
	public Bike() {
		System.out.println("Bike()");
	}//建構式(連接14號檔案)
	
	
	//提供方法:加速.減速
	public void upspeed() {
		speed=speed < 1 ? 1:speed * 1.4;
		
	}
	
	public void downspeed() {
		speed=speed < 1 ? 0:speed * 0.5;
	}
	
	public double getSpeed() {
		 return speed;
		//新增一個可以傳回速度的，在12號檔案，想知道速度時呼叫getSpeed()
	}
	
	@Override
	public String toString() {
		return "I am Bike:" + speed;
	}

	
	
}


