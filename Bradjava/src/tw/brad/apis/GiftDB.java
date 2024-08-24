package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class GiftDB {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iii";
	private static final String SQL_QUERY = "SELECT * FROM gift";

	private Connection conn;
	private ResultSet rs;
	private String[] fields;

	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		conn = DriverManager.getConnection(URL, prop);

	}

	public void query() throws SQLException {
		// 查詢
		query(SQL_QUERY);
	}

	public void query(String sql) throws SQLException {
		// 查詢
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd=rs.getMetaData();
		fields=new String[rsmd.getColumnCount()];
		for(int i=0;i<rsmd.getColumnCount();i++) {
			fields[i]=rsmd.getColumnLabel(i+1);			
			System.out.println(fields[i]);
		}
		
	}

	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			return 0;
		}
	}

	public int getCols() {
		return fields.length;
	}

	
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(fields[col]);
		} catch (Exception e) {
			return "ERROR";
		}
		
	}

	public String[] getFieldName() {
		return fields;
	}
	public void delData(int row) throws SQLException{
		rs.absolute(row+1);
		rs.deleteRow();
	}
	public void updateData(String newData,int row,int col) {
		try {
			rs.absolute(row+1);
			rs.updateString(col+1, newData);
			rs.updateRow();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	

	
	
	
}
