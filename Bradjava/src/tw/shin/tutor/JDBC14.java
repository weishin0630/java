package tw.shin.tutor;
//複製12號(取出資料庫裡的腳踏車屬性)
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.apis.Bike;

public class JDBC14 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iii";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id=?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				InputStream in = rs.getBinaryStream("bike");

				// ------
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				Bike b1 = (Bike) obj;
				System.out.println(b1.getSpeed());

				
//				if (obj instanceof Bike) {
//					System.out.println("yes");
//				} else {
//					System.out.println("no");
//				}

			} else {
				System.out.println("id not exist");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
