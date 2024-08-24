package tw.brad.javaee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad18")
public class Brad18 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		double rate=0; //如省略這邊的double&try.catch需要在URL上直接給參數
		try {	 
			rate=Double.parseDouble( request.getParameter("rate"));
		}catch(Exception e) {
			
		}
//		rate=50;
		
		BufferedImage img=new BufferedImage(400,20,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d= img.createGraphics();		
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, 400, 20);
		
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0,(int)(rate/100*400), 20);
		
				
		response.setContentType("image/jpeg");//.setContentType-->與瀏覽器宣告
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
		
	}

}
