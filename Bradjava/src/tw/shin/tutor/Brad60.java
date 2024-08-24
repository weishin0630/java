package tw.shin.tutor;
//複製59號，把網址(pdf轉uml)
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad60 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout=new FileOutputStream("dir2/gamer.pdf");//另存到dir2裡面
			//https://pdfmyurl.com/?url=需要轉pdf的網址，/?-->後面寫要接的內容
			URL url = new URL("https://pdfmyurl.com/?url=https://www.gamer.com.tw");
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			byte[] buf=new byte[4*1024]; int len;
			while((len=bin.read(buf)) !=-1) {
				fout.write(buf,0,len);
			}
			bin.close();
			
			fout.flush();
			fout.close();
			
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
