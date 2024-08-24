package tw.shin.tutor;
//finally
public class Brad38 {

	public static void main(String[] args) {
		m1();
		System.out.println("Game Over");
	}
	
	static void m1() {
		System.out.println("1");
		int[] a= {1,2,3,4};
		
		try {
			System.out.println(a[1]);
			System.out.println("Brad"); //這邊出現代表剛剛沒出例外
		}catch(Exception e) {
			System.out.println(e);
			return; //這邊寫上return(可以寫在try跟catch裡面)
		}finally { 
			//finally會在return前就先做這邊
			//但不會做"ok"那邊
			//return寫在這邊代表ok那邊沒有意義
			System.out.println("f");
		}
		System.out.println("OK");
	}

}
