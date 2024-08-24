package tw.shin.tutor;
//UDP接收
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收
public class Brad54 {

	public static void main(String[] args) {
		byte[] buf=new byte[4*1024];//接收大小
		try {
			DatagramSocket socket=new DatagramSocket(8888);
			DatagramPacket packet=new DatagramPacket(buf,buf.length);
			socket.receive(packet);//接收封包
			socket.close();
			
			String urIp=packet.getAddress().getHostAddress();
			byte[] data=packet.getData();
			int len=packet.getLength(); //長度(重要)
			
			System.out.println("Receive ok");
			System.out.printf("%s => %s\n",urIp,new String(data,0,len)); //帶出傳遞訊息
			System.out.println(data.length);
			System.out.println(len);
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}

	}

}
