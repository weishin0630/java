package tw.shin.tutor;
//把網址的內容傳輸進來
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad58 {

	public static void main(String[] args) {
		try {
			URL url = new URL("url");
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			bin.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
