package tw.shin.tutor;
//overload-覆載
//override-覆寫
public class Brad25 {

	public static void main(String[] args) {
		

	}

}
class Brad251{
	void m1() {}
	void m1(int a) {}
	public int m1(double a) {return 1;}
	protected Object m2() {return new Object();}
}
class Brad252 extends Brad251{
	public String m2() {     //Object=String(延伸)
		return "";		
//有延伸就可以(比父類別做的更多更大)private的話就是不給別人使用，就沒有override
	}
}