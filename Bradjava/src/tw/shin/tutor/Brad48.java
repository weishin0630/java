package tw.shin.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileReader;

//複製46號
//FileReader(AutoCloseable)自動關閉:try()
//但裡面只能放關閉的資料，其他不能放
public class Brad48 {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("dir1/ns1hosp.csv"); 
				BufferedReader br = new BufferedReader(reader);) {

			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line); //完整的一列
				String[] data = line.split(",");
				System.out.printf("%s:%s:%s\n", data[1], data[2], data[4], data[7]);
			} // 取縣市.醫院名子.醫院地址

//			br.close();
			System.out.println("ok");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
