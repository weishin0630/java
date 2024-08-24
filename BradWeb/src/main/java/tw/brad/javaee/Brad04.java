package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad04")
public class Brad04 extends HttpServlet {

    public Brad04() {
        System.out.println("Brad04()"); //物件初始化只有一次
        
    }
//	@Override
//	public void init() throws ServletException {
//		System.out.println("init()");
//		super.init();
//	}
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init(ServletConfig)");
////		super.init(config);  //此行註解上面的init()及不會顯示
//		//init-->都只會跑一次
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(1)");
//		super.service(req, resp); //這邊是控制下面的doGet()
//		 resp.setContentType("text/html; charset=UTF-8"); 
//			PrintWriter out= resp.getWriter();
//			out.print("Hello,Brad04"); //下面doGet可以省略只寫這邊
		System.out.println(req.getMethod());
	}

//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service(2)");
//		super.service(req, res);
//	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out= response.getWriter();
		out.print("Hello,Brad04"); 
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html; charset=UTF-8"); 
		 PrintWriter out= resp.getWriter();
		 out.print("doGet()");
	}
	
}
