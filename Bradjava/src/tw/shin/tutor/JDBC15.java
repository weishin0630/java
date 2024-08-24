package tw.shin.tutor;

//複製14號(北風業績排行)
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import tw.brad.apis.Bike;

/*  //MYSQL上的指令
 SELECT e.EmployeeID,e.LastName,sum(od.UnitPrice*od.Quantity) total FROM orders o
JOIN orderdetails od on (o.OrderID =od.OrderID)
JOIN employees e on (o.EmployeeID=e.EmployeeID)
GROUP BY o.EmployeeID
order by total DESC

ID=5=>75567.7500  //-->驗算
SELECT SUM(UnitPrice*Quantity) FROM	orderdetails
WHERE OrderID IN (
	SELECT OrderID FROM orders
    WHERE EmployeeID =5
)

 */

public class JDBC15 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/northwind";
	private static final String SQL_QUERY = " SELECT e.EmployeeID,e.LastName,sum(od.UnitPrice*od.Quantity) total "
			+ "FROM orders o "  //這邊後面需要空一格
			+ "JOIN orderdetails od on (o.OrderID =od.OrderID) "
			+ "JOIN employees e on (o.EmployeeID=e.EmployeeID) " 
			+ "GROUP BY o.EmployeeID "
			+ "order by total DESC";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("EmployeeID");
				String name = rs.getString("LastName");
				String total = rs.getString("total");
				System.out.printf("%s:%s:%s\n", id, name, total);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
