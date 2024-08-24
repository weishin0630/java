package tw.shin.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//FileOutputStream 輸出串流
public class Brad42 {

	public static void main(String[] args) {
		String mesg="資Hello,World\n";
		try {
			FileOutputStream fount=new FileOutputStream("dir1/file3.txt",true);//創建file3//多添加一個true(布林)即可記錄每一次
			fount.write(mesg.getBytes());  //讓他寫出字串 //寫到file3裡的文字
			fount.flush();
			fount.close();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
