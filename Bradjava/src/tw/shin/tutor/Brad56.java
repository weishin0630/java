package tw.shin.tutor;
//TCP接收
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad56 {

	public static void main(String[] args) {
		try (
				ServerSocket server = new ServerSocket(7777);
				Socket socket = server.accept();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())
				){
						 
				String urIp = socket.getInetAddress().getHostAddress();
			
//				System.out.println(urIp + "=>");

				String fname = String.format("dir2/%s.jpg", urIp);
				BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(fname));
			
				BufferedInputStream bin=new BufferedInputStream(socket.getInputStream());
				
				byte[]buf=new byte[4*1024];
				int len;
				while((len=bin.read(buf)) !=-1) {
					bout.write(buf,0,len);
				}
				
				bout.flush();
				bout.close();
				System.out.println(urIp+"=>ok");
			
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
