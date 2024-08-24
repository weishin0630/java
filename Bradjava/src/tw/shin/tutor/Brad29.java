package tw.shin.tutor;
//LinkedHashSet(不重複，有順序性)
import java.util.LinkedHashSet;

public class Brad29 {

	public static void main(String[] args) {
		LinkedHashSet<String> names=new LinkedHashSet<>();
		names.add("Brad");
		names.add("Eric");
		names.add("Andy");
		names.add("Mark");
		names.add("Tony");
		for(String name:names) {
			System.out.println(name);
		}
		

	}

}
