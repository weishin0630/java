package tw.shin.tutor;
import java.net.DatagramPacket;
//建構
//DatagramSocket
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Brad53 {

	public static void main(String[] args) {
		//UDP建構(資料傳遞)
		String mesg="142";
		byte[] mesgBuf=mesg.getBytes();
		try {
			DatagramSocket socket=new DatagramSocket();
			DatagramPacket packet=new DatagramPacket(mesgBuf,mesgBuf.length,
					InetAddress.getByName("10.0.100.142"),8888); //8888->port號
			
			socket.send(packet); //發送資料
			socket.close();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
