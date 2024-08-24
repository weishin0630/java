package tw.shin.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.Property;

import com.mysql.cj.xdevapi.PreparableStatement;

//prepareStatement 修改資料庫的資料(防止銀馬攻擊)
public class JDBC4 {

	public static void main(String[] args) {
		String url3="jdbc:mysql://127.0.0.1:3306/bread";
		Properties prop=new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn=DriverManager.getConnection(url3,prop)){
			String name ="Amy";
			String tel="0123456";
			String birthday="1998-01-01";
			int id=4;
			String sql="UPDATE cust SET name =?, tel=?, birthday=? WHERE id=?";
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			pstmt.setInt(4, id);
			
			pstmt.executeUpdate();
			System.out.println("ok");
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
