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

@WebServlet("/Brad17")
public class Brad17 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String source="C:\\Users\\User\\eclipse-workspace\\BradWeb\\src\\main\\webapp\\upload\\dog.jpeg";
		BufferedImage img=ImageIO.read(new File(source));
		Graphics2D g2d= img.createGraphics();
		
		//讓字變形(類似圖形驗證碼)
		Font font1=new Font(null,Font.BOLD,70);
		AffineTransform af=new AffineTransform();
		af.rotate(Math.toRadians(30));//30->角度
		Font font2=font1.deriveFont(af);
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.setFont(new Font(null,Font.BOLD,70));
		g2d.drawString("線條小狗DOG", 100, 100);
				
		response.setContentType("image/jpeg");//.setContentType-->與瀏覽器宣告
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
//		另存新檔
		ImageIO.write(img, "JPEG", new File("d:/JAVAclass/dog.jpg"));
		
	}

}
