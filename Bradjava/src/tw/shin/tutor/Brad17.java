package tw.shin.tutor;

import java.util.Random;

import tw.brad.apis.ID;

public class Brad17 {
//身分證
	public static void main(String[] args) {
//		System.out.println(ID.isRight("A123456789"));
		
//		Random rand=new Random();
//		System.out.println(rand.nextInt(2));
		
		
		ID id1=new ID();
		ID id2=new ID(false);
		ID id3=new ID('B');
		ID id4=new ID(true,'Y');
		ID id5=ID.newID("A123456789");
		
		System.out.println(id1.getID());
		System.out.println(id2.getID());
		System.out.println(id3.getID());
		System.out.println(id4.getID());
		System.out.println(id5.getID());
		
		

	}

}
