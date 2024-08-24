package tw.shin.tutor;
import java.io.FileInputStream;
//上傳頭像
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.brad.apis.Bike;
//複製11號(新增之前腳踏車屬性)
public class JDBC13 {
	private static final String USER="root";
	private static final String PASSWd ="root";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/iii";
	private static final String SQL_UPDATE="UPDATE member SET bike=? WHERE id=?";

	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user",USER );
		prop.put("password", PASSWd);
		
		Bike b1=new Bike();
		b1.upspeed();b1.upspeed();b1.upspeed();
		System.out.println(b1.getSpeed());
		
		try {
		Connection	conn = DriverManager.getConnection(URL, prop);
		PreparedStatement pstmt=conn.prepareStatement(SQL_UPDATE);		
		
		
		pstmt.setObject(1, b1);
		pstmt.setInt(2, 1);
		if(pstmt.executeUpdate()>0){
			System.out.println("ok");
		}else {
			System.out.println("xx");
		}
		
		
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
