package tw.shin.tutor;
//可被執行的視窗
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class Brad15 extends JFrame {
	private JButton b1, b2, b3;

	public Brad15() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		
		setLayout(new FlowLayout()); //依視窗調整位置，按鈕也會調整
		add(b1);add(b2);add(b3); //添加按鈕上去
		

		// 這些會留在最底下
		setSize(640, 480); // 調整視窗大小
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // EXIT_ON_CLOSE可直接叫
		// 視窗關閉即結束
	}

	public static void main(String[] args) {
		new Brad15();

	}

}
