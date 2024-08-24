package tw.shin.tutor;

import java.util.Arrays;

public class PokerV3 {
//洗牌只跑51次(使用交換)=>洗牌演算法
	public static void main(String[] args) {
		// 洗牌
		final int nums = 52; // 宣告nums=52
		int[] poker = new int[nums];
		for (int i = 0; i < poker.length; i++)
			poker[i] = i;

		for (int i = nums - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			// poker[rand]<=>poker[i] rand跟i做交換
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		for (int card : poker) {
			System.out.println(card);
		}
		System.out.println("---發牌---");
		// 發牌
		int[][] players = new int[4][13]; // 4個玩家每人13張牌
		for (int i = 0; i < poker.length; i++) {
			players[i % 4][i / 4] = poker[i]; // [取4個玩家的餘數][除4個玩家，因4個為1輪]
		}

		// 驗算發牌
//				for(int card:players[0]) { //[0~3號玩家=4個人]
//					System.out.println(card);

		// 定義(牌的花色&數字)
		String[] suits = { "黑桃", "紅心", "方塊", "梅花" };
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		// 驗算
		for (int[] player : players) {

			Arrays.sort(player); // -->理牌

			for (int card : player) {
				System.out.printf("%s%s", suits[card / 13], values[card % 13]);
			}
		}

		System.out.println("---攤牌---");
		// 攤牌
		for (int[] player : players) {
			for (int card : player) {
				System.out.println(card + " ");
			}
			System.out.println();
		}

	}
}
