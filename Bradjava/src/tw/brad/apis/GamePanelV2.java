package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanelV2 extends JPanel {
	private BufferedImage[] ballImgs; // 這邊已知是4個圖片
	private int ballW, ballH, viewW, viewH; // 長寬是固定的
	private Timer timer;
	private LinkedList<BallTask> balls;

	public GamePanelV2() {
		setBackground(Color.BLUE);
		try {
			ballImgs = new BufferedImage[] { // 建造四顆球
					ImageIO.read(new File("dir1/ball0.png")), ImageIO.read(new File("dir1/ball1.png")),
					ImageIO.read(new File("dir1/ball2.png")), ImageIO.read(new File("dir1/ball3.png")) };

			ballW = ballImgs[0].getWidth();
			ballH = ballImgs[0].getHeight();
		} catch (IOException e) {

		}
		balls = new LinkedList<>();
		addMouseListener(new MyLister());
		timer = new Timer();
		timer.scheduleAtFixedRate(new RefreshViews(), 0, 17);// 這邊是->FPS
	}

	// 內部類別:(如寫於方法中需先定義才能呼叫)
	private class MyLister extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int ex = e.getX() - (int) (ballW / 2.0);
			int ey = e.getY() - (int) (ballH / 2.0);

			BallTask ball = new BallTask(ex, ey);
			balls.add(ball); // 這邊(ball)已經給balls，不止於區域變數
			timer.scheduleAtFixedRate(ball, 100, 30);

		}
	}

	private class RefreshViews extends TimerTask {
		@Override
		public void run() {
			repaint();

		}

	}

	private class BallTask extends TimerTask {
		private int x, y, dx, dy;
		private int img;

		// 球已進行初始化
		public BallTask(int x, int y) {
			this.x = x;
			this.y = y;
			dx = (int) (Math.random() * 9) - 4; // -4 ~ +4共9個數
			dy = (int) (Math.random() * 9) - 4;
			img = (int) (Math.random() * 4);
		}

//右鍵->source(get&set)
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getImg() {
			return img;
		}

		@Override
		public void run() {
			if (x <= 0 || x + ballW > viewW) {
				dx *= -1;
				x = x < 0 ? 1 : viewW - ballW;
			} else {
				x += dx;
			}
			if (y <= 0 || y + ballH > viewH) {
				dy *= -1;
				y = y < 0 ? 1 : viewH - ballH;
			} else {
				y += dy;
			}

		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight();

		for (BallTask ball : balls) {
			g.drawImage(ballImgs[ball.getImg()], ball.getX(), ball.getY(), null);
		}

	}

}
