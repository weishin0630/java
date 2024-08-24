package tw.shin.tutor;

//分頁處理(複製06號)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC8 {

	public static void main(String[] args) {
		
		int rpp=10; //一頁有幾筆
		
		System.out.print("要看第幾頁:");
		Scanner scanner = new Scanner(System.in);
		int page = scanner.nextInt();//要看第幾頁:輸入數字		
		int start=(page -1)*rpp;
		
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String url = "jdbc:mysql://127.0.0.1:3306/iii";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			String sql = "SELECT *FROM gift ORDER BY id LIMIT ?,?"; //LIMIT->分頁
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs=pstmt.executeQuery();
			
			// 抓出表格所有資料
			while (rs.next()) {
				String id = rs.getString("id");
				String city = rs.getString("city");
				String name = rs.getString("name");

				System.out.printf("%s:%s:%s\n", id, city, name);
			}
	
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
