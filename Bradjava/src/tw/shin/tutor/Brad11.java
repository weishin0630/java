package tw.shin.tutor;

public class Brad11 {
//交換數值
	public static void main(String[] args) {
		int a = 10, b = 3;
		// 第一種:宣告第三種變數
		int c = a;
		a = b;
		b = c;
		// 第二種:
		a = a + b; // 10+3 a=13
		b = a - b; // 13-3 b=10
		a = a - b; // 13-10 a=3
		System.out.printf("a=%d,b=%d", a, b);
		

	}

}
