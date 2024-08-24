package tw.shin.tutor;
//建構式(把物件初始化)
public class Brad18 {

	public static void main(String[] args) {
		Brad183 obj =new Brad183(); 
	}

}


//建構式(帶入我們要印的東西)
class Brad181 {
	Brad181() {
		System.out.println("Brad181()");
	}
}

class Brad182 extends Brad181 {
	Brad182() {
		System.out.println("Brad182()");
	}
}

class Brad183 extends Brad182 {
	Brad183() {
		this(2);  //呼叫下面的int
		System.out.println("Brad183()");
	}
	Brad183(int a) {
		//這邊隱藏的super會跑到182去，最後才跑這邊
		System.out.println("Brad183(int)");
	}
	
	Brad183(String a) {
		
		System.out.println("Brad183(String)");
	}
}
