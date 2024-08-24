package tw.shin.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.json.Property;

//修改
public class JDBC3 {

	public static void main(String[] args) {
		String url3="jdbc:mysql://127.0.0.1:3306/bread";
		Properties prop=new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn=DriverManager.getConnection(url3,prop)){

			Statement stmt= conn.createStatement();
			String sql="UPDATE cust SET tel='333' WHERE id=4";
			//修改資料
			
			int n=stmt.executeUpdate(sql);
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
