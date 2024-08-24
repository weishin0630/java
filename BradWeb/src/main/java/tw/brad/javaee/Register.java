package tw.brad.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.MemberDB;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private MemberDB memberDB=null;  //連接MemberDB的資料表
       
    
    public Register() {
        try {
			memberDB=new MemberDB();
			
		} catch (Exception e) {
//			memberDB=null; //=null也等同於初始化(等號就算)
			System.out.println(e);		
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(memberDB == null) return;
		
		request.setCharacterEncoding("UTF-8");
		String account= request.getParameter("account");
		String passwd= request.getParameter("passwd");
		String neme= request.getParameter("name");
		
//		詢問帳號有無重複(無重複->新增，重複->返回)
		if(!memberDB.isAccountExist(account)) {
			try {
				if(memberDB.addMember(account, passwd, neme)) {
					response.sendRedirect("brad17.jsp");
				}else {
					response.sendRedirect("brad16.jsp?errType=3");//無新增成功
				}
			} catch (Exception e) {
//				response.sendRedirect("brad16.jsp?errType=2");
				response.sendError(500, e.toString());
			}
		}else {
			response.sendRedirect("brad16.jsp?errType=1");
			//1-->帳號重複(JSP是可以接收參數的)
		}
	}

}
