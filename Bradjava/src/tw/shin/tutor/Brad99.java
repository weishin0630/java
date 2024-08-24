package tw.shin.tutor;

public class Brad99 {

	public static void main(String[] args) {
		// 99乘法表

		// 現在改這邊數值即可
		final int ROWS = 3; // 幾行
		final int COLS = 3; // 幾列
		final int START = 1; // 從甚麼數字開始

		for (int k = 0; k < ROWS; k++) {
			for (int j = 1; j <= 9; j++) {
				for (int i = START; i < START + COLS; i++) {
					int newi = i + k * COLS; // 這邊k*4是因為有4行，例2+旁邊的4可以到第6行
					int r = newi * j;
					System.out.printf("%d x %d =%d \t", newi, j, r);
				}
				System.out.println();
			}
			System.out.println("----");
		}

	}

}
