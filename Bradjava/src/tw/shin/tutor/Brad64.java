package tw.shin.tutor;
//synchronized鎖定...notify通知:多重執行緒
public class Brad64 {

	public static void main(String[] args) {
		Store store=new Store();
		Producer p=new Producer(store);
		Consumer c1=new Consumer(store,"Shin");
		Consumer c2=new Consumer(store,"Amy");
		Consumer c3=new Consumer(store,"Brad");
		p.start();
		c1.start();
		c2.start();
		c3.start();
	}

}

class Store {
	private int qty;
	private int max;

	Store() {
		max = 10;
	}

	// throws InterruptedException-->wait拋出的例外
	// synchronized鎖定，同步
	synchronized void add(int add) throws InterruptedException {
		System.out.printf("準備進貨: %d\n", add);
		while (qty + add > max) {
			wait(); // 無限期等候，直到這個條件不成立
		}
		qty += add;
		System.out.printf("完成進貨: %d,目前庫存: %d\n", add, qty);
		notify();// 這邊鎖定，同步後須告知
	}

	synchronized void buy(int buy, String name) throws InterruptedException {
		System.out.printf("%s 想買: %d\n", name, buy);
		while (qty < buy) {
			wait(); // 無限期等候，直到這個條件不成立
		}
		qty -= buy;
		System.out.printf("完成賣出:%d(%s) ,目前庫存:%d\n", buy, name,qty);
		notify();// 這邊鎖定後須告知 //無保證先後順序
	}
}

class Producer extends Thread {
	private Store store;

	public Producer(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// wait拋出來的例外，在這邊try catch
			try {
				store.add(5);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

class Consumer extends Thread {
	private Store store;
	private String name;

	public Consumer(Store store, String name) {
		this.store = store;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				store.buy((int)(Math.random() * 3) + 1,name);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}