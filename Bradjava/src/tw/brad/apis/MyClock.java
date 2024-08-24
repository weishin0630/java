package tw.brad.apis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//時鐘
import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;

	// 建構式:
	public MyClock() {
		timer = new Timer();
//		setText("10:20:30");
		timer.schedule(new MyTask(),0,100);
	}

	private class MyTask extends TimerTask {

		@Override
		public void run() {//時間到做這邊
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			setText(sdf.format(new Date()));
		}

	}

}
