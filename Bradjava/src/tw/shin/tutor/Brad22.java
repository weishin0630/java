package tw.shin.tutor;

public class Brad22 {

	public static void main(String[] args) {
		Brad221 obj1= new Brad222(); //我需要那一個介面
		Brad223 obj2= new Brad222();
		Brad222 obj3= new Brad222();
		obj1.m1();obj1.m2(); //221
		obj2.m3();obj2.m4(); //222
		obj3.m1();obj3.m2();obj3.m3();obj3.m4(); //223

	}

}
interface Brad221{
	void m1();
	void m2();
}

interface Brad223{
	void m3();
	void m4();
}

class Brad222 implements Brad221,Brad223{
	public void m1() {}  //介面本身為public，所以需要加入public
	public void m2() {}
	public void m3() {}  //可以有很多個
	public void m4() {}

}