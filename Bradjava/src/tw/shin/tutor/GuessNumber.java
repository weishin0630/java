package tw.shin.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GuessNumber extends JFrame implements ActionListener { // 引用跑出視窗
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private String answer;
	private int counter; //計數器

	public GuessNumber() {
		super("猜數字遊戲"); // super只能在第一列

		input = new JTextField(); //輸入數字
		guess = new JButton("猜"); //按鈕
		log = new JTextArea(); //下面框框
		
		input.setFont(new Font(null,Font.BOLD,31)); //調整文字大小&粗斜體
		
		setLayout(new BorderLayout());
		
		JPanel top =new JPanel(new BorderLayout());
		//添加裡面的分層區隔
		top.add(guess,BorderLayout.EAST);
		top.add(input,BorderLayout.CENTER);
				
		//外層的添加區隔
		add(top,BorderLayout.NORTH);
		add(log,BorderLayout.CENTER);		
				
		// 這三列要放最後面
		setSize(640, 480); // 設定尺寸
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 設定關掉即關閉
	
		init();
		initEvent();
		
	}
	
	private void init() {
		answer=creatAnswer(4);
		counter=0;
		System.out.println(answer);
	}
	
	private void initEvent() {
		guess.addActionListener(this); //this:按鈕本人自己
		//點選錯誤的Lets-引用跑出上面public
	}
	
	private static String creatAnswer(int d) { 
		//複製poker v3
		final int nums = 10; 
		int[] poker = new int[nums];
		for (int i = 0; i < poker.length; i++)
			poker[i] = i;

		for (int i = nums-1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		//上面複製poker v3
		StringBuffer sb=new StringBuffer();
		for (int i=0;i<3;i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new GuessNumber(); //把視窗叫出來

	}


	@Override    //public Guessnumber委託出來的
	public void actionPerformed(ActionEvent e) {
		counter++;
//		System.out.println(input.getText()); //測試有無連結到數字輸入
		String g=input.getText();  //讓數字顯示在下面區域
		
//		System.out.println(checkAB(g,a));	
		String result =checkAB(g,answer);
//		log.setText(String.format("%s=>%s", g,result));
		
		log.append(String.format("%d=>%s=>%s\n",counter, g,result));
		
		input.setText("");
		
		if(result.equals("4A0B")) {
			JOptionPane.showMessageDialog(null, "WINNER!");
		}else if(counter==10) {
			JOptionPane.showMessageDialog(null, "LOSER!"+answer);
		}
		
		
		
	}
	private static String checkAB(String g,String a) {
		int A=0,B=0;
		
		for(int i=0;i<a.length();i++) {			
			if(g.charAt(i)==a.charAt(i)){
				A++;
			}else if(a.indexOf(g.charAt(i)) !=-1){
				B++;
			}
		}
		
		return String.format("%dA%dB", A,B);
	}
}
