package tw.shin.tutor;
//TCP發送
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad55 {

	public static void main(String[] args) {
		File source=new File("dir1/hi.jpg");
		try (	BufferedInputStream bin=new BufferedInputStream(new FileInputStream(source));
				Socket client=new Socket(InetAddress.getByName("10.0.100.142"),7777);				
				BufferedOutputStream bout=new BufferedOutputStream(client.getOutputStream())){
			
			byte[] buf=new byte[(int)source.length()];
			bin.read(buf);
			bout.write(buf);
			
			
					String mesg="Hello";
					bout.write(mesg.getBytes());
					
					
			System.out.println("Send ok!!!");
		
			
		} catch (Exception e) {
			System.out.println(e);
		} 

	}

}
