package tw.shin.tutor;
//58->59 <網路圖片轉換+另存新檔>
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad59 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout=new FileOutputStream("dir2/yahoo.jpg");//另存到dir2裡面
			
			URL url = new URL("https://s.yimg.com/ny/api/res/1.2/E2uvw7KZueJw03zpoXWjFQ--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTY0MDtjZj13ZWJw/https://media.zenfs.com/ko/gotv_ctitv_com_tw_678/cea78a73385761458a2377eeedede02a");
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
