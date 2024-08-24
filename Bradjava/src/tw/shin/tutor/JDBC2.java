package tw.shin.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.json.Property;

//刪除資料表裡的資料
public class JDBC2 {

	public static void main(String[] args) {
		String url3="jdbc:mysql://127.0.0.1:3306/bread";
		Properties prop=new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn=DriverManager.getConnection(url3,prop)){

			Statement stmt= conn.createStatement();
			String sql="DELETE FROM cust WHERE id=3";
			//刪除
			
			int n=stmt.executeUpdate(sql);
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
