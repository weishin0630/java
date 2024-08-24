package tw.shin.tutor;
import java.io.ObjectStreamException;
import java.sql.SQLException;
import java.util.IllegalFormatException;

public class Brad39 {
//多重例外
	public static void main(String[] args) {
		

	}

}
class Brad391{
	void m1() throws Exception{}
}
class Brad392 extends Brad391{
	void m1() throws ObjectStreamException,IllegalFormatException,SQLException{}
}