package tw.shin.tutor;
//HashMap
import java.util.HashMap;
import java.util.Set;

public class Brad32 {

	public static void main(String[] args) {
		HashMap<String,Object> map=new HashMap<>();
		//<String,Object>-->String字串跟Object類型
		//可儲存不同類型的值(字串.浮點數.布林值)
		map.put("name", "Brad");
		map.put("age", 18);
		map.put("gender", true);
		map.put("weight", 80.1);
		System.out.println(map.get("age")); //取出age的值
		
		System.out.println("---分隔線---");
		//尋訪資料 -->印出每個資料
		Set<String> keys=map.keySet();
		for(String key:keys) {
			System.out.printf("%s => %s\n", key, map.get(key));
		
			
		}
	}

}
