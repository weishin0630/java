package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//這兩行可以固定
		request.setCharacterEncoding("UTF-8"); //進來utf-8
		response.setContentType("text/html; charset=UTF-8");  
		//這邊把原本網頁的字樣顯示出來
		PrintWriter out=response.getWriter();
		out.print("Hello~~~~");

}
}
