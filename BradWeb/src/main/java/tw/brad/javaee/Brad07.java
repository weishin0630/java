package tw.brad.javaee;

//出來的結果會跟前端的6號檔案一樣
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String x, y, result, op; // 統一宣告
		x = y = result = op = "";

		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
			op = request.getParameter("op");
			
			try {
				int intX = Integer.parseInt(x);
				int intY = Integer.parseInt(y);

				int r1, r2;

//			System.out.println(op);  //此為op的除錯驗算
//			if(op.equals("+")) {
//				System.out.println("加");
//			}

				switch (op) {
				case "1":
					r1 = intX + intY;
					result += r1;
					break;
				case "2":
					r1 = intX - intY;
					result += r1;
					break;
				case "3":
					r1 = intX * intY;
					result += r1;
					break;
				case "4":
					r1 = intX / intY;
					r2 = intX % intY;

					result += String.format("%d...%d", r1, r2);
					break;
				}
			} catch (Exception e) {

			}			
			
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta charset='UTF-8'>");
		out.println("<form action='Brad07'> ");
		out.printf("<input name='x' value='%s'/>\n", x);
		out.println("<select name='op'>"); // 帶出參數
		out.printf("<option value='1' %s>+</option>\n",op.equals("1")?"selected":"");
		out.printf("<option value='2' %s>-</option>\n",op.equals("2")?"selected":"");
		out.printf("<option value='3' %s>*</option>\n",op.equals("3")?"selected":"");
		out.printf("<option value='4' %s>/</option>\n",op.equals("4")?"selected":"");
		out.println("</select>");
		out.printf("<input name='y' value='%s'/>\n", y);
		out.println("<input type=\"submit\" value='='/>");
		out.printf("<span>%s</span>\n", result);
		out.println("</form>");

		response.flushBuffer();

	}

}
