package tw.shin.tutor;

import tw.brad.apis.Bike;
import tw.brad.apis.Scooter;
import tw.brad.apis.Car;

public class Brad14 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter ("Red"); //摩托車的第二個建構式
		System.out.println(s1.getColor());
		
		Bike b1 = new Bike();
		
		Car c1=new Car(3); 
		//car檔案沒有建構式，但因為沿用bike跟scooter的建構式，所以car也會有
		
	}

}
