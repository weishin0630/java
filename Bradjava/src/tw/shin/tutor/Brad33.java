package tw.shin.tutor;

import java.io.File;

public class Brad33 {

	public static void main(String[] args) {
//		File f1=new File("d:\dir1"); 出現錯誤->為跳脫字元
		File f1 = new File("d:\\dir2"); // 兩根\\代表不是跳脫
		File f2 = new File("d:/test1"); // 可直接反過來(因為是跨平台)
		if (f1.exists()) {
			System.out.println("OK");
		} else {
			System.out.println("XX");
			if (f1.mkdir()) {
				System.out.println("ok2");
			} else {
				System.out.println("xx");
			}
		}
		File nowDir = new File("."); // .-->現在所在資料夾
		System.out.println(nowDir.getAbsoluteFile());
		// 檔案位置
	}
}
