package tw.shin.tutor;

public class PokerV1 {
//使用for(){}迴圈跟if(){}else{}迴圈
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 測試時間
		// 洗牌
		int[] poker = new int[52];
		for (int i = 0; i < poker.length; i++) {
			int temp = (int) (Math.random() * 52); // 跑出52個亂數

			// 檢查機制(檢查有無重複)
			boolean isRepeat = false; // -->跑false代表沒有進入if迴圈，所以沒有重複
			for (int j = 0; j < i; j++) {
				if (temp == poker[j]) {
					// 此為重複
					isRepeat = true; // 重複就會跑true，因為重複才會跑進來if迴圈
					break;
				}
			}
			
			

			if (!isRepeat) { // 不重複把下面這段丟進去
				poker[i] = temp;
				System.out.println(poker[i]);
			} else {
				i--;

			}
		}
		System.out.println(System.currentTimeMillis() - start); //總共跑的時間為多少
		// 發牌

		// 攤牌+理牌
	}
}
