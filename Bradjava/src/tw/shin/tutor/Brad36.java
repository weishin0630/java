package tw.shin.tutor;

//Exception
public class Brad36 {

	public static void main(String[] args) {
		Bird b1 = new Bird();  //讓這邊去處理(強制處理)
		try {
			b1.setLeg(7);
		} catch (Exception e) {
			System.out.print("Oooop");
		}
	}

}

class Bird {
	private int leg;

	void setLeg(int leg) throws Exception { // 這邊也要呼叫(外面主要看得為這邊)
		if (leg >= 0 && leg <= 2) {
			this.leg = leg;
		} else {
			throw new Exception();  //需要對外呼叫
		}
	}
}