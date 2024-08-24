package tw.shin.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.brad.apis.Student;

//解序列化(49號&student)
public class Brad50 {

	public static void main(String[] args) {
		try {
			FileInputStream fin=new FileInputStream("dir1/brad.score");
			ObjectInputStream oin=new ObjectInputStream(fin);
			
			Object obj=oin.readObject();
			Student s1=(Student)obj;
			System.out.println(s1);
			System.out.println(s1.sum());
			System.out.println(s1.avg());			
			
			oin.close();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
