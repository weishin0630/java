package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.Bike;


@WebServlet("/Brad11")
public class Brad11 extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher=request.getRequestDispatcher("Brad12");
		
		request.setAttribute("x", 10);
		request.setAttribute("name", "peter");
		Bike b1 = new Bike();
		b1.getSpeed();
		request.setAttribute("bike", b1);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.append("<h1>Brad </h1>") //使用append可以多個使用一個即可
			.append("<hr>")
			.append("<div>hello! </div>")
			.append("<hr>");
		dispatcher.include(request, response);
		out.append("<hr>");
		
		response.flushBuffer();
	}

}