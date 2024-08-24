package tw.shin.tutor;

//Exception
public class Brad37 {

	public static void main(String[] args) {
		// 這裡如果添加throws Exception在run時還是會出錯
		Brad371 obj = new Brad371();
		try {
			obj.m1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Brad371 {
	void m1() throws Exception {
		System.out.print("Brad371:m1()");
		m2();
	}

	void m2() throws Exception {// throws Exception可以宣告或加入try catch
		System.out.print("Brad371:m2()");
		m3();
	}

	void m3() throws Exception {
		System.out.print("Brad371:m3()");
		throw new Exception();
	}
}