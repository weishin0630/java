package tw.brad.javaee;
//第一支Serverlet
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad01
 */
@WebServlet("/Brad01")
public class Brad01 extends HttpServlet {
//	private static final long serialVersionUID = 1L; -->沒有人用，所以可以拿掉
       
 
//    public Brad01() {
//        super();
//        
//    }  建構式-->無傳參數

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("ok");
		PrintWriter pw=	response.getWriter();
		pw.print("Hello,shin");
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);與23行一樣內容
//	} 

}
