package tw.shin.tutor;
//模糊關鍵字查詢
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;



public class JDBC7 {

	public static void main(String[] args) {
		//這邊為prepare(準備前置資料)
		System.out.print("關鍵字:");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		
		//使用like+?
		String sql = "SELECT *FROM gift WHERE name LIKE ? OR feature LIKE ? OR addr LIKE ?";
		String kw ="%"+key+"%";
				
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String url = "jdbc:mysql://127.0.0.1:3306/iii";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			//避免銀馬攻擊
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, kw);
			pstmt.setString(2, kw);
			pstmt.setString(3, kw);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String name =rs.getString("name");
				String feature =rs.getString("feature");
				String addr =rs.getString("addr");
				
				System.out.println(name);
				System.out.println(feature);
				System.out.println(addr);
				
				System.out.println("-----");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
