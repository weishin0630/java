package tw.shin.tutor;

public class Brad19 {
	public static void main(String[] args) {
		Brad191 obj1=new Brad191();
		obj1.m1();obj1.m2();
		
		Brad192 obj2=new Brad192();
		obj2.m1();obj2.m2();obj2.m3();
		
		Brad191 obj3= new Brad192(); 
		obj3.m1();obj3.m2();
		//宣告一個新的191-obj3但使用192的方式初始化
		//沿用的是191的方法不會是192
		//型別轉換
		//Brad191 obj3:宣告
				
		Brad192 obj4=(Brad192)obj3;
		obj4.m1();obj4.m2();obj4.m3();
		//強制轉型
		//所以192的方法全都可以使用
		
//		Brad192 obj5 =(Brad192)(new Brad193()); 
//		Brad193 obj6=new Brad192();  //沒關西語法會直接出錯
		//只有直系(父類別)才有關係，就算強制轉換也不行
		
		Brad191 obj7=new Brad192();
//		Brad193 obj8=(Brad193)obj7; //於執行階段會顯示類別出錯
		//強制轉型為另一個東西
		
//		if(obj7 instanceof object) {
//			System.out.println("Yes1");
//		}else {
//			System.out.println("No1");
//		}				
		
	}
}


class Brad191{
	void m1() {
		System.out.println("Brad191:m1()");
	}
	void m2() {
		System.out.println("Brad191:m2()");
	}
}
class Brad192 extends Brad191{
	void m2() {//改寫父類別的方法
		System.out.println("Brad192:m2()");
	}
	void m3() {
		System.out.println("Brad192:m3()");
	}
}
class Brad193 extends Brad191{//從192複製來的193(同輩)
	void m2() {
		System.out.println("Brad193:m2()");
	}
	void m3() {
		System.out.println("Brad193:m3()");
	}
}