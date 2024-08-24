package tw.shin.tutor;
//mysql裡的gift-資料修改&取出資料

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC16 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iii";
	private static final String SQL_QUERY = "SELECT * FROM gift";

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String id =rs.getString("id");
				String name =rs.getString("name");
				System.out.printf("%s:%s\n",id,name);
				
			}			
			System.out.println("---分隔線---");
			//抓取第一筆
			if(rs.first()) {
				String id =rs.getString("id");
				String name =rs.getString("name");
				System.out.printf("%s:%s\n",id,name);
			}
			System.out.println("---分隔線---");
			//抓第47筆
			if(rs.absolute(47)) {
				String id =rs.getString("id");
				String name =rs.getString("name");
				System.out.printf("%s:%s\n",id,name);
			}			
			System.out.println("---分隔線---");
			//將47筆的資料修改
			rs.updateString("name", "古意禮");
			rs.updateString("town", "田頭鎮");
			//網際網路裡也修改
			rs.updateRow();
			
			String id =rs.getString("id");
			String name =rs.getString("name");
			System.out.printf("%s:%s\n",id,name);
			
			System.out.println("---分隔線---");
			//刪除47列-->游標會到46號
//			rs.deleteRow(); 
			
			id =rs.getString("id");
			name =rs.getString("name");
			System.out.printf("%s:%s\n",id,name);
			
			System.out.println("---分隔線---");
			rs.moveToInsertRow(); //新增一行
			rs.updateString("name", "古意禮");
			rs.updateString("feature", "");
			rs.updateString("addr", "");
			rs.updateString("picurl", "");
			rs.updateString("city", "");
			rs.updateString("town", "田頭鎮");
			rs.updateDouble("lat", 0.0);
			rs.updateDouble("lng", 0.0);
			rs.insertRow();
			
			
			
			
				
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
