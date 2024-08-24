package tw.shin.tutor;
//取出數字
//TreeSet有順序性.不重複
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Brad28 {
//威力彩號碼(不重複)  //先有Integer才有辦法使用TreeSet大到小排列
	public static void main(String[] args) {
		TreeSet<Integer> power=new TreeSet<Integer>();//<>-->代表可以使用for each
//		set.add(12);
//		set.add(127);
//		set.add(125);
//		set.add((byte)12); //沒有辦法自動轉型
		while (power.size()<6) {
			power.add(new Random().nextInt(1,39));
		}
		System.out.println(power);
		System.out.println("---分隔線---");
		//取出數字
		Iterator<Integer> it= power.iterator(); //泛型:<>，it:迭代器
		while(it.hasNext()) {  //使用power.帶出來
			Integer num=it.next();
			System.out.println(num);
		}
		System.out.println("---分隔線---");
		//這邊使用陣列一樣的方法取出數字
		for(Integer v:power) {
			System.out.println(v);
		}
	}

}
