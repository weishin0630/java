package tw.brad.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.BradUtils;


@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//取出Attribute
		String result=(String)request.getAttribute("result");
		String x=(String)request.getAttribute("x");
		String y=(String)request.getAttribute("y");	
		String view=(String)request.getAttribute("view");	
		
		//顯示(1.結合view->Load 2.展示->Show)
		//1.Load View
		try {
			String	webPage = BradUtils.loadView(view);		 
		//2.Show View
		webPage=webPage.replaceAll("@x@",x).replaceAll("@y@",y).replaceAll("@result@",result);						
			
		response.getWriter().print(webPage);
		response.flushBuffer();
	}catch (Exception e) {
		response.getWriter().print("ERROR!");
		response.flushBuffer();
		}			
		
	}

}
