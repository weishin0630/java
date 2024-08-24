package tw.shin.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad51 {

	public static void main(String[] args) {
		Brad513 obj =new Brad513();
		
		try {
			ObjectOutputStream oout=new ObjectOutputStream
					(new FileOutputStream("dir1/test.ok"));			
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("ok");
			
			System.out.println("---解序列化---");
			
			ObjectInputStream oin=new ObjectInputStream(new FileInputStream("dir1/test.ok"));
			oin.readObject();
			oin.close();
			System.out.println("ok2");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Brad511 implements Serializable{ //宣告在這邊即可不用解序列化
	Brad511(){System.out.println("Brad511");}
}
class Brad512 extends Brad511 {
	Brad512(){System.out.println("Brad512");}
}
class Brad513 extends Brad512 {
	Brad513(){System.out.println("Brad513");}
}