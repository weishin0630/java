package tw.shin.tutor;
//取出頭像並儲存
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC12 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iii";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id=?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("icon");
				// -------
				new Thread() {
					public void run() {
						try {
							String filename = String.format("dir2/%s.png", account);
							FileOutputStream fout = new FileOutputStream(filename);
							byte[] buf = new byte[64 * 1024];
							int len = in.read(buf);
							fout.write(buf, 0, len);
							fout.flush();
							fout.close();
							System.out.println("Save ok");
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}.start();

			} else {
				System.out.println("");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
