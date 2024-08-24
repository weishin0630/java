package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

@WebServlet("/Brad19")
public class Brad19 extends HttpServlet {
	private Connection conn;

	public Brad19() { // 建構式->做一次即可
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 導入mysql驅動程式
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("no");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key=request.getParameter("key");
		String key2="%" +key+ "%";
		
		String sql = "SELECT *FROM gift";
		
		if(key !=null) {
			sql="SELECT * FROM gift WHERE name LIKE ? OR feature LIKE? OR addr LIKE ?";
			
		}		
		
		//以下為處理頁面
		RequestDispatcher dispatcher = request.getRequestDispatcher("sform1.html");

		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter();

		dispatcher.include(request, response);

		out.print("<table border='1' width=100%>");
		out.print("<tr><th>ID</th><th>Name</th><th>Feature</th><th>Address</th><th>Photo</th></tr>");
	
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if(key!= null) {
				pstmt.setString(1, key2);
				pstmt.setString(2, key2);
				pstmt.setString(3, key2);
			}		
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String feature = rs.getString("feature");
				String addr = rs.getString("addr");
				String picurl = rs.getString("picurl");
				out.println("<tr>");
				out.printf("<td>%s</td>\n", id);
				out.printf("<td>%s</td>\n", name);
				out.printf("<td>%s</td>\n", feature);
				out.printf("<td>%s</td>\n", addr);
				out.printf("<td><img src='%s' width='160px' height='90px' /></td>\n", picurl);
				out.println("</tr>");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		out.println("</table>");
		
		response.flushBuffer();
	}

}
