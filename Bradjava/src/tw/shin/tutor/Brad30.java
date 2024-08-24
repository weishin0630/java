package tw.shin.tutor;
//LinkedList
//可重複.可獨立插入即刪除
import java.util.LinkedList;
import java.util.List;


public class Brad30 {

	public static void main(String[] args) {
		List list=new LinkedList();
		list.add("Brad");
		list.add(123);
		list.add(1,12.3);  //前面加1,(順序)就可以移到第一位
		list.add(true);		
		list.add(123);
		list.add("Brad");	
		
		list.add(list.remove(3));//-->(要移的位置)
		System.out.println(list.size()); //總共有6個值
		System.out.println("---分隔線---");
		for(Object obj:list) {
			System.out.println(obj);
		}

	}

}
