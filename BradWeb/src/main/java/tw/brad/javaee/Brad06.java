package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad06")
public class Brad06 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String	x=request.getParameter("x"); //取回前端的x
		String	y=request.getParameter("y");
		System.out.printf("%s,%s\n",x,y);	//這邊印出前端送來的數字
		
		int r =Integer.parseInt(x)+Integer.parseInt(y); //計算
		
		//讓他呈現出來
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.printf("%s+%s=%d", x,y,r);
		out.flush();
		out.close();
		
	}
	
}
