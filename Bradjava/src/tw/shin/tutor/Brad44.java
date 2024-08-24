package tw.shin.tutor;
//複製檔案到另一個資料夾(時間較短，I/O次數較少)
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad44 {

	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		try {
			byte[] buf=new byte[4*1024];
			
			FileInputStream fin=new FileInputStream("dir1/text.pdf");
			FileOutputStream fount=new FileOutputStream("dir2/text3.pdf");
			
			
			int len;
			while((len=fin.read(buf)) !=-1) {
				fount.write(buf,0,len);
			}
			
			fin.close();
			fount.flush();
			fount.close();
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis()-start);
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
