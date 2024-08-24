package tw.shin.tutor;

//FileInputStream 串流 //讀取file1
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad34 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("./dir1/file1.txt");
			//讀出一個一個的字
//			int c=fin.read();
//			System.out.print((char)c); //(char)強制轉型
//			 c=fin.read();  //讀到下一個
//			System.out.print((char)c);
			
			//讀出檔案全部內容
			int c;
			while((c=fin.read()) !=-1){
				System.out.print((char)c);
			}
			
			
			fin.close(); //關閉串流，新增一個catch
			System.out.println("OK");
		} catch (Exception e) {
			//FileNotFoundException->Exception(通通當成Exception處理)
			System.out.println(e);
		}			
//		 catch (IOException e) {
//			System.out.println(e);
//		}
	}

}
