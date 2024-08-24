package tw.shin.tutor;
//try catch
public class Brad35 {

	public static void main(String[] args) {
		int a=10,b=3;  
		int[]d= {1,2,3};
		
		try {//run的時候才會蹦出錯誤，所以先使用try catch
		int c=a/b;   //try:要執行的程式
		System.out.println(c);
		System.out.println(d[12]);
		}catch(ArrayIndexOutOfBoundsException e) { //catch錯誤時要執行的
			System.out.println("Err");
		}catch(ArithmeticException e) {
			System.out.println("Err2");
		}
		catch(RuntimeException e) {
			System.out.println("Err3");
		}
			System.out.println("ok");
	}

}
