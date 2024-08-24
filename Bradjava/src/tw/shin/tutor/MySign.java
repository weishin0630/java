package tw.shin.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.brad.apis.MyClock;
import tw.brad.apis.MyPanelV2;

public class MySign extends JFrame {
	private MyPanelV2 myPanel;
	private JButton clear, undo, redo, color, boid, loadObj, saveObj, saveJPEG;
	private MyClock myClock;
	// 上面添加按鈕
	public MySign() {
		super("Sign App");

		myPanel = new MyPanelV2();
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);

		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
//		boid = new JButton("boid");
		saveObj = new JButton("save Object");
		loadObj = new JButton("load Object");
		saveJPEG = new JButton("save JPEG");

		JPanel top = new JPanel(new FlowLayout());
		myClock = new MyClock();
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
//		top.add(boid);
		top.add(loadObj);
		top.add(saveObj);
		top.add(saveJPEG);
		top.add(myClock);
		// 添加進去框框裡面
		add(top, BorderLayout.NORTH);

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}

	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();
			}
		});
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
//		boid.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});

		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}

		});
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
		saveJPEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myPanel.saveJPEG();
					System.out.println("ok");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

	}

	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
		if (newColor != null) {
			myPanel.setColor(newColor);
		}
	}

	private void saveObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//			System.out.println("ok"); //知道剛剛有連接上
			File file = jfc.getSelectedFile();
			try {
				myPanel.saveLines(file);
				JOptionPane.showMessageDialog(null, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Save Failure");
			}
		}
	}

	private void loadObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				myPanel.loadLines(file);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failure");
			}
		}

	}	
	

	public static void main(String[] args) {
		new MySign();
	}

}