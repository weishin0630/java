package tw.shin.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.json.Property;

//載入外部驅動程式
public class JDBC01 {

	public static void main(String[] args) {
		//Load Driver(Connector)
		//But,....
		try {//載入外部驅動程式
			//填入->com.mysql.cj.jdbc.Driver
			//可以不用做這段，確認有放到正確位置即可
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
		
		//與mysql的bread資料庫連線
		//如是8889的port3306後要接:8889
		//問號隔開參數(key=value)，&-->第二個		
		String url1="jdbc:mysql://127.0.0.1:3306/bread?user=root&password=root";
//		try(Connection conn=DriverManager.getConnection(url1)){
//			System.out.println("ok2");
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		//第二個連線方式:
		String url2="jdbc:mysql://127.0.0.1:3306/bread";
//		try(Connection conn=DriverManager.getConnection(url2,"root","root")){
//			System.out.println("ok3");
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		//第三個方式:(老師推薦)
		String url3="jdbc:mysql://127.0.0.1:3306/bread";
		Properties prop=new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn=DriverManager.getConnection(url3,prop)){
//			System.out.println("ok4");
			Statement stmt= conn.createStatement();
			//資料表裡新增資料↓
			String sql="INSERT INTO cust(name,tel,birthday) VALUES ('Brad','123','1999-01-02')";
			sql +=",('Annie','12345','1999-01-02')";
			sql +=",('Eric','54321','1999-01-02')";
			int n=stmt.executeUpdate(sql);
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
