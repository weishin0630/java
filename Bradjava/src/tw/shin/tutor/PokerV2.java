package tw.shin.tutor;

public class PokerV2 {
//使用do{}while()迴圈，省略if{}else{}
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 測試時間
		// 洗牌
		int[] poker = new int[52];
		boolean isRepeat; //宣告boolean
		int temp; //宣告temp
		for (int i = 0; i < poker.length; i++) {
			do {  //使用do{}跟while()迴圈
				//do裡面的做一次後去判斷while的對或錯
				temp = (int) (Math.random() * 52); // 跑出52個亂數

				// 檢查機制(檢查有無重複)
				isRepeat = false; // -->跑false代表沒有進入if迴圈，所以沒有重複
				for (int j = 0; j < i; j++) {
					if (temp == poker[j]) {
						// 此為重複
						isRepeat = true; // 重複就會跑true，因為重複才會跑進來if迴圈
						break;
					}
				}
			} while (isRepeat);

			poker[i] = temp;
			System.out.println(poker[i]); //這邊就可以減掉i--
			//少了if else迴圈
		}
		System.out.println(System.currentTimeMillis() - start); // 總共跑的時間為多少
		// 發牌

		// 攤牌+理牌
	}
}
