package tw.shin.tutor;
//取ip位置
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad52 {

	public static void main(String[] args) {
		try {
			InetAddress ip=InetAddress.getByName("www.iii.org.tw");//印出資策會主機名稱
			System.out.println(ip); //localhost(別名)/127.0.0.1(ip)
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}

}
