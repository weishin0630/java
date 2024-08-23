package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.mindrot.BCrypt;

public class MemberDB {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String USER="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost/iii";
	private static final String SQL_CHECK="SELECT count(account)FROM member WHERE account=?";
	private static final String SQL_INSERT="INSERT INTO member(account,passwd,name)VALUE(?,?,?)";
	private static final int INSSERT_ACCOUNT=1;
	private static final int INSSERT_PASSWD=2;
	private static final int INSSERT_NAME=3;
//	以上是需要常使用的，所以使用final固定
	private Connection conn;
	
	
	public MemberDB() throws Exception{ //在建構式直接拋出例外
		Properties	prop=new Properties();
		prop.put("user", USER);
		prop.put("password",PASSWORD);
		
		
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,prop);
	}
	public boolean isAccountExist(String account) {
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL_CHECK);
			pstmt.setString(1, account);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt("count")>0;
			
		} catch (Exception e) {
			System.out.println("ERROR-1");
		}
		return true;
	}
	public boolean addMember(String account,String passwd,String name) throws Exception{
		PreparedStatement pstmt=conn.prepareStatement(SQL_INSERT);
		pstmt.setString(INSSERT_ACCOUNT, account);
		pstmt.setString(INSSERT_PASSWD, BCrypt.hashpw(passwd, BCrypt.gensalt())); //密碼加密
		pstmt.setString(INSSERT_NAME, name);
		
		return pstmt.executeUpdate() >0;
		
		
	}
	
	}
	

