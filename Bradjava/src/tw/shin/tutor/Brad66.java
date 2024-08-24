package tw.shin.tutor;

import org.mindrot.BCrypt;
//會員密碼
public class Brad66 {

	public static void main(String[] args) {
		//1.看不出來密碼  2.每次都不一樣
		String passwd="123456";
		String newpasswd=BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(newpasswd);
		System.out.println(newpasswd.length());
		if(BCrypt.checkpw("123456", newpasswd)) { //要用原來的方式做比對才有辦法
			System.out.println("ok");
		}else {
			System.out.println("XX");
		}
		
	}

}
