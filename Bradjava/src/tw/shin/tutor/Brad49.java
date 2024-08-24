package tw.shin.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Student;

//把student(apis)物件序列化
public class Brad49 {
	public static void main(String[] args) {
		Student s1= new Student("Brad",40,72,53);
		System.out.println(s1);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		s1.getBike().upspeed(); //沿用腳踏車
		System.out.println(s1.getBike().getSpeed());
		
		
		//物件序列化
		try {
			FileOutputStream fout=new FileOutputStream("dir1/bread.score");
			ObjectOutputStream oout=new ObjectOutputStream(fout);
			
			oout.writeObject(s1); //將物件序列化
		
			oout.flush();
			oout.close();
			System.out.println("ok");		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
