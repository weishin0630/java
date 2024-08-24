package tw.brad.apis;

import java.io.Serializable;

//與49號一起
public class Student implements Serializable{ 
	//implements Serializable-->宣告即可序列化
	private String name;
	private int math,ch,eng;
	private Bike bike; //新增一個腳踏車
	
	
	public Student(String name,int math,int ch,int eng) {
		this.name=name;
		this.math=math;
		this.ch=ch;
		this.eng=eng;
		bike=new Bike();
		
	}
	public Bike getBike() {return bike;}
	
	public int sum() {return math+ch+eng;}
	public double avg() {return sum()/3.0;}
	
	@Override
	public String toString() {
		return String.format("%s:%d:%d:%d",name,math,ch,eng);
	}
}
