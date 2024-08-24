package tw.shin.tutor;
//LinkedList排序位置
import java.util.LinkedList;
import java.util.List;

public class Brad31 {

	public static void main(String[] args) {
		List<String> times=new LinkedList<String>();
		//前面加入0,即可把每一個搶在前面
		times.add(0,"10:20:30");  
		times.add(0,"10:20:34");
		times.add(0,"10:20:37");
		times.add(0,"10:20:47");
		times.add(0,"10:20:51");
		times.add(0,"10:20:59");
		
		System.out.println("---分隔線---");
	
		for(String time:times) {
			System.out.println(time);
		}
		
		
	}

}
