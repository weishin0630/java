package tw.shin.tutor;
//複製檔案到另一個資料夾(時間較長，I/O次數較多)
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad43 {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fount=new FileOutputStream("dir2/text2.pdf");
			FileInputStream fin=new FileInputStream("dir1/text.pdf");
			
			int b;
			while((b=fin.read()) !=-1) {
				fount.write(b);
			}
			fin.close();
			fount.flush();
			fount.close();
			System.out.println("Finish");
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
