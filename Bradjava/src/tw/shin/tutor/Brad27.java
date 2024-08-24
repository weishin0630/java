package tw.shin.tutor;
//HashSet
import java.util.HashSet;
import tw.brad.apis.Bike;

public class Brad27 {

	public static void main(String[] args) {
		HashSet set=new HashSet();//HashSet 效能較好
		
		set.add("Brad");
		set.add(12);  //把int進行auto-boxing 物件實體
		//12-->new Integer(12)
		set.add(12.3);
		set.add("Brad");
		set.add(new Bike());
		set.add(12);
		
		System.out.println(set.size()); //不重複
		System.out.println(set); //無順序
		
		
	}

}
