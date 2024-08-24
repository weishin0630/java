package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Brad09")
@MultipartConfig( location="C:\\Users\\User\\eclipse-workspace\\BradWeb\\src\\main\\webapp\\upload")
//檔案上傳後會到上面網址的地方
public class Brad09 extends HttpServlet {		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//接收
		response.setContentType("text/html; charset=UTF-8"); //維護
		PrintWriter out= response.getWriter();
		
		Part part=request.getPart("upload"); //get相關資訊(但要做的只有放到路徑)
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getSubmittedFileName());
		
		
		if(part.getSize()>0) {
			part.write(part.getSubmittedFileName());
			
		}else {
			out.print("Upload Failure");
		}
		
		
		
	}
}
