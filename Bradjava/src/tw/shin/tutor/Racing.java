package tw.shin.tutor;

//賽跑程式
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;

	public Racing() {
		super("Racing");

		setLayout(new GridLayout(9, 1));
		go = new JButton("GO!!!");
		add(go);
		lanes = new JLabel[8];
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel(String.format("%d. ", (i + 1)));
			add(lanes[i]);
		}

		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initGame();
	}

	private void initGame() {
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
	}

	private void go() {
		rank = 0;

		for (int i = 0; i < lanes.length; i++) {
			lanes[i].setText(String.format("%d. ", (i + 1)));
		}
		cars = new Car[8];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i);
		}
		for (int i = 0; i < cars.length; i++) {
			cars[i].start();
		}
	}

	// 車子設置為內部類別(方便存取外部類別及方法)
	private class Car extends Thread {
		private int lane;
		private StringBuffer path;

		Car(int lane) {
			this.lane = lane;
			path = new StringBuffer(String.format("%d. ", (lane + 1)));
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				path.append(">");
				if (i == 99) {
//					path.append(++rank);
					path.append("WINNER");
				}
				lanes[lane].setText(path.toString());
				if(i == 99) {
					//第一名出現時，其他就不跑了
					stopGame();
				}
								
				try { //這邊會接收到interrupt，達到停止
					Thread.sleep(10 + (int) (Math.random() * 100));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
	
	void stopGame() {
		for(int i=0; i<cars.length;i++) {
			cars[i].interrupt(); //當被呼叫後，讓每台車子停止
		}
	}

	public static void main(String[] args) {
		new Racing();
	}

}
