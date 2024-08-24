package tw.shin.tutor;

import java.io.File;
//FileInputStream 輸入串流//與34號相同讀取file2(有中文)
import java.io.FileInputStream;

public class Brad41 {

	public static void main(String[] args) {
		try {
			//使用File讀取全部檔案的內容(有中英夾雜)
			File source=new File("./dir1/file2.txt");
			FileInputStream fin = new FileInputStream(source);
						
			int len; byte[] buf =new byte[(int)source.length()]; //一個中文字3byte
			fin.read(buf);
			System.out.println(new String(buf));
			
//			len=fin.read(buf);
//			System.out.println(new String(buf,0,len));
			//取出file2檔案裡的中文字			
			
			//使用while讀出全部的字(無中英混合)
			while((len=fin.read(buf)) !=-1) {
				System.out.print(new String(buf,0,len));
			}
						
			fin.close();
			System.out.println();
			System.out.println("ok");
		} catch (Exception e) {			
			System.out.println(e);
		}			

	}

}
