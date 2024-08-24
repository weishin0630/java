package tw.shin.tutor;

//查詢
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC6 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String url = "jdbc:mysql://127.0.0.1:3306/iii";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			String sql = "SELECT *FROM gift ORDER BY CITY";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 抓出表格所有資料
			while (rs.next()) {
				String id = rs.getString("id");
				String city = rs.getString("city");
				String name = rs.getString("name");

				System.out.printf("%s:%s:%s\n", id, city, name);
			}
//			System.out.println("---分隔線---");
//			System.out.println(rs.getRow()); //console:0
//			rs.next(); //移到下一個
//			System.out.println(rs.getRow()); ////console:1
//			rs.absolute(7); //移到第7筆
//			System.out.println(rs.getRow());
			// 拋出例外(因為不能指定，只能下一個)

			// 抓出表格裡的資料:
//			int id =rs.getInt(1); //選取id表格
//			System.out.println(id);
//			String name =rs.getString(2); //選取name表格
//			System.out.println(name);

			// 依照欄位名稱抓出表格資料(比較部會帶入太多數字):
//			int id =rs.getInt("id"); //如換成String也可以，int在sql上用作於運算，與java無關
//			System.out.println(id);
//			String name =rs.getString("name"); 
//			System.out.println(name);	
//			


//			stmt.close(); //不close也可以		
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
