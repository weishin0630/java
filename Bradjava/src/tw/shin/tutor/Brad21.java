package tw.shin.tutor;

//抽象abstract
public class Brad21 {

	public static void main(String[] args) {
		Brad211 obj1=new Brad211() {//一個抽象類別無法直接建構物件實體
			//但可直接馬上實作(偏向於一次性使用)
			@Override
			void m2() {
				System.out.println("Brad211:m2()");
				}			
		}; 
		obj1.m1();obj1.m2();

		//第二種方法(可以寫較多)
		Brad211 obj2 = new Brad212();
		obj2.m1();
		obj2.m2(); // m1為繼承,m2為自己

	}

}

abstract class Brad211 { // 這邊需要對外宣告，是抽象的類別
	void m1() {
		System.out.println("Brad211:m1()");
	}

	abstract void m2(); // 抽象的方法類別(須對外宣告)
}

class Brad212 extends Brad211 {
	void m2() {
		System.out.println("Brad212:m2()");
	}
}

class Brad213 extends Brad211 {
	void m2() {
		System.out.println("Brad213:m2()");
	}
}
