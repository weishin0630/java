package tw.shin.tutor;
//Thread執行緒
public class Brad62 {

	public static void main(String[] args) {
		MyThread mt1=new MyThread("A"); 
		MyThread mt2=new MyThread("B");
		
		MyRunnable mr1=new MyRunnable("C");
		Thread t1=new Thread(mr1);//這才是執行緒
		
		mt1.start(); 
		mt2.start();
		t1.start();
		System.out.println("ok");//交給cpu決定，但會完成這個方法
		
		//測驗:
//		mt1.run();
//		System.out.println("--------");
//		mt1.start(); //啟動生命特徵(跑下面的程式)(只能跑一次)
//		System.out.println("--------");
//		mt1.run();
//		System.out.println("--------");
//		mt1.start();

	}

}

//沿用父類別，使他有生命特徵
class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name=name;
	}   //顯示交錯的答案
	
	@Override //直接run->override
	public void run() {
		for(int i=0; i<20 ;i++) {
			System.out.printf("%s:%d\n",name,i);
			
			try {
				Thread.sleep(100);//純粹睡眠
			} catch (InterruptedException e) {								
			}
		}
	}
	
}




//Runnable(彈性較大)(找別人當父類別)
class MyRunnable implements Runnable {
	private String name;
	
	public MyRunnable(String name) {
		this.name=name;
	}   //顯示交錯的答案
	
	@Override //直接run->override
	public void run() {
		for(int i=0; i<20 ;i++) {
			System.out.printf("%s:%d\n",name,i);
			
			try {
				Thread.sleep(100);//純粹睡眠
			} catch (InterruptedException e) {								
			}
		}
	}
	
}