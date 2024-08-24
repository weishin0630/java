package tw.shin.tutor;
//滑鼠移動時顯示xy座標
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Brad24 extends JFrame{

	public Brad24() {
//		MyMouseListener mouseListener=new MyMouseListener();
		MyMouseListenerV2 mouseListener=new MyMouseListenerV2();
		addMouseListener(mouseListener); //這邊要添加下面才有辦法使用
		addMouseMotionListener(mouseListener);
		
		
		setSize(640, 480); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
		
	public static void main(String[] args) {
		new Brad24();
	}

}
//第二版本-MouseAdapter裡面是空的，所以裡面可以套用方法，就不需要寫那麼多
class MyMouseListenerV2 extends MouseAdapter{
	public void mousePressed(MouseEvent e) {
		
		System.out.println("press");
	}
	public void mouseDragged(MouseEvent e) {
	System.out.println(String.format("%d*%d",e.getX(),e.getY()));
	}
}




//第一版本 
class MyMouseListener implements MouseListener,MouseMotionListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("press");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		System.out.println("release");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Drag");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}}
