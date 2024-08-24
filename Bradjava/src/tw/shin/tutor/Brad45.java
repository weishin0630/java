package tw.shin.tutor;

import java.io.FileNotFoundException;
import java.io.FileReader;

//FileReader
public class Brad45 {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("./dir1/file2.txt");
			int c;
			while((c=fr.read()) !=-1){
				System.out.print((char)c);
			}
			
			fr.close();
			System.out.print("ok");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	
	}

}
