package tw.shin.tutor;

public class Brad05 {

	public static void main(String[] args) {
		// <練習>
		int year = 2000;
		boolean isLeap;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true;
				} else {
					isLeap = false;
				}
			} else {
				isLeap = true;
			}

		} else {
			isLeap = false;
		}
		System.out.printf("%d年為%s年", year, isLeap ? "閏" : "平");

		// 第二種寫法:
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("閏年");// 29
		} else {
			System.out.println("平年");// 28
		}

	}

}
