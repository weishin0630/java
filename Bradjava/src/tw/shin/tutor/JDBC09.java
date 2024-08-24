package tw.shin.tutor;
//確認帳號有無重複
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.mindrot.BCrypt;

public class JDBC09 {
	static Connection conn; //這邊宣告一個static

	public static void main(String[] args) {
		System.out.println("Register...");
		// 先連線成功->在驗證帳號
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String url = "jdbc:mysql://127.0.0.1:3306/iii";

		try {
			conn = DriverManager.getConnection(url, prop);

			Scanner scanner = new Scanner(System.in);

			String account;

			// 排除帳號重複:
			do {
				System.out.print("Account:");
				account = scanner.next();
			} while (isAccountExist(account));

			System.out.println("Password:"); // 密碼:123456
			String passwd = scanner.next();
			System.out.println("Name:");
			String name = scanner.next();

			String sql = "INSERT INTO member (account,passwd,name)VALUES(?,?,?)";
			String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, hashPasswd);
			pstmt.setString(3, name);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Register Success");
			} else {
				System.out.println("Reigister Failure");
			}

		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException();
		}

	}

	// 重複的帳號排除掉:
	static boolean isAccountExist(String account) throws SQLException {
		String sql = "SELECT count(account)count From member WHERE account=?";
		PreparedStatement pstmt = conn.prepareStatement(sql); //可拿出來
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count=rs.getInt("count");
		
		return count >0;
	}
}
