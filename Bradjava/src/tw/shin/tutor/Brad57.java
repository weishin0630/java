package tw.shin.tutor;
//http=tcp驗證
import java.net.ServerSocket;
import java.net.Socket;

public class Brad57 {

	public static void main(String[] args) {
	
		try (ServerSocket server = new ServerSocket(9487); //port預設是80(在瀏覽器上不用打port號)
				//其餘的都是:http://ip:9487
				Socket socket = server.accept();
				){
			System.out.println("ok");
		}catch(Exception e) {
			
		}
	}

}
