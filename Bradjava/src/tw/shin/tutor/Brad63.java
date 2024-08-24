package tw.shin.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad63 {

	public static void main(String[] args) {
		Timer timer =new Timer();
		timer.schedule(new MyTask(),0, 1*1000);//-->馬上做，重複做
		timer.schedule(new StopTask(timer), 10*1000);//時間到->結束
		System.out.println("I'm Main");
	}
}
class MyTask extends TimerTask{
	private int i;
	@Override
	public void run() {
		System.out.println("i++");
	}
}

class StopTask extends TimerTask{
	private Timer timer;
	public StopTask(Timer timer){
		this.timer=timer;
	}
	@Override
	public void run() {
		timer.purge(); //清掉任務
		timer.cancel(); //取消時間
		timer=null;		
	}
	
}