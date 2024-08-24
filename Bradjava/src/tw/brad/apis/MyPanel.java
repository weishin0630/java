package tw.brad.apis;
//MySign
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private LinkedList<LinkedList<Point>> lines;
	
	public MyPanel() {
		setBackground(Color.DARK_GRAY);
		
		lines = new LinkedList<>();
		MyListener myListener = new MyListener();
		
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			LinkedList<Point> line = new LinkedList<>();
			
			Point point = new Point(e.getX(), e.getY());
			line.add(point);
			
			lines.add(line);//新增新的線
			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().add(point); //放在最後面那條線
			
			repaint();//被Graphics呼叫出來的
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;//轉型才需要
		
		g2d.setColor(Color.BLUE); //畫筆顏色
		g2d.setStroke(new BasicStroke(4));//這邊需要轉型

		for (LinkedList<Point> line  : lines) {
			//迴圈-->畫線
			for (int i = 1; i< line.size(); i++) {
				Point p0 = line.get(i-1);
				Point p1 = line.get(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
		
	}
}